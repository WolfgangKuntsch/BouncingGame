public class SlowBallPowerup extends Powerup
{
    private Ball ball;
    
    public SlowBallPowerup(int xPosNew, int yPosNew, Ball ballNew)
    {
        super(xPosNew, yPosNew);
        ball = ballNew;
    }
    
    @Override public void doPowerupEffect() {
        ball.setSpeed(0.5f);
    }
}
