public class Bat extends Figur
{
    private static final int BAT_WIDTH = 300;
    private static final int BAT_HEIGHT = 20;
    private static final int BAT_STEP = 10;
    private int x;
    private int y;
    private int width = BAT_WIDTH;
    private int height = BAT_HEIGHT;
    private boolean advancedControls;
    private Ball ball;
    
    public Bat(Ball ballNew)
    {
        super();
        ball = ballNew;
        
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
    @Override void SonderTasteGedrückt(int taste)
    {
        switch (taste)
        {
            // Pfeil nach links + a
            case 37:
                if(x <= width/5) break;
                x -= BAT_STEP;
                break;
            // Pfeil nach oben
            case 38:
                if (!advancedControls) break;
                y -= BAT_STEP;
                break;
            // Pfeil nach rechts
            case 39:
                if (x >= Zeichenfenster.MalflächenBreiteGeben() - width / 5) break;
                x += BAT_STEP;
                break;
            // pfeil nach unten
            case 40:
                if (!advancedControls) break;
                y += BAT_STEP;
                break;
        }
        
        PositionSetzen(x, y);
    }
    
    @Override void TasteGedrückt(char taste) {
        switch (taste) {
            case 'w':
                SonderTasteGedrückt(38);
                break;
            case 'a':
                SonderTasteGedrückt(37);
                break;
            case 's':
                SonderTasteGedrückt(40);
                break;
            case 'd':
                SonderTasteGedrückt(39);
                break;
        }
    }
    
    public void setAdvancedControls(boolean active) {
        advancedControls = active;
    }
    
    private void draw()
    {
        FigurteilFestlegenRechteck(-(width / 2), 0, width, height, "grau");
    }
    
    public void checkCollisions() {
        switch (CustomMath.CircleRectangleCollision(ball.getXPos(), ball.getYPos(), ball.getRadius(), x, y, height, width)) {
                case 1: // Top
                case 2: // Bottom
                    ball.reflectY();
                    break;
            
                case 3: // Left
                case 4: // Right
                    ball.reflectX();
                    break;
            
                case 5: // Top-left
                case 6: // Top-right
                case 7: // Bottom-left
                case 8: // Bottom-right
                    int dx =  (int) (0.1 * (ball.getXPos() - (x + width/2)));
                    int dy =  (int) (0.1 * (ball.getYPos() - (x + height/2)));
                    ball.setDirection(dx, dy);
                    
                    break;
            }
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
}
