import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class IOTest02_Catching {

  public static void main(String[] args) throws IOException{
    InputStream in;
    
    // Example #1
    in = null;
    try{
      in = new FileInputStream(Utils.getNonExistingFile()); //IOException HERE
      // Won't be ran.
      System.out.println(in.read());
      System.out.println(in.read());
      in.close();
    }
    catch(IOException ex){
      System.err.println(ex.getMessage());
      // Do nothing: we couldn't even open a stream.
      // In real programm we should close stream.
    }
    
    // Example #2
    in = null;
    try{
      in = Utils.getTestRemoteInputStream();
      System.out.println(in.read());
      // Now we can wait for blocking resource (disconnect from internet).
      try{
        Thread.sleep(15000);//Please turn of internet connection now
      } catch (InterruptedException ex) {}
      System.out.println(in.read()); //IOException HERE
      // Won't be ran
      in.close();
    }
    catch(IOException ex){
      System.err.println(ex.getMessage());
      // We should try to close stream due it was opened. But close could throw IoException too.
      if(in != null){ // What if we haven't even open stream?
        try{
          in.close();
        }
        catch(IOException exClose){
          System.err.println(ex.getMessage());
        }
      }
    }
    // We also could put close() to finally block.
    
    // Example #2
    // Clever way: try-with-resources. Short and right code.
    try(InputStream in2 = Utils.getTestRemoteInputStream()){
      System.out.println(in2.read());
      System.out.println(in2.read());
    }
    catch(IOException ex){
      System.err.println(ex.getMessage());
    }
  }
}
