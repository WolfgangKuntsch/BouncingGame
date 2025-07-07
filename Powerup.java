abstract public class Powerup
{
    private int xPos;
    private int yPos;
    private static int speed = 20;
    
    protected static int sideLength = 20;
    
    protected PowerupSymbol symbol;
    
    public Powerup()
    {
        xPos = 0;
        yPos = 0;
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
    
    public int getSideLength() {
        return sideLength;
    }
    
    public void doPowerupEffect() {
        
    }
}
