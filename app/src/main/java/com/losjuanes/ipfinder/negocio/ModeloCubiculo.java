package com.losjuanes.ipfinder.negocio;

public class ModeloCubiculo {
    private String nombre;
    private String ip;
    private String nodo;
    private String usuario;

    public ModeloCubiculo(String nombre, String ip, String nodo, String usuario) {
        this.nombre = nombre;
        this.ip = ip;
        this.nodo = nodo;
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIp() {
        return ip;
    }

    public String getNodo() {
        return nodo;
    }

    public String getUsuario() {
        return usuario;
    }
}
