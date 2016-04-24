
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
 * Task: find and explane mistakes.
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class Task2 {

  public static void main(String[] args) {
    new Task2();
  }

  public Task2() {
    // Find and create file
    File file = new File(Paths.get("Task2").toUri().normalize());
    if (!file.exists()) {
      System.out.printf("File %s doesn't exists. Creating new one.\n", file);
      try {
        file.createNewFile();
      } catch (IOException ex) {
        System.err.println("Couldn't create a file.");
        System.exit(1);
      }
    }

    Address  address = new Address("Kazan", "Kremlyovskaya", "18");
    Person person = new Person("Ivanov Ivan Ivanovich", address);

    // Write to file
    try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
      System.out.printf("Writing object: %s.\n", person);
      os.writeObject(person);
    } catch (FileNotFoundException ex) {
      System.err.println("File not found.");
    } catch (IOException ex) {
      System.err.printf("IO error: %s\n", ex.getMessage());
      ex.printStackTrace();
    }
  }
}
