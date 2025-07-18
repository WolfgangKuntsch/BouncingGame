public class SideWalls extends Figur {
    private final int WAND_DICKE = 10;
    private int screenWidth;
    private int screenHeight;

    public SideWalls() {
        super();
        this.screenWidth = 1950;
        this.screenHeight = Zeichenfenster.MalflächenHöheGeben()*3;
        
        //linke Wand
        FigurteilFestlegenRechteck(0, 0, WAND_DICKE, screenHeight, "magenta");
        
        //rechte Wand
        FigurteilFestlegenRechteck(screenWidth, 0, WAND_DICKE, screenHeight, "magenta");

        GanzNachVornBringen();
        
        PositionSetzen(0, 0);
    }

 
    public boolean checkKollision(int x, int y, int radius) {
        // Linke Wand
        if (x - radius <= WAND_DICKE) {
            return true;
        }
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
}