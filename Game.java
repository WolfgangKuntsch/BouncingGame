
/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Game extends Ereignisbehandlung
{
    private Bat character;
    private BrickController bricks;
    private Ball ball;
    
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
        ball = new Ball(0, 0, 20, 0, 0);
        bricks = new BrickController(Zeichenfenster.MalflächenBreiteGeben(), Zeichenfenster.MalflächenHöheGeben(), ball, character);
        StartGame();
    }
    
    @Override void TaktImpulsAusführen()
    {
        bricks.frame();       
    }
    
    void StartGame() 
    {
        TaktdauerSetzen(100);
        bricks.populateGrid(BRICK_WIDTH, BRICK_HEIGTH, NUM_COLUMNS, NUM_ROWS, BRICK_SPACING);
        Starten();    
    }
    
    
    
    void KollisionPrüfen() 
    {
        
    }
}
