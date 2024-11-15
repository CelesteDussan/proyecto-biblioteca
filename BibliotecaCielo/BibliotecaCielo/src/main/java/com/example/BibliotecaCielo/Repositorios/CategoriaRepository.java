package com.example.BibliotecaCielo.Repositorios;

import com.example.BibliotecaCielo.Entidades.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categorias, Integer> {
}
