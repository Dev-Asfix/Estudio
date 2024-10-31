package com.dev.conversion;

import java.util.Scanner;

public class CurrencyMenu {
    //Desplegamos el Menu
    public void displayMenu() {
        System.out.println("Selecciona la moneda de conversión:");
        System.out.println("1: USD - Estados Unidos, Ecuador, El Salvador");
        System.out.println("2: BRL - Brasil");
        System.out.println("3: CNY - China");
        System.out.println("4: COP - Colombia");
        System.out.println("5: IDR - Indonesia");
        System.out.println("6: ILS - Israel");
        System.out.println("7: KRW - Corea del Sur");
        System.out.println("8: MXN - México");
        System.out.println("9: PEN - Perú");
        System.out.println("10: UYU - Uruguay");
        System.out.println("11: VES - Venezuela");
        System.out.println("Escribe 'Salir' para finalizar.");
        System.out.print("Elige una opción: ");
    }

    public String getCurrencyCode(int option) {
        return switch (option) {
            case 1 -> "USD";
            case 2 -> "BRL";
            case 3 -> "CNY";
            case 4 -> "COP";
            case 5 -> "IDR";
            case 6 -> "ILS";
            case 7 -> "KRW";
            case 8 -> "MXN";
            case 9 -> "PEN";
            case 10 -> "UYU";
            case 11 -> "VES";
            default -> null;
        };
    }
}
