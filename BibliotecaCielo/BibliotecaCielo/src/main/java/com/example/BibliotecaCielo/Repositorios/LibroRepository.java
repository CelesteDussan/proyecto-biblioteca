package com.example.BibliotecaCielo.Repositorios;

import com.example.BibliotecaCielo.Entidades.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libros, Integer> {
}
