import java.util.ArrayList;

public class BrickController
{
    private ArrayList<Brick> bricks;
    private Ball ball;
    
    private int screenWidth;
    private int screenHeight;
    
    public BrickController(int screenWidthNew, int screenHeightNew, Ball ballNew)
    {
        bricks = new ArrayList<Brick>();
        ball = ballNew;
        screenWidth = screenWidthNew;
        screenHeight = screenHeightNew;
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
