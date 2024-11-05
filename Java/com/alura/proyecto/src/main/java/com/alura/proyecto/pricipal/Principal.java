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
   }

}
