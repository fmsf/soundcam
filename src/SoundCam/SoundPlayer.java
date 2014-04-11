import ddf.minim.*;
import ddf.minim.signals.*;
import ddf.minim.effects.*;


public class SoundPlayer {
 
    private AudioOutput output;
    private Note currentNote;
    private Minim minim; 
    private String path;
     
      
    public SoundPlayer(Minim minim, String path) {
       output = minim.getLineOut();
       currentNote = null;
       this.minim = minim;
       this.path = path;
    }
    
    public void play(Note note) {
        if ( note != currentNote ) {          
          Mp3Instrument mi = new Mp3Instrument( this.minim , this.path);
          mi.playPiano(note);
          mi.playGuitar(note);
          
          output.unmute();
          currentNote = note;
        }
    }
  
  
}
