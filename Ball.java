public class Ball extends Figur {

    public Ball(int xPos, int yPos, int radius, int dx, int dy) 
    {super();
        FigurteilFestlegenEllipse(-50, -50, 100, 100, "grau");
        PositionSetzen(25, 250);
    }

    public int getXPos() {
        return 0;
    }

    public int getYPos() {
        return 0;
    }

    public int getRadius() {
        return 0;
    }
    
    // Bewegung in X-Richtung umdrehen
    public void reflectX() {
    }

    // Bewegung in Y-Richtung umdrehen
    public void reflectY() {
        
    }
    
    //Größe des Balles setzen
    public void setScale(float scale) { 
         
    }
    
    //Geschwindigkeit des Balles setzen
    public void setSpeed(float speef) { 
         
    }
}
