public class Bat extends Figur
{
    private static final int BAT_WIDTH = 300;
    private static final int BAT_HEIGHT = 20;
    private static final int BAT_STEP = 10;
    private int x;
    private int y;
    private int width = BAT_WIDTH;
    private int height = BAT_HEIGHT;
    private boolean advancedControls = false;
    
    public Bat()
    {
        super();
        this.x = Zeichenfenster.MalflächenBreiteGeben() / 2;
        this.y = Zeichenfenster.MalflächenHöheGeben() - 20;
        PositionSetzen(x, y);
        draw();
    }
    
    //Größe des Schlägers setzen
    public void setScale(float scale) {
         EigeneFigurLöschen();
         this.width = Math.round(scale * BAT_WIDTH);
         this.height = Math.round(scale * BAT_HEIGHT);
         draw();
    }
    
    /*
     * Die  Aktionsmethode für gedrückte Sondertasten.
     * @param taste KeyCode der gedrückten Taste
     */
    @Override void SonderTasteGedrückt (int taste)
    {
        switch (taste)
        {
            // Pfeil nach links + a
            case 37:
            case 65:
                x -= BAT_STEP;
                break;
            // Pfeil nach oben
            case 38:
            case 87:
                y -= BAT_STEP;
                break;
            // Pfeil nach rechts
            case 39 :
                x += BAT_STEP;
                break;
            // pfeil nach unten
            case 40 :
                y += BAT_STEP;
                break;
        }
        
        PositionSetzen(x, y);
    }
    
    public void setAdvancedControls(boolean active) {
        this.advancedControls = active;
        // throw new UnsupportedOperationException("Not Yet Implemented");
    }
    
    private void draw()
    {
        FigurteilFestlegenRechteck(width / 2, 0, width, height, "grau");
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
}
