public class AdvancedControlPowerup extends Powerup
{
    private Bat bat;
    
    public AdvancedControlPowerup(int radiusNew, int speedNew, Bat batNew)
    {
        super(radiusNew, speedNew);
        symbol = new PowerupSymbol(radius, "magenta", "AdvancedControl");
        bat = batNew;
    }
    
    @Override public void doPowerupEffect() {
        bat.setAdvancedControls(true);
    }
}
