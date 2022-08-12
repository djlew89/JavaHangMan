package com.danlewis;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class UIManager {
    public static String readFile(String filename) {

        StringBuilder builder = new StringBuilder();
        try {

            FileInputStream fileInputStream = new FileInputStream(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";

            while (line != null) {
                // process lines of text

                line = bufferedReader.readLine();
                if (line != null) {
                    builder.append(line).append("\n");
                }
            }

            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void clearScreen(){
        for(int i=0; i < 20; i++){
            System.out.println();
        }
    }

}
