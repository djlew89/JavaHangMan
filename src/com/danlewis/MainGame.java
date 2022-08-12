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

    public static final int MAX_ERRORS = 6;
    public static int incorrectGuesses = 0;
    public static Set<Character> guessedLetters = new HashSet<>();
    static List<String> gameBoards = FileUtils.gameBoardPaths;
    private final Scanner scanner;
    private StringBuilder hiddenWord;
    private final UIManager uiManager;
    private GameState gameState;
    private Player player;
    private String word;

    public MainGame() {
        uiManager = new UIManager();
        scanner = new Scanner(System.in);
        hiddenWord = new StringBuilder();
        gameState = GameState.SETUP;
    }

    private void setUp() {
        createPlayer();
        createHiddenWord();
        gameState = GameState.RUNNING;
    }

    public void runGame() {
        setUp();

        do {
            if(gameState == GameState.SETUP){
                restartGame();
            }
            System.out.println(word);
            System.out.printf("Player: %s\n\n", player.getName());
            System.out.printf("Your word:\n %s\n", hiddenWord);

            System.out.println(UIManager.readFile(gameBoards.get(incorrectGuesses)));
            System.out.printf("Guessed letters: %s\n\n", guessedLetters.toString());

            System.out.println("Guess a letter: ");
            char letter = scanner.nextLine().toLowerCase(Locale.ROOT).charAt(0);
            System.out.println();

            if (!Validator.isValidGuess(letter)) {
                System.out.println("Please guess a letter");
                continue;
            }

            if (guessedLetters.contains(letter)) {
                System.out.printf("The letter \"%s\" has been guessed\n\n", letter);
                continue;
            }


            for (int i = 0; i < word.length(); i++) {
                if (letter == word.charAt(i)) {
                    hiddenWord.setCharAt(i, letter);
                    guessedLetters.add(letter);
                }
            }

            if (!word.contains(String.valueOf(letter))) {
                guessedLetters.add(letter);
                incorrectGuesses++;
            }
            checkForGameOver();

        } while (gameState != GameState.QUIT);
    }

    private void restartGame() {
        incorrectGuesses = 0;
        guessedLetters.clear();
        uiManager.clearScreen();
        createHiddenWord();
        gameState = GameState.RUNNING;
    }

    private void checkForGameOver() {
        if (word.compareTo(hiddenWord.toString()) == 0) {
            System.out.printf("Congrats, %s! You Won!\n", player.getName());
            System.out.println(UIManager.readFile(gameBoards.get(gameBoards.size() - 1)));
            System.out.printf("Your word was: %s\n", hiddenWord);
            checkForPlayAgain();
        }
        if (incorrectGuesses == MAX_ERRORS) {
            System.out.printf("You lose, %s!\n", player.getName());
            System.out.println(UIManager.readFile(gameBoards.get(incorrectGuesses)));
            System.out.printf("Your word was: %s\n", word);
            checkForPlayAgain();
        }
    }

    private void checkForPlayAgain() {
        System.out.println("Would you like to try again? Y/N");
        if(scanner.nextLine().equalsIgnoreCase("Y")){
            gameState = GameState.SETUP;
        }else gameState = GameState.QUIT;
    }

    private void createHiddenWord() {
        hiddenWord = new StringBuilder();
        word = Words.getWord();
        for (int i = 0; i < word.length(); i++) {
            hiddenWord.append("-");
        }
    }

    private void createPlayer() {
        player = new Player();
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
    }

    private enum GameState {
        SETUP,
        RUNNING,
        QUIT
    }
}
