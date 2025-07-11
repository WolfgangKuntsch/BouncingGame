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
    public BrickController(int screenWidthNew, int screenHeightNew, Ball ballNew, Bat batNew, PowerupController powerupControllerNew)
    {
        bricks = new ArrayList<Brick>();
        ball = ballNew;
        bat = batNew;
        
        screenWidth = screenWidthNew;
        screenHeight = screenHeightNew;
        
        rand = new Random();
        
        powerups = powerupControllerNew;
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
            throw new IndexOutOfBoundsException("Too many rows or columns to fit on screen");
        }
    }
    
    public void frame() {
        //move the powerups
        powerups.frame();
        var iter = bricks.iterator();
        while (iter.hasNext()) {
            Brick brick = iter.next();
            // draw the brick
            brick.draw();
            // collision between Ball and Brick
            switch (CustomMath.CircleRectangleCollision(ball.getXPos(), ball.getYPos(), ball.getRadius(), brick.getXPos(), brick.getYPos(), brick.getHeight(), brick.getWidth())) {
                case 1: // Top
                case 2: // Bottom
                    ball.reflectY();
                    iter.remove();
                    breakBrick(brick);
                    //iter.remove();
                    break;
            
                case 3: // Left
                case 4: // Right
                    ball.reflectX();
                    iter.remove();
                    breakBrick(brick);
                    //iter.remove();
                    break;
            
                case 5: // Top-left
                case 6: // Top-right
                case 7: // Bottom-left
                case 8: // Bottom-right
                    int dx =  (int) (0.1 * (ball.getXPos() - (brick.getXPos() + brick.getWidth()/2)));
                    int dy =  (int) (0.1 * (ball.getYPos() - (brick.getYPos() + brick.getHeight()/2)));
                    ball.setDirection(dx, dy);
                    iter.remove();
                    breakBrick(brick);
                    
                    break;
            }
        }
    }
    private void breakBrick(Brick brick) {
        Powerup powerup = powerups.choosePowerup();
        if (powerup != null) {
            powerup.setPosition(brick.getXPos(), brick.getYPos());
            powerups.addPowerup(powerup); 
        }
        brick.remove();
        bricks.remove(brick);
    }
    
    public int getBrickCount () {
        return bricks.size();
    }
}
