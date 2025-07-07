public class SmallBatPowerup extends Powerup
{
    private Bat bat;
    
    public SmallBatPowerup(Bat batNew)
    {
        super();
        symbol = new PowerupSymbol(sideLength, "rot", "SmallBat");
        bat = batNew;
    }
    
    @Override public void doPowerupEffect() {
        bat.setScale(0.5f);
    }
}
