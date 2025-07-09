public class FastBallPowerup extends Powerup
{
    private Ball ball;
    
    public FastBallPowerup(int radiusNew, int speedNew, Ball ballNew)
    {
        super(radiusNew, speedNew);
        symbol = new PowerupSymbol(radius, "rot", "FastBall");
        ball = ballNew;
    }
    
    @Override public void doPowerupEffect() {
        ball.setSpeed(1.5f);
    }
}
