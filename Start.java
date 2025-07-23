import java.io.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Start extends Symbol
{
    private Text t1,t2,t3;
    private Rechteck r1;
    
    public Start()
    {
        r1 = new Rechteck();
        r1.GrößeSetzen(Zeichenfenster.MalflächenBreiteGeben(), Zeichenfenster.MalflächenHöheGeben());
        r1.PositionSetzen(0, 0);
        r1.FarbeSetzen("grau");
        r1.GanzNachVornBringen();
        r1.GanzNachHintenBringen();
        
        t1 = new Text();
        t1.TextSetzen("BOUNCING GAME");
        t1.FarbeSetzen("rot");
        t1.TextGrößeSetzen(80);
        t1.PositionSetzen(60, 200);
        //t1.SichtbarkeitSetzen(false);
        
        t2 = new Text();
        t2.TextSetzen("Press 'R' to run!");
        t2.FarbeSetzen("blau");
        t2.TextGrößeSetzen(60);
        t2.PositionSetzen(200, 300);
        //t2.SichtbarkeitSetzen(false);

        t3 = new Text();
        t3.TextSetzen("Press 'L' to load game!");
        t3.FarbeSetzen("schwarz");
        t3.TextGrößeSetzen(60);
        t3.PositionSetzen(100, 400);
        //t3.SichtbarkeitSetzen(false);
        
    }
    

    @Override void TasteGedrückt (char taste)
    {
        switch (taste)
        {
            case 'r':        //Taste R
                StartGame();
                break;
            case 'l':        //Taste L
                LoadGame();
                break;
        }
    }
    
    private void StartGame()
    {
        t1.SichtbarkeitSetzen(false);
        t2.SichtbarkeitSetzen(false);
        t3.SichtbarkeitSetzen(false);
        r1.SichtbarkeitSetzen(false);
        new Game();
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
                    t1.SichtbarkeitSetzen(false);
                    t2.SichtbarkeitSetzen(false);
                    t3.SichtbarkeitSetzen(false);
                    r1.SichtbarkeitSetzen(false);
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
    
    
    
    
    
    
    
    
    
    @Override
    public void draw(int xpos, int ypos)
    {
        t1.SichtbarkeitSetzen(true);
        t2.SichtbarkeitSetzen(true);
        t3.SichtbarkeitSetzen(true);
        
    }


}
