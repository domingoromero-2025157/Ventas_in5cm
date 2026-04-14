package com.Ventas_in5cm.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final String USUARIO_VALIDO = "admin";
    private final String CONTRASENA_VALIDA = "1234";

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String usuario,
                            @RequestParam String clave) {

        if (USUARIO_VALIDO.equals(usuario) && CONTRASENA_VALIDA.equals(clave)) {
            return "redirect:/home";
        } else {
            return "login";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}