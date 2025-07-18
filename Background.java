import java.util.Random;
import java.util.ArrayList;
import java.io.*;

public class Background implements Serializable
{
    private Rechteck r1;
    private ArrayList<Star> stars;
    private int screenWidth;
    private int screenHeight;

    private int minRadius;
    private int maxRadius;
    private int minDecay;
    private int maxDecay;

    private int minSpawnDelay; // min delay frames before spawning a star replacement
    private int maxSpawnDelay; // max delay frames

    private Random rand;

    // List holding countdown timers for pending star spawns
    private ArrayList<Integer> pendingSpawns;

    public Background(int screenWidthNew, int screenHeightNew, 
                      int minStars, int maxStars,
                      int minRadiusNew, int maxRadiusNew,
                      int minDecayNew, int maxDecayNew,
                      int minSpawnDelayNew, int maxSpawnDelayNew) {
        rand = new Random();

        screenWidth = screenWidthNew;
        screenHeight = screenHeightNew;

        minRadius = minRadiusNew;
        maxRadius = maxRadiusNew;
        minDecay = minDecayNew;
        maxDecay = maxDecayNew;

        minSpawnDelay = minSpawnDelayNew;
        maxSpawnDelay = maxSpawnDelayNew;

        r1 = new Rechteck();
        r1.GrößeSetzen(screenWidth, screenHeight);
        r1.PositionSetzen(0, 0);
        r1.FarbeSetzen("schwarz");
        r1.GanzNachVornBringen();
        r1.GanzNachHintenBringen();

        stars = new ArrayList<>();
        pendingSpawns = new ArrayList<>();

        int starCount = rand.nextInt(maxStars + 1) + minStars;
        for (int i = 0; i < starCount; i++) {
            stars.add(createRandomStar());
        }
    }

    private Star createRandomStar() {
        int x = rand.nextInt(screenWidth + 1);
        int y = rand.nextInt(screenHeight + 1);
        int radius = rand.nextInt(maxRadius - minRadius + 1) + minRadius;
        int decay = rand.nextInt(maxDecay - minDecay + 1) + minDecay;
        return new Star(x, y, radius, decay);
    }

    public void frame() {
        // Remove dead stars and count how many died
        int deadStars = 0;
        var iter = stars.iterator();
        while (iter.hasNext()) {
            Star star = iter.next();
            star.draw(0, 0);
            if (star.getRadius() <= 0) {
                iter.remove();
                deadStars++;
            }
        }

        // For each dead star, add a random delay before spawning replacement
        for (int i = 0; i < deadStars; i++) {
            int delay = rand.nextInt(maxSpawnDelay - minSpawnDelay + 1) + minSpawnDelay;
            pendingSpawns.add(delay);
        }

        // Countdown timers, spawn stars when ready
        for (int i = pendingSpawns.size() - 1; i >= 0; i--) {
            int timer = pendingSpawns.get(i) - 1;
            if (timer <= 0) {
                stars.add(createRandomStar());
                pendingSpawns.remove(i);
            } else {
                pendingSpawns.set(i, timer);
            }
        }
    }
}
