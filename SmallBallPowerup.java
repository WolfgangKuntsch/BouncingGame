public class SmallBallPowerup extends Powerup
{
    private Ball ball;
    
    public SmallBallPowerup(Ball ballNew)
    {
        super();
        symbol = new PowerupSymbol(radius, "rot", "SmallBall");
        ball = ballNew;
    }
    
    @Override public void doPowerupEffect() {
        ball.setScale(0.5f);
    }
}
