package com.example.inmobiliaria.model;

import retrofit2.http.Header;

public class Propietario {

    private int idPropietario;
    private String nombre;
    private String apellido;
    private int dni;
    private String correo;
    private long telefono;
    private String clave;
    private int estadoPropietario;

    public Propietario() {
    }

    public Propietario(int idPropietario, String nombre, String apellido, int dni, String correo, long telefono, String clave, int estadoPropietario) {
        this.idPropietario = idPropietario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
        this.clave = clave;
        this.estadoPropietario = estadoPropietario;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getEstadoPropietario() {
        return estadoPropietario;
    }

    public void setEstadoPropietario(int estadoPropietario) {
        this.estadoPropietario = estadoPropietario;
    }
}

