import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class that generates the window for the main game.
 */
public class GameScreen extends JFrame implements KeyListener {

    private ArrayList<VisibleObject> thingsToDraw = new ArrayList<>();

    /**A methood that sets up the window in which the game will be played.
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
        this.addKeyListener(this);
        
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
    private void playGame(GamePanel playingField) throws InterruptedException {
        while (true) { 
            Thread.sleep(500);
            for (VisibleObject vo : this.thingsToDraw) {
                vo.setTime(vo.getTime() - 1);
                vo.correctColor();
                if (vo.getTime() == 0) {
                    thingsToDraw.remove(vo);
                }
            }
            playingField = new GamePanel(thingsToDraw);
        }
    }


    /**Constructor for the start menu.
     */
    public GameScreen(int width, int height) {
        this.thingsToDraw.add(new VisibleObject(
            width / 2 - 20, height / 2 - 20, 40, 40, Color.RED, 1));
        GamePanel playingField = new GamePanel(this.thingsToDraw);
        JPanel textField = new JPanel();
        setUp(width, height, playingField, textField);
        try {
            playGame(playingField);
        } catch (InterruptedException e) {
            System.out.print("Something went wrong while playing the game!");
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 40 -> System.out.println("Down");
            case 39 -> System.out.println("Rigth");
            case 38 -> System.out.println("Up");
            case 37 -> System.out.println("Left");
            default -> System.out.println(e.getKeyCode());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Ignore this method.
        //Use keyPressed() instead.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Ignore this method.
        //Use keyPressed() instead.
    }
}
