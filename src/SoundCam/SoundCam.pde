import processing.video.*;
import ddf.minim.*;

Scale scale = Scale.newBasicScale();
SoundPlayer soundPlayer;
void setup() {
  size(640, 480);
  soundPlayer = new SoundPlayer( new Minim( this ) ) ;
    
  scale.moveTo(Note.FA);  
  scale.moveTo(Note.FA);

}


void draw() {
  Note note;
  note = scale.getNote();
  
  soundPlayer.play(note);
}


