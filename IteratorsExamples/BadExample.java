
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Code for studying purposes.
 * Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 * 
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class BadExample {

  public static void main(String[] args) {
    
    List<String> al = new ArrayList<>();
    al.add("1");
    al.add("");
    al.add("3");
    al.add("");
    al.add("5");
    for(String el : al){
      if (el.isEmpty()) {
        al.remove(el); // Exception here: java.util.ConcurrentModificationException
      }
    }
    for (String el : al) {
      System.out.println(el);
    }
  }
}
