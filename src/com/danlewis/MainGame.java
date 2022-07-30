package com.danlewis;

import java.util.*;

/*
 * Hangman logic
 *
 * Get a word and hide it.
 * Split the word into an array.
 * get the player to guess a letter:
 * a) if the letter is in the array
 *       show the letter and add it to the guessed letters set
 *
 * b) if it is not in the array
 *       show the letter, increment the guess counter and hangman UI, then add it to the guessed letters set
 *
 * This loop continues until the player has guessed the word or has hanged the man
 * A bool will be used to check the state of the game
 *
 */

public class MainGame {
    // Keep track of the current state of the game
    public enum GameState{
        GUESSING,
        WON,
        LOST
    }
    // Number of errors allowed and current number of errors
    public static final int MAX_ERRORS = 6;
    public static int numberOfErrors;

    // A set for guessed letters
    public static Set<String> guessedLetters = new HashSet<>();

    // Bool for state of game
    public static boolean gameOver = false;

    public static void main(String[] args) {
        // Get word
        String word = Words.getWord();
        System.out.println(word);

        // Hide word
        StringBuilder hiddenWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            hiddenWord.append("-");
        }
        System.out.println(hiddenWord);

        // Split word into array
        String[] letters = word.split("");

        StringBuilder newHiddenWord;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Guess a letter: ");
            String letter = input.nextLine();

            newHiddenWord = new StringBuilder(hiddenWord);

            // Check for the letter in the word,
            // if it's there, replace it
            for (int i = 0; i < word.length(); i++) {
                if (letter.charAt(0) == word.charAt(i)) {
                    newHiddenWord.setCharAt(i, letter.charAt(0));
                    guessedLetters.add(String.valueOf(letter.charAt(0)));
                    gameOver = true;
                }
            }
        } while (!gameOver);

        System.out.println(newHiddenWord);
        System.out.println(guessedLetters.toString());
    }
}
