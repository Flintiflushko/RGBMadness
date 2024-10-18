import java.awt.Color;
import java.util.Random;

public class DZBlue extends DangerZone {
    private Random random = new Random();
    
    public DZBlue(PlayerCharacter player) {
        super(0, 0, 0, 0, Color.MAGENTA, 0);
        this.setVisuals(player);
    }
    
    
    public void setVisuals(PlayerCharacter player) {
        this.setX(player.getX() - random.nextInt(20));
        this.setY(player.getY() - random.nextInt(20));
        this.setWidth(player.getWidth() + random.nextInt(80));
        this.setHeight(player.getHeight() + random.nextInt(80));
        this.setTrueColor(new Color(0, 0, 200));
        this.setTime(100 + random.nextInt(100));
    }

}
