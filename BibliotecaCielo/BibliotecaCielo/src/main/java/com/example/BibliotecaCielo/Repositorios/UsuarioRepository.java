package com.example.BibliotecaCielo.Repositorios;

import com.example.BibliotecaCielo.Entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {
}
