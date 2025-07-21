public class RightWall{
    private final int WAND_DICKE = 10;
    private int screenWidth;
    private int screenHeight;
    
    private int xPos;
    private int yPos;
    
    private WallSymbol symbol;

    public RightWall(int screenWidthNew, int screenHeightNew) {
        super();
        this.screenWidth = screenWidthNew;
        this.screenHeight = screenHeightNew;
        
        xPos = screenWidth - WAND_DICKE;
        yPos = 0;
        symbol = new WallSymbol(WAND_DICKE, screenHeight, xPos, yPos);
    }

 
    public boolean checkKollision(int x, int y, int radius) {
        // Linke Wand
        // if (x - radius <= WAND_DICKE) {
            // return true;
        // }
        // Rechte Wand
        if (x + radius >= screenWidth - WAND_DICKE) {
            return true;
        }
        return false;
    }

   
    public boolean checkBallVerloren(int y, int radius) {
        return y + radius >= screenHeight;
    }

   
    public int getWandDicke() {
        return WAND_DICKE;
    }

    public int getHeight() {
        return screenHeight;
    }
    
    public int getX() {
        return xPos;
    }
    
    public int getY() {
        return yPos;
    }
}
