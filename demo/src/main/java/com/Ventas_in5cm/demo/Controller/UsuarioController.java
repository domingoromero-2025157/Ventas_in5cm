package com.Ventas_in5cm.demo.Controller;

import com.Ventas_in5cm.demo.Service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios/lista")
    public String listarUsuarios(Model model) {

        var lista = usuarioService.getAllUsuarios();

        System.out.println("USUARIOS: " + lista);

        model.addAttribute("usuarios", lista);

        return "usuarios";
    }
    }

