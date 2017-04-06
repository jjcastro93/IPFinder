package com.losjuanes.ipfinder.datos;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.losjuanes.ipfinder.negocio.modelo.Cubiculo.TablaCubiculo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CubiculoBD extends SQLiteOpenHelper {
    public static final String RUTA_BD = "/data/data/com.losjuanes.ipfinder/databases/";
    public static final String NOMBRE_BD = "cubiculo.db";
    public static final int VERSION_BD = 1;
    private SQLiteDatabase myDataBase;
    public Context context;

    public CubiculoBD(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(cubiculoSQL());

        try {
            importarBD();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void importarBD(){
        boolean existeBD = checarBD();

        if (existeBD) {
            // Si existe, no haemos nada!
        } else {
            // Llamando a este método se crea la base de datos vacía en la ruta
            // por defecto del sistema de nuestra aplicación por lo que
            // podremos sobreescribirla con nuestra base de datos.
            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copiando database");
            }
        }

    }

    private void copyDataBase() throws IOException {
        OutputStream databaseOutputStream = new FileOutputStream("" + RUTA_BD + NOMBRE_BD);
        InputStream databaseInputStream;

        byte[] buffer = new byte[1024];
        int length;

        databaseInputStream = context.getAssets().open("cubiculo.db");
        while ((length = databaseInputStream.read(buffer)) > 0) {
            databaseOutputStream.write(buffer);
        }

        databaseInputStream.close();
        databaseOutputStream.flush();
        databaseOutputStream.close();
    }

    private boolean checarBD() {
        SQLiteDatabase checarBD = null;

        try {
            String myPath = RUTA_BD + NOMBRE_BD;
            checarBD = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        } catch (SQLiteException e) {
            // Base de datos no creada todavia
        }

        if (checarBD != null) {

            checarBD.close();
        }

        return checarBD != null ? true : false;
    }

    public SQLiteDatabase openDataBase() throws SQLException {

        // Open the database
        String myPath = RUTA_BD + NOMBRE_BD;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        return myDataBase;
    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();

        super.close();
    }
}
