import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class that generates the window for the main game.
 */
public class GameScreen extends JFrame implements KeyListener, ActionListener {

    private ArrayList<VisibleObject> thingsToDraw = new ArrayList<>();
    private int difficulty;
    private int score;
    private GamePanel playingField;
    private JPanel textArea;
    private final Timer timer;

    /**A methood that sets up the window in which the game will be played.
     * The methood takes the width, height and 2 panels which it manipulates
     * to make the initial look of the window.
     */
    private void setUp(
        int width, int height) {
        this.playingField = new GamePanel(this.thingsToDraw);
        this.textArea = new JPanel();
        this.difficulty = 1;
        this.score = 0;
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.addKeyListener(this);
        
        this.playingField.setSize(width, 9 * height / 10);
        this.playingField.setLayout(null);
        this.playingField.setVisible(true);
        this.add(playingField);
        this.playingField.setLocation(0, height / 10);

        this.textArea.setSize(width, height / 10);
        this.textArea.setBackground(Color.GRAY);
        this.textArea.setLayout(null);
        this.textArea.setVisible(true);
        this.add(textArea);
        this.textArea.setLocation(0, 0);
    }

    /**
     * A methood that initiates the actual game.
     */
    private void gameLoop() {
        System.out.println("Looped gameloop");
        if (thingsToDraw.size() <= difficulty) {
            thingsToDraw.add(new VisibleObject(100, 
                100, 
                100, 
                100, 
                new Color(255, 255, 255, 255), 
                 180));
        }
        this.playingField = new GamePanel(thingsToDraw);
        this.playingField.repaint();
    }


    /**Constructor for the start menu.
     */
    public GameScreen(int width, int height) {
        setUp(width, height);
        timer = new Timer(500, this);
        timer.start();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        gameLoop();
    }
}

/* 
 * Here are all the sources of information that were used while creating this class.
 * https://docs.oracle.com/javase/8/docs/api/index.html?java/awt/event/KeyListener.html
 * https://docs.oracle.com/javase/8/docs/api/?java/util/ArrayList.html
 * https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Random.html
 */
