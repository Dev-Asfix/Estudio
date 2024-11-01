package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporada;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner in = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String API_KEY = "&apikey=ef162820";
    private final String API_BASE = "https://www.omdbapi.com/?t=";
    private ConvierteDatos convierteDatos = new ConvierteDatos();

    public void muestraMenu(){
        System.out.println("Escribe el nombre de la Serie: ");
        var nombre = in.nextLine();
        var json = consumoAPI.obtenerDatos(API_BASE+nombre.replace(" ", "+")+API_KEY);
        var datos = convierteDatos.obtenerDatos(json , DatosSerie.class);
        System.out.println(datos);

        List<DatosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= datos.totalDeTemporadas() ; i++) {
            json = consumoAPI.obtenerDatos(API_BASE+nombre.replace(" ","+")+"&Season="+i+API_KEY);
            var datosTemporada = convierteDatos.obtenerDatos(json , DatosTemporada.class);
            temporadas.add(datosTemporada);
        }
        //temporadas.forEach(System.out::println);
//        for (int i = 0; i < datos.totalDeTemporadas(); i++) {
//            List<DatosEpisodio> episodioTemporada = temporadas.get(i).episodios();
//            for (int j = 0; j < episodioTemporada.size(); j++) {
//                System.out.println(episodioTemporada.get(j).titulo());
//            }
//        }
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
    }
}
