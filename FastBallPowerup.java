public class FastBallPowerup extends Powerup
{
    private Ball ball;
    
    public FastBallPowerup(int xPosNew, int yPosNew, Ball ballNew)
    {
        super(xPosNew, yPosNew);
        ball = ballNew;
    }
    
    @Override public void doPowerupEffect() {
        ball.setSpeed(1.5f);
    }
}
