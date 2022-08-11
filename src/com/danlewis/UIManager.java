package com.danlewis;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class UIManager {
    public static String readFile(String filename){

            StringBuilder builder = new StringBuilder();
        try {

            FileInputStream si = new FileInputStream(filename);
            InputStreamReader isr = new InputStreamReader( si, StandardCharsets.UTF_8);

            BufferedReader br = new BufferedReader( isr );
            String line = br.readLine();

            while( line != null )
            {
                // process lines of text

                line = br.readLine();
                if(line != null){
                    builder.append(line).append("\n");
                }
            }

            br.close();
            isr.close();
            si.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
