package com.losjuanes.ipfinder.datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.losjuanes.ipfinder.negocio.ModeloCubiculo;
import com.losjuanes.ipfinder.negocio.dominio.Cubiculo;
import com.losjuanes.ipfinder.negocio.modelo.Cubiculo.TablaCubiculo;

import java.util.ArrayList;

public class ImplementacionDAOCubiculo implements DAOCubiculo{

    private CubiculoBD cubiculoBD;
    private SQLiteDatabase database;

    @Override
    public ModeloCubiculo getCubiculoByIP(Context context, String ip) {
        ModeloCubiculo cubiculo = null;
        Cursor cursor;

        cubiculoBD = new CubiculoBD(context);
        database = cubiculoBD.getReadableDatabase();

        cursor = database.query(
                TablaCubiculo.NOMBRE_TABLA,
                new String[]{TablaCubiculo.NOMBRE, TablaCubiculo.IP, TablaCubiculo.NODO, TablaCubiculo.USUARIO},
                TablaCubiculo.IP + " = ?",
                new String[]{ip},
                null,
                null,
                null
        );

        cursor.moveToFirst();
        if (cursor.isFirst()){
            cubiculo = new ModeloCubiculo(
                    cursor.getString(cursor.getColumnIndexOrThrow(TablaCubiculo.NOMBRE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(TablaCubiculo.IP)),
                    cursor.getString(cursor.getColumnIndexOrThrow(TablaCubiculo.NODO)),
                    cursor.getString(cursor.getColumnIndexOrThrow(TablaCubiculo.USUARIO))
            );
        }
        cursor.close();

        database.close();

        return cubiculo;
    }

    @Override
    public ArrayList<Cubiculo> getCubiculo(Context context, String nomCubiculo) {

        ArrayList<Cubiculo> cubiculoIps = new ArrayList<>();

        Cursor cursor;
        Cubiculo cubiculo;

        cubiculoBD = new CubiculoBD(context);
        database = cubiculoBD.getReadableDatabase();

        cursor = database.query(
                TablaCubiculo.NOMBRE_TABLA,
                new String[]{TablaCubiculo.NOMBRE, TablaCubiculo.IP, TablaCubiculo.NODO, TablaCubiculo.USUARIO},
                TablaCubiculo.NOMBRE + " = ?",
                new String[]{nomCubiculo},
                null,
                null,
                TablaCubiculo.USUARIO + " ASC"
        );

        while (cursor.moveToNext()) {
            cubiculo = new Cubiculo(
                    cursor.getString(cursor.getColumnIndexOrThrow(TablaCubiculo.NOMBRE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(TablaCubiculo.IP)),
                    cursor.getString(cursor.getColumnIndexOrThrow(TablaCubiculo.NODO)),
                    cursor.getString(cursor.getColumnIndexOrThrow(TablaCubiculo.USUARIO))
            );
            cubiculoIps.add(cubiculo);
        }

        cursor.close();
        database.close();

        return cubiculoIps;
    }
}
