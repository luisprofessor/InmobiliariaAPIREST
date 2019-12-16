package com.example.inmobiliaria.model;

public class Usuario {
    private Integer idUsuario;
    private String apellido;
    private String nombre;
    private String mail;
    private String password;
    private String activo;
    private String idPerfil;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String apellido, String nombre, String mail, String password, String activo, String idPerfil) {
        this.idUsuario = idUsuario;
        this.apellido = apellido;
        this.nombre = nombre;
        this.mail = mail;
        this.password = password;
        this.activo = activo;
        this.idPerfil = idPerfil;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }
}
