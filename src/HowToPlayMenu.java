import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class HowToPlayMenu extends JFrame {

    int dialogWidth = 500;
    int dialogHeight = 150;

    HowToPlayMenu () {
        this.getContentPane().setBackground(Color.BLACK);

        this.setSize(dialogWidth, dialogHeight);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));


        JLabel label = new JLabel();
        label.setText("<html><dive style = 'text-align: center;'>"
            + "<font color='red'>Use wasd to move.</font><br>"
            + "<font color='green'>Avoid obstacles to earn points.</font></html>");
        label.setFont(new Font("Sans Serif", Font.BOLD, 24));
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon closeIcon = new ImageIcon("src/assets/vfx/exitIcon.jpg");
        
        JButton closeButton = new JButton();
        
        closeButton.setPreferredSize(new Dimension(60, 60));
        closeButton.setMaximumSize(new Dimension(60, 60));
        closeButton.setBorderPainted(false);
        // closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        // closeButton.setIcon(closeIcon);
        if (closeIcon.getIconWidth() > 0) {
            closeButton.setIcon(closeIcon);
        } else {
            closeButton.setText("Close");  // Fallback if the image doesn't load
        }

        closeButton.addActionListener((ActionEvent e) -> {
            this.dispose();
        }); 
        
        this.add(closeButton);
        this.add(label);
        this.setVisible(true);

        this.setLocationRelativeTo(StartMenu.mainPanel);
        
        
    }
}
