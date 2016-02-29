
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * Code for studying purposes. Programming course. Kazan Federal University,
 * ITIS. http://study.istamendil.info/
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class ModifableCollection extends AbstractCollection<Integer>{

  public static void main(String[] args) {
    Collection<Integer> col;
    
    col = new ModifableCollection();
    // Why wont work this definition: Collection col = new UnmodifableCollection(); ?
    for(Integer el : col){
      System.out.println(el);
    }
    System.out.println();
    
    List<Integer> arrList = new ArrayList<>();
    arrList.add(10);
    arrList.add(42);
    arrList.add(12);
    col = new ModifableCollection(arrList);
    for(Integer el : col){
      System.out.println(el);
    }
    
    try{
      col.add(505);
    }
    catch(UnsupportedOperationException ex){
      System.out.println("Add method is not supported: collection is unmodifable.");
    }
    System.out.println();
    for(Integer el : col){
      System.out.println(el);
    }
  }
  
  private final static int DEFAULT_SIZE = 10;
  
  private Integer[] data;
  private int size;
  
  public ModifableCollection(){
    data = new Integer[DEFAULT_SIZE];
    size = DEFAULT_SIZE;
  }
  
  public ModifableCollection(Collection<? extends Integer> col){
    data = new Integer[col.size()];
    size = 0;
    for(Integer el : col){
      data[size] = el;
      size++;
    }
  }

  @Override
  public Iterator<Integer> iterator() {
    return new BasicCollectionIterator();
  }

  @Override
  public int size() {
    return data.length;
  }
  
  @Override
  public boolean add(Integer el){
    if(size >= data.length){
      Integer[] newData = new Integer[data.length * 2];
      System.arraycopy(data, 0, newData, 0, data.length);
      data = newData;
    }
    data[size] = el;
    size++;
    return true;
  }

  private class BasicCollectionIterator implements Iterator<Integer> {
    private int current = 0;

    @Override
    public boolean hasNext() {
      return current < size;
    }

    @Override
    public Integer next() {
      Integer value = data[current];
      current++;
      return value;
    }
  }
}
