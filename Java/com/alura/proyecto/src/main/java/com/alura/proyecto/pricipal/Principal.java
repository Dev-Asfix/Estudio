package com.alura.proyecto.pricipal;

import com.alura.proyecto.model.DatosBusqueda;
import com.alura.proyecto.model.Libro;
import com.alura.proyecto.service.ConsumoAPI;
import com.alura.proyecto.service.ConvertirDatos;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    Scanner in = new Scanner(System.in);
    ConsumoAPI consumoAPI = new ConsumoAPI();
    ConvertirDatos convertirDatos = new ConvertirDatos();
    private final String URL_BASE = "https://gutendex.com/books/";
    private final String URL_BASE_BUSQUEDA = "https://gutendex.com/books/?search=";

   public void mostrarMenu(){

       var json = consumoAPI.obtenerDatos(URL_BASE);
       var datos = convertirDatos.obtenerDatos(json, DatosBusqueda.class);
       System.out.println(datos);

       //Top 10 Libros mas descargados
       System.out.println("Top 10 libros mas descargados/");
       datos.resultados().stream()
               .sorted(Comparator.comparing(Libro::descargas).reversed())
               .limit(5)
               .map(l -> l.titulo().toUpperCase())
               //.map(Libro::titulo) -- Solo imprime titulos
               .forEach(System.out::println);

       //Busqueda de libros por nombre
       System.out.println("Ingrese el NOmbre : ");
       var tituloLibro = in.nextLine();
       json = consumoAPI.obtenerDatos(URL_BASE_BUSQUEDA+tituloLibro.replace(" ","+"));
       var datosBusqueda = convertirDatos.obtenerDatos(json, DatosBusqueda.class);

       Optional<Libro> libroOptional = datosBusqueda.resultados().stream()
               .filter(t -> t.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
               .findFirst();
       if(libroOptional.isPresent()){
           System.out.println("Libro encontrado");
           System.out.println(libroOptional.get());
       } else {
           System.out.println("Libro no encontrado");
       }

       //Trabajando con estadisticas

       DoubleSummaryStatistics est = datosBusqueda.resultados().stream()
               .filter(d -> d.descargas() > 0)
               .collect(Collectors.summarizingDouble(Libro::descargas));


       System.out.println("Estadisticas de las descargas : ");
       System.out.println(est);
       System.out.println("Estadísticas de descargas de los libros:");
       System.out.println("Promedio de descargas: " + est.getAverage());
       System.out.println("Total de descargas: " + est.getSum());
       System.out.println("Mínimo de descargas: " + est.getMin());
       System.out.println("Máximo de descargas: " + est.getMax());
       System.out.println("Cantidad de libros: " + est.getCount());
   }

}
