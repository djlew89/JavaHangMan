package com.danlewis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    Validator() {
    }

    public static boolean isValidName(String playerName) {
        String regex = "[A-Za-z]+|[A-Za-z]*\\s[A-Za-z]+";
        Pattern p = Pattern.compile(regex);
        if (playerName == null) return false;
        Matcher m = p.matcher(playerName);
        return m.matches();
    }

    // Overkill but worth it
    public static boolean isValidGuess(char guess) {
        String regex = "[A-Za-z]";
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(String.valueOf(guess));
        return m.matches();
    }

}
