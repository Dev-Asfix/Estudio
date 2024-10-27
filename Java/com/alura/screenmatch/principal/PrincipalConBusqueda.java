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


        //Http client
        HttpClient client = HttpClient.newHttpClient();
        //Reques
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

                //clasea HttpREsponse
        HttpResponse<String> response = client
                 .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json); //se conecta el json



        //Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        //TituloOmdb mitutuloOmdb = gson.fromJson(json, TituloOmdb.class);
        //System.out.println(mitutuloOmdb);
        try{
       //     Titulo miTitulo = new Titulo(miTituloOmdb);
         //   System.out.println(miTitulo);
        }catch(NumberFormatException e){
            System.out.println("Ocurrio un error : ");
            System.out.println(e.getMessage());
        }
        //Try catch
    }
}
