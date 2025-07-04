public class BigBatPowerup extends Powerup
{
    private Bat bat;
    
    public BigBatPowerup(int xPosNew, int yPosNew, Bat batNew)
    {
        super(xPosNew, yPosNew);
        bat = batNew;
    }
    
    @Override public void doPowerupEffect() {
        bat.setScale(1.5f);
    }
}
