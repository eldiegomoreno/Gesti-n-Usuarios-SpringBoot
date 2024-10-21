package org.example.gestionusuarios.service;

import org.example.gestionusuarios.model.Sesion;
import org.example.gestionusuarios.model.Usuario;
import org.example.gestionusuarios.repository.SesionRepository;
import org.example.gestionusuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SesionRepository sesionRepository;

    public String iniciarSesion(String correo, String contrasena) {
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            // Crear nueva sesión
            Sesion sesion = new Sesion();
            sesion.setUsuarioId(usuario.getId());
            sesion.setFechaInicio(LocalDateTime.now());
            sesionRepository.save(sesion);

            return "Inicio de sesión exitoso, fecha de inicio: " + sesion.getFechaInicio();
        } else {
            return "Credenciales incorrectas";
        }
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
