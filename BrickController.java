import java.util.ArrayList;

public class BrickController
{
    private ArrayList<Brick> bricks;
    private Ball ball;
    
    private int screenWidth;
    private int screenHeight;
    
    private int brickWidth = 100;
    private int brickHeight = 30;
    
    public BrickController(int screenWidthNew, int screenHeightNew)
    {
        bricks = new ArrayList<Brick>();
        
        screenWidth = screenWidthNew;
        screenHeight = screenHeightNew;
    }
    
    public void addBrick(Brick brickNew) {
        bricks.add(brickNew);
    }
    
    public void populateGrid(int rows, int columns, int spacing) {
        if (((screenWidth - ((rows + 1) * spacing) / brickWidth) >= rows) && ((screenHeight - ((columns + 1) * spacing) / brickHeight) >= columns)) {
            int spacingInbetween = (screenHeight - 2* spacing - rows * brickWidth) / (rows - 1);
                
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; i++) {
                    Brick brick = new Brick(spacing + j * (brickWidth + spacingInbetween), spacing + i * (brickHeight + spacingInbetween), brickHeight, brickWidth);
                    addBrick(brick);
                }
            }
        }
    }
    
    public void frame() {
        for (Brick brick : bricks) {
            // draw the brick
            brick.draw();
            
            // collision between Ball and Brick
            switch (CustomMath.CircleRectangleCollision(ball.getXPos(), ball.getYPos(), ball.getRadius(), brick.getXPos(), brick.getYPos(), brick.getHeight(), brick.getWidth())) {
                case 1: // Top
                case 2: // Bottom
                    ball.reflectY();
                    bricks.remove(brick);
                    break;
            
                case 3: // Left
                case 4: // Right
                    ball.reflectX();
                    bricks.remove(brick);
                    break;
            
                case 5: // Top-left
                case 6: // Top-right
                case 7: // Bottom-left
                case 8: // Bottom-right
                    ball.reflectX();
                    ball.reflectY();
                    bricks.remove(brick);
                    break;
            }
        }
    }
}
