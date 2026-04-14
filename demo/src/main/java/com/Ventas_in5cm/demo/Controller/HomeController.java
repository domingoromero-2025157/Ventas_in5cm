package com.Ventas_in5cm.demo.Controller;

import com.Ventas_in5cm.demo.Entity.Usuario;
import com.Ventas_in5cm.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/home")
    public String listar(Model model) {
        List<Usuario> lista = service.getAllUsuarios();
        model.addAttribute("usuarios", lista);
        return "home";
    }

    @GetMapping("/clientes")
    public String clientes() { return "cliente"; }

    @GetMapping("/productos")
    public String productos() { return "producto"; }

    @GetMapping("/usuarios")
    public String usuarios() { return "usuario"; }

    @GetMapping("/ventas")
    public String ventas() { return "venta"; }

    @GetMapping("/detalleVenta")
    public String detalleVenta() { return "detalleVenta"; }
}