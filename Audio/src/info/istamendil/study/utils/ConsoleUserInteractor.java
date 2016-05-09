package info.istamendil.study.utils;

import java.util.Scanner;

/**
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 * 
 * Code for studying purposes. Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 */
public class ConsoleUserInteractor implements UserInteractor{
  
  private final Scanner sc;
  
  public ConsoleUserInteractor(){
    this.sc = new Scanner(System.in);
  }

  @Override
  public String readCommand() throws UserInteractorReadException {
    return sc.nextLine();
  }

  @Override
  public void print(String output) throws UserInteractorWriteException {
    System.out.println(output);
  }

}
