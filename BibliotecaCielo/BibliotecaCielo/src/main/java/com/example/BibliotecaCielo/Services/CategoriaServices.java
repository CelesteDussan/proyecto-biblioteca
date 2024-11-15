package com.example.BibliotecaCielo.Services;

import com.example.BibliotecaCielo.Entidades.Categorias;
import com.example.BibliotecaCielo.Repositorios.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServices {

    @Autowired
    private CategoriaRepository categoriaRepository;

    //listar categoria
    public ResponseEntity<List<Categorias>> listar() {
        List<Categorias> categorias = categoriaRepository.findAll();
        return ResponseEntity.ok(categorias);
    }
    public ResponseEntity<Categorias> buscar(Integer id) {
        Optional<Categorias> categoria = categoriaRepository.findById(id);
        return categoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    //Guardar categoria
    public ResponseEntity<Categorias> insertar(Categorias categoria) {
        Categorias nuevaCategoria = categoriaRepository.save(categoria);
        return ResponseEntity.ok(nuevaCategoria);
    }
}
