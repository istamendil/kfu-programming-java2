import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
public class SimpleByteStreamExample {
  public static void main(String[] args){
    
    // Find and create file
    File file = new File(Paths.get("simpleByteStreamExample").toUri().normalize());
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
    try(OutputStream is = new FileOutputStream(file)){
      Random rand = new Random();
      byte[] data = new byte[5];
      for(int i = 0 ; i < data.length ; i++){
        data[i] = (byte) rand.nextInt(127);
      }
      System.out.printf("Write new generated array of bytes: %s.\n", Arrays.toString(data));
      is.write(data);
    } catch (FileNotFoundException ex) {
      System.err.println("File not found.");
    } catch (IOException ex) {
      System.err.printf("IO error: %s\n", ex.getMessage());
      ex.printStackTrace();
    }
    
    // Read file
    try(InputStream is = new FileInputStream(file)){
      System.out.println("Read file:");
      int data;
      while((data = is.read()) != -1){
       System.out.println(data);
      }
    } catch (FileNotFoundException ex) {
      System.err.println("File not found.");
    } catch (IOException ex) {
      System.err.printf("IO error: %s\n", ex.getMessage());
      ex.printStackTrace();
    }
  }
}
