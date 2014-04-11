import java.util.*;

public enum Note {
  
  DO(2610),
  RE(2930),
  MI(3290),
  FA(3490),
  SOL(3920),
  LA(4400),
  SI(4930);
  
  private long frequency;
  private String name;
  
  private Note(long frequency) {
      this.frequency = frequency;
  }
  
  public long getFrequency() {
    return frequency; 
  }
  
  public static List<Note> getValuesList() {
     List<Note> notes = new ArrayList(); 
     for ( Note note : Note.values() ) {
       notes.add(note);
     }
     return notes;    
  }
  
}
