package com.danlewis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UIManager {
    public static String readFile(String filename){

            StringBuilder builder = new StringBuilder();
            try (BufferedReader buffer = new BufferedReader(new FileReader(filename)))
            {
                String str;
                while ((str = buffer.readLine()) != null)
                {
                    builder.append(str).append("\n");
                }
            } catch (IOException e) {
                System.out.printf("Unable to read from file: %s", filename);
                e.printStackTrace();
            }
        return builder.toString();
    }
}
