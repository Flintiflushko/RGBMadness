import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class that generates the window for the main game.
 */
public class GameScreen extends JFrame implements KeyListener, ActionListener {

    private ArrayList<VisibleObject> thingsToDraw = new ArrayList<>();
    private final Iterator<VisibleObject> iterator = thingsToDraw.iterator();
    private int difficulty;
    private int score;
    private GamePanel playingField;
    private JPanel textArea;
    private final Timer timer;
    private final Random random = new Random();

    /**A methood that sets up the window in which the game will be played.
     * The methood takes the width, height and 2 panels which it manipulates
     * to make the initial look of the window.
     */
    private void setUp(
        int width, int height) {
        this.playingField = new GamePanel(this.thingsToDraw);
        this.textArea = new JPanel();
        this.score = 0;
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.addKeyListener(this);

        this.textArea.setSize(width, height / 10);
        this.textArea.setBackground(Color.GRAY);
        this.textArea.setLayout(null);
        this.textArea.setVisible(true);
        this.add(textArea);
        this.textArea.setLocation(0, 0);

        playingField = new GamePanel(thingsToDraw);
        this.add(playingField);
    }

    /**
     * A methood that initiates the actual game.
     */
    private void gameLoop() {
        System.out.println(score);
        difficulty = score / 10 + 1;
        if (thingsToDraw.size() < this.difficulty && thingsToDraw.size() < 5) {
            thingsToDraw.add(new VisibleObject(
                random.nextInt(700), 
                random.nextInt(800), 
                random.nextInt(250) + 50, 
                random.nextInt(250) + 50, 
                new Color(255, 0, 0), 
                random.nextInt(140) + 120));
        }

        for (VisibleObject vo : this.thingsToDraw) {
            vo.setTime(vo.getTime() - 1);
            vo.correctState();
            if (vo.getState() == 0) {
                this.score++;
                thingsToDraw = copyAllBut(thingsToDraw, vo);
                
                if (this.thingsToDraw.isEmpty()) {
                    break;
                }
            }

            //TODO check for collision here

        }

        
        this.playingField.redrawPanel(thingsToDraw);
    }

    private ArrayList<VisibleObject> copyAllBut(
        ArrayList<VisibleObject> toCopy, 
        VisibleObject thingNotToCopy) {
        ArrayList<VisibleObject> newAL = new ArrayList<>();
        for (VisibleObject vo : toCopy) {
            if (!vo.equals(thingNotToCopy)) {
                newAL.add(vo);
            }
        }
        return newAL;
    }

    /**Constructor for the start menu.
     */
    public GameScreen(int width, int height) {
        setUp(width, height);
        timer = new Timer(16, this);
        timer.start();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 40) {
            System.out.println("Down");
        }
        if (e.getKeyCode() == 39) {
            System.out.println("Rigth");
        }
        if (e.getKeyCode() == 38) {
            System.out.println("Up");
        }
        if (e.getKeyCode() == 37) {
            System.out.println("Left");
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
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Random.html
 * https://www.geeksforgeeks.org/iterators-in-java/
 */
