public class Brick
{
    private int xPos; //x-Position of top-left corner
    private int yPos; //y-Position of top-left corner
    
    private int height; 
    private int width;
    
    private BrickSymbol symbol;
    
    public Brick(int xPosNew, int yPosNew, int heightNew, int widthNew)
    {
        xPos = xPosNew;
        yPos = yPosNew;
        height = heightNew;
        width = widthNew;
        
        symbol = new BrickSymbol(width, height);
    }
    
    public int getXPos(){
        return xPos;
    }
    
    public int getYPos(){
        return yPos;
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getWidth(){
        return width;
    }
    
    public void draw() {
        symbol.draw(xPos, yPos);
    }
    
    public void remove() {
        symbol.remove();
    }
}
