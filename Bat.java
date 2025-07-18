public class Bat extends Figur
{
    private static final int BAT_WIDTH = 300;
    private static final int BAT_HEIGHT = 20;
    private static final int BAT_STEP = 10;
    private int x;
    private int y;
    private int width = BAT_WIDTH;
    private int height = BAT_HEIGHT;
    private boolean advancedControls = true;
    private Ball ball;
    //private SoundEffect sound;
    
    public Bat(Ball ballNew)
    {
        super();
        //sound = new SoundEffect("jump.mp3");
        ball = ballNew;
        
        this.x = Zeichenfenster.MalflächenBreiteGeben() / 2;
        this.y = Zeichenfenster.MalflächenHöheGeben() - 20;
        PositionSetzen(x, y);
        draw();
    }
    
    public void rePaint()
    {
        PositionSetzen(XPositionGeben(), YPositionGeben());
        draw();
    }
    
    public void setScale(float scale) {
         EigeneFigurLöschen();
         this.width = Math.round(scale * BAT_WIDTH);
         this.height = Math.round(scale * BAT_HEIGHT);
         draw();
    }
    
    @Override void SonderTasteGedrückt(int taste) {
        switch (taste)
        {
            // Pfeil nach links + a
            case 37:
                if(x <= width/5) break;
                x -= BAT_STEP;
                break;
            // Pfeil nach oben
            case 38:
                if (!advancedControls || y >= height) break;
                y -= BAT_STEP;
                break;
            // Pfeil nach rechts
            case 39:
                if (x >= Zeichenfenster.MalflächenBreiteGeben() - width / 5) break;
                x += BAT_STEP;
                break;
            // pfeil nach unten
            case 40:
                if (!advancedControls || y >= Zeichenfenster.MalflächenHöheGeben() - height) break;
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
    
    private void draw() {
        FigurteilFestlegenRechteck(-(width / 2), 0, width, height, "grau");
    }
    
    public boolean checkCollisions() {
        boolean retVal = false;
        switch (CustomMath.CircleRectangleCollision(ball.getXPos(), ball.getYPos(), ball.getRadius(), x - (width / 2), y, height - (height / 2), width)) {
                case 1: // Top
                case 2: // Bottom
                    //sound.play();
                    ball.reflectY();
                    retVal = true;
                    break;
            
                case 3: // Left
                case 4: // Right
                    ball.reflectX();
                    retVal = true;
                    break;
            
                case 5: // Top-left
                case 6: // Top-right
                case 7: // Bottom-left
                case 8: // Bottom-right
                    int dx =  (int) (0.1 * (ball.getXPos() - (x + width/2)));
                    int dy =  (int) (0.1 * (ball.getYPos() - (x + height/2)));
                    ball.setDirection(dx, dy);
                    retVal = true;
                    break;
            }
            return retVal;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
}
