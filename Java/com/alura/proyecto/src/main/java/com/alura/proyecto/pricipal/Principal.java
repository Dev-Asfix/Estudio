package com.alura.proyecto.pricipal;

import com.alura.proyecto.model.DatosBusqueda;
import com.alura.proyecto.model.Libro;
import com.alura.proyecto.service.ConsumoAPI;
import com.alura.proyecto.service.ConvertirDatos;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    ConsumoAPI consumoAPI = new ConsumoAPI();
    ConvertirDatos convertirDatos = new ConvertirDatos();
    Scanner in = new Scanner(System.in);
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
               .forEach(System.out::println)
       ;




   }

}

