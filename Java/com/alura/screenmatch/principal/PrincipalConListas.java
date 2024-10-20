package com.alura.screenmatch.principal;

import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;
import com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalConListas {
    public static void main(String[]args){
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.evalua(10);
        Pelicula otraPelicula = new Pelicula("Pablito", 2023);
        otraPelicula.evalua(5);
        var peliculaTitanic = new Pelicula("Titanic",2002);
        peliculaTitanic.evalua(4);
        Serie lost = new Serie("Lost", 2000);
        lost.evalua(20);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaTitanic);
        lista.add(lost);


        for(Titulo item : lista){
            System.out.println(item);

            if(item instanceof Pelicula pelicula && pelicula.getClasificacion() > 1){
                System.out.println(pelicula.getClasificacion());
            }
        }
        ArrayList<String> listas = new ArrayList<>();
        listas.add("Pablito");
        listas.add("Jack");
        listas.add("Perla");
        listas.add("Abiga");
        listas.add("Bercer");


        System.out.println("Lista Desordenada : " + listas);

        Collections.sort(listas);
        System.out.println("Lista Ordenada" + listas);

        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo :: getFechaDeLanzamiento));
        System.out.println(lista);
    }
}
