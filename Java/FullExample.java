import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class FullExample {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI("https://api.example.com/user/1")) // Aqui va la api
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Analizar la respuesta JSON
        String jsonResponse = response.body();
        System.out.println("Respuesta JSON: " + jsonResponse);

        // Usar Scanner para analizar el JSON simple
        Scanner scanner = new Scanner(jsonResponse);
        scanner.useDelimiter("[\\{\\},:\"]");

        while (scanner.hasNext()) {
            String token = scanner.next().trim();
            if (!token.isEmpty()) {
                System.out.println(token);
            }
        }
        scanner.close();// Es buena practica hacer eso 
    }
}
