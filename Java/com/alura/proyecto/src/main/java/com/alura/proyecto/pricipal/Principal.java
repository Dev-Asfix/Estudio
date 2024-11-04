package com.alura.proyecto.pricipal;

import com.alura.proyecto.model.DatosBusqueda;
import com.alura.proyecto.model.Libro;
import com.alura.proyecto.service.ConsumoAPI;
import com.alura.proyecto.service.ConvertirDatos;

import java.util.List;

public class Principal {

    ConsumoAPI consumoAPI = new ConsumoAPI();
    ConvertirDatos convertirDatos = new ConvertirDatos();
    private final String URL_BASE = "https://gutendex.com/books/";

   public void mostrarMenu(){

       var json = consumoAPI.obtenerDatos(URL_BASE);
       var datos = convertirDatos.obtenerDatos(json, DatosBusqueda.class);
       System.out.println("Libros : ");

       List<Libro> libros = datos.resultados();
       libros.stream()
               .limit(10)
               .forEach(System.out::println);

       libros.forEach(System.out::println);
   }

}
