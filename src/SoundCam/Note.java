

public enum Note {
  
  DO(10000),
  RE(44100),
  MI(44100),
  FA(44100),
  SOL(44100),
  LA(44100),
  SI(44100);
  
  private long frequency;
  private String name;
  
  private Note(long frequency) {
      this.frequency = frequency;
  }
  
  public long getFrequency() {
    return frequency; 
  }
  
}
