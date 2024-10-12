import java.awt.Color;
import java.util.ArrayList;

/**
 * A class for the player charecter.
 */
public class PlayerCharacter extends VisibleObject{
    
    public PlayerCharacter(int x, int y, int size) {
        super(x, y, size, size, Color.WHITE);
    }

    /**
     * Returns a boolean value depending on whether the player character has collided 
     * with any of the danger zones given to it in an array list by checking 
     * the coordinates and sizes of the 2 objects.
     */
    public boolean noCollision(ArrayList<DangerZone> dangerzones) {
        for (DangerZone dz : dangerzones) {
            if (this.x + this.width < dz.getX()
                || this.x > dz.getX() + dz.getWidth()
                || this.y + this.height < dz.getY()
                || this.y > dz.getY() + dz.getHeight()) {
                return true;
            }
        }
        return false;
    }
}