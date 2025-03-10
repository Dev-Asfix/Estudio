package com.dev;

import com.dev.challenges.Palindrome.PalindromeChallenge;
import com.dev.challenges.TwoSum.TwoSumChallenge;
import com.dev.challenges.TwoSum_II.TwoSumIIChallenge;
import com.dev.core.Challenge;
import com.dev.core.ChallengeSelector;

public class ChallengeRunner {
    public static void main(String[] args) {
        Challenge[] challenges = {
                new TwoSumChallenge(),
                new PalindromeChallenge(),
                new TwoSumIIChallenge()
        };

        ChallengeSelector selector = new ChallengeSelector(challenges);
        selector.start();
    }
}
