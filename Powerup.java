abstract public class Powerup
{
    int xPos;
    int yPos;
    int speed = 20;
    
    int radius = 10;
    
    public Powerup(int xPosNew, int yPosNew)
    {
        xPos = xPosNew;
        yPos = yPosNew;
    }
    
    public void setSpeed(int speedNew) {
        speed = speedNew;
    }
    
    public void move() {
        yPos += speed;
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
}
