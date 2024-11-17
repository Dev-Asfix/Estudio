package com.alura.frases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FraseDriver  {
    @Autowired
    private FraseService service;

    @GetMapping("/series/frases")
    public FrasesDTO obtenerDatos(){
        return service.obtenerFrase();
    }
}
