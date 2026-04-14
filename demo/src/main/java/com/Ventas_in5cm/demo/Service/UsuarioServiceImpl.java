package com.Ventas_in5cm.demo.Service;

import com.Ventas_in5cm.demo.Entity.Usuario;
import com.Ventas_in5cm.demo.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public List<Usuario> getAllUsuarios() {
        return repo.findAll();
    }

    @Override
    public Usuario login(String username, String password) {

        Usuario u = repo.findByUsername(username);

        if (u != null && encoder.matches(password, u.getPassword())) {
            return u;
        }

        return null;
    }

    @Override
    public Usuario registrar(String username, String password) {

        if (repo.findByUsername(username) != null) {
            return null;
        }

        Usuario u = new Usuario();
        u.setUsername(username);
        u.setPassword(encoder.encode(password));

        return repo.save(u);
    }

    @Override
    public Usuario getUsuarioById(Integer id) {

        Optional<Usuario> user = repo.findById(id);
        return user.orElse(null);
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {

        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return repo.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Integer id, Usuario usuario) {

        Optional<Usuario> existing = repo.findById(id);

        if (existing.isEmpty()) {
            return null;
        }

        Usuario u = existing.get();

        u.setUsername(usuario.getUsername());
        u.setEmail(usuario.getEmail());
        u.setRol(usuario.getRol());
        u.setEstado(usuario.getEstado());

        if (usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
            u.setPassword(encoder.encode(usuario.getPassword()));
        }

        return repo.save(u);
    }

    @Override
    public void deleteUsuario(Integer id) {
        repo.deleteById(id);
    }
}