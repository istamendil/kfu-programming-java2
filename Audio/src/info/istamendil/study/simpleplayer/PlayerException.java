package info.istamendil.study.simpleplayer;

/**
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class PlayerException extends RuntimeException {

  public PlayerException() {
  }

  public PlayerException(String msg) {
    super(msg);
  }
  
  public PlayerException(Throwable ex){
    super(ex);
  }
}
