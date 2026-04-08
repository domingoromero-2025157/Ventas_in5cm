package com.Ventas_in5cm.demo.Service;

import com.Ventas_in5cm.demo.Entity.Usuario;
import com.Ventas_in5cm.demo.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Integer id, Usuario usuario) {
        Usuario existente = getUsuarioById(id);

        existente.setUsername(usuario.getUsername());
        existente.setPassword(usuario.getPassword()); // ← se guarda en "pasword" en BD
        existente.setEmail(usuario.getEmail());
        existente.setRol(usuario.getRol());
        existente.setEstado(usuario.getEstado());

        return usuarioRepository.save(existente);
    }

    @Override
    public void deleteUsuario(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no existe");
        }
        usuarioRepository.deleteById(id);
    }
}