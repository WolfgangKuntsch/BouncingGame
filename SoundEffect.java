
import java.applet.*;
import java.nio.file.*;
import java.net.*;

/**
 * Beschreiben Sie hier die Klasse SoundEffect.
 * 
 * @author W.K.
 * @version 11.07.2025
 */
public class SoundEffect
{
    private Path path;
    private AudioClip sound;
    
    SoundEffect(String wavDatei)
    {
        path = Paths.get(wavDatei);
        try
        {
            sound = Applet.newAudioClip( path.toUri().toURL() );
        }
        catch(MalformedURLException e)
        {
            
        }
    }

    public void play()
    {
        sound.play();
    }
}
