public class BrickSymbol extends Symbol
{
    int width;
    int height;
    
    Rechteck r1;
    Rechteck r2;
    
    public BrickSymbol(int widthNew, int heightNew) {
        super();
        width = widthNew;
        height = heightNew;
        
        r1 = new Rechteck();
        r1.SichtbarkeitSetzen(false);
        
        r2 = new Rechteck();
        r2.SichtbarkeitSetzen(false);
    }
    
    @Override public void draw(int xPosNew, int yPosNew) {
        r1.SichtbarkeitSetzen(true);
        r1.PositionSetzen(xPosNew, yPosNew);
        r1.GrößeSetzen(width, height);
        r1.FarbeSetzen("schwarz");
        
        r2.SichtbarkeitSetzen(true);
        r2.PositionSetzen(xPosNew + 5, yPosNew + 5);
        r2.GrößeSetzen(width - 10, height - 10);
        r2.FarbeSetzen("grau");
        r2.GanzNachVornBringen();
    }
}
