public class SmallBallPowerup extends Powerup
{
    private Ball ball;
    
    public SmallBallPowerup(int radiusNew, int speedNew, Ball ballNew)
    {
        super(radiusNew, speedNew);
        symbol = new PowerupSymbol(radius, "rot", "SmallBall");
        ball = ballNew;
    }
    
    @Override public void doPowerupEffect() {
        ball.setScale(0.5f);
    }
}
