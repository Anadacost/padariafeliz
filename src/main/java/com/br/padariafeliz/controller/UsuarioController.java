package com.br.padariafeliz.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    // Página de cadastro
    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    // Página de login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

}