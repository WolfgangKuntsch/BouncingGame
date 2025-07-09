public class BigBatPowerup extends Powerup
{
    private Bat bat;
    
    public BigBatPowerup(int radiusNew, int speedNew, Bat batNew)
    {
        super(radiusNew, speedNew);
        symbol = new PowerupSymbol(radius, "gruen", "BigBat");
        bat = batNew;
    }
    
    @Override public void doPowerupEffect() {
        bat.setScale(1.5f);
    }
}
