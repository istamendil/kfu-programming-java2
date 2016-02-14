/**
 * Code for studying purposes.
 * Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 * 
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class ClassCastingWithSimpleContainer {
  public static void main(String[] args){
    String source = "42 apples";
    UnifiedSimpleContainer container = new UnifiedSimpleContainer(source);
    
    System.out.println(container.getValue());
    System.out.println(container.getType());
    
    // We have to cast value to String
    String newString1 = (String) container.getValue();
    
    System.out.println(newString1);
    
    // Java won't give opportunity to do such trick
    //String newString2 = (container.getType()) container.getValue();
    // java.lang.RuntimeException: Uncompilable source code - incompatible types: java.lang.Class cannot be converted to java.lang.String
    
    // Here will be thrown ClassCastException on METHOD RUN
    // Integer newInteger = (Integer) container.getValue();
  }
}
