package com.losjuanes.ipfinder.negocio;

import android.content.Context;

import com.losjuanes.ipfinder.datos.DAOCubiculo;
import com.losjuanes.ipfinder.datos.ImplementacionDAOCubiculo;
import com.losjuanes.ipfinder.negocio.dominio.Cubiculo;

import java.util.ArrayList;

public class ImplementacionServicioCubiculo implements ServicioCubiculo{
    DAOCubiculo dao = new ImplementacionDAOCubiculo();

    @Override
    public ArrayList<Cubiculo> buscaCubiculo(Context conext, String cubiculo) {
        return dao.getCubiculo(conext, cubiculo);
    }
}
