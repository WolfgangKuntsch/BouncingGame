public class Ball extends Figur {
    private int radius;
    private float dx;
    private float dy;
    private float speedMultiplier = 1.0f;
    private int startX;
    private int startY;
    private boolean verloren;
    private float scale = 1.0f;

    public Ball(int xPos, int yPos, int radius, float dxNew, float dyNew) {
        super();
        this.radius = radius;
        this.dx = dxNew;
        this.dy = dyNew;
        this.startX = xPos;
        this.startY = yPos;
        this.verloren = false;
        
        FigurteilFestlegenEllipse(-radius, -radius, radius*2, radius*2, "rot");
        PositionSetzen(xPos, yPos);
        GanzNachVornBringen();
    }

    public void bewegen() {
        if (!verloren) {
            PositionSetzen((int)(XPositionGeben() + dx * speedMultiplier), 
                         (int)(YPositionGeben() + dy * speedMultiplier));
        }
    }

    public int getXPos() {
        return XPositionGeben();
    }

    public int getYPos() {
        return YPositionGeben();
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
        PositionSetzen(startX, startY);
        verloren = false;
        dx = Math.abs(dx); 
        dy = -Math.abs(dy); 
    }

    public void setScale(float scale) {
        this.scale = scale;
        EigeneFigurLöschen();
        FigurteilFestlegenEllipse(-getRadius(), -getRadius(), 
                                 getRadius()*2, getRadius()*2, "rot");
    }

    public void setSpeed(float multiplier) {
        this.speedMultiplier = multiplier;
    }

    public void setDirection(float dx, float dy) {
        this.dx = dx;
        this.dy = dy;
    }
}