/**
 * @author Pablo Rosas Ramirez
 * @version 1.0
 * @since 2024-10-29
 */

package com.dev.conversion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Service {
    private static final String API_KEY = "97ec11893b9562fd36a60d8f";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/PEN/";

    public Datos getCambio(String codigo) throws IOException, InterruptedException{
        String url = BASE_URL + codigo;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), Datos.class);
    }
    public double convertirMonto(double monto , double tasaDeConversion){
        return monto * tasaDeConversion;
    }

    public void guardarCambioEnArchivo(Datos datos, String nombreArchivo){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //String json = gson.toJson(datos);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("codigoBase", datos.codigoBase());
        jsonObject.addProperty("codigoObjetivo", datos.codigoObjetivo());
        jsonObject.addProperty("tasaDeConversion", datos.tasaDeConversion());
        String json = gson.toJson(jsonObject);

        try(FileWriter fileWriter = new FileWriter(nombreArchivo)){
            fileWriter.write(json);
            System.out.println("✅ Archivo JSON creado exitosamente");
        }catch (IOException e){
            System.out.println("Erro al guardar JSON : " + e.getMessage());
        }
    }

    public void guardarEnHistorial(double monto, String codigoObjetivo, double tasaDeConversion, double resultado){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHoraActual = LocalDateTime.now().format(formato);

        String registro = String.format("Fecha: %s | Monto en PEN %.2f | Moneda Destino : %s | Tasa de conversion: %.4f | REsultado : %.2f %s%n",
                fechaHoraActual, monto, codigoObjetivo, tasaDeConversion, resultado, codigoObjetivo);
        try(FileWriter writer = new FileWriter("historial.txt", true)){
            writer.write(registro);
            System.out.println("✅ Registro Guardado en el historial.");
        } catch (IOException e) {
            System.out.println("Error al guardar el historial : " +e.getMessage());
        }
    }

}
