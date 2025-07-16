public class WinScreen extends Symbol
{
    private Text t1;
    private int r;
    private int g;
    private int b;
    
    private int frameCounter;
    
    public WinScreen()
    {
        t1 = new Text();
        t1.TextSetzen("YOU WIN !");
        t1.TextGrößeSetzen(80);
        t1.PositionSetzen(200, 310);
        t1.SichtbarkeitSetzen(false);
    }
    
    @Override
    public void draw(int xpos, int ypos)
    {
        t1.SichtbarkeitSetzen(true);
    
        // Increment frame counter every frame
        frameCounter++;
    
        // Use sine wave functions for smooth RGB cycling
        double frequency = 0.05; // Controls speed of the color cycle
    
        int r = (int)(127.5 * (1 + Math.sin(frequency * frameCounter)));
        int g = (int)(127.5 * (1 + Math.sin(frequency * frameCounter + 2 * Math.PI / 3)));
        int b = (int)(127.5 * (1 + Math.sin(frequency * frameCounter + 4 * Math.PI / 3)));
    
        t1.FarbeSetzen(r, g, b);
    }


}
