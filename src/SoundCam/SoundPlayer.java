import ddf.minim.*;
import ddf.minim.signals.*;
import ddf.minim.effects.*;


public class SoundPlayer {
 
    private AudioOutput output;
    private Note currentNote;
    private Minim minim; 
    private String path;
    private Mp3Instrument mi; 
      
    public SoundPlayer(Minim minim, String path) {
       this.output = minim.getLineOut();
       this.currentNote = null;
       this.minim = minim;
       this.path = path;
       this.mi = new Mp3Instrument( this.minim , this.path);
    }
    
    public void play(Note note) {
        if ( note != currentNote ) {
          
          
          //default values for piano mp3 sounds, DO to RE [0, 4, 6, 12, 19, 22, 26], Available: 30 sounds
          mi.playPiano(note);
          
          //mi.playGuitar(note);
          
          output.unmute();
          currentNote = note;
        }
    }
  
  
}
