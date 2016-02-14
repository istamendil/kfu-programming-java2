/**
 * 
 * Code for studying purposes.
 * Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 * 
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class UsingGenericsClasses {

  public static void main(String[] args){
    
    String a = "abc";
    UnifiedGenericsContainer<String> u_a = new UnifiedGenericsContainer<>(a);
    System.out.println(u_a.getValue());
    System.out.println(u_a.getType());
    
    Integer b = 42;
    UnifiedGenericsContainer<Integer> u_b = new UnifiedGenericsContainer<>(b);
    System.out.println(u_b.getValue());
    System.out.println(u_b.getType());
    
    Object c = new Object();
    UnifiedGenericsContainer<Object> u_c = new UnifiedGenericsContainer<>(c);
    System.out.println(u_c.getValue());
    System.out.println(u_c.getType());
    
    UnifiedGenericsContainer<Object> d = u_c;
    UnifiedGenericsContainer<UnifiedGenericsContainer<Object>> u_d = new UnifiedGenericsContainer<>(d);
    System.out.println(u_d.getValue());
    System.out.println(u_d.getType());
  }
}
