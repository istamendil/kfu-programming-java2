
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Code for studying purposes.
 * Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 * 
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class OkExample {

  public static void main(String[] args) {
    
    List<String> al = new LinkedList<>();
    al.add("1");
    al.add("");
    al.add("3");
    al.add("");
    al.add("5");
    for(int i = 0; i < al.size(); i ++){
      if (al.get(i).isEmpty()) {
        al.remove(i); // It's ok
      }
    }
    for (String el : al) {
      System.out.println(el);// 1 3 5
    }
  }
}
