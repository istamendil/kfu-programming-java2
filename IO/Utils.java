
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

  public static final String TEST_FILENAME = "dummyFile.io";
  public static final String TEST_REMOTE_HOST = "study.istamendil.info";
  public static final String TEST_REMOTE_AUDIO = "https://github.com/istamendil/kfu-programming-java2/raw/master/Audio/1nylon-guitar-girl-from-ipanema.wav";
  public static final String NON_EXISTING_FILENAME = "nef.io";

  public static File getTestFile() {
    try {
      File file = new File(IOTest01_Simpliest.class.getResource(TEST_FILENAME).toURI());
      if (!file.exists()) {
        file.createNewFile();
      }
      return file;
    } catch (IOException | URISyntaxException ex) {
      ex.printStackTrace();//Don't do this in real programms!
      return null;
    }
  }
  
  public static InputStream getTestRemoteInputStream() {
    try {
      Socket s = new Socket(TEST_REMOTE_HOST, 80);
      PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
      pw.println("GET / HTTP/1.1");
      pw.println("HOST: " + TEST_REMOTE_HOST);
      pw.println();
      pw.flush();
      return s.getInputStream();
    } catch (IOException ex) {
      ex.printStackTrace();//Don't do this in real programms!
      return null;
    }
  }
  
  public static URL getTestAudioUrl() {
    try {
      return new URL(TEST_REMOTE_AUDIO);
    } catch (MalformedURLException ex) {
      ex.printStackTrace();//Don't do this in real programms!
      return null;
    }
  }

  public static void removetestFile() {
    try{
      File file = getTestFile();
      if (file != null && file.exists()) {
        Files.delete(file.toPath());
      }
    } catch (IOException ex) {
      ex.printStackTrace();//Don't do this in real programms!
    }
  }

  public static File getNonExistingFile() {
    return new File(NON_EXISTING_FILENAME);
  }

  public static int getExceptionLineNumber(Throwable e) {
    return e.getStackTrace()[1].getLineNumber();
  }
}
