import ddf.minim.*;
import java.io.File;
import java.util.*;

public class Mp3Instrument
{
  
  private AudioSnippet player;
  private Minim minim;
  HashMap<Note, AudioSnippet> pianoCache;
  HashMap<Note, AudioSnippet> guitarCache;
  
  public Mp3Instrument( Minim minim , String path )
  {
      this.minim = minim;
      pianoCache = new HashMap();
      guitarCache = new HashMap();
  } 
  
  private AudioSnippet getPianoAudioSnippet(Note note) {
    if( !pianoCache.containsKey(note) ) {
       pianoCache.put(note, this.minim.loadSnippet("data/piano/"+note.name()+".mp3")); 
    }
    return pianoCache.get(note);
  }
  
  private AudioSnippet getGitarAudioSnippet(Note note) {
    if( !guitarCache.containsKey(note) ) {
       guitarCache.put(note, this.minim.loadSnippet("data/guitar/"+note.name().charAt(0)+".mp3")); 
    }
    return guitarCache.get(note);
  }
  
  public void playPiano( Note note ){
      System.out.println("play piano - note: " + note); 
      getPianoAudioSnippet(note).play();
  }
  
    public void playPianochords( Note note ){
      System.out.println(note.name() + "  "+ note.next().name()+"    "+ note.next().name());
      getPianoAudioSnippet(note).play();
      getPianoAudioSnippet(note.next()).play();
      getPianoAudioSnippet(note.next().next()).play();

  }
  
  public void playGuitar( Note note ){
      System.out.println("play guitar - note: " + note); 
      getGitarAudioSnippet(note).play(1000); 
  }
}
