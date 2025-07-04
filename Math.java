public class Math
{
    public Math()
    {
        
    }
    
    public static int CircleRectangleCollision(int cx, int cy, int cr, int rx, int ry, int rh, int rw) {    
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
    
        if (PointInCircle(cx, cy, cr, left, top)) {
            return 5; // Top-left corner
        }
    
        if (PointInCircle(cx, cy, cr, right, top)) {
            return 6; // Top-right corner
        }
    
        if (PointInCircle(cx, cy, cr, left, bottom)) {
            return 7; // Bottom-left corner
        }
    
        if (PointInCircle(cx, cy, cr, right, bottom)) {
            return 8; // Bottom-right corner
        }
    
        // No collision
        return 0;
    }
    
    public static boolean PointInCircle(int cx, int cy, int cr, int px, int py) {
        int dx = cx - px;
        int dy = cy - py;
        return dx * dx + dy * dy <= cr * cr;
    }
    
    public static boolean collisionBetweenCircles(int c1x, int c1y, int c1r, int c2x, int c2y, int c2r) {
        int dx = c1x - c2x;
        int dy = c1y - c2y;
        return dx * dx + dy * dy <= (c1r + c2r) * (c1r + c2r);
    }
}
