import java.awt.Color;
import java.util.Random;

public class DZPurple extends DangerZone {
    private Random random = new Random();
    
    public DZPurple() {
        super(0, 0, 0, 0, Color.MAGENTA, 0);
        setVisuals();
    }
    
    @Override
    public void setVisuals() {
        this.setY(random.nextInt(875));
        this.setWidth(1500);
        this.setHeight(random.nextInt(40) + 40);
        this.setTrueColor(new Color(200, 0, 200));
        this.setTime(240);
    }

}
