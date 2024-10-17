import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class EndScreen extends JFrame{

    EndScreen() {
        this.getContentPane().setBackground(Color.BLACK);
        this.setSize(700, 900);
        this.setLayout(null);

        JLabel label = new JLabel();
        label.setText("<html><dive style = 'text-align: center;'>"
            + "<font color='red'>GAME</font><br>"
            + "<font color='green'>OVER</font></html>");
        label.setFont(new Font("Sans Serif", Font.BOLD, 24));
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVisible(true);
        label.setOpaque(true);

        MainMenuButton closeButton = new MainMenuButton(450, 90, Color.BLUE, "Close");
        
        closeButton.setPreferredSize(new Dimension(60, 60));
        closeButton.setMaximumSize(new Dimension(60, 60));
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        // closeButton.setIcon(closeIcon);
        // if (closeIcon.getIconWidth() > 0) {
        //     closeButton.setIcon(closeIcon);
        // } else {
        //     closeButton.setText("Close");  // Fallback if the image doesn't load
        // }

        closeButton.addActionListener((ActionEvent e) -> {
            this.dispose();
        }); 

        this.add(label);
        this.add(closeButton);
        closeButton.setLocation(450/2, (900 - (90 / 9)) / 2);
        this.setVisible(true);
        this.setLocationRelativeTo(StartMenu.mainPanel);
    }
}
