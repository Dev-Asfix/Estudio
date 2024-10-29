package com.dev.conversor;
import java.util.Scanner;

//Se crea la clase Operacion
public class Operacion {
    private Scanner in = new Scanner(System.in);
    private String cantidadString;
    public double cantidad;

    //Aqui se sube el menu
    public void menu() {

            System.out.println("""
                    1  : USD	Estados Unidos, Ecuador, El Salvador, entre otros
                    2  : BRL	Brasil
                    3  : CNY	China
                    4  : COP	Colombia
                    5  : IDR	Indonesia
                    6  : ILS	Israel
                    7  : KRW	Corea del Sur
                    8  : MXN	México
                    9  : PEN	Perú
                    10 : UYU	Uruguay
                    11 : VES	Venezuela
                    ****************************************
                    
                    Escribe "Salir" si quieres salir. 
                    
                    Elige una opción:
                    """);

            String input = in.nextLine();

            if (input.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo del programa...");

            }

            try {
                int opcion = Integer.parseInt(input);
                precio(opcion);
                decision(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido o 'Salir' para salir.");
            }

        in.close(); // Cerramos el Scanner al final
    }

    public void precio(int opcion) {
        System.out.println("Dime la cantidad: ");
        cantidad = in.nextDouble();
        in.nextLine(); // Consumimos el salto de línea después de leer la cantidad
    }

    public void decision(int opcion) {
        switch (opcion) {
            case 1:
                cantidadString = "USD";  // Estados Unidos, Ecuador, El Salvador, etc.
                break;
            case 2:
                cantidadString = "BRL";  // Brasil
                break;
            case 3:
                cantidadString = "CNY";  // China
                break;
            case 4:
                cantidadString = "COP";  // Colombia
                break;
            case 5:
                cantidadString = "IDR";  // Indonesia
                break;
            case 6:
                cantidadString = "ILS";  // Israel
                break;
            case 7:
                cantidadString = "KRW";  // Corea del Sur
                break;
            case 8:
                cantidadString = "MXN";  // México
                break;
            case 9:
                cantidadString = "PEN";  // Perú
                break;
            case 10:
                cantidadString = "UYU";  // Uruguay
                break;
            case 11:
                cantidadString = "VES";  // Venezuela
                break;
            default:
                System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                return;
        }

    }

    public String getCantidadString(){
        return cantidadString;
    }
    public double getCAntidad(){
        return cantidad;
    }
}
