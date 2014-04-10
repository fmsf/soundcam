

public enum Note {
  
  DO(1245),
  RE(1234),
  MI(1234),
  FA(1234),
  SOL(1234),
  LA(1234),
  SI(1234);
  
  private long frequency;
  private String name;
  
  private Note(long frequency) {
      this.frequency = frequency;
  }
  
  public long getFrequency() {
    return frequency; 
  }
  
}
