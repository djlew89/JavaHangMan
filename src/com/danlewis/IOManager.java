package com.danlewis;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class IOManager {
    public static Clip readAudioFile(String fileName) {

        File audioFile = new File(fileName);
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(audioFile));
            return clip;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
