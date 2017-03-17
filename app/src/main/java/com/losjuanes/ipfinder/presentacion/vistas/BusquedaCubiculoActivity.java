package com.losjuanes.ipfinder.presentacion.vistas;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.losjuanes.ipfinder.R;
import com.losjuanes.ipfinder.negocio.dominio.Cubiculo;
import com.losjuanes.ipfinder.presentacion.controladores.ImplementacionCtrldrBusquedaCubiculo;
import com.losjuanes.ipfinder.presentacion.vistas.adaptadores.ListViewAdapter;

import java.util.ArrayList;

public class BusquedaCubiculoActivity extends AppCompatActivity {
    private AutoCompleteTextView actvCubiculo;
    private Button btnBuscar;
    private ListView lvCubiculos;

    private ImplementacionCtrldrBusquedaCubiculo controlador;

    private Context context= this;

    private String cubiculo = "";

    private ArrayList<Cubiculo> cubiculoIps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_cubiculo);

        //Navegacion hacia atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        controlador = new ImplementacionCtrldrBusquedaCubiculo();

        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        lvCubiculos = (ListView) findViewById(R.id.lvCubiculos);

        actvCubiculo = (AutoCompleteTextView) findViewById(R.id.actvCubiculo);
        String[] salas = getResources().getStringArray(R.array.salas);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, salas);
        actvCubiculo.setAdapter(adapter);

        //Se le asigna la funcionalidad al boton
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Oculta el teclado
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(BusquedaCubiculoActivity.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(actvCubiculo.getWindowToken(), 0);

                cubiculo = actvCubiculo.getText().toString();

                if (!cubiculo.equals("")){
                    cubiculoIps = controlador.buscaCubiculo(context, cubiculo);

                    if (cubiculoIps.size() > 0){
                        //agregamos los elementos al listview
                        ListViewAdapter listViewAdapter;

                        listViewAdapter = new ListViewAdapter(context, cubiculoIps);
                        lvCubiculos.setAdapter(listViewAdapter);
                    } else {
                        Toast.makeText(context, getResources().getString(R.string.msj_cubiculoNoExiste), Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(context, getResources().getString(R.string.msj_cubiculoVacio), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
