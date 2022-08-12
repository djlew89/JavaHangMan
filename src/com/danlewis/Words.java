package com.danlewis;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Words {
    // At the start of the game, read words into a list and pick one at random and return it
    private static ArrayList<String> getWordsList() {
        ArrayList<String> wordsList = new ArrayList<>();
        try {

            FileInputStream fileInputStream = new FileInputStream("Words.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();

            while (line != null) {
                // process lines of text

                line = bufferedReader.readLine();
                wordsList.add(line);
            }

            bufferedReader.close();
            inputStreamReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordsList;
    }

    public static String getWord() {
        Random random = new Random();
        ArrayList<String> words = getWordsList();
        return words.get(random.nextInt(words.size()));
    }
}
