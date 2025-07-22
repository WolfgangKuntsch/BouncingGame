public class PiercingPowerup extends Powerup
{
    private BrickController bricks;
    
    public PiercingPowerup(int radiusNew, int speedNew)
    {
        super(radiusNew, speedNew);
        symbol = new PowerupSymbol(radius, "weiss", "Piercing");
    }
}
