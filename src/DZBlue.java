import java.awt.Color;
import java.util.Random;

/**
 * Class for the blue DZ.
 */
public class DZBlue extends DangerZone {
    private Random random = new Random();
    
    /**
     * Constructor for the class for the blue DZ.
     */
    public DZBlue(PlayerCharacter player) {
        super(0, 0, 0, 0, Color.MAGENTA, 0);
        this.setVisuals(player);
    }
    
    /**
     * Choses a position ased on the players coordinates.
     */
    public void setVisuals(PlayerCharacter player) {
        this.setX(player.getX() - random.nextInt(20));
        this.setY(player.getY() - random.nextInt(20));
        this.setWidth(player.getWidth() + random.nextInt(80));
        this.setHeight(player.getHeight() + random.nextInt(80));
        this.setTrueColor(new Color(0, 0, 200));
        this.setTime(100 + random.nextInt(100));
    }
}
