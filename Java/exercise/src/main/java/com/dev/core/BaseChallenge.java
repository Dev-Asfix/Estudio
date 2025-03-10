package com.dev.core;

import com.dev.utils.ConsoleUtils;

import java.util.Scanner;

public abstract class BaseChallenge implements Challenge {
    protected final Scanner scanner = new Scanner(System.in);

    protected void printHeader(String title) {
        ConsoleUtils.printHeader(title);
    }

}
