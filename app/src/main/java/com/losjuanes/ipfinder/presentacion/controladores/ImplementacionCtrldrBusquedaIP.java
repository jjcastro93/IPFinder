package com.losjuanes.ipfinder.presentacion.controladores;

import android.content.Context;

import com.losjuanes.ipfinder.negocio.ImplementacionServicioIP;
import com.losjuanes.ipfinder.negocio.ModeloCubiculo;
import com.losjuanes.ipfinder.negocio.ServicioCubiculo;
import com.losjuanes.ipfinder.negocio.ServicioIP;

public class ImplementacionCtrldrBusquedaIP implements CtrldrBusquedaIP {
    ServicioIP servicioIP = new ImplementacionServicioIP();

    @Override
    public ModeloCubiculo buscarIP(Context context, String ip) {
        return servicioIP.buscarIP(context, ip);
    }
}
