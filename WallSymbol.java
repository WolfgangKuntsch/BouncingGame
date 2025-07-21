public class WallSymbol extends Symbol
{
    private Rechteck r1;
    
    public WallSymbol(int widthNew, int heightNew, int xPos, int yPos)
    {
        r1 = new Rechteck();
        r1.GrößeSetzen(widthNew, heightNew);
        r1.PositionSetzen(xPos, yPos);
        r1.FarbeSetzen("grau");
    }
}
