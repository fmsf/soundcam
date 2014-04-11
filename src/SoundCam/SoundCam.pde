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
  //Init sound vars...
  scale = Scale.newBasicScale();
  soundPlayer = new SoundPlayer( new Minim( this ), sketchPath ) ;
  colorRange = new ColorRange( Note.getValuesList() );
  
  //Init video vars...
  size(640, 480);
  frameRate(2);
  // This the default video input, see the GettingStartedCapture 
  // example if it creates an error
  video = new Capture(this, width, height);
  // Start capturing the images from the camera
  video.start(); 
  // Create an array to store the previously captured frame
  loadPixels();
  oldFrame = new Frame(video.pixels);
}

void draw() {
  if (video.available()) {
    // When using video to manipulate the screen, use video.available() and
    // video.read() inside the draw() method so that it's safe to draw to the screen
    video.read(); // Read the new frame from the camera
    video.loadPixels(); // Make its pixels[] array available
    
    Frame thisFrame = new Frame(video.pixels);
    
    if( oldFrame != null ) {
      Frame subtractedFrame = thisFrame.subtract(oldFrame);
      
      scale.moveTo( colorRange.getNoteForColor( thisFrame.intersectAndGetAverageRed( subtractedFrame )) );
      Note note = scale.getNote();
      InstrumentType instrumentType = thisFrame.intersectAndGetAverageGreen( subtractedFrame );
      soundPlayer.play(note, instrumentType);
      print("\n Note: " + note);

      
      System.arraycopy( subtractedFrame.getPixels(), 0, pixels, 0, subtractedFrame.getPixels().length );
      updatePixels();
    }
    oldFrame = thisFrame;
  }
}


