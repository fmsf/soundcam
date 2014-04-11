import ddf.minim.*;
import ddf.minim.signals.*;
import ddf.minim.effects.*;


public class SoundPlayer {
 
    private AudioOutput output;
    private Note currentNote;
    private Minim minim; 
    private String path;
    private Mp3Instrument mp3Instrument; 
      
    public SoundPlayer(Minim minim, String path) {
       this.output = minim.getLineOut();
       this.currentNote = null;
       this.minim = minim;
       this.path = path;
       this.mp3Instrument = new Mp3Instrument( this.minim , this.path);
    }
    
    public void play(Note note, InstrumentType instrumentType) {
        if ( note != currentNote ) {
          
          switch (instrumentType){
             case PIANO:
                mp3Instrument.playPiano(note);
                break;
             case PIANO_CHORDS:
                mp3Instrument.playPianochords(note);
                break;
             case GUITAR_AND_PIANO:
                mp3Instrument.playPiano(note);
                mp3Instrument.playGuitar(note);
          }
          output.unmute();
          currentNote = note;
        }
    } 
  
}
