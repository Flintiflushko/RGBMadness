import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class that generates the window for the main game.
 */
public class GameScreen extends JFrame {

    private ArrayList<VisibleObject> thingsToDraw = new ArrayList<>();

    /**
     * A methood that sets up the window in which the game will be played.
     * The methood takes the width, height and 2 panels which it manipulates
     * to make the initial look of the window.
     */
    private void setUp(
        int width, int height, JPanel playingField, JPanel textField) {
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        playingField.setSize(width, 9 * height / 10);
        playingField.setLayout(null);
        playingField.setVisible(true);
        this.add(playingField);
        playingField.setLocation(0, height / 10);

        textField.setSize(width, height / 10);
        textField.setBackground(Color.GRAY);
        textField.setLayout(null);
        textField.setVisible(true);
        this.add(textField);
        textField.setLocation(0, 0);

    }

    /**
     * A methood that initiates the actuall game.
     */
    private void playGame(JPanel playingField) throws InterruptedException {

    }


    /**
     * Constructor for the start menu.
     */
    public GameScreen(int width, int height) {
        this.thingsToDraw.add(new VisibleObject(width / 2, height / 2, 40, 40, Color.WHITE));
        GamePanel playingField = new GamePanel(this.thingsToDraw);
        JPanel textField = new JPanel();
        setUp(width, height, playingField, textField);
        try {
            playGame(playingField);
        } catch (InterruptedException e) {
            System.out.print("Something went wrong while playing the game!");
        }
    }
}
