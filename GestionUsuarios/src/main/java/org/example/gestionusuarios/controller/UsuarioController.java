package org.example.gestionusuarios.controller;

import org.example.gestionusuarios.model.LoginRequest;
import org.example.gestionusuarios.model.Usuario;
import org.example.gestionusuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public String iniciarSesion(@RequestBody LoginRequest loginRequest) {
        return usuarioService.iniciarSesion(loginRequest.getCorreo(), loginRequest.getContrasena());
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    // Puedes agregar métodos para mostrar usuarios y sesiones aquí
}
