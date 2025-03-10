package com.dev.utils.validation_errors;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
    private final Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getValidInteger(String message) {
        while (true) {
            System.out.println("\n──────────────────────────────────────────");
            System.out.print("📌 " + message + " ➜ ");
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("❌  ERROR: Entrada no válida. Ingrese un número entero.");
                scanner.next(); // Limpiar buffer
            }
        }
    }

    public int getValidSize(String message, int minSize) {
        while (true) {
            int size = getValidInteger(message);
            if (size >= minSize) {
                return size;
            }
            System.out.println("⚠  ADVERTENCIA: El tamaño debe ser al menos " + minSize + ".");
        }
    }

    public int[] getValidSortedArray(int size) {
        int[] nums = new int[size];
        System.out.println("\n📋 Ingrese " + size + " números enteros en orden ascendente:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        for (int i = 0; i < size; i++) {
            nums[i] = getValidInteger("Elemento [" + (i + 1) + "]: ");

            if (i > 0 && nums[i] < nums[i - 1]) {
                System.out.println("⚠  ADVERTENCIA: El número ingresado debe ser mayor o igual que el anterior.");
                i--; // Repetir esta iteración
            }
        }
        System.out.println("✅ Entrada validada correctamente.\n");
        return nums;
    }
}
