package com.losjuanes.ipfinder.negocio.dominio;

public class Cubiculo {

    private String cubiculo;
    private String ip;
    private String nodo;
    private String usuario;

    public Cubiculo(String cubiculo, String ip, String nodo, String usuario) {
        this.cubiculo = cubiculo;
        this.ip = ip;
        this.nodo = nodo;
        this.usuario = usuario;
    }

    public String getCubiculo() {
        return cubiculo;
    }

    public void setCubiculo(String cubiculo) {
        this.cubiculo = cubiculo;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNodo() {
        return nodo;
    }

    public void setNodo(String nodo) {
        this.nodo = nodo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
