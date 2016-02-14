/**
 * Code for studying purposes.
 * Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 * 
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class ClassCastingWithGenericsContainer {
  public static void main(String[] args){
    String source = "42 apples";
    UnifiedGenericsContainer<String> container = new UnifiedGenericsContainer<>(source);
    
    System.out.println(container.getValue());
    System.out.println(container.getType());
    
    // No need to cast returned value
    String newString1 = container.getValue();
    
    System.out.println(newString1);
    
    // Here will be thrown "error: incompatible types: String cannot be converted to Integer" on COMPILING
    //Integer newInteger = container.getValue();
  }

}
