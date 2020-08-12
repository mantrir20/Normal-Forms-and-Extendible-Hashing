package normalization;

import java.util.HashSet;
import java.util.Set;

public final class Attribute {
  protected static final int AVERAGE_LENGTH = 10;
  
  private final String name;
  
  public static Set<Attribute> getSet(String names) {
    if (names.equals(""))
      return new HashSet<>(); 
    names = names.replaceAll("\\s+", "");
    return getSet(names.split(","));
  }
  
  public static Set<Attribute> getSet(String[] names) {
    Set<Attribute> attrs = new HashSet<>();
    byte b;
    int i;
    String[] arrayOfString;
    for (i = (arrayOfString = names).length, b = 0; b < i; ) {
      String s = arrayOfString[b];
      attrs.add(of(s));
      b++;
    } 
    return attrs;
  }
  
  public static Attribute of(String name) {
    return new Attribute(name);
  }
  
  public Attribute(String name) {
    this.name = name;
  }
  
  public boolean equals(Object o) {
    if (o == this)
      return true; 
    if (!(o instanceof Attribute))
      return false; 
    Attribute a = (Attribute)o;
    return a.name.equals(this.name);
  }
  
  public String getName() {
    return this.name;
  }
  
  public int hashCode() {
    return this.name.hashCode();
  }
  
  public String toString() {
    return this.name;
  }
}
