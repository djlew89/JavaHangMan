package com.danlewis;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Words {
    private static ArrayList<String> getWordsList() {
        ArrayList<String> wordsList = new ArrayList<>();
        try {

            FileInputStream fileInputStream = new FileInputStream("Words.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();

            while (line != null) {

                line = bufferedReader.readLine();
                wordsList.add(line);
            }

            bufferedReader.close();
            inputStreamReader.close();
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
