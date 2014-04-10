import java.util.*;

public class Scale {
  
   List<Note> notes;
   
   int currentNote = 0;
 
   private Scale(List notes) {
      this.notes = notes; 
   }
   
   public Note getNote() {
      return notes.get(currentNote);
   }
 
   public static class Builder {
      List<Note> notes;
      
      public Builder() {
         notes = new ArrayList(); 
      }
      
      public Builder add(Note note) {
         this.notes.add(note); 
         return this;
      }
      
      public Scale build() {
          return new Scale(notes);      
      }
   } 
  
   public static Scale newBasicScale() {
      Builder builder = new Builder();
      return builder.add(Note.DO)
             .add(Note.RE)
             .add(Note.MI)
             .add(Note.FA)
             .add(Note.SOL)
             .add(Note.LA)
             .add(Note.SI)
             .build();
   }
}
