package com.dev.utils;

public class LoadingUtils {
    public static void showLoading(String message) {
        System.out.print(ConsoleColors.PURPLE + message);
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(500);
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(ConsoleColors.RESET);
    }
}
