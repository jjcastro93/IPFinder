package com.losjuanes.ipfinder.datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.losjuanes.ipfinder.negocio.ModeloCubiculo;
import com.losjuanes.ipfinder.negocio.modelo.Cubiculo.TablaCubiculo;

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

        database.close();

        return cubiculo;
    }
}
