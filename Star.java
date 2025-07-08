public class Star extends Symbol {
    private int radius;
    private final int decay;
    private Kreis c1;

    public Star(int xPosNew, int yPosNew, int radiusNew, int decayNew) {
        c1 = new Kreis();
        xPos = xPosNew;
        yPos = yPosNew;
        move(xPos, yPos);
        c1.PositionSetzen(xPos, yPos);

        radius = radiusNew;
        decay = decayNew;

        c1.RadiusSetzen(radius);
        c1.FarbeSetzen("gelb");
        c1.SichtbarkeitSetzen(false);
    }

    @Override
    public void draw(int xPosNew, int yPosNew) {
        radius -= decay;
        if (radius < 0) radius = 0;
        System.out.println("Star at (" + xPos + ", " + yPos + ") radius: " + radius);
        c1.RadiusSetzen(radius);
        c1.GanzNachHintenBringen();
        c1.NachVornBringen();
        c1.SichtbarkeitSetzen(true);
    }


    public int getRadius() {
        return radius;
    }
}
