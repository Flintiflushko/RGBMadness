import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
* Class StartMenu extends JFrame and is the 
* class that will contain the structure of the 
* starting menu of the game.
*/
public class StartMenu extends JFrame {
    
    static JPanel mainPanel = new JPanel();

    /**
     * Constructor for the start menu.
     */
    public StartMenu(int width, int height) {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        mainPanel.setSize(width, height);
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setLayout(null);
        this.add(mainPanel);
        this.setVisible(true);

        int buttonWidth = width / 2;
        int buttonHeight = height / 10;
        int buttonStartX = (width - buttonWidth) / 2;
        int buttonStartY = (height - (buttonHeight / 9)) / 2;

        ImagePanel image = new ImagePanel(buttonStartY);
        mainPanel.add(image);

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
            this.dispose();
            new SoundManager().playClickSFX();
            new GameScreen(800, 1000).setVisible(true);
        }); 
        htpButton.addActionListener((ActionEvent e) -> {
            new SoundManager().playClickSFX();
            HowToPlayMenu menu = new HowToPlayMenu();
        });
        exitButton.addActionListener((ActionEvent e) -> {
            new SoundManager().playClickSFX();
            this.dispose();
        });
    }
}

/* 
 * Here are all the sources of information that were used while creating this class.
 */