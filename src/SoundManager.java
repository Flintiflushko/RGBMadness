
import java.io.File;
import javax.sound.sampled.*;

public class SoundManager {

    public void playGameOverSFX() {
        try {
            File sfx = new File("src/assets/sfx/GameOver.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(sfx);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
        }
    }

    public void playAttackSFX() {
        try {
            File sfx = new File("src/assets/sfx/Attack.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(sfx);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
        }
    }

    public void playClickSFX() {
        try {
            File sfx = new File("src/assets/sfx/Click.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(sfx);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
        }
    }
    
}
