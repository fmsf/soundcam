import java.util.*;

public class ColorRange {
   
   private final int MAX_RANGE = 255;
   private final int MIN_RANGE = 0;
   private int interval;
   private List<Note> notes;
  
   public ColorRange(List<Note> notes) {
      this.notes = notes;
      interval = (MAX_RANGE / notes.size()) + 1;
   } 
   
   // TODO: verify this function
   public Note getNoteForColor(int value) {
       System.out.println(" with color value:" + value);
       int currentIncrement = interval;
       for ( int i = 0; i < notes.size(); i++ ) {
          if ( value < currentIncrement ) {
            return notes.get(i);
          }
          currentIncrement += interval;
       }
       return notes.get( notes.size() - 1 );
   }
  
}