import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * Class that generates a how-to-play menu.
 */
public class HowToPlayMenu extends JFrame {
    private int dialogWidth = 700;
    private int dialogHeight = 150;

    /**
     * Constructor for the how-to-play menu.
     */
    HowToPlayMenu() {
        this.getContentPane().setBackground(Color.BLACK);
        this.setSize(dialogWidth, dialogHeight);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.setResizable(false);

        JLabel label = new JLabel();
        label.setText("<html><dive style = 'text-align: center;'>"
            + "<font color='red'>Use [w][a][s][d] to move.</font><br>"
            + "<font color='green'>Use [n] and [m] to speed up or slow down.</font><br>"
            + "<font color='blue'>Avoid obstacles to earn points.</font></html>");
        label.setFont(new Font("Sans Serif", Font.BOLD, 24));
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon closeIcon = new ImageIcon("src/assets/vfx/exitIcon.jpg");
        
        JButton closeButton = new JButton();
        closeButton.setPreferredSize(new Dimension(60, 60));
        closeButton.setBorderPainted(false);

        if (closeIcon.getIconWidth() > 0) {
            closeButton.setIcon(closeIcon);
        } else {
            closeButton.setText("Close");  // Fallback if the image doesn't load
        }

        closeButton.addActionListener((ActionEvent e) -> {
            new SoundManager().playClickSFX();
            this.dispose();
        }); 
        
        this.add(closeButton);
        this.add(label);
        this.setVisible(true);
        this.setLocationRelativeTo(StartMenu.mainPanel);
    }
}
