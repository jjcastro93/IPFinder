package com.losjuanes.ipfinder.negocio;

import android.content.Context;

import com.losjuanes.ipfinder.negocio.dominio.Cubiculo;

import java.util.ArrayList;

public interface ServicioCubiculo {

    ArrayList<Cubiculo> buscaCubiculo(Context context, String cubiculo);
}
