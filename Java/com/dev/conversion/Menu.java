/**
 * @author Pablo Rosas Ramirez
 * @version 1.0
 * @since 2024-10-29
 */

package com.dev.conversion;

public class Menu {

    public void desplegarMenu() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║      🌎 Selección de Moneda 🌎         ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("  Elige una moneda para la conversión:\n");

        System.out.println("   1️⃣  USD - Estados Unidos, Ecuador, El Salvador");
        System.out.println("   2️⃣  BRL - Brasil");
        System.out.println("   3️⃣  CNY - China");
        System.out.println("   4️⃣  COP - Colombia");
        System.out.println("   5️⃣  IDR - Indonesia");
        System.out.println("   6️⃣  ILS - Israel");
        System.out.println("   7️⃣  KRW - Corea del Sur");
        System.out.println("   8️⃣  MXN - México");
        System.out.println("   9️⃣  PEN - Perú");
        System.out.println("  10️⃣  UYU - Uruguay");
        System.out.println("  11️⃣  VES - Venezuela");

        System.out.println("\n🔸 Escribe 'Salir' para finalizar.");
        System.out.println("\n➡️  Ingresa el número de la opción que deseas elegir: ");
    }


    public String getTipoDeCodigo(int option){
        return switch (option){
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
