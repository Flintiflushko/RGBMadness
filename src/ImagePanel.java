import java.awt.*;
import javax.swing.*;

public class ImagePanel extends JPanel {
    int imageWidth = 300;
    int imageHeight = 200;
    Image image;

    public ImagePanel(int buttonStartY) {
        this.setBackground(Color.WHITE);
        this.setBounds((700 - imageWidth) / 2, (buttonStartY - imageHeight) / 2, 300, 200);
        this.setVisible(true);
        this.setOpaque(true);
        image = new ImageIcon("src/assets/vfx/RGBMTS.jpg").getImage();
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(image, 0, 0, null);
    }
}