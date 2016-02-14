/**
 * Code for studying purposes.
 * Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 * 
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 * @param <T> Contained obj
 */
public class UnifiedGenericsContainer<T> {
  private final T obj;
  
  public UnifiedGenericsContainer(T obj){
    this.obj = obj;
  }

  public T getValue() {
    return obj;
  }
  
  public Class getType(){
    return this.obj.getClass();
  }
  
}
