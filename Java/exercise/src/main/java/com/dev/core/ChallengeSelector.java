package com.dev.core;

import com.dev.utils.ConsoleColors;
import com.dev.utils.LoadingUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChallengeSelector {
    private final Challenge[] challenges;
    private final Scanner scanner = new Scanner(System.in);

    public ChallengeSelector(Challenge[] challenges) {
        this.challenges = challenges;
    }

    public void start() {
        while (true) {
            System.out.println("\n" + ConsoleColors.BOLD + ConsoleColors.PURPLE +
                    "╔══════════════════════════════════════════╗");
            System.out.println("║      🚀  MENÚ DE RETOS DISPONIBLES       ║");
            System.out.println("╚══════════════════════════════════════════╝" + ConsoleColors.RESET);

            System.out.println(ConsoleColors.CYAN + "Selecciona un reto para poner a prueba tus habilidades:" + ConsoleColors.RESET);

            for (int i = 0; i < challenges.length; i++) {
                System.out.println(ConsoleColors.YELLOW + " [" + (i + 1) + "] " +
                        ConsoleColors.GREEN + challenges[i].getClass().getSimpleName() + ConsoleColors.RESET);
            }
            System.out.println(ConsoleColors.YELLOW + " [" + (challenges.length + 1) + "] " +
                    ConsoleColors.MAGENTA + "Salir del programa" + ConsoleColors.RESET);

            int choice = getValidInput();

            if (choice == challenges.length + 1) {
                LoadingUtils.showLoading("🔄 Guardando progreso y cerrando sesión");
                System.out.println("\n" + ConsoleColors.BOLD + ConsoleColors.BLUE +
                        "👋 ¡Gracias por participar! Nos vemos pronto. 🚀" + ConsoleColors.RESET);
                break;
            } else if (choice >= 1 && choice <= challenges.length) {
                LoadingUtils.showLoading("🔹 Preparando entorno del reto");
                System.out.println("\n" + ConsoleColors.CYAN + "🏆 Ejecutando reto: " +
                        ConsoleColors.BOLD + challenges[choice - 1].getClass().getSimpleName() + "..." + ConsoleColors.RESET);
                challenges[choice - 1].execute();
            } else {
                System.out.println(ConsoleColors.RED + "⚠ Opción no válida. Ingresa un número del listado." + ConsoleColors.RESET);
            }
        }
    }

    private int getValidInput() {
        while (true) {
            System.out.println();
            System.out.print(ConsoleColors.BOLD + ConsoleColors.PURPLE +
                    "💱  Introduce el número de tu selección: " + ConsoleColors.RESET);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(ConsoleColors.RED +
                        "❌ Error: Solo se permiten números. Intenta nuevamente." + ConsoleColors.RESET);
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
    }
}
