package com.dev.Reto2;

import java.util.Scanner;

public class PalindromeConsoleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeSolution();

        System.out.println("\u001B[35m=== Comprobador de Palíndromos ===\u001B[0m");
        System.out.print("Ingrese un número: ");
        int number = scanner.nextInt();

        boolean result = checker.isPalindrome(number);

        if (result) {
            System.out.println("\u001B[32mEl número " + number + " es un palíndromo.\u001B[0m");
        } else {
            System.out.println("\u001B[31mEl número " + number + " no es un palíndromo.\u001B[0m");
        }
        scanner.close();
    }
}
