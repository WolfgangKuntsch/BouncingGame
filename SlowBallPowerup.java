public class SlowBallPowerup extends Powerup
{
    private Ball ball;
    
    public SlowBallPowerup(int radiusNew, int speedNew, Ball ballNew)
    {
        super(radiusNew, speedNew);
        symbol = new PowerupSymbol(radius, "gruen", "SlowBall");
        ball = ballNew;
    }
    
    @Override public void doPowerupEffect() {
        ball.setSpeed(0.5f);
    }
}
