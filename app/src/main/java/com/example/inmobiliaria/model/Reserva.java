package com.example.inmobiliaria.model;

import java.time.LocalDate;

public class Reserva {
    private Integer idReserva;
    private String egreso;
    private String ingreso;
    private String estado;
    private double precioTotal;
    private int idBungalow;
    private int idTipo;
    private int idTitular;
    private int idUsuario;
    private Huesped titular;


    public Reserva() {
    }

    public Reserva(Integer idReserva, String egreso, String ingreso, String estado, double precioTotal, int idBungalow, int idTipo, int idTitular, int idUsuario) {
        this.idReserva = idReserva;
        this.egreso = egreso;
        this.ingreso = ingreso;
        this.estado = estado;
        this.precioTotal = precioTotal;
        this.idBungalow = idBungalow;
        this.idTipo = idTipo;
        this.idTitular = idTitular;
        this.idUsuario = idUsuario;

    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public String getEgreso() {
        return egreso;
    }

    public void setEgreso(String egreso) {
        this.egreso = egreso;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getIdBungalow() {
        return idBungalow;
    }

    public void setIdBungalow(int idBungalow) {
        this.idBungalow = idBungalow;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(int idTitular) {
        this.idTitular = idTitular;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Huesped getTitular() {
        return titular;
    }

    public void setTitular(Huesped titular) {
        this.titular = titular;
    }

    @Override
    public String toString() {
        return idReserva +"_"+ ingreso + "_" + idBungalow ;
    }
}
