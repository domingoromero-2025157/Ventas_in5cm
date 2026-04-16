package com.Ventas_in5cm.demo.Controller;

import com.Ventas_in5cm.demo.Entity.Usuarios;
import com.Ventas_in5cm.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "Registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(Usuarios usuario) {

        System.out.println(" ENTRÓ AL POST REGISTRO");

        System.out.println("USERNAME: " + usuario.getUsername());
        System.out.println("EMAIL: " + usuario.getEmail());
        System.out.println("PASSWORD: " + usuario.getPasword());

        usuario.setRol("USER");
        usuario.setEstado(1);

        usuarioService.saveUsuarios(usuario);

        return "redirect:/login";
    }
}