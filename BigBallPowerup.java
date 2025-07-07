public class BigBallPowerup extends Powerup
{
    private Ball ball;
    
    public BigBallPowerup(Ball ballNew)
    {
        super();
        symbol = new PowerupSymbol(sideLength, "gruen", "SlowBall");
        ball = ballNew;
    }
    
    @Override public void doPowerupEffect() {
        ball.setScale(1.5f);
    }
}
