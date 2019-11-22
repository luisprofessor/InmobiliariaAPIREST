package com.example.inmobiliaria.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Pago {
    private int id;
    private Contrato contrato;
    private int nroPago;
    private Date fecha;
    private double importe;

    public Pago() {
    }

    public Pago(int id, Contrato contrato, int nroPago, Date fecha, double importe) {
        this.id = id;
        this.contrato = contrato;
        this.nroPago = nroPago;
        this.fecha = fecha;
        this.importe = importe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public int getNroPago() {
        return nroPago;
    }

    public void setNroPago(int nroPago) {
        this.nroPago = nroPago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
