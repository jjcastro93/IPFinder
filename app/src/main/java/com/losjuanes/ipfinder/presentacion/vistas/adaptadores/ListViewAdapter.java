package com.losjuanes.ipfinder.presentacion.vistas.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.losjuanes.ipfinder.R;
import com.losjuanes.ipfinder.negocio.dominio.Cubiculo;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<Cubiculo>{

    private final Context context;
    private final ArrayList<Cubiculo> values;


    public ListViewAdapter(Context context, ArrayList<Cubiculo> values) {
        super(context, R.layout.listview_adapter, values);
        this.context = context;
        this.values = values;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // En primer lugar "inflamos" una nueva vista, que será la que se
        // mostrará en la celda del ListView. Para ello primero creamos el
        // inflater, y después inflamos la vista.
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.listview_adapter, null);

        TextView tvIp = (TextView) item.findViewById(R.id.tv_ip);
        tvIp.setText(values.get(position).getIp());

        TextView tvNodo = (TextView) item.findViewById(R.id.tv_nodo);
        tvNodo.setText(values.get(position).getNodo());

        TextView tvUsuario = (TextView) item.findViewById(R.id.tv_usuario);
        tvUsuario.setText(values.get(position).getUsuario());

        // Devolvemos la vista para que se muestre en el ListView.
        return item;
    }
}
