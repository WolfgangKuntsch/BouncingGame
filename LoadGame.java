    import java.io.*;
    import java.io.FileInputStream;
    import java.io.ObjectInputStream;
/**
 * Beschreiben Sie hier die Klasse LoadGame.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class LoadGame implements Serializable
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Game game;
    


    /**
     * Konstruktor für Objekte der Klasse LoadGame
     */
    public LoadGame()
    {
        // Instanzvariable initialisieren
        game = new Game();
    }
    
    public void saveGame(Game game, String filename) {
        try 
        //(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) 
        {
            FileOutputStream  fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(game);
            out.close();
            fileOut.close();
            System.out.println("Game saved successfully!");
        } 
        catch (IOException e) 
        {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }
    
    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    // public static Game loadGame(String filename) 
     // {
        // System.out.println("loading from" + filename);
        // Game game;
         // try 
         // //(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) 
        // {
            // FileInputStream fileIn = new FileInputStream(filename);
            // ObjectInputStream in = new ObjectInputStream(fileIn);
            // game = in.readObject();
            // in.close();
            // fileIn.close();
            // // Game loadedGame = (Game) in.readObject();
            // // System.out.println("Game loaded successfully!");
            // // return loadedGame;
        // } 
        // catch (IOException i)
        // {
            // i.printStackTrace();
            // return null;
        // }
        // catch (ClassNotFoundException c)
        // {
            // System.out.println("Error loading game: " + c.getMessage());
            // c.printStackTrace();
            // return null;
    // }
    // return game;
// }
}
    