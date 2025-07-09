abstract public class Powerup
{
    private int xPos;
    private int yPos;
    private static int speed = 5;
    
    protected static int radius = 10;
    
    protected PowerupSymbol symbol;
    
    public Powerup(int radiusNew, int speedNew)
    {
        xPos = 0;
        yPos = 0;
        
        radius = radiusNew;
        speed = speedNew;
    }
    
    public void setPosition (int xPosNew, int yPosNew) {
        xPos = xPosNew;
        yPos = yPosNew;
    }
    
    public void setSpeed(int speedNew) {
        speed = speedNew;
    }
    
    public void frame() {
        yPos += speed;
        symbol.draw(xPos, yPos);
    }
    
    public int getXPos() {
        return xPos;
    }
    
    public int getYPos() {
        return yPos;
    }
    
    public int getRadius() {
        return radius;
    }
    
    public void doPowerupEffect() {
        
    }
    
    public void remove() {
        symbol.remove();
    }
}
