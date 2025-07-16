public class Score
{
    private int score;
    private int scoreMultiplier;
    private int frameCounter;
    
    private ScoreIndicator sco;
    private BrickController bricks;
    
    public Score(BrickController bricksNew)
    {
        bricks = bricksNew;
        sco = new ScoreIndicator();
    }
    
    public void frame(boolean running, boolean batCollide) {
        frameCounter++;
        if (frameCounter >= 10) {
            score += 10;
        }
        
        if (batCollide) {
            scoreMultiplier = 1;
        }
        
        if (bricks.didCollide()) {
            score -= 10 * scoreMultiplier;
        }
        
        if (running) {
            sco.draw(0,0,score);
        }
    }
}
