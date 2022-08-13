package com.danlewis;

import java.util.ArrayList;
import java.util.Arrays;

public class FileUtils {

    private static final String GAME_MUSIC_PATH = "Sfx\\";

    public static final String BACKGROUND_MUSIC = GAME_MUSIC_PATH + "Background.wav";

    public static final String GAME_WON_MUSIC = GAME_MUSIC_PATH + "Won.wav";

    public static final String GAME_LOST_MUSIC = GAME_MUSIC_PATH + "GameOver.wav";


    public static final String GAME_BOARD_PATH = "UIStates\\";

    public static final String BOARD_EMPTY = GAME_BOARD_PATH + "InitialState.txt";

    public static final String BOARD_ONE = GAME_BOARD_PATH + "WrongGuessOne.txt";

    public static final String BOARD_TWO = GAME_BOARD_PATH + "WrongGuessTwo.txt";

    public static final String BOARD_THREE = GAME_BOARD_PATH + "WrongGuessThree.txt";

    public static final String BOARD_FOUR = GAME_BOARD_PATH + "WrongGuessFour.txt";

    public static final String BOARD_FIVE = GAME_BOARD_PATH + "WrongGuessFive.txt";

    public static final String BOARD_SIX = GAME_BOARD_PATH + "WrongGuessSix.txt";

    public static final String BOARD_WIN = GAME_BOARD_PATH + "WinningState.txt";

    public static final ArrayList<String> gameBoardPaths = new ArrayList<>(
            Arrays.asList(BOARD_EMPTY, BOARD_ONE, BOARD_TWO, BOARD_THREE, BOARD_FOUR, BOARD_FIVE, BOARD_SIX, BOARD_WIN));
}
