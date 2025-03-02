package com.dev.Reto2;

public class PalindromeSolution implements PalindromeChecker {
    @Override
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int halfReversed = 0;
        System.out.println("\u001B[34mIniciando verificación del número: " + x + "\u001B[0m");

        while (x > halfReversed) {
            System.out.println("\u001B[36mNúmero actual: " + x + " | Mitad invertida: " + halfReversed + "\u001B[0m");
            halfReversed = halfReversed * 10 + x % 10;
            x /= 10;
        }

        System.out.println("\u001B[32mResultado final - Número restante: " + x + " | Mitad invertida: " + halfReversed + "\u001B[0m");
        return (x == halfReversed || x == halfReversed / 10);
    }
}
