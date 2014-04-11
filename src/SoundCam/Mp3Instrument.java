import ddf.minim.*;

public class Mp3Instrument
{
  
  private AudioPlayer player;
  private Minim minim;
  
  public Mp3Instrument( Minim minim )
  {
    
      this.minim = minim;
  
  }
  
  public void playPiano( Note note ){
    
       switch (note) {
            case DO:
                    player = minim.loadFile("\\data\\piano\\a#58.mp3");
                    break;
            case RE:
                    player = minim.loadFile("\\data\\piano\\b59.mp3");
                    break;
            case MI:
                    player = minim.loadFile("\\data\\piano\\c#49.mp3");
                    break;
            case FA:
                    player = minim.loadFile("\\data\\piano\\d#51.mp3");
                    break;
            case SOL:
                    player = minim.loadFile("\\data\\piano\\e52.mp3");
                    break;
            case LA:
                    player = minim.loadFile("\\data\\piano\\f#54.mp3");
                    break;
            case SI:
                    player = minim.loadFile("\\data\\piano\\g#56.mp3");

      }
      player.play();
  }
  
  public void playGuitar( Note note ){
    
       switch (note) {
            case DO:
                    player = minim.loadFile("\\data\\guitar\\Dm_vbr.mp3");
                    break;
            case RE:
                    player = minim.loadFile("\\data\\guitar\\2nd_String_B__vbr.mp3");
                    break;
            case MI:
                    player = minim.loadFile("\\data\\guitar\\3rd_String_G_vbr.mp3");
                    break;
            case FA:
                    player = minim.loadFile("\\data\\guitar\\4th_String_D_vbr.mp3");
                    break;
            case SOL:
                    player = minim.loadFile("\\data\\guitar\\5th_String_A_vbr.mp3");
                    break;
            case LA:
                    player = minim.loadFile("\\data\\guitar\\6th_String_E_vbr.mp3");
                    break;
            case SI:
                    player = minim.loadFile("\\data\\guitar\\C_vbr.mp3");

      }
      player.play(1500);
  }
}
