public class BrickSymbol extends Symbol
{
    int width;
    int height;
    
    Rechteck rechteck;
    
    public BrickSymbol(int xPosNew, int yPosNew, int widthNew, int heightNew) {
        super(xPosNew, yPosNew);
        width = widthNew;
        height = heightNew;
        
        rechteck = new Rechteck();
        rechteck.SichtbarkeitSetzen(false);
    }
    
    @Override public void draw(int xPosNew, int yPosNew) {
        rechteck.SichtbarkeitSetzen(true);
        rechteck.PositionSetzen(xPosNew, yPosNew);
        rechteck.GrößeSetzen(width, height);
        rechteck.FarbeSetzen("grau");
    }
}
