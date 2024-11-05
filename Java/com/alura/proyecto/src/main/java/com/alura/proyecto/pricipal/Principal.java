package com.alura.proyecto.pricipal;

import com.alura.proyecto.model.DatosBusqueda;
import com.alura.proyecto.model.Libro;
import com.alura.proyecto.service.ConsumoAPI;
import com.alura.proyecto.service.ConvertirDatos;

import java.util.List;

public class Principal {

    ConsumoAPI consumoAPI = new ConsumoAPI();
    ConvertirDatos convertirDatos = new ConvertirDatos();
    Scanner in = new Scanner(System.in);
    private final String URL_BASE = "https://gutendex.com/books/";
    private final String URL_BASE_BUSQUEDA = "https://gutendex.com/books/?search=";
   
    public void mostrarMenu(){
        var json = consumoAPI.obtenerDatos(URL_BASE);
        var datos = convertirDatos.obtenerDatos(json, DatosBusqueda.class);
        System.out.println("Libros : ");

        List<Libro> libros = datos.resultados();

       libros.stream()
               .limit(5)
               .forEach(libro -> System.out.println(libro.titulo()));

               System.out.println("Escribe el nombre que quieres buscar : ");
       var nombre = in.nextLine();

       json = consumoAPI.obtenerDatos(URL_BASE_BUSQUEDA + nombre.replace(" ", "%20"));
       var datosBusqueda = convertirDatos.obtenerDatos(json , DatosBusqueda.class);


    }

}
