

/**
 * Code for studying purposes.
 * Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 * 
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 * @param <T> Contained obj
 */
public class UnifiedSimpleContainer {
  private final Object obj;
  
  public UnifiedSimpleContainer(Object obj){
    this.obj = obj;
  }

  public Object getValue() {
    return obj;
  }
  
  public Class getType(){
    return this.obj.getClass();
  }
  
}
