public class PowerupSymbol extends Symbol
{
    Kreis c1;
    Text t1;
    
    int radius = 0;
    String color;
    String text;
    
    public PowerupSymbol(int radiusNew, String colorNew, String textNew)
    {
        super();
        radius = radiusNew;
        color = colorNew;
        text = textNew;
        
        c1 = new Kreis();
        c1.RadiusSetzen(radius);
        c1.FarbeSetzen(color);
        c1.GanzNachHintenBringen();
        c1.SichtbarkeitSetzen(false);
        
        t1 = new Text();
        t1.TextSetzen(text);
        t1.TextGrößeSetzen(radius);
        t1.SichtbarkeitSetzen(false);
    }
    
    @Override public void draw(int xPos, int yPos) {
        c1.PositionSetzen(xPos, yPos);
        c1.SichtbarkeitSetzen(true);
        
        t1.PositionSetzen(xPos - radius, yPos + radius);
        t1.SichtbarkeitSetzen(true);
    }
    
    
}
