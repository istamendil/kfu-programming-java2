
import java.util.Objects;

/**
 * Code for studying purposes. Programming course. Kazan Federal University,
 * ITIS. http://study.istamendil.info/
 *
 * @author Alexander Ferenets (Istamendil) <ist.kazan@gmail.com>
 */
public class Address {

  public final String city;
  public final String street;
  public final String house;

  public Address(String city, String street, String house) {
    this.city = city;
    this.street = street;
    this.house = house;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + Objects.hashCode(this.city);
    hash = 71 * hash + Objects.hashCode(this.street);
    hash = 71 * hash + Objects.hashCode(this.house);
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
    final Address other = (Address) obj;
    if (!Objects.equals(this.city, other.city)) {
      return false;
    }
    if (!Objects.equals(this.street, other.street)) {
      return false;
    }
    if (!Objects.equals(this.house, other.house)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Address{" + "city=" + city + ", street=" + street + ", house=" + house + '}';
  }

}
