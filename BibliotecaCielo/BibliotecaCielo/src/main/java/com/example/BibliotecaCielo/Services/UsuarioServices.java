package com.example.BibliotecaCielo.Services;

import com.example.BibliotecaCielo.Entidades.Usuarios;
import com.example.BibliotecaCielo.Repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Listar Usuarios
    public ResponseEntity<List<Usuarios>> getAllUsuarios() {
        List<Usuarios> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    // Listar por ID
    public ResponseEntity<Usuarios> getUsuarioById(int id) {
        Optional<Usuarios> usuario = usuarioRepository.findById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Guardar Usuarios
    public ResponseEntity<Usuarios> addUsuario(Usuarios usuario) {
        Usuarios nuevoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    // Actualizar Usuarios
    public ResponseEntity<Usuarios> updateUsuario(Usuarios usuario) {
        Optional<Usuarios> usuarioExistente = usuarioRepository.findById(usuario.getIdUsuario());
        if (usuarioExistente.isPresent()) {
            Usuarios usuariosActualizado = usuarioExistente.get();
            usuariosActualizado.setCorreo(usuario.getCorreo());
            usuariosActualizado.setTelefono(usuario.getTelefono());
            usuariosActualizado.setTipo_documento(usuario.getTipo_documento());
            usuariosActualizado.setNumero_docuemento(usuario.getNumero_docuemento());
            usuariosActualizado.setNombre_completo(usuario.getNombre_completo());

            Usuarios updatedUsuario = usuarioRepository.save(usuariosActualizado);
            return ResponseEntity.ok(updatedUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar Usuarios por ID
    public ResponseEntity<Void> deleteUsuario(int id) {
        Optional<Usuarios> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}