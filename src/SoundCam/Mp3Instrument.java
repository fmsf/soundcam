import ddf.minim.*;
import java.io.File;
import java.util.ArrayList;

public class Mp3Instrument
{
  
  private AudioPlayer player;
  private Minim minim;
  
  //default values for piano mp3 sounds, DO to RE [0, 4, 6, 12, 19, 22, 26], Available: 30 sounds
  private int[] guitarFileIndexes = new int[]{8, 1, 2, 3, 4, 5, 6};
  
  //default values for guitar mp3 sounds, DO to RE [8, 1, 2, 3, 4, 5, 6], Available: 10 sounds
  private int[] pianoFileIndexes = new int[]{0, 4, 6, 12, 19, 22, 26};
  
  public Mp3Instrument( Minim minim , String path)
  {
      this.minim = minim;
  } 
  
  public void playPiano( Note note ){
      int data[] = pianoFileIndexes;
      System.out.println("playPiano - note: " + note); 
      player = this.minim.loadFile("data/piano/"+note.name()+".mp3");
      player.play();
  }
  
  public void playGuitar( Note note ){
      int data[] = guitarFileIndexes;
       
      player.play(1500);
  }
}
