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

    // List of game boards (hangman images) --> UIManager.readFile(gameBoards.get(index)
    static List<String> gameBoards = FileUtils.gameBoardPaths.stream().map(String::toString).collect(Collectors.toList());

    // Bool for state of game
    public static boolean gameOver = false;

    public static void main(String[] args) {

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
            //
            System.out.printf("Your word:\n %s\n", newHiddenWord);
            System.out.println(word);
            System.out.println(UIManager.readFile(gameBoards.get(numberOfErrors)));
            System.out.printf("Guessed letters: %s\n\n", guessedLetters.toString());

            Scanner input = new Scanner(System.in);
            System.out.println("Guess a letter: ");
            String letter = input.nextLine();
            System.out.println();

            if(guessedLetters.contains(letter.substring(0,1))){
                System.out.printf("Letter has been guessed\n\n");
                continue;
            }

            // Check for the letter in the word,
            // if it's there, replace it
            for (int i = 0; i < word.length(); i++) {
                if (letter.charAt(0) == word.charAt(i)) {
                    newHiddenWord.setCharAt(i, letter.charAt(0));
                    guessedLetters.add(String.valueOf(letter.charAt(0)));
                }
            }

            if(!word.contains(letter)){
                guessedLetters.add(String.valueOf(letter.charAt(0)));
                numberOfErrors++;
                if(numberOfErrors == MAX_ERRORS){
                    System.out.println("You Lose!");
                    System.out.println(UIManager.readFile(gameBoards.get(numberOfErrors)));
                    gameOver = true;
                }
            }

            if(word.compareTo(newHiddenWord.toString()) == 0){
                System.out.println("You Win!");
                System.out.printf("Your word was: %s\n", newHiddenWord);
                gameOver = true;
            }

        } while (!gameOver);
//
//        System.out.println(newHiddenWord);
//        System.out.printf("Guessed Letters: %s\n", guessedLetters.toString());
//        System.out.println(numberOfErrors);
//        System.out.println(UIManager.readFile(gameBoards.get(numberOfErrors)));
    }
}
