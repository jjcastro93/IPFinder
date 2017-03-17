package com.losjuanes.ipfinder.datos;

import android.content.Context;

import com.losjuanes.ipfinder.negocio.ModeloCubiculo;
import com.losjuanes.ipfinder.negocio.dominio.Cubiculo;

import java.util.ArrayList;

public interface DAOCubiculo {
    ModeloCubiculo getCubiculoByIP(Context context, String ip);

    ArrayList<Cubiculo> getCubiculo(Context context, String cubiculo);
}
