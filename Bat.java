public class Bat extends Figur
{
    private static final int BAT_WIDTH = 200;
    private static final int BAT_HEIGHT = 40;
    private static final int BAT_STEP = 10;
    private int x;
    private int y;
    private int width = BAT_WIDTH;
    private int height = BAT_HEIGHT;
    private boolean advancedControls;
    private boolean fast;
    private Ball ball;
    
    private int screenWidth;
    private int screenHeight;
    
    private boolean autopilot;
    
    private BatSymbol symbol;
    //private SoundEffect sound;
    
    public Bat(Ball ballNew, int screenWidthN, int screenHeightN)
    {
        super();
        //sound = new SoundEffect("jump.mp3");
        ball = ballNew;
        
        screenWidth = screenWidthN;
        screenHeight = screenHeightN;
        
        this.x = screenWidth / 2 - BAT_WIDTH / 2;
        this.y = screenHeight - 20;
        
        symbol = new BatSymbol(BAT_WIDTH, BAT_HEIGHT);
        
        SichtbarkeitSetzen(false);
        symbol.draw(x,y);
    }
    
    public void setScale(float scale) {
        width = (int) (BAT_WIDTH * scale);
        height = (int) (BAT_HEIGHT * scale);
        symbol.setScale(scale);
    }
    
    @Override void SonderTasteGedrückt(int taste) {
        switch (taste)
        {
            // Pfeil nach links + a
            case 37:
                if(x <= 0) break;
                x -= fast ? BAT_STEP * 2 : BAT_STEP;
                break;
            // Pfeil nach oben
            case 38:
                if (!advancedControls || y <= height) break;
                y -= fast ? BAT_STEP * 2 : BAT_STEP;
                break;
            // Pfeil nach rechts
            case 39:
                if (x >= screenWidth - width) break;
                x += fast ? BAT_STEP * 2 : BAT_STEP;
                break;
            // pfeil nach unten
            case 40:
                if (!advancedControls || y >= screenHeight - height) break;
                y += fast ? BAT_STEP * 2 : BAT_STEP;
                break;
        }
        
        symbol.draw(x,y);
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
    
    public void setFast(boolean active) {
        fast = active;
    }
    
    public void frame() {
        if (autopilot) {
            if (ball.getXPos() - (x + width/2) > 50) {
                SonderTasteGedrückt(39);
            }
            if (ball.getXPos() - (x + width/2) < -50) {
                SonderTasteGedrückt(37);
            }
            symbol.draw(x,y);
        }
    }
    
    public boolean checkCollisions() {
        if (CustomMath.CircleRectangleCollision(ball.getXPos(), ball.getYPos(), ball.getRadius(), x, y, height, width) > 0) {
                /*case 0: // No collision
                    return false;

                case 1: // Top
                case 2: // Bottom
                    //sound.play();
                    ball.reflectY();
                    break;
            
                case 3: // Left
                case 4: // Right
                    ball.reflectX();
                    break;
            
                case 5: // Top-left
                case 6: // Top-right
                case 7: // Bottom-left
                case 8: // Bottom-right*/
                    int dx =  3 * (ball.getXPos() - (x + width/2));
                    int dy =  -(ball.getYPos() - (x + height/2) + 2);
                    ball.setDirection(dx, dy);
                    return true;
                    //break;
            }
        //sound.play();
        return false;
    }
    
    public void setAutopilot(boolean doAutopilot) {
        autopilot = doAutopilot;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}