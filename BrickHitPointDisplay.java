public class BrickHitPointDisplay extends Symbol {
    private Text t1;
    private int x;
    private int y;
    private boolean visible;
    private int displayTimer;   // counts frames displayed
    private static final int DISPLAY_DURATION = 30;  // frames to show

    public BrickHitPointDisplay() {
        t1 = new Text();
        t1.FarbeSetzen("gelb");
        t1.TextGrößeSetzen(30);
        t1.GanzNachVornBringen();
        t1.SichtbarkeitSetzen(false);
        visible = false;
        displayTimer = 0;
    }

    /**
     * Call this method to show the point display at the brick location.
     * @param xPos X position of the broken brick.
     * @param yPos Y position of the broken brick.
     * @param points Points to display (e.g., 10, 20).
     */
    public void show(int xPos, int yPos, int points) {
        x = xPos;
        y = yPos;
        t1.TextSetzen("+" + points);
        t1.PositionSetzen(x, y);
        t1.SichtbarkeitSetzen(true);
        visible = true;
        displayTimer = 0;
    }

    /**
     * Call this every frame to update visibility and fade-out.
     */
    public void draw(int xPos, int yPos, int score) {
        if (visible) {
            t1.PositionSetzen(x, y - displayTimer);  // floating effect: moves up
            displayTimer++;
            if (displayTimer > DISPLAY_DURATION) {
                t1.SichtbarkeitSetzen(false);
                visible = false;
            }
        }
    }
}
