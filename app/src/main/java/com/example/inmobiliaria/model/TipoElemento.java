package com.example.inmobiliaria.model;

public class TipoElemento {
    private Integer idTipoElemento;
    private String descripcion;
    private Integer estado;

    public TipoElemento() {
    }

    public TipoElemento(Integer idTipoElemento, String descripcion, Integer estado) {
        this.idTipoElemento = idTipoElemento;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdTipoElemento() {
        return idTipoElemento;
    }

    public void setIdTipoElemento(Integer idTipoElemento) {
        this.idTipoElemento = idTipoElemento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
