import java.awt.Color;
import javax.swing.JButton;

/**
 * Seperate class for the buttons on the main menu.
 */
public class MainMenuButton extends JButton {
    /**
     * Constructor that expexts the dimentions of the button and the text that it will display.
     */
    public MainMenuButton(int width, int height, Color color, String text) {
        this.setSize(width, height);
        this.setText(text);
        this.setBackground(color);
        this.setVisible(true);
        this.setOpaque(true);
        this.setBorderPainted(false);
    }
}
