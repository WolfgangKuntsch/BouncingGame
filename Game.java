import java.io.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Game extends Ereignisbehandlung implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Bat character;
    private Ball ball;
    private LeftWall leftWall;
    private RightWall rightWall;
    private UpperWall upperWall;
    
    private Background background;
    private static int BACKGROUND_MIN_STARS = 1;
    private static int BACKGROUND_MAX_STARS = 1;
    private static int BACKGROUND_STAR_MIN_RADIUS = 5;
    private static int BACKGROUND_STAR_MAX_RADIUS = 15;
    private static int BACKGROUND_STAR_MIN_DECAY = 1;
    private static int BACKGROUND_STAR_MAX_DECAY = 2;
    private static int BACKGROUND_STAR_MIN_DELAY = 5;
    private static int BACKGROUND_STAR_MAX_DELAY = 15;

    private BrickController bricks;
    private static int BRICK_WIDTH = 80;
    private static int BRICK_HEIGTH = 20;
    private static int BRICK_SPACING = 30;
    private static int NUM_COLUMNS = 6;
    private static int NUM_ROWS = 5;

    private static int POWERUP_RADIUS = 10;
    private static int POWERUP_SPEED = 2;

    private WinScreen win;
    private LoseScreen lose;
    private boolean running;
    
    private int screenWidth;
    private int screenHeight;
    

    /**
     * Konstruktor für Objekte der Klasse Spiel
     */
    public Game()
    {
        super();
        
        screenWidth = Zeichenfenster.MalflächenBreiteGeben();
        screenHeight = Zeichenfenster.MalflächenHöheGeben();
        
        ball = new Ball(400, 340, 10, 0, 5);
        character = new Bat(ball, screenWidth, screenHeight);
        
        rightWall = new RightWall(screenWidth, screenHeight);
        leftWall = new LeftWall(screenWidth, screenHeight);
        upperWall = new UpperWall(screenWidth, screenHeight);

        win = new WinScreen();
        lose = new LoseScreen();

        background = new Background(screenWidth, screenHeight, BACKGROUND_MIN_STARS, BACKGROUND_MAX_STARS, BACKGROUND_STAR_MIN_RADIUS, BACKGROUND_STAR_MAX_RADIUS, BACKGROUND_STAR_MIN_DECAY, BACKGROUND_STAR_MAX_DECAY, BACKGROUND_STAR_MIN_DELAY, BACKGROUND_STAR_MAX_DELAY);
        bricks = new BrickController(screenWidth, screenHeight, ball, character, new PowerupController(screenWidth, screenHeight, ball, character, POWERUP_RADIUS, POWERUP_SPEED));
        running = false;
        StartGame();
    }

    @Override void TaktImpulsAusführen()
    {
        background.frame();
        character.frame();
        ball.bewegen();
        boolean ballBatCollision = false;
        ballBatCollision = character.checkCollisions();
        bricks.frame(running, ballBatCollision);
        
        if (ball.getYPos() < screenHeight && (ball.getXPos() < -(ball.getRadius()) || ball.getXPos() > screenWidth + ball.getRadius() || ball.getYPos() < -ball.getRadius())) {
            ball.reset();
        }
        
        if (CustomMath.CircleRectangleCollision(ball.getXPos(), ball.getYPos(), ball.getRadius(), rightWall.getX(), rightWall.getY(), rightWall.getHeight(), rightWall.getWandDicke()) == 3) {
            ball.reflectX();            
        }
        
        if (CustomMath.CircleRectangleCollision(ball.getXPos(), ball.getYPos(), ball.getRadius(), leftWall.getX(), leftWall.getY(), leftWall.getHeight(), leftWall.getWandDicke()) == 4) 
        {
            ball.reflectX();            
        }
        
        if (CustomMath.CircleRectangleCollision(ball.getXPos(), ball.getYPos(), ball.getRadius(), upperWall.getX(), upperWall.getY(), upperWall.getWandDicke(), upperWall.getWidth() * 2) == 2 ) 
        {
            ball.reflectY();            
        }

        if (bricks.getBrickCount() == 0) {
            win.draw(0,0);
            running = false;
            ball.setVerloren(true);
        }
        
        if (ball.getYPos() > screenHeight + ball.getRadius()) {
            lose.draw(0,0);
            running = false;
            ball.setVerloren(true);
        }
        
        
    }

    void StartGame() 
    {
        TaktdauerSetzen(10);
        bricks.populateGrid(BRICK_WIDTH, BRICK_HEIGTH, NUM_COLUMNS, NUM_ROWS, BRICK_SPACING);
        running = true;
        Starten();    
    }

    void PauseGame()
    {
        Anhalten();
        running = false;
    }

    void ResumeGame() 
    {
        Starten();
        running = true;
    }

    @Override void TasteGedrückt (char taste)
    {
        switch (taste)
        {
            case 'p':        //Taste P
                PauseGame();
                System.out.println("Pause");
                break;
            case 'r':        //Taste R
                ResumeGame();
                System.out.println("Resume");
                break;
            case 's':        //Taste S
                if (!running)
                {
                    SaveGame();
                }
                break;
        }
    }
    
    @Override void SonderTasteGedrückt(int taste) {
        switch (taste) {
            case 16:
                character.setFast(true);
        }
    }

    //public static String serialize (GameState state);

    //static GameState deserialize (String customFormat);

    public void SaveGame()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Spiel speichern unter");
        // Optional: Filter für Dateitypen hinzufügen
        FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Bouncing-Dateien (*.bnc)", "bnc");
        fileChooser.setFileFilter(textFilter);
        int userSelection = fileChooser.showSaveDialog(Zeichenfenster.JFrameGeben());
        if (userSelection == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            // Überprüfen, ob die Endung fehlt und ggf. hinzufügen
            if (!filePath.toLowerCase().endsWith(".bnc"))
            {
                filePath += ".bnc";
                selectedFile = new File(filePath);
            }

            // Hier den eigentlichen Speichervorgang durchführen
            try (FileOutputStream fileOut = new FileOutputStream(selectedFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOut))
            {
                out.writeObject(this);
            }
            catch (IOException i)
            {
                i.printStackTrace();
            }
        }
    }

    public void LoadGame()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Spiel öffnen");
        // Optional: Filter für Dateitypen hinzufügen
        FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Bouncing-Dateien (*.bnc)", "bnc");
        fileChooser.setFileFilter(textFilter);
        int userSelection = fileChooser.showOpenDialog(Zeichenfenster.JFrameGeben());
        if (userSelection == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            // Überprüfen, ob die Endung fehlt und ggf. hinzufügen
            if (filePath.toLowerCase().endsWith(".bnc"))
            {
                try (FileInputStream fileIn = new FileInputStream(selectedFile);
                ObjectInputStream in = new ObjectInputStream(fileIn))
                {
                    Game newGame = (Game) in.readObject();
                    // Hier: Anzeige und Zustand auf das neue Spiel-Objekt newGame umstellen ...
                    
                    
                }
                catch (IOException i)
                {
                    i.printStackTrace();
                    return;
                }
                catch (ClassNotFoundException c)
                {
                    System.out.println("Game Klasse nicht gefunden.");
                    c.printStackTrace();
                    return;
                }
            }
        }
    }
}
