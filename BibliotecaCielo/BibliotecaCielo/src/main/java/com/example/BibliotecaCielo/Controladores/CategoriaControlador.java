package com.example.BibliotecaCielo.Controladores;

import com.example.BibliotecaCielo.Entidades.Categorias;
import com.example.BibliotecaCielo.Services.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaControlador {

    @Autowired
    private CategoriaServices categoriaServices;

    @GetMapping
    public ResponseEntity<List<Categorias>> listar(){
        return categoriaServices.listar();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categorias> buscar(@PathVariable int id){
        return categoriaServices.buscar(id);
    }
    @PostMapping
    public ResponseEntity<Categorias> inserir(@RequestBody Categorias categorias){
        return categoriaServices.insertar(categorias);
    }
}
