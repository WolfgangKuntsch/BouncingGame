public class LoseScreen extends Symbol
{
    private Text t1;
    
    private int frameCounter;
    
    public LoseScreen()
    {
        t1 = new Text();
        t1.TextSetzen("YOU LOSE!");
        t1.FarbeSetzen("rot");
        t1.TextGrößeSetzen(80);
        t1.PositionSetzen(200, 310);
        t1.SichtbarkeitSetzen(false);
    }
    
    @Override
    public void draw(int xpos, int ypos)
    {
        t1.SichtbarkeitSetzen(true);
        
    }


}
