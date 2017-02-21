package com.losjuanes.ipfinder.presentacion.vistas;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

import com.losjuanes.ipfinder.R;
import com.losjuanes.ipfinder.presentacion.controladores.ImplementacionCtrldrBusquedaCubiculo;

public class BusquedaCubiculoActivity extends AppCompatActivity {
    private EditText etCubiculo;
    private Button btnBuscar;
    private TableLayout tabla;

    private ImplementacionCtrldrBusquedaCubiculo controlador;

    private Activity busquedaCubiculoActivity = this;

    private String cubiculo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_cubiculo);

        //Navegacion hacia atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        controlador = new ImplementacionCtrldrBusquedaCubiculo();

        etCubiculo = (EditText) findViewById(R.id.etCubiculo);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        tabla = (TableLayout) findViewById(R.id.tabla);

        //Se le asigna la funcionalidad al boton
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Oculta el teclado
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(BusquedaCubiculoActivity.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(etCubiculo.getWindowToken(), 0);

                cubiculo = etCubiculo.getText().toString();

                if (cubiculo.compareTo("") != 0){
                    controlador.agregarFilas(busquedaCubiculoActivity, tabla);
                }else{
                    Toast.makeText(busquedaCubiculoActivity, getResources().getString(R.string.msj_cubiculoVacio), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
