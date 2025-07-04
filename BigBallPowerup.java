public class BigBallPowerup extends Powerup
{
    private Ball ball;
    
    public BigBallPowerup(int xPosNew, int yPosNew, Ball ballNew)
    {
        super(xPosNew, yPosNew);
        ball = ballNew;
    }
    
    @Override public void doPowerupEffect() {
        ball.setScale(1.5f);
    }
}
