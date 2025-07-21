public class BallSymbol extends Symbol
{
    Kreis c1;    
    private int radius = 0;
    
    public BallSymbol(int radiusNew, String color)
    {
        super();
        radius = radiusNew;
        
        c1 = new Kreis();
        c1.RadiusSetzen(radius);
        c1.FarbeSetzen(color);
        c1.SichtbarkeitSetzen(false);
    }
    
    @Override public void draw(int xPos, int yPos) {
        c1.PositionSetzen(xPos, yPos);
        c1.SichtbarkeitSetzen(true);
    }
    
    public void setScale(float scale) {
        c1.RadiusSetzen((int) (radius * scale));
    }
}
