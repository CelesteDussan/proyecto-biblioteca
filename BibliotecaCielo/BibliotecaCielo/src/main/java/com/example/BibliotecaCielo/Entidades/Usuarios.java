package com.example.BibliotecaCielo.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idUsuario;

    @Column(name = "nombre_completo")
    private String nombre_completo;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "tipo_documento")
    private String tipo_documento;

    @Column(name = "numero_documento")
    private int numero_docuemento;

    @OneToMany(mappedBy = "usuario")
    @JsonBackReference
    private Set<Prestamos> prestamos = new HashSet<>();

    public Usuarios() {
    }

    public Usuarios(int idUsuario, String nombre_completo, String correo, String telefono, String tipo_documento, int numero_docuemento, Set<Prestamos> prestamos) {
        this.idUsuario = idUsuario;
        this.nombre_completo = nombre_completo;
        this.correo = correo;
        this.telefono = telefono;
        this.tipo_documento = tipo_documento;
        this.numero_docuemento = numero_docuemento;
        this.prestamos = prestamos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public int getNumero_docuemento() {
        return numero_docuemento;
    }

    public void setNumero_docuemento(int numero_docuemento) {
        this.numero_docuemento = numero_docuemento;
    }

    public Set<Prestamos> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Set<Prestamos> prestamos) {
        this.prestamos = prestamos;
    }
}