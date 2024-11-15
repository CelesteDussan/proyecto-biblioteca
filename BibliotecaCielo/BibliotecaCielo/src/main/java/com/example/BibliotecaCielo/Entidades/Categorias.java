package com.example.BibliotecaCielo.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categoria")
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int idCategoria;

    @Column(name = "nombre")
    private String nombreCategoria;

    @OneToMany(mappedBy = "categoria")
    @JsonBackReference
    private Set<Libros> libros = new HashSet<>();


    public Categorias() {
    }

    public Categorias(int idCategoria, String nombreCategoria, Set<Libros> libros) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.libros = libros;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Set<Libros> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libros> libros) {
        this.libros = libros;
    }
}
