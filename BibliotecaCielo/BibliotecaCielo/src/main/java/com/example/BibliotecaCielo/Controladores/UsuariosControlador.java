package com.example.BibliotecaCielo.Controladores;

import com.example.BibliotecaCielo.Entidades.Usuarios;
import com.example.BibliotecaCielo.Services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosControlador {

    @Autowired
    private UsuarioServices usuarioServices;

    @GetMapping
    public ResponseEntity<List<Usuarios>> listar() {
        return usuarioServices.getAllUsuarios();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuarios> listarID(@PathVariable int idUsuario) {
        return usuarioServices.getUsuarioById(idUsuario);
    }

    @PostMapping
    public ResponseEntity<Usuarios> guardar(@RequestBody Usuarios usuarios) {
        return usuarioServices.addUsuario(usuarios);
    }

    @PutMapping
    public ResponseEntity<Usuarios> actualizar(@RequestBody Usuarios usuarios) {
        return usuarioServices.updateUsuario(usuarios);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> delete(@PathVariable int idUsuario) {
        return usuarioServices.deleteUsuario(idUsuario);
    }
}