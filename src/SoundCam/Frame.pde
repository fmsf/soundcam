import processing.video.*;

public class Frame{
  
  private int numPixels;
  private int[] pixels;
  private int averageColorRed;

  public Frame(int[] pixels){
    this.pixels = pixels;
    averageColorRed = 0;
  }
  
  public int[] getPixels(){
    return this.pixels;
  }
  
  public boolean hasColor() {
    return averageColorRed != 0;
  }
  
  public int intersectAndGetAverageRed(Frame frame) {
     int[] otherFrame = frame.getPixels();
     int activePixels = 0;
     long redSum = 0;
     for ( int i = 0; i < otherFrame.length; i++ ) {
         //if ( otherFrame[i] != 0 ) {
            activePixels++;
            color currColor = pixels[i];
            int currR = (currColor >> 16) & 0xFF; // Like red(), but faster
            redSum += currR;
         //} 
     }
     if( activePixels == 0) {
       return 0;
     }
     return (int) redSum / activePixels;
     
  }
  
  public Frame subtract(Frame frame){
    int[] otherFrame = frame.getPixels();
    int[] newFrame = new int[otherFrame.length];
    
    int movementSum = 0; // Amount of movement in the frame
    for (int i = 0; i < numPixels; i++) { // For each pixel in the video frame...
      color currColor = pixels[i];
      color prevColor = otherFrame[i];
      
      // Extract the red, green, and blue components from current pixel
      int currR = (currColor >> 16) & 0xFF; // Like red(), but faster
      int currG = (currColor >> 8) & 0xFF;
      int currB = currColor & 0xFF;
      // Extract red, green, and blue components from previous pixel
      int prevR = (prevColor >> 16) & 0xFF;
      
      averageColorRed += currR;
      
      int prevG = (prevColor >> 8) & 0xFF;
      int prevB = prevColor & 0xFF;
      
      // Compute the difference of the red, green, and blue values
      int diffR = abs(currR - prevR);
      int diffG = abs(currG - prevG);
      int diffB = abs(currB - prevB);
      
      // Add these differences to the running tally
      movementSum += diffR + diffG + diffB;
      // Render the difference image to the screen
      pixels[i] = color(diffR, diffG, diffB);
      
      // The following line is much faster, but more confusing to read
      //pixels[i] = 0xff000000 | (diffR << 16) | (diffG << 8) | diffB;
      // Save the current color into the 'previous' buffer
      newFrame[i] = currColor;
    }
    
    return new Frame(newFrame);
  }
  
}
