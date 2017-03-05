package com.losjuanes.ipfinder.datos;

import android.content.Context;

import com.losjuanes.ipfinder.negocio.ModeloCubiculo;

public interface DAOCubiculo {
    ModeloCubiculo getCubiculoByIP(Context context, String ip);
}
