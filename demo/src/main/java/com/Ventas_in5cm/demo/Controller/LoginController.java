package com.Ventas_in5cm.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "Login";
    }
}