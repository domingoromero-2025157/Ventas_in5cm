package com.Ventas_in5cm.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String inicio() {
        return "home";
    }

    @GetMapping("/home")
    public String home() { return "home"; }

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