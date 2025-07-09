import java.util.ArrayList;
import java.util.Random;

public class PowerupController
{
    ArrayList<Powerup> powerups;
    Ball ball;
    Bat bat;
    
    int screenWidth;
    int screenHeight;
    
    Random rand;
    
    private int powerupRadius;
    private int powerupSpeed;
    
    public PowerupController(int screenHeightNew, int screenWidthNew, Ball ballNew, Bat batNew, int powerupRadiusNew, int powerupSpeedNew)
    {
        screenHeight = screenHeightNew;
        screenWidth = screenWidthNew;
        
        ball = ballNew;
        bat = batNew;
        rand = new Random();
        
        powerupRadius = powerupRadiusNew;
        powerupSpeed = powerupSpeedNew;
        
        powerups = new ArrayList<Powerup>();
    }
    
    public void addPowerup(Powerup powerupNew) {
        powerups.add(powerupNew);
    }
    
    //Processes the Powerups, called every frame
    public void frame() {
        var iter = powerups.iterator();
        while (iter.hasNext()) {
            Powerup powerup = iter.next();
            powerup.frame();
            
            // Clear Powerup if it is off screen
            if ((powerup.getYPos() + powerup.getRadius() + 10) > screenHeight) {
                iter.remove();
                powerup.remove();
                powerups.remove(powerup);
            }
            
            //Collision between Ball and Powerup --> triggers the Powerup effect
            if (CustomMath.CircleRectangleCollision(powerup.getXPos(), powerup.getYPos(), powerup.getRadius(), bat.getX(), bat.getY(), bat.getHeight(), bat.getWidth()) > 0) {
                clearPowerupEffects();
                powerup.doPowerupEffect();
                iter.remove();
                powerup.remove();
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
        
        // AdvancedControlsPowerup
        bat.setAdvancedControls(false);
    }
    
    public Powerup choosePowerup() {
        switch (rand.nextInt(8)) {
            case 1:
                return new FastBallPowerup(powerupRadius, powerupSpeed, ball);
            case 2:
                return new SlowBallPowerup(powerupRadius, powerupSpeed, ball);
            case 3:
                return new SmallBallPowerup(powerupRadius, powerupSpeed, ball);
            case 4:
                return new BigBallPowerup(powerupRadius, powerupSpeed, ball);
            case 5:
                return new SmallBatPowerup(powerupRadius, powerupSpeed, bat);
            case 6:
                return new BigBatPowerup(powerupRadius, powerupSpeed, bat);
            case 7:
                return new AdvancedControlPowerup(powerupRadius, powerupSpeed, bat);
            default:
                return null;
        }
    }
}
