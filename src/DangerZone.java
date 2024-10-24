import java.awt.Color;
import java.util.Random;

/**
 * Class for the zones that the player must avoid.
 * It extends the class visual object to get 
 * its structure about the coordinate, size and color.
 */
public class DangerZone extends VisibleObject {

    private SoundManager sfx;
    private Color trueColor;
    private int time; //time is in frames; the game will run at ~60 FPS
    private int state; 
    /* state corresponds to what should happen with the object
     * 3 - location indication with transparent color
     * 2 - blinking white and letting out a sound effect
     * 1 - active
     * 0 - to be removed
     */
    
    /**
    * Constructor for general use.
    */
    public DangerZone(int x, int y, int width, int height, Color color, int time) {
        super(x, y, width, height, color);
        this.trueColor = color;
        this.state = 3;
        this.time = time + new Random().nextInt(91) - 45;
        this.sfx = new SoundManager();
    }

    /**
     * Method that checks how much time the object has left 
     * and assigns it the correct color.
     * When an visible object is close to dissapearing it 
     * will blink in white and then become "ACTIVE".
     */
    public void correctState() {
        if (this.time > 90) {
            // if there is more then 1.5 sec. before the object's time is up
            // it should be somewhat transparent.
            color = new Color(
                trueColor.getRed(),
                trueColor.getGreen(), 
                trueColor.getBlue(),
                 70);
            this.state = 3;
        } else if (this.time > 60) {
            // if there is 1 to 1.5 sec. before the object's time is up 
            // it should blink in white and give out a sound effect.
            if (this.time == 90) { 
                sfx.playAttackSFX();
            }
            this.color = new Color(255, 255, 255, 255);
            this.state = 2;
        } else if (this.time > 0) {
            // if there is less than 1 sec before the object's time is up 
            // it should become completely opaque.
            this.color = new Color(
                trueColor.getRed(),
                trueColor.getGreen(), 
                trueColor.getBlue(),
                 255);
            this.state = 1;
        } else {
            // if there is no time left then the object should be removed
            this.state = 0;
        }
    }

    public void setVisuals() {}

    public void setTime(int time) {
        this.time = time;
    }

    public void setTrueColor(Color trueColor) {
        this.trueColor = trueColor;
    }

    public int getState() {
        return this.state;
    }

    public Color getTrueColor() {
        return this.trueColor;
    }
   
    public int getTime() {
        return this.time;
    }

}
