package com.dev.conversion;

import java.io.IOException;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyMenu menu = new CurrencyMenu();
        ExchangeRateService service = new ExchangeRateService();

        while (true) {
            menu.displayMenu();
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Salir")) {
                System.out.println("Aplicación finalizada.");
                break;
            }

            int option;
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Intente de nuevo.");
                continue;
            }

            String codigoObjetivo = menu.getCurrencyCode(option);
            if (codigoObjetivo == null) {
                System.out.println("Opción inválida. Intente de nuevo.");
                continue;
            }

            System.out.print("Ingrese la cantidad en PEN que desea convertir: ");
            double monto;
            try {
                monto = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Cantidad inválida. Intente de nuevo.");
                continue;
            }

            try {
                ExchangeRateResponse response = service.getExchangeRate(codigoObjetivo);
                double conversionResult = service.convertirMonto(monto, response.tasaDeConversion());

                System.out.printf("Tasa de conversión: %.4f %s = 1 PEN%n", response.tasaDeConversion(), codigoObjetivo);
                System.out.printf("Monto convertido: %.2f %s%n", conversionResult, codigoObjetivo);
            } catch (IOException | InterruptedException e) {
                System.out.println("Error al obtener la tasa de cambio. Inténtelo de nuevo más tarde.");
            }
        }
        scanner.close();
    }
}
