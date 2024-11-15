package com.example.BibliotecaCielo.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "libros")
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int idLibro;

    @Column(name = "nombre")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "cantidad_copias")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "categoria_id",nullable = false)
    @JsonBackReference
    private Categorias categoria;

    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "libro")
    private Set<Prestamos> prestamos = new HashSet<>();

    public Libros() {
    }

    public Libros(int idLibro, String titulo, String autor, int cantidad, Categorias categoria, String estado, Set<Prestamos> prestamos) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.estado = estado;
        this.prestamos = prestamos;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<Prestamos> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Set<Prestamos> prestamos) {
        this.prestamos = prestamos;
    }
}
