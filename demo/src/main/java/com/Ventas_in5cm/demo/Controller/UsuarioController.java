package com.Ventas_in5cm.demo.Controller;

import com.Ventas_in5cm.demo.Entity.Usuario;
import com.Ventas_in5cm.demo.Service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    // LOGIN (CORREGIDO)
    @GetMapping("/usuario")
    public String login() {
        return "usuario";
    }

    @PostMapping("/usuario/login")
    public String validar(@RequestParam String usuario,
                          @RequestParam String password,
                          Model model) {

        Usuario u = service.login(usuario, password);

        if (u != null) {
            return "redirect:/lista";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "usuario";
        }
    }

    // REGISTRO
    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

    @PostMapping("/registro")
    public String guardar(@RequestParam String usuario,
                          @RequestParam String password,
                          Model model) {

        Usuario u = service.registrar(usuario, password);

        if (u == null) {
            model.addAttribute("error", "Usuario ya existe");
            return "registro";
        }

        return "redirect:/usuario";
    }

    // LISTA
    @GetMapping("/lista")
    public String listar(Model model) {

        List<Usuario> lista = service.getAllUsuarios();

        model.addAttribute("usuarios", lista);
        return "lista";
    }

    // ELIMINAR
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {

        service.deleteUsuario(id);

        return "redirect:/lista";
    }
}