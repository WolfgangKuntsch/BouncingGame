public class Score {
    private int score = 0;
    private int scoreMultiplier = 1;
    private int frameCounter = 0;

    private final ScoreIndicator scoreIndicator = new ScoreIndicator();
    private final BrickHitPointDisplay hitPointDisplay = new BrickHitPointDisplay();

    public Score() {
        // Possibly add hitPointDisplay to the rendering system if needed
    }

    public void frame(boolean running, boolean batCollide) {
        if (!running) return;

        frameCounter++;
        if (frameCounter >= 50) {
            score -= 1; // Passive penalty for time
            frameCounter = 0;
        }

        if (batCollide) {
            scoreMultiplier = 1;
        }

        scoreIndicator.draw(0, 0, score);

        // Draw the floating point display every frame
        hitPointDisplay.draw(0, 0, score);
    }

    public void onBrickHit(int xPos, int yPos) {
        int points = 10 * scoreMultiplier;
        score += points;
        scoreMultiplier++;

        // Show the points popup at the brick position
        hitPointDisplay.show(xPos, yPos, points);
    }

    public int getFinalScore() {
        return score;
    }
}
