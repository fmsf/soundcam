import ddf.minim.*;
import java.io.File;
import java.util.ArrayList;

public class Mp3Instrument
{
  
  private AudioPlayer player;
  private Minim minim;
  private ArrayList<String> pianoData;
  private ArrayList<String> guitarData;
  
  public Mp3Instrument( Minim minim , String path)
  {
      this.minim = minim;
      SetupData(path);
  }
  
  private void SetupData(String path){
    File[] filesGuitar = listFiles(path+"/data/guitar/");
    guitarData = ReadData(filesGuitar, path+"/data/guitar/");
    File[] filesPiano = listFiles(path+"/data/piano");
    pianoData = ReadData(filesPiano, path+"/data/piano/");
  }
  
  private ArrayList<String> ReadData(File[] files, String path){
    ArrayList<String> data = new ArrayList<String>();
    for (int i = 0; i < files.length; i++) {
      File f = files[i];
      data.add(path + f.getName());
      //System.out.println("-"+data.get(i));
    }
    System.out.println("\nSIZE"+data.size());
    return data;
  }
  
  private String[] listFileNames(String dir) {
    File file = new File(dir);
    if (file.isDirectory()) {
      String names[] = file.list();
      return names;
    } else {
      // If it's not a directory
      return null;
    }
  }

  private File[] listFiles(String dir) {
    File file = new File(dir);
    if (file.isDirectory()) {
      File[] files = file.listFiles();
      return files;
    } else {
      // If it's not a directory
      return null;
    }
  } 
  
  public void playPiano( Note note, int[] data ){
        System.out.println("playPiano - note: " + note); 
       switch (note) {
            case DO:
                    player = this.minim.loadFile(pianoData.get(data[0]));//0
                    break;
            case RE:
                    player = this.minim.loadFile(pianoData.get(data[1]));//4
                    break;
            case MI:
                    player = this.minim.loadFile(pianoData.get(data[2]));//6
                    break;
            case FA:
                    player = this.minim.loadFile(pianoData.get(data[3]));//12
                    break;
            case SOL:
                    player = this.minim.loadFile(pianoData.get(data[4]));//19
                    break;
            case LA:
                    player = this.minim.loadFile(pianoData.get(data[5]));//22
                    break;
            case SI:
                    player = this.minim.loadFile(pianoData.get(data[6]));//26

      }
      player.play();
  }
  
  public void playGuitar( Note note, int[] data ){
    
       switch (note) {
            case DO:
                    player = this.minim.loadFile(guitarData.get(data[0]));//8
                    break;
            case RE:
                    player = this.minim.loadFile(guitarData.get(data[1]));//1
                    break;
            case MI:
                    player = this.minim.loadFile(guitarData.get(data[2]));//2
                    break;
            case FA:
                    player = this.minim.loadFile(guitarData.get(data[3]));//3
                    break;
            case SOL:
                    player = this.minim.loadFile(guitarData.get(data[4]));//4
                    break;
            case LA:
                    player = this.minim.loadFile(guitarData.get(data[5]));//5
                    break;
            case SI:
                    player = this.minim.loadFile(guitarData.get(data[6]));//6

      }
      player.play(1500);
  }
}
