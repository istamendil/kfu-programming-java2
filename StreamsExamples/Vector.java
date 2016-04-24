
import java.io.Serializable;

/**
 * Code for studying purposes. Programming course. Kazan Federal University,
 * ITIS. http://study.istamendil.info/
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class Vector implements Serializable {

  private static final long serialVersionUID = 565467565444431L;

  public final int x;
  public final int y;

  public Vector(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 73 * hash + this.x;
    hash = 73 * hash + this.y;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      System.out.println(1);
      return true;
    }
    if (obj == null) {
      System.out.println(2);
      return false;
    }
    if (getClass() != obj.getClass()) {
      System.out.println(3);
      return false;
    }
    final Vector other = (Vector) obj;
    if (this.x != other.x) {
      System.out.println(4);
      System.out.println(this.x);
      System.out.println(other.x);
      return false;
    }
    if (this.y != other.y) {
      System.out.println(5);
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Vector{" + "x=" + x + ", y=" + y + '}';
  }

}
