
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
public class GoodExample {

  public static void main(String[] args) {
    
    List<String> al = new ArrayList<>();
    al.add("1");
    al.add("");
    al.add("3");
    al.add("");
    al.add("5");
    Iterator<String> it = al.iterator();
    while (it.hasNext()) {
      String el = it.next();
      if (el.isEmpty()) {
        it.remove();
      }
    }
    for (String el : al) {
      System.out.println(el);
    }
  }
}
