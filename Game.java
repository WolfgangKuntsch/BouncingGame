
/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Game extends Ereignisbehandlung
{
    private Bat character;
    /**
     * Konstruktor für Objekte der Klasse Spiel
     */
    public Game()
    {
        super();
        character = new Bat();
        StartGame();
    }
    
    @Override void TaktImpulsAusführen()
    {
            
    }
    
    void StartGame() 
    {
        TaktdauerSetzen(100);
        Starten();    
    }
    
    
    
    void KollisionPrüfen() 
    {
        
    }
}
