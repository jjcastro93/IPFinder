package com.losjuanes.ipfinder.presentacion.vistas;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.losjuanes.ipfinder.R;
import com.losjuanes.ipfinder.negocio.ModeloCubiculo;
import com.losjuanes.ipfinder.presentacion.controladores.CtrldrBusquedaIP;
import com.losjuanes.ipfinder.presentacion.controladores.ImplementacionCtrldrBusquedaIP;

public class BusquedaIPActivity extends AppCompatActivity {

    CtrldrBusquedaIP ctrldrBusquedaIP = new ImplementacionCtrldrBusquedaIP();
    Context context = this;

    private ModeloCubiculo cubiculo;

    private EditText et_IP;
    private Button btn_buscar;
    private TextView tvIPcubiculo,tvIPnodo,tvIPusuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_ip);

        //Navegacion hacia atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_IP = (EditText) findViewById(R.id.et_IP);
        btn_buscar = (Button) findViewById(R.id.btn_buscar);

        tvIPcubiculo = (TextView) findViewById(R.id.tv_IPCubiculo);
        tvIPnodo = (TextView) findViewById(R.id.tv_IPNodo);
        tvIPusuario = (TextView) findViewById(R.id.tv_IPUsuario);

        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ip = "148.206." + et_IP.getText().toString();

                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(et_IP.getWindowToken(), 0);

                cubiculo = ctrldrBusquedaIP.buscarIP(context, ip);

                if (cubiculo != null) {
                    tvIPusuario.setText(cubiculo.getNombre());
                    tvIPnodo.setText(cubiculo.getNodo());
                    tvIPusuario.setText(cubiculo.getUsuario());
                }else{
                    Toast.makeText(context, "La ip no existe.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
