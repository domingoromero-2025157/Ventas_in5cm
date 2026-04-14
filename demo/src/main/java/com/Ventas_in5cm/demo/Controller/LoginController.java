package com.Ventas_in5cm.demo.Controller;

import com.Ventas_in5cm.demo.Entity.Usuario;
import com.Ventas_in5cm.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService service;

    // LOGIN
    @GetMapping("/")
    public String login() {
        return "Login";
    }

    @PostMapping("/login")
    public String validar(@RequestParam String usuario,
                          @RequestParam String password,
                          Model model) {

        Usuario u = service.login(usuario, password);

        if (u != null) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "Login";
        }
    }

    // REGISTRO


    // LISTA DE USUARIOS


    // ELIMINAR USUARIO
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.deleteUsuario(id);
        return "redirect:/lista";
    }
}