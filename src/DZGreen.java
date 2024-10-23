import java.awt.Color;
import java.util.Random;

/**
 * Class for the green DZ.
 */
public class DZGreen extends DangerZone {
    private Random random = new Random();
    
    /**
     * Constructor for the class for the green DZ.
     */
    public DZGreen() {
        super(0, 0, 0, 0, Color.MAGENTA, 0);
        setVisuals();
    }
    
    @Override
    public void setVisuals() {
        this.setX(random.nextInt(800));
        this.setWidth(random.nextInt(40) + 40);
        this.setHeight(1500);
        this.setTrueColor(new Color(0, 200, 0));
        this.setTime(240);
    }

}
