import ddf.minim.*;
import java.io.File;
import java.util.*;

public class Mp3Instrument
{
  
  private AudioSample player;
  private Minim minim;
  HashMap<Note, AudioSample> pianoCache;
  HashMap<Note, AudioSample> guitarCache;
  
  public Mp3Instrument( Minim minim , String path )
  {
      this.minim = minim;
      pianoCache = new HashMap();
      guitarCache = new HashMap();
      
      for(Note note : Note.values()){
          pianoCache.put(note, this.minim.loadSample("data/piano/"+note.name()+".mp3")); 
          if( !guitarCache.containsKey(note) ) {
             guitarCache.put(note, this.minim.loadSample("data/guitar/"+note.name().charAt(0)+".mp3")); 
          }
      }
  } 
  
  private AudioSample getPianoAudioSample(Note note) {
    if( !pianoCache.containsKey(note) ) {
       pianoCache.put(note, this.minim.loadSample("data/piano/"+note.name()+".mp3")); 
    }
    return pianoCache.get(note);
  }
  
  private AudioSample getGitarAudioSample(Note note) {
    if( !guitarCache.containsKey(note) ) {
       guitarCache.put(note, this.minim.loadSample("data/guitar/"+note.name().charAt(0)+".mp3")); 
    }
    return guitarCache.get(note);
  }
  
  public void playPiano( Note note ){
      System.out.println("play piano - note: " + note); 
      getPianoAudioSample(note).trigger();
  }
  
  public void playGuitar( Note note ){
      System.out.println("play guitar - note: " + note); 
      getGitarAudioSample(note).trigger(); 
  }
}
