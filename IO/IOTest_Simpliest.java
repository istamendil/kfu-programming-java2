
import java.io.FileInputStream;
import java.io.IOException;


public class IOTest_Simpliest {

  public static void main(String[] args) throws IOException{
    FileInputStream in = new FileInputStream(Utils.getTestFile());
    System.out.println(in.read());
    in.close();
  }
}
