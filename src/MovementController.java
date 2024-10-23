/**
 * A class for the movement of the player.
 */
public class MovementController {

    /**
     * The method takes an array of boolean elements and based on that 
     * determines what keys are pressed and how the cordinates of 
     * the player should be changed.
     */
    public void movePlayer (
        boolean[] keysPressed,
        int speed, 
        PlayerCharacter playerCharecter,
        GamePanel playingField) {
        if (keysPressed[4]) {
            //"Boost"
            speed = speed * 2;
        }
        if (keysPressed[5]) {
            //"Boost"
            speed = speed / 2;
        }
        if (keysPressed[0]) {
            //"Up"
            playerCharecter.setY(playerCharecter.getY() - speed);
            if (playerCharecter.getY() < 0) {
                playerCharecter.setY(0);
            }
        }
        if (keysPressed[1]) {
            //Left
            playerCharecter.setX(playerCharecter.getX() - speed);
            if (playerCharecter.getX() < 0) {
                playerCharecter.setX(0);
            }
        }
        if (keysPressed[2]) {
            //Down
            playerCharecter.setY(playerCharecter.getY() + speed);
            if (playerCharecter.getY() + playerCharecter.getHeight() > playingField.getHeight()) {
                playerCharecter.setY(playingField.getHeight() - playerCharecter.getHeight());
            }
        }
        if (keysPressed[3]) {
            //Rigth
            playerCharecter.setX(playerCharecter.getX() + speed);
            if (playerCharecter.getX() + playerCharecter.getWidth() > playingField.getWidth()) {
                playerCharecter.setX(playingField.getWidth() - playerCharecter.getWidth());
            }
        }
        
    }
    
}
