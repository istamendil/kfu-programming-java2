import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

/**
 * Code for studying purposes.
 * Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 * 
 * Task: find and explane mistakes.
 * 
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class Task1 {
  public static void main(String[] args){
    File file = new File(Paths.get("Task1").toUri());
    try(InputStream is = new FileInputStream(file)){
      int data;
      while((data = is.read()) != -1){
       System.out.println(data);
      }
    } catch (IOException ex) {
      System.err.printf("IO error: %s\n", ex.getMessage());
    } catch (FileNotFoundException ex) {
      System.err.println("File not found.");
    }
  }
}
