

public enum Note {
  
  DO(246),
  RE(261),
  MI(293),
  FA(329),
  SOL(349),
  LA(391),
  SI(440);
  
  private long frequency;
  private String name;
  
  private Note(long frequency) {
      this.frequency = frequency;
  }
  
  public long getFrequency() {
    return frequency; 
  }
  
}
