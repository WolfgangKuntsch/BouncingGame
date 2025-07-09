public class SmallBatPowerup extends Powerup
{
    private Bat bat;
    
    public SmallBatPowerup(int radiusNew, int speedNew, Bat batNew)
    {
        super(radiusNew, speedNew);
        symbol = new PowerupSymbol(radius, "rot", "SmallBat");
        bat = batNew;
    }
    
    @Override public void doPowerupEffect() {
        bat.setScale(0.5f);
    }
}
