public class AutopilotPowerup extends Powerup
{
    private Bat bat;
    
    public AutopilotPowerup(int radiusNew, int speedNew, Bat batN)
    {
        super(radiusNew, speedNew);
        symbol = new PowerupSymbol(radius, "orange", "Autopilot");
        bat = batN;
    }
    
    @Override public void doPowerupEffect() {
        bat.setAutopilot(true);
    }
}
