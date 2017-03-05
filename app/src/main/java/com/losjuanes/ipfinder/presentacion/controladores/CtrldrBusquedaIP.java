package com.losjuanes.ipfinder.presentacion.controladores;

import android.content.Context;

import com.losjuanes.ipfinder.negocio.ModeloCubiculo;

/**
 * Created by josec on 17/02/2017.
 */

public interface CtrldrBusquedaIP {
    ModeloCubiculo buscarIP(Context context, String ip);
}
