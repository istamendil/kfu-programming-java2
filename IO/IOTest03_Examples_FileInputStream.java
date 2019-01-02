import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class IOTest03_Examples_FileInputStream {

  public static void main(String[] args) {
    File file = Utils.getTestFile();
//    File file = new File("/tmp/text.txt");
    try(FileInputStream in = new FileInputStream(file)){
      System.out.println(in.read());
      System.out.println(in.read());
      System.out.println(in.read());
    }
    catch(IOException ex){
      ex.printStackTrace();//Don't do this in real program
    }
  }
}
