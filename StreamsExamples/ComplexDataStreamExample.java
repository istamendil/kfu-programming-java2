import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UTFDataFormatException;
import java.nio.file.Paths;

/**
 * Code for studying purposes.
 * Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 * 
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class ComplexDataStreamExample {
  
  public static void main(String[] args){
    
    // Find and create file
    File file = new File(Paths.get("complexDataStreamExample").toUri().normalize());
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
    try(DataOutputStream os = new DataOutputStream(new FileOutputStream(file))){
      os.writeBoolean(true);
      os.writeByte(42);
      os.writeChar('A');
      os.writeDouble(1e12);
      os.writeFloat(3.14f);
      os.writeLong(548878489334534l);
      os.writeShort(30042);
      os.writeUTF("Hello world!абвгд");
    } catch (FileNotFoundException ex) {
      System.err.println("File not found.");
    } catch (IOException ex) {
      System.err.printf("IO error: %s\n", ex.getMessage());
      ex.printStackTrace();
    }
    
    // Read file
    try(DataInputStream is = new DataInputStream(new FileInputStream(file))){
      System.out.println("Read file:");
      System.out.println(is.readBoolean());
      System.out.println(is.readByte());
      System.out.println(is.readChar());
      System.out.println(is.readDouble());
      System.out.println(is.readFloat());
      System.out.println(is.readLong());
      System.out.println(is.readShort());
      System.out.println(is.readUTF());
    } catch (FileNotFoundException ex) {
      System.err.println("File not found.");
    } catch (UTFDataFormatException ex) {
      System.err.printf("Utf problems: %s.\n", ex.getMessage());
      ex.printStackTrace();
    } catch (IOException ex) {
      System.err.printf("IO error: %s\n", ex.getMessage());
      ex.printStackTrace();
    }
    
    // Read file
    try(DataInputStream is = new DataInputStream(new FileInputStream(file))){
      System.out.println("Wrong file reading:");
      System.out.println(is.readByte());
      System.out.println(is.readByte());
      System.out.println(is.readByte());
      System.out.println(is.readByte());
      System.out.println(is.readByte());
      System.out.println(is.readByte());
      System.out.println(is.readByte());
      System.out.println(is.readByte());
    } catch (FileNotFoundException ex) {
      System.err.println("File not found.");
    } catch (UTFDataFormatException ex) {
      System.err.printf("Utf problems: %s.\n", ex.getMessage());
      ex.printStackTrace();
    } catch (IOException ex) {
      System.err.printf("IO error: %s\n", ex.getMessage());
      ex.printStackTrace();
    }
  }
}
