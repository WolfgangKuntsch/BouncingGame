public class SmallBallPowerup extends Powerup
{
    private Ball ball;
    
    public SmallBallPowerup(int xPosNew, int yPosNew, Ball ballNew)
    {
        super(xPosNew, yPosNew);
        ball = ballNew;
    }
    
    @Override public void doPowerupEffect() {
        ball.setScale(0.5f);
    }
}
