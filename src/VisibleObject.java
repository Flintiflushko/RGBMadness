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
    private int time;

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
    }

    /**
     * Method that checks how much time the object has left 
     * and assigns it the correct color.
     * When an visible object is close to dissapearing it 
     * will blink in white and then become "ACTIVE".
     */
    public void correctColor() {
        if (this.time <= 1 && this.time > 0) {
            this.color = Color.WHITE;
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
}