package com.danlewis;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

public class UIManager {
    public static String readFile(String filename) {

        StringBuilder builder = new StringBuilder();
        try {

            FileInputStream fileInputStream = new FileInputStream(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";

            while (line != null) {
                line = bufferedReader.readLine();
                if (line != null) {
                    builder.append(line).append("\n");
                }
            }

            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static void displayHUD(Player player, StringBuilder hiddenWord,
                                  List<String> gameBoards, int incorrectGuesses, Set<Character> guessedLetters) {
        System.out.printf("Player: %s\n\n", player.getName());
        System.out.printf("Your word:\n %s\n", hiddenWord);

        System.out.println(UIManager.readFile(gameBoards.get(incorrectGuesses)));
        System.out.printf("Guessed letters: %s\n\n", guessedLetters.toString());
    }

    public void clearScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

}
