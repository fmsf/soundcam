import ddf.minim.*;
import ddf.minim.signals.*;
import ddf.minim.effects.*;


public class SoundPlayer {
 
    private AudioOutput output;
    private Note currentNote;
    private Minim minim; 
     
      
    public SoundPlayer(Minim minim) {
       output = minim.getLineOut();
       currentNote = null;
       this.minim = minim;
    }
    
    public void play(Note note) {
        if ( note != currentNote ) {          
          //output.addSignal( new SquareWave(440, 1, note.getFrequency()) );
          //output.addEffect( new LowPassSP(200, note.getFrequency()) );
          //output.playNote( 0.0f, 0.9f, new MyInstrument( note.getFrequency(), output, "SINE" ) );
          Mp3Instrument mi = new Mp3Instrument( this.minim );     
          mi.playPiano(note);
          mi.playGuitar(note);     
                    
                    
          output.unmute();
          currentNote = note;
        }
    }
  
  
}
