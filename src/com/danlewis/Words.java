package com.danlewis;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Words {
    // At the start of the game, read words into a list and pick one at random and return it
    private static ArrayList<String> getWordsList(){
        ArrayList<String> wordsList = new ArrayList<>();
        try {

            FileInputStream si = new FileInputStream("C:\\Java Projects\\JavaHangMan\\Words.txt");
            InputStreamReader isr = new InputStreamReader( si, "UTF-8" );
            BufferedReader br = new BufferedReader( isr );
            String line = br.readLine();

            while( line != null )
            {
                // process lines of text

                line = br.readLine();
                wordsList.add(line);
            }

            br.close();
            isr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordsList;
    }

    public static String getWord(){
        Random random = new Random();
        ArrayList<String> words = getWordsList();
        return words.get(random.nextInt(words.size()));
    }
}
