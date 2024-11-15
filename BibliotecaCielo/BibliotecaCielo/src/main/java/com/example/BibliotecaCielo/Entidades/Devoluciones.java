package com.example.BibliotecaCielo.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "devoluciones")
public class Devoluciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int idDevolucion;

    @ManyToOne
    @JoinColumn(name = "prestamo_id")
    @JsonBackReference
    private Prestamos prestamo;

    @Column(name = "fecha_devolucion")
    private Date fechaDevolucion;

    @Column(name = "estado_libro")
    private String estado;

    public Devoluciones() {}

    public Devoluciones(Prestamos prestamo, Date fechaDevolucion, String estado) {
        this.prestamo = prestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    public Devoluciones(int idDevolucion, Prestamos prestamo, Date fechaDevolucion, String estado) {
        this.idDevolucion = idDevolucion;
        this.prestamo = prestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }


    public int getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(int idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Prestamos getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamos prestamo) {
        this.prestamo = prestamo;
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
