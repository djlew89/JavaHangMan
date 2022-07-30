package com.danlewis;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Quick call to test that I can show an image
        String image = UIManager.readFile("src/UIStates/WrongGuessSix.txt");
        System.out.println(image);

//        Putting this here for safe keeping
//        List<String> gameBoards = FileUtils.gameBoardPaths.stream().map(String::toString).collect(Collectors.toList());

    }
}
