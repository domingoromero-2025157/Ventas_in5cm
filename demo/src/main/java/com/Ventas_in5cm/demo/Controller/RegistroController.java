package com.Ventas_in5cm.demo.Controller;

import com.Ventas_in5cm.demo.Entity.Usuarios;
import com.Ventas_in5cm.demo.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/Registro")
    public String mostrarRegistro(){
        return "register";
    }

    @PostMapping("/Registro")
    public String registrarUsuario(Usuarios usuario){

        usuario.setRol("USER");
        usuario.setEstado(1);

        usuarioRepository.save(usuario);

        return "redirect:/login";
    }
}