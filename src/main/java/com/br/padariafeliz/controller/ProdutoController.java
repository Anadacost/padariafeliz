package com.br.padariafeliz.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoController {

    // Página de produtos
    @GetMapping("/produtos")
    public String produtos() {
        return "produtos";
    }

    // Detalhes de um produto
    @GetMapping("/produto/detalhes")
    public String detalhesProduto() {
        return "detalhes-produto";
    }

}