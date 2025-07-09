public class Wand {
    private Rechteck linkeWand;
    private Rechteck rechteWand;
    private Rechteck obereWand;
    private final int WAND_DICKE = 10;
    private int screenWidth;
    private int screenHeight;

    public Wand() {
        this.screenWidth = Zeichenfenster.MalflächenBreiteGeben();
        this.screenHeight = Zeichenfenster.MalflächenHöheGeben();
        
        linkeWand = new Rechteck();
        linkeWand.PositionSetzen(WAND_DICKE/2, screenHeight/2);
        linkeWand.GrößeSetzen(WAND_DICKE, screenHeight);
        linkeWand.FarbeSetzen("grau");
        
        rechteWand = new Rechteck();
        rechteWand.PositionSetzen(screenWidth - WAND_DICKE/2, screenHeight/2);
        rechteWand.GrößeSetzen(WAND_DICKE, screenHeight);
        rechteWand.FarbeSetzen("grau");
        
        obereWand = new Rechteck();
        obereWand.PositionSetzen(screenWidth/2, WAND_DICKE/2);
        obereWand.GrößeSetzen(screenWidth, WAND_DICKE);
        obereWand.FarbeSetzen("grau");
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

    
    public void setSichtbarkeit(boolean sichtbar) {
        linkeWand.SichtbarkeitSetzen(sichtbar);
        rechteWand.SichtbarkeitSetzen(sichtbar);
        obereWand.SichtbarkeitSetzen(sichtbar);
    }
}