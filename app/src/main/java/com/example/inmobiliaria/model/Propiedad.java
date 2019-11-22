package com.example.inmobiliaria.model;

public class Propiedad {
    private int id;
    private Propietariox propietariox;
    private String direccion;
    private int ambientes;
    private String tipo;
    private String uso;
    private double precio;
    private boolean disponible;

    public Propiedad() {
    }

    public Propiedad(int id, Propietariox propietariox, String direccion, int ambientes, String tipo, String uso, double precio, boolean disponible) {
        this.id = id;
        this.propietariox = propietariox;
        this.direccion = direccion;
        this.ambientes = ambientes;
        this.tipo = tipo;
        this.uso = uso;
        this.precio = precio;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Propietariox getPropietariox() {
        return propietariox;
    }

    public void setPropietariox(Propietariox propietariox) {
        this.propietariox = propietariox;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(int ambientes) {
        this.ambientes = ambientes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
