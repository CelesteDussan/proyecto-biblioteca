package com.example.BibliotecaCielo.Services;

import com.example.BibliotecaCielo.Entidades.Devoluciones;
import com.example.BibliotecaCielo.Repositorios.DevolucionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DevolucionesServices {

    @Autowired
    private DevolucionesRepository devolucionesRepository;


    public ResponseEntity<List<Devoluciones>> listarDevoluciones() {
        List<Devoluciones> devoluciones = devolucionesRepository.findAll();
        return ResponseEntity.ok(devoluciones);
    }

    public ResponseEntity<Devoluciones> AgregarDevoluciones(Devoluciones devoluciones) {
        devolucionesRepository.save(devoluciones);
        return ResponseEntity.ok(devoluciones);
    }
}
