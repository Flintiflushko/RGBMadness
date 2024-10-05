import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
* Class StartMenu extends JFrame and is the 
* class that will contain the structure of the 
* starting menu of the game.
*/
public class StartMenu extends JFrame{
    /**
     * Constructor for the start menu.
     */
    public StartMenu(int width, int height) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setSize(new Dimension(width, height));
        mainPanel.setBackground(Color.BLACK);
        this.add(mainPanel);

        int buttonWidth = width / 2;
        int buttonHeight = height / 10;
        int buttonStartX = (width - buttonWidth) / 2;
        int buttonStartY = (height - (buttonHeight / 9)) / 2;

        MainMenuButton playButton = new MainMenuButton(buttonWidth, buttonHeight, "PLAY");
        playButton.moveTo(buttonStartX, buttonStartY);
        mainPanel.add(playButton);
        playButton.addActionListener((ActionEvent e) -> {
            System.out.println("You clicked the PLAY button");
        }); 

        MainMenuButton htpButton = new MainMenuButton(buttonWidth, buttonHeight, "HOW TO PLAY?");
        htpButton.moveTo(buttonStartX, buttonStartY + buttonHeight);
        mainPanel.add(htpButton);
        htpButton.addActionListener((ActionEvent e) -> {
            System.out.println("Use W A S D to move, don't hit the obstacles");
        });

        MainMenuButton exitButton = new MainMenuButton(buttonWidth, buttonHeight, "EXIT");
        exitButton.moveTo(buttonStartX, buttonStartY + (buttonHeight * 2));
        mainPanel.add(exitButton);
        exitButton.addActionListener((ActionEvent e) -> {
            this.dispose();
        });

        

    }
}