import processing.video.*;

public class Frame{
    
  private final int MAX_GREEN_RANGE = 100;
  private final int MIN_GREEN_RANGE = 40;
  
  private int[] pixels;
  private int averageColorRed;
  private int averageColorGreen;
  private int averageColorBlue;

  public Frame(int[] pixels){
    this.pixels = pixels;
    averageColorRed = 0;
    averageColorGreen = 0;
    averageColorBlue = 0;
  }
  
  public int[] getPixels(){
    return this.pixels;
  }
  
  public boolean hasColor() {
    if (averageColorRed != 0 || averageColorGreen != 0 || averageColorBlue != 0)
      return true;
     return false;
  }
  
  public int intersectAndGetAverageRed(Frame frame) {
     int[] otherFrame = frame.getPixels();
     int activePixels = 0;
     long redSum = 0;
     for ( int i = 0; i < otherFrame.length; i++ ) {
       color currColor = this.pixels[i];  
       int thisFrameRed = (currColor >> 16) & 0xFF; 
       int otherFrameRed = (otherFrame[i] >> 16) & 0xFF;
       if(thisFrameRed != otherFrameRed) {
          activePixels++;        
          redSum += thisFrameRed;
       }
     }
     if( activePixels == 0) {
       return 0;
     }
     return (int) redSum / activePixels;
  }
  
  public InstrumentType intersectAndGetAverageGreen(Frame frame) {
     int[] otherFrame = frame.getPixels();
     int activePixels = 0;
     long greenSum = 0;
     for ( int i = 0; i < otherFrame.length; i++ ) {
        activePixels++;
        color currColor = this.pixels[i];
        int currG = (currColor >> 8) & 0xFF; // Like red(), but faster
        greenSum += currG;
     }
     if( activePixels == 0) {
       return InstrumentType.NONE;
     }
     int greenAvg = (int) (greenSum / activePixels);
     
     
     if (greenAvg < MIN_GREEN_RANGE){
         return InstrumentType.PIANO;
     } else if(greenAvg > MAX_GREEN_RANGE){
         return InstrumentType.PIANO_CHORDS;
     } else {
         return InstrumentType.GUITAR_AND_PIANO;
     }
  }
  
  public int intersectAndGetAverageBlue(Frame frame) {
     int[] otherFrame = frame.getPixels();
     int activePixels = 0;
     long blueSum = 0;
     for ( int i = 0; i < otherFrame.length; i++ ) {
        activePixels++;
        color currColor = this.pixels[i];
        int currB = currColor & 0xFF; // Like red(), but faster
        blueSum += currB;
     }
     if( activePixels == 0) {
       return 0;
     }
     return (int) blueSum / activePixels;
  }
  
  public Frame subtract(Frame frame){
    int[] otherFrame = frame.getPixels();
    int[] newFrame = new int[otherFrame.length];
    
    int movementSum = 0; // Amount of movement in the frame
    for (int i = 0; i < newFrame.length; i++) { // For each pixel in the video frame...
      color currColor = this.pixels[i];
      color prevColor = otherFrame[i];
      
      // Extract the red, green, and blue components from current pixel
      int currR = (currColor >> 16) & 0xFF; // Like red(), but faster
      averageColorRed += currR;
      int currG = (currColor >> 8) & 0xFF;
      averageColorGreen += currG;
      int currB = currColor & 0xFF;
      averageColorBlue += currB;
      
      // Extract red, green, and blue components from previous pixel
      int prevR = (prevColor >> 16) & 0xFF;
      int prevG = (prevColor >> 8) & 0xFF;
      int prevB = prevColor & 0xFF;
      
      // Compute the difference of the red, green, and blue values
      int diffR = abs(currR - prevR);
      int diffG = abs(currG - prevG);
      int diffB = abs(currB - prevB);
      
      // Render the difference image to the screen
      newFrame[i] = color(diffR, diffG, diffB);
    }
    
    return new Frame(newFrame);
  }
  
}
