package com.example.BibliotecaCielo.Controladores;


import com.example.BibliotecaCielo.Entidades.Libros;
import com.example.BibliotecaCielo.Entidades.PrestamoDTO;
import com.example.BibliotecaCielo.Entidades.Prestamos;
import com.example.BibliotecaCielo.Entidades.Usuarios;
import com.example.BibliotecaCielo.Services.LibrosServices;
import com.example.BibliotecaCielo.Services.PrestamosService;
import com.example.BibliotecaCielo.Services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("prestamos")
public class PrestamoControlador {

    @Autowired
    private PrestamosService prestamoService;

    @Autowired
    private UsuarioServices usuarioService;

    @Autowired
    private LibrosServices librosService;


    @GetMapping
    public ResponseEntity<List<Prestamos>> listar() {
        return prestamoService.getAllPrestamos();
    }

    @GetMapping("/{idPrestamo}")
    public ResponseEntity<Prestamos> listarID(@PathVariable int idPrestamo) {
        return prestamoService.getPrestamoById(idPrestamo);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> guardar(@RequestBody PrestamoDTO prestamoDTO) {
        ResponseEntity<Libros> libroResponse = librosService.getLibroById(prestamoDTO.getLibroId());
        ResponseEntity<Usuarios> usuarioResponse = usuarioService.getUsuarioById(prestamoDTO.getUsuarioId());

        if (libroResponse.getStatusCode() == HttpStatus.OK && usuarioResponse.getStatusCode() == HttpStatus.OK) {
            Libros libro = libroResponse.getBody();
            Usuarios usuario = usuarioResponse.getBody();

            if (libro != null && usuario != null) {
                Prestamos prestamo = new Prestamos(libro, usuario, prestamoDTO.getFechaEntrega(),
                        prestamoDTO.getEncargado(), prestamoDTO.getEstado());
                return prestamoService.addPrestamo(prestamo);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Libro o Usuario no encontrado");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Libro o Usuario no encontrado");
        }
    }

    @PutMapping
    public ResponseEntity<Prestamos> actualizar(@RequestBody Prestamos prestamo) {
        return prestamoService.updatePrestamo(prestamo);
    }

    @DeleteMapping("/{idPrestamo}")
    public ResponseEntity<Prestamos> delete(@PathVariable int idPrestamo) {
        return prestamoService.deletePrestamo(idPrestamo);
    }
}