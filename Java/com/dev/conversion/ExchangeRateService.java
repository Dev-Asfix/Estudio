package com.dev.conversion;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ExchangeRateService {
    private static final String API_KEY = "97ec11893b9562fd36a60d8f";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/PEN/";

    public ExchangeRateResponse getExchangeRate(String codigoObjetivo) throws IOException, InterruptedException {
        String url = BASE_URL + codigoObjetivo;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), ExchangeRateResponse.class);
    }

    public double convertirMonto(double monto, double tasaDeConversion) {
        return monto * tasaDeConversion;
    }
}
