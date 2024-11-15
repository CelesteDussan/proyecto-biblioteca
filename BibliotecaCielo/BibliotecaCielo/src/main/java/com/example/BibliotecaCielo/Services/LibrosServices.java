package com.example.BibliotecaCielo.Services;


import com.example.BibliotecaCielo.Entidades.Libros;
import com.example.BibliotecaCielo.Repositorios.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrosServices {

    @Autowired
    private LibroRepository libroRepository;

    // Listar Libros
    public ResponseEntity<List<Libros>> getAllLibros() {
        List<Libros> libros = libroRepository.findAll();
        return ResponseEntity.ok(libros);
    }

    // Listar Libros por ID
    public ResponseEntity<Libros> getLibroById(int id) {
        Optional<Libros> libro = libroRepository.findById(id);
        return libro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Guardar Libro
    public ResponseEntity<Libros> addLibro(Libros libro) {
        Libros nuevoLibro = libroRepository.save(libro);
        return ResponseEntity.ok(nuevoLibro);
    }

    // Actualizar Libro
    public ResponseEntity<Libros> updateLibro(Libros libro) {
        Optional<Libros> libroExistente = libroRepository.findById(libro.getIdLibro());
        if (libroExistente.isPresent()) {
            Libros libroActualizado = libroExistente.get();
            libroActualizado.setAutor(libro.getAutor());
            libroActualizado.setTitulo(libro.getTitulo());
            libroActualizado.setCantidad(libro.getCantidad());
            libroActualizado.setEstado(libro.getEstado());
            libroActualizado.setCategoria(libro.getCategoria());
            Libros updatedLibro = libroRepository.save(libroActualizado);
            return ResponseEntity.ok(updatedLibro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar Libro por ID
    public ResponseEntity<Void> deleteLibro(int id) {
        Optional<Libros> libro = libroRepository.findById(id);
        if (libro.isPresent()) {
            libroRepository.delete(libro.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}