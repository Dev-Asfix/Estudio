package com.aluracursos.screenmatch.principal;

import java.util.Arrays;
import java.util.List;

public class Ejemplo {

    public void muestraEjemplo(){
        List<String> nombres = Arrays.asList("Pablo", "Aldair", "Jack","Smit","Perla");
        nombres.stream()
                .sorted()
                .limit(2)
                .filter(e -> e.startsWith("A"))
                .map(e -> e.toUpperCase())
                .forEach(System.out::println);


    }
}
