package com.losjuanes.ipfinder.negocio;

import android.content.Context;

import com.losjuanes.ipfinder.datos.DAOCubiculo;
import com.losjuanes.ipfinder.datos.ImplementacionDAOCubiculo;

/**
 * Created by josec on 05/03/2017.
 */

public class ImplementacionServicioIP implements ServicioIP {
    DAOCubiculo daoCubiculo = new ImplementacionDAOCubiculo();

    @Override
    public ModeloCubiculo buscarIP(Context context, String ip) {
        return daoCubiculo.getCubiculoByIP(context, ip);
    }
}
