import java.util.ArrayList;
import java.util.Random;

public class BrickController
{
    private ArrayList<Brick> bricks;
    private Ball ball;
    private Bat bat;
    
    private int screenWidth;
    private int screenHeight;
    
    private PowerupController powerups;
    
    private Random rand;
    
    public BrickController(int screenWidthNew, int screenHeightNew, Ball ballNew, Bat batNew)
    {
        bricks = new ArrayList<Brick>();
        ball = ballNew;
        bat = batNew;
        
        screenWidth = screenWidthNew;
        screenHeight = screenHeightNew;
        
        rand = new Random();
        
        powerups = new PowerupController(screenWidth, screenHeight, ball, bat);
    }
    
    public void addBrick(Brick brickNew) {
        bricks.add(brickNew);
    }
    
    public void populateGrid(int brickWidth, int brickHeight, int cols, int rows, int spacing) {
        if (((screenWidth - ((cols + 1) * spacing) / brickWidth) >= cols) && ((screenHeight - ((rows + 1) * spacing) / brickHeight) >= rows)) {
            int sideSpacing = (screenWidth - (cols * brickWidth + (cols - 1) * spacing)) / 2;    
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Brick brick = new Brick(sideSpacing + j * (brickWidth + spacing), spacing + i * (brickHeight + spacing), brickHeight, brickWidth);
                    bricks.add(brick);
                }
            }
        }
        else {
            System.out.println("too many");
        }
    }
    
    public void frame() {
        //move the powerups
        powerups.frame();
        for (Brick brick : bricks) {
            // draw the brick
            brick.draw();
            
            // collision between Ball and Brick
            switch (CustomMath.CircleRectangleCollision(ball.getXPos(), ball.getYPos(), ball.getRadius(), brick.getXPos(), brick.getYPos(), brick.getHeight(), brick.getWidth())) {
                case 1: // Top
                case 2: // Bottom
                    ball.reflectY();
                    breakBrick(brick);
                    break;
            
                case 3: // Left
                case 4: // Right
                    ball.reflectX();
                    breakBrick(brick);
                    break;
            
                case 5: // Top-left
                case 6: // Top-right
                case 7: // Bottom-left
                case 8: // Bottom-right
                    ball.reflectX();
                    ball.reflectY();
                    breakBrick(brick);
                    break;
            }
        }
    }
    private void breakBrick(Brick brick) {
        Powerup powerup = choosePowerup();
        powerup.setPosition(brick.getXPos(), brick.getYPos());
        powerups.addPowerup(powerup);
        
        bricks.remove(brick);
    }
    private Powerup choosePowerup() {
        switch (rand.nextInt(0,7)) {
            case 1:
                return new FastBallPowerup(ball);
            case 2:
                return new SlowBallPowerup(ball);
            case 3:
                return new SmallBallPowerup(ball);
            case 4:
                return new BigBallPowerup(ball);
            case 5:
                return new SmallBatPowerup(bat);
            case 6:
                return new BigBatPowerup(bat);
            default:
                return null;
        }
    }
}
