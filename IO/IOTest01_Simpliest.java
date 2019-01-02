import java.io.FileInputStream;
import java.io.IOException;


public class IOTest01_Simpliest {

  public static void main(String[] args) throws IOException{
    FileInputStream in = new FileInputStream(Utils.getTestFile());
    System.out.println(in.read());
    in.close();
  }
}
