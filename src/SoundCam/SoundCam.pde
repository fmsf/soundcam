import processing.video.*;
import ddf.minim.*;

//Video vars
Capture video;

//Sound vars...
Scale scale;
ColorRange colorRange;
SoundPlayer soundPlayer;

Frame oldFrame;

void setup() {
  size(640, 480);
  frameRate(1);
  
  // This the default video input, see the GettingStartedCapture 
  // example if it creates an error
  video = new Capture(this, width, height);
  
  // Start capturing the images from the camera
  video.start(); 
  
  // Create an array to store the previously captured frame
  loadPixels();
  
  //Init sound vars...
  scale = Scale.newBasicScale();
  soundPlayer = new SoundPlayer( new Minim( this ) ) ;
  colorRange = new ColorRange( Note.getValuesList() );
}

void draw() {
  if (video.available()) {
    
    video.read(); // Read the new frame from the camera
    video.loadPixels(); // Make its pixels[] array available
    
    Frame thisFrame = new Frame(video.pixels);
    
    if( oldFrame != null ) {
      Frame subtractedFrame = thisFrame.subtract(oldFrame);
      
      scale.moveTo( colorRange.getNoteForColor( thisFrame.intersectAndGetAverageRed( subtractedFrame )) );
      Note note = scale.getNote();
      //soundPlayer.play(note);
      print("\n Note: " + note);
      
      pixels = thisFrame.getPixels();
      updatePixels();
              
    }
    oldFrame = thisFrame;
  }
}


