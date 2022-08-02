package com.danlewis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    Validator() {
    }

    public static boolean isValidName(String playerName) {
//        String regex = "/^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/gm";
        String regex = "[A-Za-z]+|[A-Za-z]*\\s[A-Za-z]+";
        Pattern p = Pattern.compile(regex);
        if (playerName == null) return false;
        Matcher m = p.matcher(playerName);
        return m.matches();
    }

    public static boolean isValidGuess(String guess) {
        String regex = "[A-Za-z]";
        Pattern p = Pattern.compile(regex);
        if (guess == null) return false;
        Matcher m = p.matcher(guess);
        return m.matches();
    }

    public static void main(String[] args) {
        String name1 = "Dan";
        String name2 = "";
        String name3 = ".;;";
        String name4 = "Dan Lewis";

        System.out.println(isValidName(name1));
        System.out.println(isValidName(name2));
        System.out.println(isValidName(name3));
        System.out.println(isValidName(name4));
    }
}
