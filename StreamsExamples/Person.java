
import java.io.Serializable;
import java.util.Objects;

/**
 * Code for studying purposes. Programming course. Kazan Federal University,
 * ITIS. http://study.istamendil.info/
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class Person implements Serializable {

  private static final long serialVersionUID = 666554754565444431L;

  public final String name;
  public final Address address;

  public Person(String name, Address address) {
    this.name = name;
    this.address = address;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 59 * hash + Objects.hashCode(this.name);
    hash = 59 * hash + Objects.hashCode(this.address);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Person other = (Person) obj;
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    if (!Objects.equals(this.address, other.address)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Person{" + "name=" + name + ", address=" + address + '}';
  }

}
