package com.example.BibliotecaCielo.Controladores;


import com.example.BibliotecaCielo.Entidades.Libros;
import com.example.BibliotecaCielo.Services.LibrosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibrosControlador {

    @Autowired
    private LibrosServices libroService;

    @GetMapping
    public ResponseEntity<List<Libros>> listar() {
        return libroService.getAllLibros();
    }

    @GetMapping("/{idLibro}")
    public ResponseEntity<Libros> listarID(@PathVariable int idLibro) {
        return libroService.getLibroById(idLibro);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Libros> guardar(@RequestBody Libros libro) {
        return libroService.addLibro(libro);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Libros> actualizar(@RequestBody Libros libro) {
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("/{idLibro}")
    public ResponseEntity<Void> delete(@PathVariable int idLibro) {
        return libroService.deleteLibro(idLibro);
    }
}