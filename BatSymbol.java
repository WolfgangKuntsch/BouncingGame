public class BatSymbol extends Symbol
{
    private Rechteck r1;
    private int width;
    private int height;
    
    public BatSymbol(int widthNew, int heightNew)
    {
        width = widthNew;
        height = heightNew;
        
        r1 = new Rechteck();
        r1.GrößeSetzen(widthNew, heightNew);
        r1.PositionSetzen(xPos, yPos);
        r1.FarbeSetzen("grau");
        r1.SichtbarkeitSetzen(false);
    }
    
    @Override public void draw(int xPos, int yPos) {
        r1.SichtbarkeitSetzen(true);
        r1.PositionSetzen(xPos, yPos);
    }
    
    public void setScale(float scale) {
        r1.GrößeSetzen((int) (width * scale) , (int) (height * scale));
    }
}
