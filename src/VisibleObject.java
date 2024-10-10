import java.awt.Color;

/**
 * This class will be used for keeping the 
 * information of everything that will be drawn on the game panel.
 */
public class VisibleObject {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private int time; //time is in frames; the game will run at ~60 FPS
    private int state; 
    /* state corresponds to what should happen with the object
     * 3 - location indication with transparent color
     * 2 - blinking white and letting out a sound effect
     * 1 - active
     * 0 - to be removed
     */
    
    

    /**
     * Constructor for general use that takes in the x and y coordinate
     * for the start of the visible object that will be painted on the game panel
     * as well as its width, height and color.
     */
    public VisibleObject(int x, int y, int width, int height, Color color, int time) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.time = time;
        this.state = 2;
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
            this.color = new Color(
                this.color.getRed(),
                this.color.getGreen(), 
                this.color.getBlue(),
                 100);
            this.state = 3;
        } else if (this.time > 60) {
            // if there is 1 to 1.5 sec. before the object's time is up 
            // it should blink in white and give out a sound effect.
            this.color = new Color(255, 255, 255, 255);
            this.state = 2;
        } else if (this.time > 0) {
            // if there is less than 1 sec before the object's time is up 
            // it should become completely opaque.
            this.color = new Color(
                this.color.getRed(),
                this.color.getGreen(), 
                this.color.getBlue(),
                 255);
            this.state = 1;
        } else {
            // if there is no time left then the object should be removed
            this.state = 0;
        }
    }

    /**
    * The rest of the file is just getters and setters 
    * for the private fields of the class.
    */
    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }

    public void setTime(int time) {
        this.time = time; 
    }

    // Getters
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Color getColor() {
        return this.color;
    }

    public int getTime() {
        return this.time;
    }

    public int getState() {
        return this.state;
    }
}


 /* 
 * Here are all the sources of information that were used while creating this class.
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/java/awt/Color.html
 */