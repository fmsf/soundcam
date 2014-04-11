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
  
  public void playPiano( Note note ){
        System.out.println("playPiano - note: " + note); 
       switch (note) {
            case DO:
                    player = this.minim.loadFile(pianoData.get(0));//0
                    break;
            case RE:
                    player = this.minim.loadFile(pianoData.get(4));//4
                    break;
            case MI:
                    player = this.minim.loadFile(pianoData.get(6));//6
                    break;
            case FA:
                    player = this.minim.loadFile(pianoData.get(12));//12
                    break;
            case SOL:
                    player = this.minim.loadFile(pianoData.get(19));//19
                    break;
            case LA:
                    player = this.minim.loadFile(pianoData.get(22));//22
                    break;
            case SI:
                    player = this.minim.loadFile(pianoData.get(26));//26

      }
      player.play();
  }
  
  public void playGuitar( Note note ){
    
       switch (note) {
            case DO:
                    player = this.minim.loadFile(guitarData.get(8));//8
                    break;
            case RE:
                    player = this.minim.loadFile(guitarData.get(1));//1
                    break;
            case MI:
                    player = this.minim.loadFile(guitarData.get(2));//2
                    break;
            case FA:
                    player = this.minim.loadFile(guitarData.get(3));//3
                    break;
            case SOL:
                    player = this.minim.loadFile(guitarData.get(4));//4
                    break;
            case LA:
                    player = this.minim.loadFile(guitarData.get(5));//5
                    break;
            case SI:
                    player = this.minim.loadFile(guitarData.get(6));//6

      }
      player.play(1500);
  }
}
