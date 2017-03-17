package com.losjuanes.ipfinder.presentacion.controladores;

import android.content.Context;

import com.losjuanes.ipfinder.negocio.dominio.Cubiculo;
import java.util.ArrayList;

public interface CtrldrBusquedaCubiculo {

    ArrayList<Cubiculo> buscaCubiculo(Context context, String cubiculo);
}
