package com.losjuanes.ipfinder.presentacion.controladores;

import android.content.Context;
import android.util.Log;

import com.losjuanes.ipfinder.negocio.ImplementacionServicioCubiculo;
import com.losjuanes.ipfinder.negocio.ServicioCubiculo;
import com.losjuanes.ipfinder.negocio.dominio.Cubiculo;

import java.util.ArrayList;

public class ImplementacionCtrldrBusquedaCubiculo implements CtrldrBusquedaCubiculo {
    ServicioCubiculo servicio = new ImplementacionServicioCubiculo();

    @Override
    public ArrayList<Cubiculo> buscaCubiculo(Context context, String cubiculo) {
       return servicio.buscaCubiculo(context, cubiculo);
    }
}
