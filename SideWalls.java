public class SideWalls extends Figur {
    private final int WAND_DICKE = 10;
    private int screenWidth;
    private int screenHeight;

    public SideWalls() {
        super();
        this.screenWidth = Zeichenfenster.MalflächenBreiteGeben();
        this.screenHeight = Zeichenfenster.MalflächenHöheGeben();
        
        //linke Wand
        FigurteilFestlegenRechteck(0, 0, WAND_DICKE, screenHeight*3, "blau");
        
        //rechte Wand
        FigurteilFestlegenRechteck(1950, 0, WAND_DICKE, screenHeight*3, "rot");

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