public class MovementController {

    public void movePlayer (
        boolean[] keysPressed,
        int speed, 
        PlayerCharacter playerCharecter,
        GamePanel playingField ) {
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
