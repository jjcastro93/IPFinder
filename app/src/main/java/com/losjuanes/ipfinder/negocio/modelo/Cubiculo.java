package com.losjuanes.ipfinder.negocio.modelo;

/**
 * Created by josec on 05/03/2017.
 */

public final class Cubiculo {

    private Cubiculo(){}

    public static class TablaCubiculo {
        public static final String NOMBRE_TABLA = "cubiculo";
        public static final String NOMBRE = "nombre";//PK
        public static final String IP = "ip";
        public static final String NODO = "nodo";
        public static final String USUARIO = "usuario";
    }
}
