import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

/**
 * Code for studying purposes.
 * Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 * 
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class DataStreamExample {
  public static void main(String[] args){
    
    // Find and create file
    File file = new File(Paths.get("dataStreamExample").toUri().normalize());
    if(!file.exists()){
      System.out.printf("File %s doesn't exists. Creating new one.\n", file);
      try {
        file.createNewFile();
      } catch (IOException ex) {
        System.err.println("Couldn't create a file.");
        System.exit(1);
      }
    }
    
    // Write to file
    try(DataOutputStream is = new DataOutputStream(new FileOutputStream(file))){
      Random rand = new Random();
      byte[] data = new byte[5];
      for(int i = 0 ; i < data.length ; i++){
        data[i] = (byte) (rand.nextInt(255)-128);
      }
      System.out.printf("Write new generated array of bytes: %s.\n", Arrays.toString(data));
      for(int i = 0 ; i < data.length ; i++){
        is.writeByte(data[i]);
      }
    } catch (FileNotFoundException ex) {
      System.err.println("File not found.");
    } catch (IOException ex) {
      System.err.printf("IO error: %s\n", ex.getMessage());
      ex.printStackTrace();
    }
    
    // Read file
    try(DataInputStream is = new DataInputStream(new FileInputStream(file))){
      System.out.println("Read file:");
      try{
        while(true){
         System.out.println(is.readByte());
        }
      }
      catch(EOFException ex){}
    } catch (FileNotFoundException ex) {
      System.err.println("File not found.");
    } catch (IOException ex) {
      System.err.printf("IO error: %s\n", ex.getMessage());
      ex.printStackTrace();
    }
  }
}
