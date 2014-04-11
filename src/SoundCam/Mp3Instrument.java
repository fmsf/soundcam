import ddf.minim.*;
import java.io.File;
import java.util.ArrayList;

public class Mp3Instrument
{
  
  private AudioPlayer player;
  private Minim minim;
  
  public Mp3Instrument( Minim minim , String path)
  {
      this.minim = minim;
  } 
  
  public void playPiano( Note note ){
      System.out.println("play piano - note: " + note); 
      player = this.minim.loadFile("data/piano/"+note.name()+".mp3");
      player.play();
  }
  
    public void playPianochords( Note note ){
      System.out.println(note.name() + "  "+ note.next().name()+"    "+ note.next().name());
      player = this.minim.loadFile("data/piano/"+note.name()+".mp3");
      player = this.minim.loadFile("data/piano/"+note.next().name()+".mp3");
      player = this.minim.loadFile("data/piano/"+note.next().next().name()+".mp3");
      player.play();
  }
  
  public void playGuitar( Note note ){
          System.out.println("play guitar - note: " + note); 

      player = this.minim.loadFile("data/guitar/"+note.name().charAt(0)+".mp3"); 
      player.play(1000);
  }
}
