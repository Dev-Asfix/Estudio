/**
 * @author Pablo Rosas Ramirez
 * @version 1.0
 * @since 2024-10-29
 */

package com.dev.main;

import com.dev.conversion.Datos;
import com.dev.conversion.Menu;
import com.dev.conversion.Service;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        Menu menu = new Menu();
        Service service = new Service();


        while(true){
            menu.desplegarMenu();
            String entrada = in.nextLine();

            if(entrada.equalsIgnoreCase("salir")){
                System.out.println("Saliendo del Programa.");
                break;
            }

            int opcion;
            try{
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e){
                System.out.println("Opcion Invalida. Intente de Nuevo...");
                continue;
            }
            String codigo = menu.getTipoDeCodigo(opcion);
            if(codigo == null){
                System.out.println("Opcion invalida. Intente de nuevo");
                continue;
            }

            System.out.println("Ingresa la cantidad en PEN que deseas convertir: ");
            double monto;
            try{
                monto = Double.parseDouble(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Cantidad inválida. Intente de Nuevo ");
                continue;
            }

            try{
                Datos response = service.getCambio(codigo);
                double resultado = service.convertirMonto(monto, response.tasaDeConversion());

                System.out.println("\n");
                System.out.println("╔══════════════════════════════════════════════════╗");
                System.out.println("║               💱 RESULTADO DE CONVERSIÓN         ║");
                System.out.println("╠══════════════════════════════════════════════════╣");
                System.out.printf("║   📉 Tasa de Conversión: %.4f %s = 1 PEN    ║%n", response.tasaDeConversion(), codigo);
                System.out.println("╠──────────────────────────────────────────────────╣");
                System.out.printf("║   💵 Monto Convertido: %.2f %s                ║%n", resultado, codigo);
                System.out.println("╚══════════════════════════════════════════════════╝");

                service.guardarEnHistorial(monto, codigo, response.tasaDeConversion(),resultado);
                service.guardarCambioEnArchivo(response, "tasa_de_cambio" + codigo + ".json");
                System.out.println("\n");
            }catch (IOException | InterruptedException e){
                System.out.println("Error al obtener la tasa de cambio. Inténto de nuevo más tarde ");
            }
        }
        in.close();
    }
}
