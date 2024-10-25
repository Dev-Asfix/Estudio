package com.alura.screenmatch.principal;

import com.alura.screenmatch.modelos.Titulo;
//import com.google.gson.Gson;
import com.alura.screenmatch.modelos.TituloOmdb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba un nombre de la pelicula: ");
        var busqueda = lectura.nextLine();

        String direccion = "https://www.omdbapi.com/?t="+busqueda+"&apikey=ef162820";


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                 .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);



        //Gson gson = new Gson();
        //Titulo mitutulo = gson.fromJson(json,Titulo.class);
        //TituloOmdb mitutulo = gson.fromJson(json, TituloOmdb.class);
        //System.out.println(mitutulo);
    }
}
