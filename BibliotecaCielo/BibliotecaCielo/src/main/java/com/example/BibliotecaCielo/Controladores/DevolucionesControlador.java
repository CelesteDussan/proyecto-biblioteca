package com.example.BibliotecaCielo.Controladores;

import com.example.BibliotecaCielo.Entidades.DevolucionDTO;
import com.example.BibliotecaCielo.Entidades.Devoluciones;
import com.example.BibliotecaCielo.Entidades.Prestamos;
import com.example.BibliotecaCielo.Services.DevolucionesServices;
import com.example.BibliotecaCielo.Services.PrestamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/devoluciones")
public class DevolucionesControlador {

    @Autowired
    private DevolucionesServices devolucionesServices;
    @Autowired
    PrestamosService prestamosService;

    @GetMapping
    public ResponseEntity<List<Devoluciones>> listarDevoluciones() {
        return devolucionesServices.listarDevoluciones();

    }

    @PostMapping
    public ResponseEntity registrarDevolucion(@RequestBody DevolucionDTO devolucionDTO) {
        ResponseEntity<Prestamos> prestamoResponse = prestamosService.getPrestamoById(devolucionDTO.getPrestamoId());

        if (prestamoResponse.getStatusCode() == HttpStatus.OK) {
            Prestamos prestamo = prestamoResponse.getBody();

            if (prestamo != null) {
                Devoluciones devolucion = new Devoluciones(prestamo, devolucionDTO.getFechaDevolucion(), devolucionDTO.getEstado());
                devolucionesServices.AgregarDevoluciones(devolucion);
                return ResponseEntity.status(HttpStatus.CREATED).body("Devolución registrada exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Préstamo no encontrado");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Préstamo no encontrado");
        }
    }
}

