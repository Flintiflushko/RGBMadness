import java.awt.Color;
import java.util.Random;

/**
 * Class for the red DZ.
 */
public class DZRed extends DangerZone {
    private Random random = new Random();
    
    /**
     * Constructor for the class for the red DZ.
     */
    public DZRed() {
        super(0, 0, 0, 0, Color.MAGENTA, 0);
        setVisuals();
    }
    
    @Override
    public void setVisuals() {
        this.setX(random.nextInt(700));
        this.setY(random.nextInt(800));
        this.setWidth(random.nextInt(400) + 150);
        this.setHeight(random.nextInt(400) + 150);
        this.setTrueColor(new Color(200, 0, 0));
        this.setTime(240);
    }

}
