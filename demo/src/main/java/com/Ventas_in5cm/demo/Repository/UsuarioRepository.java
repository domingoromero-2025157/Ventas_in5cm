package com.Ventas_in5cm.demo.Repository;

import com.Ventas_in5cm.demo.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUsername(String username);

    Usuario registrar(String usuario, String password);

    List<Usuario> getAllUsuarios();
}