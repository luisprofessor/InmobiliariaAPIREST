package com.example.inmobiliaria.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Contrato {
    private int id;
    private Inquilino inquilino;
    private Propiedad propiedad;
    private double precio;
    private Date fechaInicio;
    private Date fechaFin;
    private double multa;

    public Contrato() {
    }

    public Contrato(int id, Inquilino inquilino, Propiedad propiedad, double precio, Date fechaInicio, Date fechaFin, double multa) {
        this.id = id;
        this.inquilino = inquilino;
        this.propiedad = propiedad;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.multa = multa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
}
