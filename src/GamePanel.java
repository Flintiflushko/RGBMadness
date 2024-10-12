
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * In this class we override the paint method of the JPanel class
 * and make it print all of the visible objects on the game panel.
 */
public class GamePanel extends JPanel {

    private final ArrayList<DangerZone> thingsToDisplay = new ArrayList<>();

    /**
    * Constructor that takes in an ArrayList of visible objects 
    * and copies it to the class's private field. 
    */
    public GamePanel(ArrayList<DangerZone> thingsToDisplay) {
        for (DangerZone thingToAdd : thingsToDisplay) {
            this.thingsToDisplay.add(thingToAdd);
        }
        this.setSize(800, 900);
        this.setVisible(true);
        this.setLocation(0, 100);
        this.setLayout(null);
    }

    /**
     * TODO. javadoc
     */
    public void redrawPanel(ArrayList<DangerZone> thingsToDraw) {
        this.thingsToDisplay.clear();
        for (DangerZone thingToAdd : thingsToDraw) {
            this.thingsToDisplay.add(thingToAdd);
        }
        this.repaint();
    }

    /**
     * Overriding the paint method as mentioned in the class description.
     */
    @Override
    public void paint(Graphics grafix) {
        Graphics2D grafix2d = (Graphics2D) grafix;

        grafix2d.setPaint(Color.black);
        grafix2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (VisibleObject objectToDraw : this.thingsToDisplay) {
            grafix2d.setPaint(objectToDraw.getColor());
            grafix2d.fillRect(
                objectToDraw.getX(), objectToDraw.getY(), 
                objectToDraw.getWidth(), objectToDraw.getHeight());
        }
    }
    
}

/* 
 * Here are all the sources of information that were used while creating this class.
 * https://docs.oracle.com/javase/8/docs/api/?java/util/ArrayList.html
 */