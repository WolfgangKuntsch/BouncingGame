public class Bat extends Figur
{
    private static final int BAT_WIDTH = 100;
    private static final int BAT_HEIGHT = 20;
    private static final int BAT_STEP = 10;
    private int x = BAT_WIDTH / 2;
    private int y = Zeichenfenster.MalflächenHöheGeben() - 20;
    private float scale = 1f;
    
    public Bat()
    {
        super();
        draw();
    }
    
    //Größe des Schlägers setzen
    public void setScale(float scale) {
         EigeneFigurLöschen();
         this.scale = scale;
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
            // Pfeil nach links
          case 37:
            Gehen(-BAT_STEP);
            y -= BAT_STEP;
            break;
            // Pfeil nach rechts
          case 39:
            Gehen(BAT_STEP);
            y += BAT_STEP;
            break;
        }
    }
    
    private void draw()
    {
        FigurteilFestlegenRechteck(x, y, Math.round(scale * BAT_WIDTH), Math.round(scale * BAT_HEIGHT), "grau");
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getWidth() {
        return Math.round(scale * BAT_WIDTH);
    }
    
    public int getHeight() {
        return Math.round(scale * BAT_HEIGHT);
    }
}
