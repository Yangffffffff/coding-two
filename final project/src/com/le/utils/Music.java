package com.le.utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music{
    String name;
    AudioInputStream audioInput;
    Clip clip;
    public Music(String str) {
        name = str;
    }

    public void pause(){
        clip.stop();
    }

    public void start() {
        try {
            File f = new File(name);
            audioInput = AudioSystem.getAudioInputStream(f);
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
