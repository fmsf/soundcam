import processing.video.*;


Scale scale = Scale.newBasicScale();

void setup() {
  size(640, 480);
  
//  video = new Capture(this, width, height);
  
//  video.start();
}


void draw() {
  Note note;
  note = scale.getNote();
  System.out.println(note.name() + " " + note.getFrequency());  
}


