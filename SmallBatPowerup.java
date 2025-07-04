public class SmallBatPowerup extends Powerup
{
    private Bat bat;
    
    public SmallBatPowerup(int xPosNew, int yPosNew, Bat batNew)
    {
        super(xPosNew, yPosNew);
        bat = batNew;
    }
    
    @Override public void doPowerupEffect() {
        bat.setScale(0.5f);
    }
}
