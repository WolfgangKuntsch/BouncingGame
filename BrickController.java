import java.util.ArrayList;

public class BrickController
{
    private ArrayList<Brick> bricks;
    private Ball ball;
    
    public BrickController()
    {
        bricks = new ArrayList<Brick>();
    }
    
    public void addBrick(Brick brickNew) {
        bricks.add(brickNew);
    }
    
    public void collisionHandling() {
        for (Brick brick : bricks) {
            switch (collisionDetected(brick)) {
                case 1: // Top
                case 2: // Bottom
                    ball.reflectY();
                    break;
            
                case 3: // Left
                case 4: // Right
                    ball.reflectX();
                    break;
            
                case 5: // Top-left
                case 6: // Top-right
                case 7: // Bottom-left
                case 8: // Bottom-right
                    ball.reflectX();
                    ball.reflectY();
                    break;
            }

        }
    }
    
        public int collisionDetected(Brick brick) {
        // Ball data
        int cr = ball.getRadius();
        int cx = ball.getXPos();
        int cy = ball.getYPos();
    
        // Brick data
        int rx = brick.getXPos();
        int ry = brick.getYPos();
        int rw = brick.getWidth();
        int rh = brick.getHeight();
    
        // Brick corners
        int top = ry;
        int bottom = ry + rh;
        int left = rx;
        int right = rx + rw;
    
        // ==== SIDE COLLISIONS ====
    
        // Top collision
        if (cy + cr >= top && cy < top && cx >= left && cx <= right) {
            return 1; // Top
        }
    
        // Bottom collision
        if (cy - cr <= bottom && cy > bottom && cx >= left && cx <= right) {
            return 2; // Bottom
        }
    
        // Left collision
        if (cx + cr >= left && cx < left && cy >= top && cy <= bottom) {
            return 3; // Left
        }
    
        // Right collision
        if (cx - cr <= right && cx > right && cy >= top && cy <= bottom) {
            return 4; // Right
        }
    
        // ==== CORNER COLLISIONS ====
    
        if (CustomMath.PointInCircle(cx, cy, cr, left, top)) {
            return 5; // Top-left corner
        }
    
        if (CustomMath.PointInCircle(cx, cy, cr, right, top)) {
            return 6; // Top-right corner
        }
    
        if (CustomMath.PointInCircle(cx, cy, cr, left, bottom)) {
            return 7; // Bottom-left corner
        }
    
        if (CustomMath.PointInCircle(cx, cy, cr, right, bottom)) {
            return 8; // Bottom-right corner
        }
    
        // No collision
        return 0;
    }
}
