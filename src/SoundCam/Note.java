import java.util.*;

public enum Note {
  
  a57, a58, a69, a70,
  b59, b71,
  c48, c49, c60, c61, c72, c73,
  d50, d51, d62, d63, d74, d75,
  e52, e64, e76, 
  f53, f54, f65, f66,
  g55, g56, g67, g68;
  
  
  
  
  
  private Note() {}
  
  public String getFileName() {
     return this.name(); 
  }
  
  public static List<Note> getValuesList() {
     List<Note> notes = new ArrayList(); 
     for ( Note note : Note.values() ) {
       notes.add(note);
     }
     return notes;    
  }
  
}
