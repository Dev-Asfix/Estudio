package com.alura.frases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {

    @Autowired
    private FrasesRepository repo;

    public FrasesDTO obtenerFrase(){
        Frases frase = repo.obtenerFrase();
        return new FrasesDTO(frase.getTitulo(),frase.getFrase(),frase.getPersonaje(),frase.getPoster());

    }
}
