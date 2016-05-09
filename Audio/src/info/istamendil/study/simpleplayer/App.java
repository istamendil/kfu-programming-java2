package info.istamendil.study.simpleplayer;

import info.istamendil.study.utils.*;
import java.io.File;
import java.io.FileFilter;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Code for studying purposes. Programming course. Kazan Federal University,
 * ITIS. http://study.istamendil.info/
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class App{

  public static void main(String[] args) {
    new App(new SimplePlayer(), new ConsoleUserInteractor());
  }

  private Path musicDir;
  private final Player player;
  private final UserInteractor terminal;

  public App(Player player, UserInteractor interactor) {
    this.player = player;
    this.terminal = interactor;
    
    this.start();
  }

  public void start() {
    try {
      try{
        this.musicDir = Paths.get(".").toAbsolutePath().normalize();
        // Examine directory for readability
      }
      catch(InvalidPathException ex){
        this.terminal.print("Can't read directory");
        System.exit(1);
      }
      String command;
      while ((command = this.terminal.readCommand()) != null) {
        switch (command) {
          case "play":
            File[] tracks = this.musicDir.toFile().listFiles(new MusicFileFilter());
            if(tracks.length > 0){
              this.terminal.print("Starting to play: " + tracks[0].getName());
              this.player.play(tracks[0]);
            }
            break;
          case "stop":
            this.player.stop();
            break;
          default:
            this.terminal.print("Unkown command");
        }
      }
    } catch (UserInteractorReadException ex) {
      System.out.println("Can't read user input due error:");
      System.err.println(ex.getMessage());
      System.exit(1);
    } catch (UserInteractorWriteException ex) {
      System.out.println("Can't print data to user due error:");
      System.err.println(ex.getMessage());
      System.exit(1);
    } catch(Throwable ex){
      ex.printStackTrace();
    }
  }
  
  private static class MusicFileFilter implements FileFilter{

    @Override
    public boolean accept(File pathname) {
      String[] parts = pathname.getName().split("\\.");
      if(parts.length > 0){
        return parts[parts.length-1].equals("wav");
      }
      return false;
    }
    
  }
}
