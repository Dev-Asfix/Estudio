/* package com.dev.conversor;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Cliente {

    public static void main(String []args){

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/97ec11893b9562fd36a60d8f/pair/USD/PEN"))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        Gson gson = new Gson();
        

        }catch(IOException | InterruptedException e){
            System.out.println("Error " + e.getMessage());
        }


    }

} */
