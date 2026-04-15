package com.Ventas_in5cm.demo.Service;

import com.Ventas_in5cm.demo.Entity.Usuarios;
import com.Ventas_in5cm.demo.Repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements com.Ventas_in5cm.demo.Service.UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    // Constructor corregido para que coincida con el nombre de la clase
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuarios> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuarios getUsuariosById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuarios saveUsuarios(Usuarios usuarios) throws RuntimeException {
        // Encriptando la contraseña antes de guardarla
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuarios.setPasword(passwordEncoder.encode(usuarios.getPasword()));

        return usuarioRepository.save(usuarios);
    }

    @Override
    public void deleteUsuarios(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no existe");
        }
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuarios updateUsuarios(Integer id, Usuarios usuarios) {
        Usuarios existingUsuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El usuario no existe"));

        existingUsuario.setUsername(usuarios.getUsername());
        existingUsuario.setPasword(usuarios.getPasword());  // Asegúrate de que la contraseña se establezca correctamente
        existingUsuario.setEmail(usuarios.getEmail());
        existingUsuario.setRol(usuarios.getRol());
        existingUsuario.setEstado(usuarios.getEstado());

        return usuarioRepository.save(existingUsuario);
    }

    // Implementación del método loadUserByUsername de UserDetailsService
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuarios usuario = usuarioRepository.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        // Asegúrate de usar un encoder para las contraseñas (en el caso de contraseñas encriptadas)
        return new User(
                usuario.getUsername(),
                usuario.getPasword(),  // La contraseña debe estar encriptada
                new ArrayList<>()
        );
    }
}