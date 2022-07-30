package com.danlewis;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Words {
    // At the start of the game, read words into a list and pick one at random and return it
    private static ArrayList<String> getWordsList(){
        Path p = Paths.get("Words.txt");
        File wordsText = new File(String.valueOf(p));
        Scanner file = null;
        try {
            file = new Scanner(wordsText);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> wordsList = new ArrayList<>();

        if (file != null) {
            while (file.hasNext()) {
                wordsList.add(file.next());
            }
        }
        file.close();
        return wordsList;
    }

    public static String getWord(){
        Random random = new Random();
        ArrayList<String> words = getWordsList();
        return words.get(random.nextInt(words.size()));
    }
}
