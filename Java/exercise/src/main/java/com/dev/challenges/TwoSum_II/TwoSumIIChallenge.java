package com.dev.challenges.TwoSum_II;


import com.dev.core.BaseChallenge;
import com.dev.utils.ConsoleColors;
import com.dev.utils.LoadingUtils;
import com.dev.utils.validation_errors.InputValidator;

import java.util.InputMismatchException;

public class TwoSumIIChallenge extends BaseChallenge {
    private final InputValidator validator = new InputValidator(scanner);

    @Override
    public void execute() {
        printHeader("🔢 Two Sum II Challenge ");

        // Paso 1: Definir el tamaño del array
        LoadingUtils.showLoading("📏 Configurando el tamaño del array...");
        int size = validator.getValidSize(ConsoleColors.CYAN + "📝 Ingrese el tamaño del array ordenado (mínimo 2): " + ConsoleColors.RESET, 2);

        // Paso 2: Ingresar los valores del array ordenado
        LoadingUtils.showLoading("🔢 Preparando la entrada de datos...");
        int[] nums = validator.getValidSortedArray(size);

        // Paso 3: Ingresar el objetivo
        LoadingUtils.showLoading("🎯 Estableciendo el objetivo...");
        int target = validator.getValidInteger(ConsoleColors.CYAN + "💰 Ingrese el número objetivo (suma esperada): " + ConsoleColors.RESET);

        // Paso 4: Procesar la solución
        LoadingUtils.showLoading("🤖 Analizando los datos...");
        TwoSumIISolver solver = new TwoSumIISolver();
        int[] result = solver.findTwoSumII(nums, target);

        // Resultado final
        System.out.println(ConsoleColors.BOLD + ConsoleColors.GREEN + "\n📊 RESULTADO DEL CÁLCULO" + ConsoleColors.RESET);
        if (result.length == 2) {
            System.out.println(ConsoleColors.GREEN + "✅ Solución encontrada: Los números en las posiciones (base 1) " +
                    result[0] + " y " + result[1] + " suman " + target + "." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "⚠ No se encontraron soluciones posibles para la suma esperada." + ConsoleColors.RESET);
        }
    }
}
