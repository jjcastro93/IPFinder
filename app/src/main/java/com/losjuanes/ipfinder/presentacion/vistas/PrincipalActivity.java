package com.losjuanes.ipfinder.presentacion.vistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.losjuanes.ipfinder.R;
import com.losjuanes.ipfinder.presentacion.controladores.CtrldrBusquedaIP;
import com.losjuanes.ipfinder.presentacion.controladores.ImplementacionCtrldrBusquedaIP;

public class PrincipalActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnConsultaIP,btnConsultaCubiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnConsultaIP = (Button) findViewById(R.id.btnConsultaIP);
        btnConsultaCubiculo = (Button) findViewById(R.id.btnConsultaCubiculo);

        btnConsultaIP.setOnClickListener(this);
        btnConsultaCubiculo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnConsultaIP){
            startActivity(new Intent(PrincipalActivity.this,BusquedaIPActivity.class));
        }else{
            startActivity(new Intent(PrincipalActivity.this,BusquedaCubiculoActivity.class));
        }
    }
}
