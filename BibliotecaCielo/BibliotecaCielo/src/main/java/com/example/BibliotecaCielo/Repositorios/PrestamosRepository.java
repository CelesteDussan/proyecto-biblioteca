package com.example.BibliotecaCielo.Repositorios;

import com.example.BibliotecaCielo.Entidades.Prestamos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamosRepository extends JpaRepository<Prestamos, Integer> {
}
