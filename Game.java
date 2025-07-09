
/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Game extends Ereignisbehandlung
{
    private Bat character;
    private Ball ball;
    
    private Background background;
    private static int BACKGROUND_MIN_STARS = 20;
    private static int BACKGROUND_MAX_STARS = 40;
    private static int BACKGROUND_STAR_MIN_RADIUS = 5;
    private static int BACKGROUND_STAR_MAX_RADIUS = 15;
    private static int BACKGROUND_STAR_MIN_DECAY = 1;
    private static int BACKGROUND_STAR_MAX_DECAY = 2;
    private static int BACKGROUND_STAR_MIN_DELAY = 5;
    private static int BACKGROUND_STAR_MAX_DELAY = 15;
    
    private BrickController bricks;
    private static int BRICK_WIDTH = 80;
    private static int BRICK_HEIGTH = 20;
    private static int BRICK_SPACING = 20;
    private static int NUM_COLUMNS = 6;
    private static int NUM_ROWS = 8;
    
    /**
     * Konstruktor für Objekte der Klasse Spiel
     */
    public Game()
    {
        super();
        character = new Bat();
        ball = new Ball(10, 10, 20, 10, 10);
        background = new Background(Zeichenfenster.MalflächenBreiteGeben(), Zeichenfenster.MalflächenHöheGeben(), BACKGROUND_MIN_STARS, BACKGROUND_MAX_STARS, BACKGROUND_STAR_MIN_RADIUS, BACKGROUND_STAR_MAX_RADIUS, BACKGROUND_STAR_MIN_DECAY, BACKGROUND_STAR_MAX_DECAY, BACKGROUND_STAR_MIN_DELAY, BACKGROUND_STAR_MAX_DELAY);
        bricks = new BrickController(Zeichenfenster.MalflächenBreiteGeben(), Zeichenfenster.MalflächenHöheGeben(), ball, character);
        StartGame();
    }
    
    @Override void TaktImpulsAusführen()
    {
        background.frame();
        bricks.frame();
        ball.bewegen();
    }
    
    void StartGame() 
    {
        TaktdauerSetzen(100);
        bricks.populateGrid(BRICK_WIDTH, BRICK_HEIGTH, NUM_COLUMNS, NUM_ROWS, BRICK_SPACING);
        Starten();    
    }
    
    void PauseGame()
    {
        Anhalten();
    }
    
    void ResumeGame() 
    {
        Starten();    
    }
    
    @Override void SonderTasteGedrückt (int taste)
    {
        switch (taste)
        {
            case 81:        //Taste P
                PauseGame();
                break;
            case 83:        //Taste R
                ResumeGame();
                break;
        }
    }
}
