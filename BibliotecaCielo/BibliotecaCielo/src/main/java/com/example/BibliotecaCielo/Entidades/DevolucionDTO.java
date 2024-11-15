package com.example.BibliotecaCielo.Entidades;

import java.util.Date;

public class DevolucionDTO {
    private int prestamoId;
    private Date fechaDevolucion;
    private String estado;

    public DevolucionDTO() {}

    public DevolucionDTO(int prestamoId, Date fechaDevolucion, String estado) {
        this.prestamoId = prestamoId;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
