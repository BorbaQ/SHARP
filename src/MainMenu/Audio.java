package MainMenu;

import javax.sound.sampled.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Audio {

    private static final Map<String, Clip> sounds = new HashMap<>();

    public static void load(String name, String path) {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(path));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            sounds.put(name, clip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void play(String name) {
        Clip clip = sounds.get(name);
        if (clip == null) return;

        if (clip.isRunning()) {
            clip.stop();
        }
        clip.setFramePosition(0); // rewind
        clip.start();
    }
}