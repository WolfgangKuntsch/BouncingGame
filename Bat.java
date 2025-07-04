public class Bat extends Figur
{
    public Bat()
    {
        super();
        FigurteilFestlegenRechteck(0, 0, 100, 20, "grau");
    }
    
    //Größe des Schlägers setzen
    public void setScale(float scale) { 
         //EigeneFigurLöschen();
         //FigurteilFestlegenRechteck(0, 0, , , "grau");
    }
    
    /*
     * Die  Aktionsmethode für gedrückte Sondertasten.
     * @param taste KeyCode der gedrückten Taste
     */
    @Override void SonderTasteGedrückt (int taste)
    {
        switch (taste)
        {
            // Pfeil nach links
          case 37:
            WinkelSetzen(180);
            Gehen(10);
            break;
            // Pfeil nach oben
          case 38:
            WinkelSetzen(90);
            Gehen(10);
            break;
            // Pfeil nach rechts
          case 39:
            WinkelSetzen(0);
            Gehen(10);
            break;
            // Pfeil nach unten
          case 40:
            WinkelSetzen(270);
            Gehen(10);
            break;
        }
    }
}
