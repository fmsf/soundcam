import java.util.*;

public class Scale {
  
   List<Note> notes;
   
   int currentNoteIndex = 0;
 
   private Scale(List notes) {
      this.notes = notes; 
   }
   
   public Note getNote() {
      return notes.get(currentNoteIndex);
   }
   
   public int size() {
      return notes.size(); 
   }
   
   public Scale moveTo(Note note) {
      int index = notes.indexOf(note); 
      int distance = index - currentNoteIndex;
      if ( distance > 2 ) {
         currentNoteIndex += 2; 
      } else if ( distance < -2 )  {
          currentNoteIndex += -2;
      } else {
         currentNoteIndex += distance; 
      }
      return this;
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
      return builder.add(Note.a57)
                    .add(Note.a58)
                    .add(Note.a69)
                    .add(Note.a70)
                    .add(Note.b59)
                    .add(Note.b71)
                    .add(Note.c48)
                    .add(Note.c49)
                    .add(Note.c60)
                    .add(Note.c61)
                    .add(Note.c72)
                    .add(Note.c73)
                    .add(Note.d50)
                    .add(Note.d51)
                    .add(Note.d62)
                    .add(Note.d63)
                    .add(Note.d74)
                    .add(Note.d75)
                    .add(Note.e52)
                    .add(Note.e64)
                    .add(Note.e76)
                    .add(Note.f53)
                    .add(Note.f54)
                    .add(Note.f65)
                    .add(Note.f66)
                    .add(Note.g55)
                    .add(Note.g56)
                    .add(Note.g67)
                    .add(Note.g68)
            .build();
   }
   
}
