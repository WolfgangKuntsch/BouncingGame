public class BigBallPowerup extends Powerup
{
    private Ball ball;
    
    public BigBallPowerup(int radiusNew, int speedNew, Ball ballNew)
    {
        super(radiusNew, speedNew);
        symbol = new PowerupSymbol(radius, "gruen", "SlowBall");
        ball = ballNew;
    }
    
    @Override public void doPowerupEffect() {
        ball.setScale(1.5f);
    }
}
