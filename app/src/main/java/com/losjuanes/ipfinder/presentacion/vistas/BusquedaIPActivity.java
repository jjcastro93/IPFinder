package com.losjuanes.ipfinder.presentacion.vistas;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.losjuanes.ipfinder.R;

public class BusquedaIPActivity extends AppCompatActivity {

    private EditText et_IP;
    private Button btn_buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_ip);

        //Navegacion hacia atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_IP = (EditText) findViewById(R.id.et_IP);
        btn_buscar = (Button) findViewById(R.id.btn_buscar);

        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(et_IP.getWindowToken(), 0);
            }
        });
    }
}
