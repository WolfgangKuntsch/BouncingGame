import java.util.ArrayList;

public class PowerupController
{
    ArrayList<Powerup> powerups;
    Ball ball;
    Bat bat;
    
    int screenWidth;
    int screenHeight;
    
    public PowerupController(int screenHeightNew, int screenWidthNew, Ball ballNew, Bat batNew)
    {
        screenHeight = screenHeightNew;
        screenWidth = screenWidthNew;
        
        ball = ballNew;
        bat = batNew;
        
        powerups = new ArrayList<Powerup>();
    }
    
    public void addPowerup(Powerup powerupNew) {
        powerups.add(powerupNew);
    }
    
    //Processes the Powerups, called every frame
    public void processPowerups() {
        for (Powerup powerup : powerups) {
            powerup.move();
            
            // Clear Powerup if it is off screen
            if ((powerup.getYPos() + powerup.getRadius() + 10) > screenHeight) {
                powerups.remove(powerup);
            }
            
            //Collision between Ball and Powerup --> triggers the Powerup effect
            if (CustomMath.collisionBetweenCircles(ball.getXPos(), ball.getYPos(), ball.getRadius(), powerup.getXPos(), powerup.getYPos(), powerup.getRadius())) {
                clearPowerupEffects();
                powerup.doPowerupEffect();
                powerups.remove(powerup);
            }
        }
    }
    
    private void clearPowerupEffects() {
        // BigBatPowerup & SmallBatPowerup
        bat.setScale(1f);
        
        // BigBallPowerup & SmallBallPowerup
        ball.setScale(1f);
        
        // FastBallPowerup & SlowBallPowerup
        ball.setSpeed(1f);
    }
}
