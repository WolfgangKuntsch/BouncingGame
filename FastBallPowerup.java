public class FastBallPowerup extends Powerup
{
    private Ball ball;
    
    public FastBallPowerup(Ball ballNew)
    {
        super();
        symbol = new PowerupSymbol(sideLength, "rot", "FastBall");
        ball = ballNew;
    }
    
    @Override public void doPowerupEffect() {
        ball.setSpeed(1.5f);
    }
}
