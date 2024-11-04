package com.alura.proyecto.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosBusqueda(
        @JsonAlias("count") Integer contador,
        @JsonAlias("results") List<Libro> resultados

        ){


}
