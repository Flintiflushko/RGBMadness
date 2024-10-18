import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * Class that generates the window for the end screen.
 */
public class EndScreen extends JFrame {
    /**
     * Constructor for the end screen.
     */
    public EndScreen() {
        this.getContentPane().setBackground(Color.BLACK);
        this.setSize(700, 900);
        this.setLayout(null);

        JLabel gameOver = new JLabel();
        gameOver.setText("<html><dive style = 'text-align: center;'>"
            + "<font color='red'>GAME</font><br>"
            + "<font color='red'>OVER</font></html>");
        gameOver.setFont(new Font("Sans Serif", Font.BOLD, 50));
        gameOver.setHorizontalAlignment(SwingConstants.CENTER);
        gameOver.setVisible(true);

        JLabel score = new JLabel("Your score is: " + GameScreen.getScore());
        score.setFont(new Font("Sans Serif", Font.BOLD, 30));
        score.setForeground(Color.GREEN);
        score.setBackground(Color.BLACK);
        score.setHorizontalAlignment(SwingConstants.CENTER);
        score.setVisible(true);
        score.setOpaque(true);

        int buttonWidth = 350;
        int buttonHeight = 90;
        MainMenuButton closeButton = new MainMenuButton(buttonWidth, buttonHeight,
            Color.BLUE, "Close");
        closeButton.setFont(new Font("Sans Serif", Font.BOLD, 24));
        closeButton.addActionListener((ActionEvent e) -> {
            this.dispose();
        }); 

        MainMenuButton newGameButton = new MainMenuButton(buttonWidth, buttonHeight, 
            Color.GREEN, "New game");
        newGameButton.setFont(new Font("Arial", Font.BOLD, 24));
        newGameButton.addActionListener((ActionEvent e) -> {
            new GameScreen(800, 1000);
            this.dispose();
        });

        int gameOverWidth = 500;  
        int gameOverHeight = 200;
        int frameWidth = this.getWidth();
        int frameHeight = this.getHeight();
        int gameOverX = (frameWidth - gameOverWidth) / 2;
        int gameOverY = (frameHeight - gameOverHeight) / 13;
        gameOver.setBounds(gameOverX, gameOverY, gameOverWidth, gameOverHeight);
        this.add(gameOver);
        int scoreWidth = 300;
        int scoreHeight = 100;
        int scoreX = (frameWidth - scoreWidth) / 2;
        int scoreY = (frameHeight - scoreHeight) / 3;
        score.setBounds(scoreX, scoreY, scoreWidth, scoreHeight);
        this.add(score);
        this.add(newGameButton);
        newGameButton.setLocation((frameWidth - buttonWidth) / 2,
            ((frameHeight - (buttonHeight / 9)) / 2) + buttonHeight);
        this.add(closeButton);
        closeButton.setLocation((frameWidth - buttonWidth) / 2,
            ((frameHeight - (buttonHeight / 9)) / 2) + 2 * buttonHeight);
        this.setVisible(true);
        this.setLocationRelativeTo(StartMenu.mainPanel);
    }
}
