import ddf.minim.*;
import java.io.File;
import java.util.ArrayList;

public class Mp3Instrument
{
  
  private AudioPlayer player;
  private Minim minim;
  private ArrayList<String> pianoData;
  private ArrayList<String> guitarData;
  
  //default values for piano mp3 sounds, DO to RE [0, 4, 6, 12, 19, 22, 26], Available: 30 sounds
  private int[] guitarFileIndexes = new int[]{8, 1, 2, 3, 4, 5, 6};
  
  //default values for guitar mp3 sounds, DO to RE [8, 1, 2, 3, 4, 5, 6], Available: 10 sounds
  private int[] pianoFileIndexes = new int[]{0, 4, 6, 12, 19, 22, 26};
  
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
  
  public void playPiano( Note note ){
      int data[] = pianoFileIndexes;
      System.out.println("playPiano - note: " + note); 
      player = this.minim.loadFile("data/piano/"+note.name()+".mp3");
      player.play();
  }
  
  public void playGuitar( Note note ){
      int data[] = guitarFileIndexes;
       
      player.play(1500);
  }
}
