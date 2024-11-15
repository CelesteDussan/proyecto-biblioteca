package com.example.BibliotecaCielo.Entidades;

import java.util.Date;

public class PrestamoDTO {

    private int libroId;
    private int usuarioId;
    private Date fechaEntrega;
    private String encargado;
    private String estado;

    // Constructor por defecto
    public PrestamoDTO() {
    }

    // Constructor con parámetros
    public PrestamoDTO(int libroId, int usuarioId, Date fechaEntrega, String encargado, String estado) {
        this.libroId = libroId;
        this.usuarioId = usuarioId;
        this.fechaEntrega = fechaEntrega;
        this.encargado = encargado;
        this.estado = estado;
    }

    // Getters y setters
    public int getLibroId() {
        return libroId;
    }

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}