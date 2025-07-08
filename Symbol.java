public class Symbol
{
    protected int xPos;
    protected int yPos;
    
    public Symbol(){
        xPos = 0;
        yPos = 0;
    }
    
    public void draw(int xPosNew, int yPosNew) {
        
    }
    
    public void move(int xPosNew, int yPosNew) {
        xPos = xPosNew;
        yPos = yPosNew;
    }
}
