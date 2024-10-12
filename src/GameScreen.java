import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class that generates the window for the main game.
 */
public class GameScreen extends JFrame implements KeyListener, ActionListener {

    private ArrayList<DangerZone> dangerZones = new ArrayList<>();
    private PlayerCharacter playerCharecter;
    private int difficulty;
    private int score;
    private int speed;
    private boolean gameInProgress;
    private GamePanel playingField;
    private JPanel textArea;
    private final Timer timer;
    private final Random random = new Random();

    /**A methood that sets up the window in which the game will be played.
     * The methood takes the width, height and 2 panels which it manipulates
     * to make the initial look of the window.
     */
    private void setUp(int width, int height) {
        playerCharecter = new PlayerCharacter(width / 2, height / 2, 40);
        this.playingField = new GamePanel(playerCharecter, this.dangerZones);
        this.textArea = new JPanel();
        this.score = 0;
        this.speed = 7;
        this.gameInProgress = true;
        
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

        playingField = new GamePanel(playerCharecter, dangerZones);
        this.add(playingField);
    }

    /**
     * A methood that initiates the actual game.
     */
    private void gameLoop() {
        System.out.println(score);
        difficulty = score / 10 + 1;
        if (dangerZones.size() < this.difficulty && dangerZones.size() < 4) {
            dangerZones.add(new DangerZone(
                random.nextInt(700), 
                random.nextInt(800), 
                random.nextInt(250) + 50, 
                random.nextInt(250) + 50, 
                new Color(255, 0, 0),
                240));
        }
        for (DangerZone dz : this.dangerZones) {
            dz.setTime(dz.getTime() - 1);
            dz.correctState();
            if (dz.getState() == 0) {
                this.score++;
                dangerZones = copyAllBut(dangerZones, dz);
            }
            if (this.dangerZones.isEmpty()) {
                break;
            }

            if (!playerCharecter.noCollision(dangerZones)) {
                this.gameInProgress = false;
            }

        }
        this.playingField.redrawPanel(playerCharecter, dangerZones);
    }

    private ArrayList<DangerZone> copyAllBut(
        ArrayList<DangerZone> toCopy, 
        VisibleObject thingNotToCopy) {
        ArrayList<DangerZone> newAL = new ArrayList<>();
        for (DangerZone vo : toCopy) {
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
            playerCharecter.setY(playerCharecter.getY() + this.speed);
            if (playerCharecter.getY() < 0) {
                playerCharecter.setY(0);
            }
        }
        if (e.getKeyCode() == 39) {
            System.out.println("Rigth");
            playerCharecter.setX(playerCharecter.getX() + this.speed);
            if (playerCharecter.getX() > this.getWidth()) {
                playerCharecter.setX(this.getWidth());
            }
        }
        if (e.getKeyCode() == 38) {
            System.out.println("Up");
            playerCharecter.setY(playerCharecter.getY() - this.speed);
            if (playerCharecter.getY() > this.getHeight()) {
                playerCharecter.setY(0);
            }
        }
        if (e.getKeyCode() == 37) {
            System.out.println("Left");
            playerCharecter.setX(playerCharecter.getX() - this.speed);
            if (playerCharecter.getX() < 0) {
                playerCharecter.setX(0);
            }
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
        if (gameInProgress) {
            gameLoop();
        } else {
            this.timer.stop();
            this.dispose();
            new StartMenu(700, 900).setVisible(true);
        }
    }
}

/* 
 * Here are all the sources of information that were used while creating this class.
 * https://docs.oracle.com/javase/8/docs/api/index.html?java/awt/event/KeyListener.html
 * https://docs.oracle.com/javase/8/docs/api/?java/util/ArrayList.html
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Random.html
 * https://www.gamedev.net/forums/topic/348728-java-smooth-keyboard-input/
 */
