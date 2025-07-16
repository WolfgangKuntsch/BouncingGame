public class ScoreIndicator extends Symbol
{
    private Text t1;

    
    public ScoreIndicator()
    {
        t1 = new Text();
        t1.FarbeSetzen("weiss");
        t1.TextSetzen("Score: ");
        t1.TextGrößeSetzen(80);
        t1.PositionSetzen(10, 60);
        t1.SichtbarkeitSetzen(false);
    }
    
    public void draw(int xpos, int ypos, int scoreN)
    {
        t1.SichtbarkeitSetzen(true);
        t1.TextSetzen("Score: "+Integer.toString(scoreN));
    }


}
