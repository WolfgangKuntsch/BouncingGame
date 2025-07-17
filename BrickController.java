import java.util.ArrayList;
import java.util.Random;

public class BrickController {
    private ArrayList<Brick> bricks = new ArrayList<>();
    private Ball ball;
    private Bat bat;
    private PowerupController powerups;
    private Score sco = new Score();

    private int screenWidth;
    private int screenHeight;
    private Random rand = new Random();

    public BrickController(int screenWidthNew, int screenHeightNew, Ball ballNew, Bat batNew, PowerupController powerupControllerNew) {
        ball = ballNew;
        bat = batNew;
        powerups = powerupControllerNew;
        screenWidth = screenWidthNew;
        screenHeight = screenHeightNew;
    }

    public void addBrick(Brick brickNew) {
        bricks.add(brickNew);
    }

    public void populateGrid(int brickWidth, int brickHeight, int cols, int rows, int spacing) {
        if ((screenWidth - ((cols + 1) * spacing)) / brickWidth >= cols && 
            (screenHeight - ((rows + 1) * spacing)) / brickHeight >= rows) {

            int sideSpacing = (screenWidth - (cols * brickWidth + (cols - 1) * spacing)) / 2;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Brick brick = new Brick(
                        sideSpacing + j * (brickWidth + spacing),
                        spacing + i * (brickHeight + spacing),
                        brickHeight,
                        brickWidth
                    );
                    bricks.add(brick);
                }
            }
        } else {
            throw new IndexOutOfBoundsException("Too many rows or columns to fit on screen");
        }
    }

    public void frame(boolean running, boolean batHit) {
        powerups.frame();

        var iter = bricks.iterator();
        while (iter.hasNext()) {
            Brick brick = iter.next();
            brick.draw();

            int collisionSide = CustomMath.CircleRectangleCollision(
                ball.getXPos(), ball.getYPos(), ball.getRadius(),
                brick.getXPos(), brick.getYPos(), brick.getHeight(), brick.getWidth()
            );

            if (collisionSide > 0) {
                handleBallReflection(collisionSide);
                handleBrickBreak(brick, iter);
            }
        }

        sco.frame(running, batHit);
    }

    private void handleBallReflection(int collisionSide) {
        switch (collisionSide) {
            case 1: case 2:
                ball.reflectY();
                break;
            case 3: case 4:
                ball.reflectX();
                break;
            case 5: case 6: case 7: case 8:
                int dx = (int) (0.1 * (ball.getXPos() - (ball.getXPos() + ball.getRadius())));
                int dy = (int) (0.1 * (ball.getYPos() - (ball.getYPos() + ball.getRadius())));
                ball.setDirection(dx, dy);
                break;
        }
    }

    private void handleBrickBreak(Brick brick, java.util.Iterator<Brick> iter) {
        Powerup powerup = powerups.choosePowerup();
        if (powerup != null) {
            powerup.setPosition(brick.getXPos(), brick.getYPos());
            powerups.addPowerup(powerup);
        }
        brick.remove();
        iter.remove();
        sco.onBrickHit(brick.getXPos(), brick.getYPos());
    }

    public int getBrickCount() {
        return bricks.size();
    }

    public Score getScore() {
        return sco;
    }
}
