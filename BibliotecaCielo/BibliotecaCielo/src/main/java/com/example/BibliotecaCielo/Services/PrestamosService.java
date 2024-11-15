package com.example.BibliotecaCielo.Services;

import com.example.BibliotecaCielo.Entidades.Prestamos;
import com.example.BibliotecaCielo.Repositorios.PrestamosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PrestamosService {

    @Autowired
    private PrestamosRepository prestamoRepository;

    // Listar Prestamos
    public ResponseEntity<List<Prestamos>> getAllPrestamos() {
        List<Prestamos> prestamos = prestamoRepository.findAll();
        return ResponseEntity.ok(prestamos);
    }

    // Listar prestamos por ID
    public ResponseEntity<Prestamos> getPrestamoById(int id) {
        Optional<Prestamos> prestamo = prestamoRepository.findById(id);
        return prestamo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Agregar Prestamos
    public ResponseEntity<Prestamos> addPrestamo(Prestamos prestamo) {
        if (prestamo.getFechaEntrega() == null) {
            prestamo.setFechaEntrega(new Date());
        }
        Prestamos nuevoPrestamo = prestamoRepository.save(prestamo);
        return ResponseEntity.ok(nuevoPrestamo);
    }

    // Actualizar prestamo
    public ResponseEntity<Prestamos> updatePrestamo(Prestamos prestamo) {
        Optional<Prestamos> prestamoExistente = prestamoRepository.findById(prestamo.getIdPrestamo());

        if (prestamoExistente.isPresent()) {
            Prestamos prestamoActualizado = prestamoExistente.get();
            prestamoActualizado.setFechaEntrega(prestamo.getFechaEntrega());
            prestamoActualizado.setEncargado(prestamo.getEncargado());

            Prestamos updatedPrestamo = prestamoRepository.save(prestamoActualizado);
            return ResponseEntity.ok(updatedPrestamo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar prestamo
    public ResponseEntity<Prestamos> deletePrestamo(int id) {
        Optional<Prestamos> prestamo = prestamoRepository.findById(id);
        if (prestamo.isPresent()) {
            prestamoRepository.deleteById(id);
            return ResponseEntity.ok(prestamo.get());
        }
        return ResponseEntity.notFound().build();
    }
}