package com.Ventas_in5cm.demo.Service;

import com.Ventas_in5cm.demo.Entity.Usuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> getAllUsuarios();

    Usuario getUsuarioById(Integer id);

    Usuario saveUsuario(Usuario usuario);

    Usuario updateUsuario(Integer id, Usuario usuario);

    void deleteUsuario(Integer id);
}