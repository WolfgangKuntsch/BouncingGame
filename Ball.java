import java.util.*;
public class Ball {
    private int radius;
    private float dx;
    private float dy;
    private float speedMultiplier = 1.0f;
    private int startX;
    private int startY;
    private boolean verloren;
    private float scale = 1.0f;
    private double speed;
    
    private int xPos;
    private int yPos;
    
    private BallSymbol symbol;

    public Ball(int xPosN, int yPosN, int radius, float dxNew, float dyNew) {
        super();
        this.radius = radius;
        this.dx = dxNew;
        this.dy = dyNew;
        this.startX = xPosN;
        this.startY = yPosN;
        this.verloren = false;
        
        speed = Math.sqrt(dx * dx + dy * dy);
        
        xPos = startX;
        yPos = startY;
        
        symbol = new BallSymbol(radius, "rot");
        
    }

    public void bewegen() {
        if (!verloren) {
            xPos += (int) dx * speedMultiplier; 
            yPos += (int) dy * speedMultiplier;
            
            symbol.draw(xPos, yPos);
        }
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public int getRadius() {
        return (int)(radius * scale);
    }

    public void reflectX() {
        dx = -dx;
    }

    public void reflectY() {
        dy = -dy;
    }

    public boolean istVerloren() {
        return verloren;
    }

    public void setVerloren(boolean status) {
        verloren = status;
    }

    public void reset() {
        xPos = startX;
        yPos = startY;
        
        verloren = false;
        dx = Math.abs(dx); 
        dy = -Math.abs(dy); 
    }

    public void setScale(float scale) {
        this.scale = scale;
        symbol.setScale(scale);
    }

    public void setSpeed(float multiplier) {
        this.speedMultiplier = multiplier;
    }

    public void setDirection(float dxN, float dyN) {
        double len = Math.sqrt(dxN * dxN + dyN * dyN);
        
        this.dx = (int) ((dxN * speed)/len) ;
        int dyNew = (int) ((dyN * speed)/len) ;
        /*if (dyNew == 0 && dyN > 0 ) {
            this.dy = 1;
        }
        else */if (dyNew == 0 && dyN < 0 ){
            this.dy = -1 ;
        }
        else {
            this.dy = dyNew;
        }
    }
}