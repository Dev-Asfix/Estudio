package com.dev.challenges.TwoSum;


import com.dev.core.BaseChallenge;
import com.dev.utils.ConsoleColors;
import com.dev.utils.LoadingUtils;
import com.dev.utils.validation_errors.InputValidator;

import java.util.InputMismatchException;

public class TwoSumChallenge extends BaseChallenge {
    private final InputValidator validator = new InputValidator(scanner);

    @Override
    public void execute() {
        printHeader("\uD83E\uDDE9  Two Sum Challenge ");

        // Paso 1: Definir el tamaño del array
        LoadingUtils.showLoading("📏 Configurando tamaño del array...");
        int size = validator.getValidSize(ConsoleColors.CYAN + "📝 Ingrese el tamaño del array (mínimo 2): " + ConsoleColors.RESET, 2);

        int[] nums = new int[size];

        // Paso 2: Ingresar los valores del array
        LoadingUtils.showLoading("🔢 Preparando la entrada de datos...");
        System.out.println(ConsoleColors.YELLOW + "\nIngrese " + size + " números enteros:" + ConsoleColors.RESET);
        for (int i = 0; i < size; i++) {
            nums[i] = validator.getValidInteger(ConsoleColors.PURPLE + "📌 Elemento [" + (i + 1) + "]: " + ConsoleColors.RESET);
        }

        // Paso 3: Ingresar el objetivo
        LoadingUtils.showLoading("🎯 Estableciendo el objetivo...");
        int target = validator.getValidInteger(ConsoleColors.CYAN + "💰 Ingrese el objetivo (suma esperada): " + ConsoleColors.RESET);

        // Paso 4: Procesar la solución
        LoadingUtils.showLoading("🤖 Analizando los datos...");
        TwoSumSolver solver = new TwoSumSolver();
        int[] result = solver.findTwoSum(nums, target);

        // Resultado final
        System.out.println(ConsoleColors.BOLD + ConsoleColors.GREEN + "\n📊 RESULTADO DEL CÁLCULO" + ConsoleColors.RESET);
        if (result.length == 2) {
            System.out.println(ConsoleColors.GREEN + "✅ Solución encontrada: Los números en las posiciones " +
                    result[0] + " y " + result[1] + " suman " + target + "." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "⚠ No se encontraron soluciones posibles para la suma esperada." + ConsoleColors.RESET);
        }
    }
}
