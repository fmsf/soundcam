import ddf.minim.*;
import ddf.minim.signals.*;
import ddf.minim.effects.*;


public class SoundPlayer {
 
    private AudioOutput output;
    private Note currentNote;
  
    public SoundPlayer(Minim minim) {
       output = minim.getLineOut();
       currentNote = null;
    }
    
    public void play(Note note) {
        if ( note != currentNote ) {          
          //output.addSignal( new SquareWave(440, 1, note.getFrequency()) );
          //output.addEffect( new LowPassSP(200, note.getFrequency()) );
          output.playNote( 0.0f, 0.9f, new MyInstrument( 246.0f, output, "SINE" ) );
                    
          output.unmute();
          currentNote = note;
        }
    }
  
  
}
