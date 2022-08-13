package com.danlewis;

import javax.sound.sampled.Clip;

public class SfxManager {
    private Clip backgroundMusicClip;
    private Clip gameWonMusicClip;
    private Clip gameLostMusicClip;

    public SfxManager() {
        initializeAudio();
    }

    private void initializeAudio(){
        backgroundMusicClip = IOManager.readAudioFile(FileUtils.BACKGROUND_MUSIC);
        gameWonMusicClip = IOManager.readAudioFile(FileUtils.GAME_WON_MUSIC);
        gameLostMusicClip = IOManager.readAudioFile(FileUtils.GAME_LOST_MUSIC);
    }

    public void stopAudio(Music music){
        switch (music){
            case BACKGROUND:
                backgroundMusicClip.stop();
                break;
            case WON:
                gameWonMusicClip.stop();
                break;
            case LOST:
                gameLostMusicClip.stop();
                break;
            default:
                System.out.printf("Invalid %s\n\n", music);
        }
    }

    public void playAudio(Music music){
        switch (music){
            case BACKGROUND:
                backgroundMusicClip.loop(Clip.LOOP_CONTINUOUSLY);
                break;
            case WON:
                gameWonMusicClip.start();
                break;
            case LOST:
                gameLostMusicClip.start();
                break;
            default:
                System.out.printf("Invalid %s\n\n", music);
        }
    }

}
