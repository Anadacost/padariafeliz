package com.br.padariafeliz.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgendamentoController {

    // Página de agendamentos
    @GetMapping("/agendamentos")
    public String agendamentos() {
        return "agendamentos";
    }

    // Agendamentos realizados pelo cliente
    @GetMapping("/meus-agendamentos")
    public String meusAgendamentos() {
        return "meus-agendamentos";
    }

}