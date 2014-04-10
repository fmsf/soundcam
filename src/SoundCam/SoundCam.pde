import processing.video.*;
import ddf.minim.*;

Scale scale = Scale.newBasicScale();

ColorRange colorRange;
SoundPlayer soundPlayer;
void setup() {
  size(640, 480);
  frameRate(30);
  
  soundPlayer = new SoundPlayer( new Minim( this ) ) ;
  colorRange = new ColorRange( Note.getValuesList() );  
  scale.moveTo( colorRange.getNoteForColor(255) );
}


void draw() {
  Note note;
  note = scale.getNote();  
  print(note);
  soundPlayer.play(note);
}


