import java.awt.*;
import javax.swing.*;

/**
 * Class that generates the image on the start menu.
 */
public class ImagePanel extends JPanel {
    private int imageWidth = 300;
    private int imageHeight = 200;
    private Image image;

    /**
     * Constructor for the image.
     */
    public ImagePanel(int buttonStartY) {
        this.setBackground(Color.WHITE);
        this.setBounds((700 - imageWidth) / 2, (buttonStartY - imageHeight) / 2, 300, 200);
        this.setVisible(true);
        this.setOpaque(true);
        image = new ImageIcon("src/assets/vfx/RGBMTS.jpg").getImage();
    }

    /**
     * Method that uses Graphics2D component to draw the image.
     */
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(image, 0, 0, null);
    }
}