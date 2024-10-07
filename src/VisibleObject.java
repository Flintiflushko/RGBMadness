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

    /**
     * Constructor for general use that takes in the x and y coordinate
     * for the start of the visible object that will be painted on the game panel
     * as well as its width, height and color.
     */
    public VisibleObject(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
    * The rest of the file is just getters and setters 
    * for the private fields of the class.
    */
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
}