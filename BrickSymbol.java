public class BrickSymbol extends Symbol
{
    int length;
    int width;
    
    public BrickSymbol(int xPosNew, int yPosNew, int lengthNew, int widthNew) {
        super(xPosNew, yPosNew);
        length = lengthNew;
        width = widthNew;
    }

}
