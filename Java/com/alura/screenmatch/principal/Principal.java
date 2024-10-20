package com.alura.screenmatch.principal;

import com.alura.screenmatch.calculos.CalculadoraDeTiempo;
import com.alura.screenmatch.calculos.FiltroRecomendacion;
import com.alura.screenmatch.modelos.Episodio;
import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.setDuracionEnMinutos(180);
        System.out.println("Duración de la película: " + miPelicula.getDuracionEnMinutos());

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(8);
        miPelicula.evalua(5);
        miPelicula.evalua(10);
        System.out.println("Total de evaluaciones: " + miPelicula.getTotalDeEvaluaciones());
        System.out.println(miPelicula.calculaMediaEvaluaciones());


        Serie lost = new Serie("Lost", 2000);
        lost.muestraFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duracion de la série: " + lost.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula("Pablito", 2023);
        otraPelicula.setDuracionEnMinutos(200);
        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluido(miPelicula);
        calculadora.incluido(otraPelicula);
        calculadora.incluido(lost);
        System.out.println(calculadora.getTiempoTotal());

        FiltroRecomendacion filtro = new FiltroRecomendacion();
        filtro.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizaciones(300);
        filtro.filtra(episodio);

        var peliculaTitanic = new Pelicula("Titanic",2002);
        peliculaTitanic.setDuracionEnMinutos(180);

        ArrayList<Pelicula> listaPelicula = new ArrayList<>();
        listaPelicula.add(miPelicula);
        listaPelicula.add(otraPelicula);
        listaPelicula.add(peliculaTitanic);

        System.out.println("el tamaño de todo es : " + listaPelicula.size());
        System.out.println("La primera pelicula es : " + listaPelicula.get(0).getNombre());
        System.out.println("La segunda pelicula es : " + listaPelicula.get(1).getNombre());

        System.out.println("La tercera pelicula es : " + listaPelicula.get(2).getNombre());

        System.out.println(listaPelicula);
        System.out.println(listaPelicula.get(0).toString());

    }
}