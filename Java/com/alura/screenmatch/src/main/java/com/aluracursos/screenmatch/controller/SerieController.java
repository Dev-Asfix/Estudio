package com.aluracursos.screenmatch.controller;


import com.aluracursos.screenmatch.dto.EpisodioDTO;
import com.aluracursos.screenmatch.dto.SerieDTO;

import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/series")
public class SerieController {
    @Autowired
    private SerieService service;

    @GetMapping()
    public List<SerieDTO> mostrarSeries(){
        return service.obtenerSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> top5Series(){
        return service.top5Series();
    }

    @GetMapping("/lanzamientos")
    public List<SerieDTO> lanzamientos(){
        return service.lanzamientosRecientes();
    }

    @GetMapping("/{id}")
    public SerieDTO obtenerId(@PathVariable Long id){
        return service.obtenerId(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO> obtenerTemporadas(@PathVariable Long id){
        return service.obtenerTemporadas(id);
    }

    @GetMapping("/{id}/temporadas/{idTemporada}")
    public List<EpisodioDTO> obtenerTemporadaPorId(@PathVariable Long id,
                                                   @PathVariable Long idTemporada){
        return service.obtenerTemporadaPorId(id, idTemporada);
    }

    @GetMapping("/categoria/{nombreCategoria}")
    public List<SerieDTO> obtenerSerieCategoria(@PathVariable String nombreCategoria){
        return service.obtenerSerieCategoria(nombreCategoria);
    }
}
