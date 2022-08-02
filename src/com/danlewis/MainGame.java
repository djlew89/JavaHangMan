package com.danlewis;

import java.util.*;
import java.util.stream.Collectors;

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
    // Number of errors allowed and current number of errors
    public static final int MAX_ERRORS = 6;
    public static int numberOfErrors = 0;

    // A set for guessed letters
    public static Set<String> guessedLetters = new HashSet<>();
    // Bool for state of game
    public static boolean gameOver = false;
    // List of game boards (hangman images) --> UIManager.readFile(gameBoards.get(index)
    static List<String> gameBoards = FileUtils.gameBoardPaths.stream().map(String::toString).collect(Collectors.toList());

    public static void main(String[] args) {
        Player player = new Player();
        Scanner getUserName = new Scanner(System.in);

        // Validate the player name
        boolean isValid = false;
        do {
            System.out.println("Enter Name: ");
            String name = getUserName.nextLine();
            if (Validator.isValidName(name)) {
                player.setName(name);
                isValid = true;
            }
            System.out.println();
        } while (!isValid);

        // Get word
        String word = Words.getWord();

        // Hide word
        StringBuilder hiddenWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            hiddenWord.append("-");
        }

        // newHiddenWord contains the dynamic word display
        StringBuilder newHiddenWord;
        newHiddenWord = new StringBuilder(hiddenWord);
        do {
            System.out.printf("Player: %s\n\n", player.getName());
            System.out.printf("Your word:\n %s\n", newHiddenWord);
            System.out.println(word);
            System.out.println(UIManager.readFile(gameBoards.get(numberOfErrors)));
            System.out.printf("Guessed letters: %s\n\n", guessedLetters.toString());

            Scanner input = new Scanner(System.in);
            System.out.println("Guess a letter: ");
            String letter = input.nextLine();
            System.out.println();

            // Validate the guess
            if (!Validator.isValidGuess(letter)) {
                System.out.printf("Please guess a letter\n\n");
                continue;
            }

            String forcedLowerCase = String.valueOf(letter.charAt(0)).toLowerCase(Locale.ROOT);

            if (guessedLetters.contains(forcedLowerCase)) {
                System.out.printf("The letter \"%s\" has been guessed\n\n", forcedLowerCase);
                continue;
            }

            // Check for the letter in the word,
            // if it's there, replace it
            for (int i = 0; i < word.length(); i++) {
                if (letter.charAt(0) == word.charAt(i)) {
                    newHiddenWord.setCharAt(i, letter.charAt(0));
                    guessedLetters.add(forcedLowerCase);
                }
            }

            if (!word.contains(letter)) {
                guessedLetters.add(forcedLowerCase);
                numberOfErrors++;
                if (numberOfErrors == MAX_ERRORS) {
                    System.out.println("You Lose!");
                    System.out.println(UIManager.readFile(gameBoards.get(numberOfErrors)));
                    System.out.printf("Your word was: %s\n", word);
                    gameOver = true;
                }
            }

            if (word.compareTo(newHiddenWord.toString()) == 0) {
                System.out.printf("Congrats, %s! You Won!\n", player.getName());
                System.out.println(UIManager.readFile(gameBoards.get(gameBoards.size() - 1)));
                System.out.printf("Your word was: %s\n", newHiddenWord);
                gameOver = true;
            }

        } while (!gameOver);
    }
}
