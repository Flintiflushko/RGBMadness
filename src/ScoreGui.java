import java.awt.*;
import javax.swing.*;
 
/**
 * A class for the top of the GameScreen where the 
 * score and speed of the player is displayed.
 */
public class ScoreGui extends JPanel {

    private JLabel scoreLabel;
    private JLabel speedLabel;

    /**
     * A constructor that takes in the score and speed that should be displayed.
     */
    public ScoreGui(int score, int speed) {
        this.setSize(800, 100);
        this.setBackground(Color.GRAY);
        this.setLayout(null);
        this.setLocation(0, 0);

        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setFont(new Font("Sans Serif", Font.BOLD, 30));
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setBackground(Color.GRAY);
        scoreLabel.setVisible(true);
        scoreLabel.setOpaque(true);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setVerticalAlignment(JLabel.CENTER);
        scoreLabel.setBounds(50, 20, 300, 50);

        speedLabel = new JLabel("Speed: " + speed);
        speedLabel.setFont(new Font("Sans Serif", Font.BOLD, 30));
        speedLabel.setForeground(Color.BLACK);
        speedLabel.setBackground(Color.GRAY);
        speedLabel.setVisible(true);
        speedLabel.setOpaque(true);
        speedLabel.setHorizontalAlignment(JLabel.CENTER);
        speedLabel.setVerticalAlignment(JLabel.CENTER);
        speedLabel.setBounds(400, 20, 300, 50);

        this.add(scoreLabel);
        this.add(speedLabel);
        this.setVisible(true);
    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    public void updateSpeed(int speed) {
        speedLabel.setText("Speed: " + speed);
    }
}
