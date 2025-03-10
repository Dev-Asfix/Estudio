package com.dev.challenges.Palindrome;

public class PalindromeSolver {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int halfReversed = 0;
        while (x > halfReversed) {
            halfReversed = halfReversed * 10 + x % 10;
            x /= 10;
        }
        return (x == halfReversed || x == halfReversed / 10);
    }
}
