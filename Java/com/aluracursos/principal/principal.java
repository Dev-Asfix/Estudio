package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporada;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

        private Scanner in = new Scanner(System.in);
        private ConsumoAPI consumoAPI = new ConsumoAPI();
        private final String API_KEY = "&apikey=ef162820";
        private final String API_BASE = "https://www.omdbapi.com/?t=";
        private ConvierteDatos convierteDatos = new ConvierteDatos();

        public void muestraMenu() {
                System.out.println("Escribe el nombre de la Serie: ");
                var nombre = in.nextLine();
                var json = consumoAPI.obtenerDatos(API_BASE + nombre.replace(" ", "+") + API_KEY);
                var datos = convierteDatos.obtenerDatos(json, DatosSerie.class);
                System.out.println(datos);

                List<DatosTemporada> temporadas = new ArrayList<>();

                for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
                        json = consumoAPI.obtenerDatos(API_BASE + nombre.replace(" ", "+") + "&Season=" + i + API_KEY);
                        var datosTemporada = convierteDatos.obtenerDatos(json, DatosTemporada.class);
                        temporadas.add(datosTemporada);
                }
                // temporadas.forEach(System.out::println);
                // for (int i = 0; i < datos.totalDeTemporadas(); i++) {
                // List<DatosEpisodio> episodioTemporada = temporadas.get(i).episodios();
                // for (int j = 0; j < episodioTemporada.size(); j++) {
                // System.out.println(episodioTemporada.get(j).titulo());
                // }
                // }
                // Lambdas

                // temporadas.forEach(t -> t.episodios().forEach(e ->
                // System.out.println(e.titulo())));

                List<DatosEpisodio> datosEpisodios = temporadas.stream()
                                .flatMap(t -> t.episodios().stream())
                                .collect(Collectors.toList());

                System.out.println("Top 5 episodios:");
                datosEpisodios.stream()
                                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                                .filter(t -> !t.evaluacion().equalsIgnoreCase("N/A"))
                                .limit(5)
                                .forEach(System.out::println);

                // Convirtiendo los datos en una lista del tipo episodio
                List<Episodio> episodios = temporadas.stream()
                                .flatMap(t -> t.episodios().stream()
                                                .map(d -> new Episodio(t.temporada(), d)))
                                .collect(Collectors.toList());

                episodios.forEach(System.out::println);

                // Orden por año
                System.out.println("Dime el año en el que quieres que apararescan : ");
                var fecha = in.nextInt();
                in.nextLine();

                LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                episodios.stream()
                                .filter(e -> e.getFechaDeLanzamiento() != null
                                                && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
                                .forEach(e -> System.out.println(
                                                "Temporada: " + e.getTemporada() +
                                                                "Titulo: " + e.getTitulo() +
                                                                "Fecha de Lanzamiento : "
                                                                + e.getFechaDeLanzamiento().format(dtf)));

                // Busca episodio por pedazo de titulo

                System.out.println("Por favor escriba el titulo del espisodio que desea ver");
                var pedazoDeTitulo = in.nextLine();

                Optional<Episodio> episodioBuscado = episodios.stream()
                                .filter(e -> e.getTitulo().toUpperCase().contains(pedazoDeTitulo.toUpperCase()))
                                .findFirst();
                if (episodioBuscado.isPresent()) {
                        System.out.println("Episodio Encontrado");
                        System.out.println("Los datos son: " + episodioBuscado.get());
                } else {
                        System.out.println("Episodio no encontrado");
                }

                Map<Integer, Double> evaluacionesPorTemporada = episodios.stream()
                                .collect(Collectors.groupingBy(Episodio::getTemporada,
                                                Collectors.averagingDouble(Episodio::getEvaluacion)));

                System.out.println(evaluacionesPorTemporada);

                DoubleSummaryStatistics est = episodios.stream()
                                .filter(e -> e.getEvaluacion() != 0.0)
                                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
                System.out.println(est);
                System.out.println("El numero de la suma es : " + est.getAverage());
                System.out.println("El numero maximo es : " + est.getMax());
                System.out.println("EL numero minimo es : " + est.getMin());
        }
}
