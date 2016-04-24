
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;

/**
 * Code for studying purposes. Programming course. Kazan Federal University,
 * ITIS. http://study.istamendil.info/
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class ObjectStreamExample {

  public static void main(String[] args) {
    new ObjectStreamExample();
  }

  public ObjectStreamExample() {
    // Find and create file
    File file = new File(Paths.get("objectStreamExample").toUri().normalize());
    if (!file.exists()) {
      System.out.printf("File %s doesn't exists. Creating new one.\n", file);
      try {
        file.createNewFile();
      } catch (IOException ex) {
        System.err.println("Couldn't create a file.");
        System.exit(1);
      }
    }

    Vector v11 = new Vector(1, 7);
    Vector v21 = new Vector(3, 17);

    // Write to file
    try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
      System.out.printf("Writing objects: %s, %s.\n", v11, v21);
      os.writeObject(v11);
      os.writeObject(v21);
    } catch (FileNotFoundException ex) {
      System.err.println("File not found.");
    } catch (IOException ex) {
      System.err.printf("IO error: %s\n", ex.getMessage());
      ex.printStackTrace();
    }

    // Read file
    try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))) {
      Vector v12 = (Vector) is.readObject();
      Vector v22 = (Vector) is.readObject();
      System.out.printf("Objects have been read: %s, %s\n", v12, v22);
      System.out.printf("v11 == v12 ? %b\n", v11.equals(v12));
      System.out.printf("v21 == v22 ? %b\n", v21.equals(v22));
    } catch (FileNotFoundException ex) {
      System.err.println("File not found.");
    } catch (IOException ex) {
      System.err.printf("IO error: %s\n", ex.getMessage());
      ex.printStackTrace();
    } catch (ClassNotFoundException ex) {
      System.err.printf("Error with reading objects: %s\n", ex.getMessage());
      ex.printStackTrace();
    }
  }
}
