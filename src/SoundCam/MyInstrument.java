import ddf.minim.*;
import ddf.minim.ugens.*;



// to make an Instrument we must define a class
// that implements the Instrument interface.
public class MyInstrument implements Instrument
{
  private AudioOutput out;

  private Oscil wave;
  private Line  ampEnv;
  
  public MyInstrument( float frequency, AudioOutput outtmp, String waveformStr )
  {
    
    Waveform waveform = Waves.SINE;
    if ("SAW".equals(waveformStr)){
      waveform = Waves.SAW;
    } else if ("PHASOR".equals(waveformStr)){
      waveform = Waves.PHASOR;
    } else if ("SQUARE".equals(waveformStr)){
      waveform = Waves.SQUARE;
    } else if ("TRIANGLE".equals(waveformStr)){
      waveform = Waves.TRIANGLE;
    } else if ("QUARTERPULSE".equals(waveformStr)){
      waveform = Waves.QUARTERPULSE;
    }   
        
    out = outtmp;
    wave   = new Oscil( frequency, 0, waveform  );
    ampEnv = new Line();
    ampEnv.patch( wave.amplitude );
  }
  
  // this is called by the sequencer when this instrument
  // should start making sound. the duration is expressed in seconds.
  public void noteOn( float duration )
  {
    // start the amplitude envelope
    ampEnv.activate( duration, 0.5f, 0 );
    // attach the oscil to the output so it makes sound
    wave.patch( out );
  }
  
  // this is called by the sequencer when the instrument should
  // stop making sound
  public void noteOff()
  {
    wave.unpatch( out );
  }
}
