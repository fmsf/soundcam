import ddf.minim.*;
import ddf.minim.ugens.*;

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
  
  public void noteOn( float duration )
  {
    ampEnv.activate( duration, 0.5f, 0 );
    wave.patch( out );
  }
  
  public void noteOff()
  {
    wave.unpatch( out );
  }
}
