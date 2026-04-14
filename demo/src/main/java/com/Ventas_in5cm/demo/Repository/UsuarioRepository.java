package com.Ventas_in5cm.demo.Repository;

import com.Ventas_in5cm.demo.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUsernameAndPassword(String username, String password);

    Optional<Usuario> findByUsername(String username);

}