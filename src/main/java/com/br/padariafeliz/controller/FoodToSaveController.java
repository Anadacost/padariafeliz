package com.br.padariafeliz.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodToSaveController {

    // Página das sacolas misteriosas
    @GetMapping("/food-to-save")
    public String foodToSave() {
        return "food-to-save";
    }

}