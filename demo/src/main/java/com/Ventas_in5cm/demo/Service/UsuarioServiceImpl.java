package com.Ventas_in5cm.demo.Service;

import com.Ventas_in5cm.demo.Entity.Usuarios;
import com.Ventas_in5cm.demo.Repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
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
    public Usuarios saveUsuarios(Usuarios usuarios) {

        usuarios.setPasword(passwordEncoder.encode(usuarios.getPasword()));

        return usuarioRepository.save(usuarios);
    }

    @Override
    public void deleteUsuarios(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuarios updateUsuarios(Integer id, Usuarios usuarios) {
        Usuarios existingUsuario = usuarioRepository.findById(id).orElseThrow();

        existingUsuario.setUsername(usuarios.getUsername());
        existingUsuario.setPasword(passwordEncoder.encode(usuarios.getPasword()));
        existingUsuario.setEmail(usuarios.getEmail());
        existingUsuario.setRol(usuarios.getRol());
        existingUsuario.setEstado(usuarios.getEstado());

        return usuarioRepository.save(existingUsuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuarios usuario = usuarioRepository.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return new User(
                usuario.getUsername(),
                usuario.getPasword(),
                new ArrayList<>()
        );
    }
}