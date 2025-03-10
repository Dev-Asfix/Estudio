package com.dev.challenges.Palindrome;


import com.dev.core.BaseChallenge;
import com.dev.utils.ConsoleColors;
import com.dev.utils.LoadingUtils;
import com.dev.utils.validation_errors.InputValidator;

import java.util.InputMismatchException;

public class PalindromeChallenge extends BaseChallenge {

    private final InputValidator validator = new InputValidator(scanner);

    @Override
    public void execute() {
        printHeader("🔢 Palindrome Number Challenge ");

        // Obtener el número con validación
        int x = validator.getValidInteger(ConsoleColors.CYAN + "🔹 Ingrese un número entero: " + ConsoleColors.RESET);

        // Usamos la nueva utilidad para mostrar animaciones de carga
        LoadingUtils.showLoading("🔄 Analizando número");
        LoadingUtils.showLoading("📊 Verificando si es palíndromo");

        PalindromeSolver solver = new PalindromeSolver();
        boolean result = solver.isPalindrome(x);

        // Mostrar resultado con mejor estética
        System.out.println("\n" + ConsoleColors.BOLD + ConsoleColors.YELLOW +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" + ConsoleColors.RESET);
        System.out.println("🔍 Resultado: El número " + ConsoleColors.BOLD + x + ConsoleColors.RESET +
                (result ? ConsoleColors.GREEN + " ✅ SÍ " : ConsoleColors.RED + " ❌ NO ") + ConsoleColors.RESET + "es un palíndromo.");
        System.out.println(ConsoleColors.BOLD + ConsoleColors.YELLOW +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" + ConsoleColors.RESET);
    }
}
