package com.losjuanes.ipfinder.presentacion.controladores;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


import com.losjuanes.ipfinder.R;

public class ImplementacionCtrldrBusquedaCubiculo implements CtrldrBusquedaCubiculo {

    public void agregarFilas(Activity activity, TableLayout table){

        //Elimina todas las filas que ya existian
        table.removeAllViews();

        for (int i = 0; i < 5; i++) {

            TableRow row = new TableRow(activity);
            //TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            //row.setLayoutParams(lp);

            LinearLayout linearLayout = new LinearLayout(activity);
            linearLayout.setOrientation(LinearLayout.VERTICAL);

            /**
             * Se agregaran los elemetos: usuario, ip y nodo al LinearLayout
             */
            TextView usuario = new TextView(activity);
            usuario.setText("Iván Sánchez Pérez");
            usuario.setTextSize(activity.getResources().getDimension(R.dimen.table_textSize));
            linearLayout.addView(usuario);

            TextView ip = new TextView(activity);
            ip.setText("146.206.38.113");
            ip.setTextSize(activity.getResources().getDimension(R.dimen.table_textSize));
            linearLayout.addView(ip);

            TextView nodo = new TextView(activity);
            nodo.setText("H1N-113");
            nodo.setTextSize(activity.getResources().getDimension(R.dimen.table_textSize));
            linearLayout.addView(nodo);

            TextView espacio = new TextView(activity);
            espacio.setText("");
            espacio.setTextSize(activity.getResources().getDimension(R.dimen.table_espacio));
            linearLayout.addView(espacio);

            //Se agrega el LinearLayout a una fila de la tabla
            row.addView(linearLayout);

            //Se agrega la fila a la tabla
            table.addView(row,i);
        }
    }
}
