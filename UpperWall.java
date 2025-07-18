
public class UpperWall extends Figur {
    private final int WAND_DICKE = 10;
    private int screenWidth;
    private int screenHeight;

    public UpperWall() {
        super();
        this.screenWidth = Zeichenfenster.MalflächenBreiteGeben();
        this.screenHeight = Zeichenfenster.MalflächenHöheGeben();
        
        //obere Wand
        FigurteilFestlegenRechteck(0, 0, screenWidth*3, WAND_DICKE, "magenta");

        GanzNachVornBringen();
        
        PositionSetzen(0, 0);
    }

 
    public boolean checkKollision(int x, int y, int radius) {
        // Obere Wand
        if (y - radius <= WAND_DICKE) {
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
