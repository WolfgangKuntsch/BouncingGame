public class Wand extends Figur {
    private Rechteck linkeWand;
    private Rechteck rechteWand;
    private Rechteck obereWand;
    private final int WAND_DICKE = 10;
    private int screenWidth;
    private int screenHeight;

    public Wand() {
        this.screenWidth = Zeichenfenster.MalflächenBreiteGeben();
        this.screenHeight = Zeichenfenster.MalflächenHöheGeben();
        
        //linke Wand
        FigurteilFestlegenRechteck(WAND_DICKE/2, screenHeight/2, WAND_DICKE, screenHeight, "blau");
        
        //rechte Wand
        FigurteilFestlegenRechteck(screenWidth - WAND_DICKE/2, screenHeight/2, WAND_DICKE, screenHeight, "blau");
        
        //obere Wand
        FigurteilFestlegenRechteck(screenWidth/2, WAND_DICKE/2, screenWidth, WAND_DICKE, "blau");

        GanzNachVornBringen();
        
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