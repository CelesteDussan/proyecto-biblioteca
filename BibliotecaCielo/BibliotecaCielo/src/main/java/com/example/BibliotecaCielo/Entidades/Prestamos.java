package com.example.BibliotecaCielo.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "prestamos")
public class Prestamos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int idPrestamo;

    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    @JsonBackReference
    private Libros libro;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference
    private Usuarios usuario;

    @Column(name = "fecha_entrega", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;

    @Column(name = "encargado", nullable = false)
    private String encargado;

    @Column(name = "estado_libro")
    private String estado;

    @OneToMany(mappedBy = "prestamo")
    @JsonManagedReference
    private Set<Devoluciones> prestamo = new HashSet<>();

    public Prestamos() {
    }

    public Prestamos(Libros libro, Usuarios usuario, Date fechaEntrega, String encargado, String estado) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaEntrega = fechaEntrega;
        this.encargado = encargado;
        this.estado = estado;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Libros getLibro() {
        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
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

    public Set<Devoluciones> getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Set<Devoluciones> prestamo) {
        this.prestamo = prestamo;
    }
}
