package MainMenu;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static MainWindow mainWindow;
    public static void main(String[] args) throws IOException, FontFormatException {
        mainWindow = new MainWindow();
        Audio.load("c","C:\\Users\\11694\\Documents\\GitHub\\sharpG\\SHARP\\src\\MainMenu\\btn_click.wav");
        try {
            File file = new File("C:\\Users\\11694\\Documents\\GitHub\\sharpG\\SHARP\\src\\MainMenu\\toalltha.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            AudioFormat format = audioStream.getFormat();

            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);

            line.open(format);
            line.start();

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = audioStream.read(buffer, 0, buffer.length)) != -1) {
                line.write(buffer, 0, bytesRead);
            }

            line.drain();
            line.close();
            audioStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}