public class SlowBallPowerup extends Powerup
{
    private Ball ball;
    
    public SlowBallPowerup(Ball ballNew)
    {
        super();
        symbol = new PowerupSymbol(sideLength, "gruen", "SlowBall");
        ball = ballNew;
    }
    
    @Override public void doPowerupEffect() {
        ball.setSpeed(0.5f);
    }
}
