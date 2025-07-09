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
        this.x = Zeichenfenster.MalflächenBreiteGeben() - BAT_WIDTH / 2;
        this.y = Zeichenfenster.MalflächenHöheGeben() - 5;
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
          case 37:
            Gehen(-BAT_STEP);
            x -= BAT_STEP;
            break;
            // Pfeil nach rechts
          case 39:
            Gehen(BAT_STEP);
            x += BAT_STEP;
            break;
        }
    }
    
    public void setAdvancedControls(boolean active) {
        this.advancedControls = active;
        throw new UnsupportedOperationException("Not Yet Implemented");
    }
    
    private void draw()
    {
        FigurteilFestlegenRechteck(x, y, width, height, "grau");
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
