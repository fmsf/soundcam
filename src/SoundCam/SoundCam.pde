import processing.video.*;
import ddf.minim.*;

Scale scale = Scale.newBasicScale();
SoundPlayer soundPlayer;
void setup() {
  size(640, 480);
  soundPlayer = new SoundPlayer( new Minim( this ) ) ;

}


void draw() {
  Note note;
  note = scale.getNote();
  System.out.println(note.name() + " " + note.getFrequency());  
  soundPlayer.play(note);
}


