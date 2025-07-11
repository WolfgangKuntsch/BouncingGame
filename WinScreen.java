public class WinScreen extends Symbol
{
    private Text t1;
    private int r;
    private int g;
    private int b;
    
    public WinScreen()
    {
        t1 = new Text();
        t1.TextSetzen("YOU WIN !");
        t1.TextGrößeSetzen(80);
        t1.PositionSetzen(200, 310);
        t1.SichtbarkeitSetzen(false);
    }
    
    @Override public void draw(int xpos,int ypos)
    {
        t1.SichtbarkeitSetzen(true);
        r += 10;
        if (r > 255) {
            r = 50;
            g+= 10;
        }
        if (g > 255) {
            g = 50;
            b+= 10;
        }
        if (b > 255) {
            b = 50;
        }
        
        t1.FarbeSetzen(r, g, b);
    }
}
