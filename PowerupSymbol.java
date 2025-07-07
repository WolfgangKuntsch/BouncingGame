public class PowerupSymbol extends Symbol
{
    Rechteck r1;
    Text t1;
    
    int sideLength = 0;
    String color;
    String text;
    
    public PowerupSymbol(int sideLengthNew, String colorNew, String textNew)
    {
        super();
        sideLength = sideLengthNew;
        color = colorNew;
        text = textNew;
        
        r1 = new Rechteck();
        r1.GrößeSetzen(sideLength, sideLength);
        r1.FarbeSetzen(color);
        r1.GanzNachHintenBringen();
        r1.SichtbarkeitSetzen(false);
        
        t1 = new Text();
        t1.TextSetzen(text);
        t1.TextGrößeSetzen(sideLength);
        t1.SichtbarkeitSetzen(false);
    }
    
    @Override public void draw(int xPos, int yPos) {
        r1.PositionSetzen(xPos, yPos);
        r1.SichtbarkeitSetzen(true);
        
        t1.PositionSetzen(xPos, yPos + sideLength);
        t1.SichtbarkeitSetzen(true);
    }
    
    
}
