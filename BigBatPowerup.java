public class BigBatPowerup extends Powerup
{
    private Bat bat;
    
    public BigBatPowerup(Bat batNew)
    {
        super();
        symbol = new PowerupSymbol(radius, "gruen", "BigBat");
        bat = batNew;
    }
    
    @Override public void doPowerupEffect() {
        bat.setScale(1.5f);
    }
}
