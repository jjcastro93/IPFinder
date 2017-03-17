package com.losjuanes.ipfinder.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.losjuanes.ipfinder.negocio.modelo.Cubiculo.TablaCubiculo;

public class CubiculoBD extends SQLiteOpenHelper {
    public static final String NOMBRE_BD = "cubiculo.db";
    public static final int VERSION_BD = 1;

    public CubiculoBD(Context context) { super(context, NOMBRE_BD, null, VERSION_BD); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(cubiculoSQL());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TablaCubiculo.NOMBRE_TABLA);
        onCreate(db);
    }

    private String cubiculoSQL(){
        return "CREATE TABLE " + TablaCubiculo.NOMBRE_TABLA + "(" +
                TablaCubiculo.NOMBRE + " TEXT NOT NULL," +
                TablaCubiculo.IP + " TEXT NOT NULL," +
                TablaCubiculo.NODO + " TEXT NOT NULL," +
                TablaCubiculo.USUARIO + " TEXT NOT NULL)";
    }
}
