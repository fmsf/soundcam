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
          
          //default values for piano mp3 sounds, DO to RE [0, 4, 6, 12, 19, 22, 26], Available: 30 sounds
          mi.playPiano(note);
          
          //default values for guitar mp3 sounds, DO to RE [8, 1, 2, 3, 4, 5, 6], Available: 10 sounds
          mi.playGuitar(note);
          
          output.unmute();
          currentNote = note;
        }
    }
  
  
}
