
import java.io.File;
import javax.sound.sampled.*;

/**
 * A Class that is responsible for all of the sound effects.
 */
public class SoundManager {

    /**
     * Called to play the sound effect for game over.
     */
    public void playGameOverSFX() {
        try {
            File sfx = new File("src/assets/sfx/GameOver.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(sfx);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Called to play the sound effect right before a danger zone becomes active.
     */
    public void playAttackSFX() {
        try {
            File sfx = new File("src/assets/sfx/Attack.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(sfx);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Called to play the sound effect when a button is pressed.
     */
    public void playClickSFX() {
        try {
            File sfx = new File("src/assets/sfx/Click.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(sfx);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
