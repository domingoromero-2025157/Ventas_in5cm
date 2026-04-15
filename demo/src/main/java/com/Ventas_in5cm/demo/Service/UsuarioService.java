package com.Ventas_in5cm.demo.Service;

import com.Ventas_in5cm.demo.Entity.Usuarios;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsuarioService {
    List<Usuarios> getAllUsuarios();
    Usuarios getUsuariosById (Integer id);
    Usuarios saveUsuarios (Usuarios usuarios);
    Usuarios updateUsuarios (Integer id, Usuarios usuarios);
    void deleteUsuarios (Integer id);
}
