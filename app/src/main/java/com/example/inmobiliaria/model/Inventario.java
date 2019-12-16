package com.example.inmobiliaria.model;

public class Inventario {
    private int idItem;
    private int idReserva;
    private int idTipoElemento;
    private int cantidadCheckin;
    private int getCantidadCheckout;
    private TipoElemento tipoElemento;

    public Inventario() {
    }

    public Inventario(int idItem, int idReserva, int idTipoElemento, int cantidadCheckin, int getCantidadCheckout) {
        this.idItem = idItem;
        this.idReserva = idReserva;
        this.idTipoElemento = idTipoElemento;
        this.cantidadCheckin = cantidadCheckin;
        this.getCantidadCheckout = getCantidadCheckout;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdTipoElemento() {
        return idTipoElemento;
    }

    public void setIdTipoElemento(int idTipoElemento) {
        this.idTipoElemento = idTipoElemento;
    }

    public int getCantidadCheckin() {
        return cantidadCheckin;
    }

    public void setCantidadCheckin(int cantidadCheckin) {
        this.cantidadCheckin = cantidadCheckin;
    }

    public int getGetCantidadCheckout() {
        return getCantidadCheckout;
    }

    public void setGetCantidadCheckout(int getCantidadCheckout) {
        this.getCantidadCheckout = getCantidadCheckout;
    }

    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }

    public void setTipoElemento(TipoElemento tipoElemento) {
        this.tipoElemento = tipoElemento;
    }
}
