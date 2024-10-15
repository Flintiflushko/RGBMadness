import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;




public class HowToPlayMenu extends JFrame {

    int dialogWidth = 500;
    int dialogHeight = 400;

    HowToPlayMenu () {
        this.getContentPane().setBackground(Color.BLACK);

        this.setSize(dialogWidth, dialogHeight);
        this.setLayout(new BorderLayout());

        // JPanel panel = new JPanel();
        // panel.setSize(dialogWidth, dialogHeight);
        // panel.setBackground(Color.BLACK);
        // panel.setLayout(null);
        // panel.setOpaque(true);
        // this.add(panel);
        // this.setVisible(true);

        JLabel label = new JLabel();
        label.setText("<html><dive style = 'text-align: center;'>" + "<font color='red'>Use wasd to move.</font><br>"
            + "<font color='green'>Avoid obstacles to earn points.</font></html>");
        label.setFont(new Font("Sans Serif", Font.BOLD, 24));
        label.setForeground(Color.white);
        label.setBackground(Color.BLACK);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setOpaque(true);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener((ActionEvent e) -> {
            this.dispose();
        }); 
        

        this.add(label, BorderLayout.NORTH);
        this.revalidate();
        label.setLocation(200, 200);
        this.add(closeButton, BorderLayout.SOUTH);
        this.setVisible(true);

        this.setLocationRelativeTo(StartMenu.mainPanel);
        
        
    }
}
