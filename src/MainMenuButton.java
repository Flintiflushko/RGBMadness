import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 * Seperate class for the buttons on the main menu.
 */
public class MainMenuButton extends JButton{
    /**
     * Constructor that expexts the dimentions of the button and the text that it will display.
     */
    public MainMenuButton(int width, int height, String text) {
        this.setSize(new Dimension(width, height));
        this.setText(text);
        this.setBackground(Color.GREEN);
        this.setVisible(true);
    }

    /**
     * Method that allows other classes to change the lacation of the button.
     */
    public void moveTo(int x, int y) {
        this.setLocation(x, y);
    }
}
