package info.istamendil.notebook;

/**
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 * 
 * Code for studying purposes. Programming course, 2nd semestr. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 */
public abstract class Application {
  protected String[] args;
  
  public Application(String[] args){
    this.args = args;
    this.init();
    this.start();
  }
  
  public abstract void init();
  public abstract void start();
}