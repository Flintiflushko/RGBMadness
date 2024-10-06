import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
* Class StartMenu extends JFrame and is the 
* class that will contain the structure of the 
* starting menu of the game.
*/
public class StartMenu extends JFrame {
    /**
     * Constructor for the start menu.
     */
    public StartMenu(int width, int height) {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        JPanel mainPanel = new JPanel();
        mainPanel.setSize(new Dimension(width, height));
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setLayout(null);
        this.add(mainPanel);
        this.setVisible(true);

        int buttonWidth = width / 2;
        int buttonHeight = height / 10;
        int buttonStartX = (width - buttonWidth) / 2;
        int buttonStartY = (height - (buttonHeight / 9)) / 2;
        
        MainMenuButton playButton = new MainMenuButton(
            buttonWidth, buttonHeight, Color.RED, "PLAY"
            );
        MainMenuButton htpButton = new MainMenuButton(
            buttonWidth, buttonHeight, Color.GREEN, "HOW TO PLAY?"
            );
        MainMenuButton exitButton = new MainMenuButton(
            buttonWidth, buttonHeight, Color.BLUE, "EXIT"
            );

        mainPanel.add(playButton);
        mainPanel.add(htpButton);
        mainPanel.add(exitButton);
        
        playButton.setLocation(buttonStartX, buttonStartY);
        htpButton.setLocation(buttonStartX, buttonStartY + buttonHeight);
        exitButton.setLocation(buttonStartX, buttonStartY + (buttonHeight * 2));

        playButton.addActionListener((ActionEvent e) -> {
            System.out.println("You clicked the PLAY button");
        }); 
        htpButton.addActionListener((ActionEvent e) -> {
            System.out.println("Use W A S D to move, don't hit the obstacles");
        });
        exitButton.addActionListener((ActionEvent e) -> {
            this.dispose();
        });
    }
}