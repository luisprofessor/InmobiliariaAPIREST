package com.example.inmobiliaria.model;

public class Huesped {
    private Integer idHuesped;
    private Long dni;
    private String apellido;
    private String nombre;
    private String mail;
    private String telefono;

    public Huesped() {
    }

    public Huesped(Integer idHuesped, Long dni, String apellido, String nombre, String mail, String telefono) {
        this.idHuesped = idHuesped;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.mail = mail;
        this.telefono = telefono;
    }

    public Integer getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(Integer idHuesped) {
        this.idHuesped = idHuesped;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return  apellido + ", "+nombre;
    }
}
