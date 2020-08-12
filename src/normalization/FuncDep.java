package normalization;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class FuncDep {
  protected final Set<Attribute> left;
  
  protected final Set<Attribute> right;
  
  public static class Builder {
    private Set<Attribute> left = new HashSet<>();
    
    private Set<Attribute> right = new HashSet<>();
    
    public FuncDep build() {
      return new FuncDep(this.left, this.right);
    }
    
    public Builder left(Attribute... as) {
      this.left.addAll(Arrays.asList(as));
      return this;
    }
    
    public Builder left(Set<Attribute> as) {
      this.left.addAll(as);
      return this;
    }
    
    public Builder right(Attribute... as) {
      this.right.addAll(Arrays.asList(as));
      return this;
    }
    
    public Builder right(Set<Attribute> as) {
      this.right.addAll(as);
      return this;
    }
  }
  
  public static Set<FuncDep> getSet(String exprs) {
    if (exprs.equals(""))
      return new HashSet<>(); 
    exprs = exprs.replaceAll("\\s+", "");
    return getSet(exprs.split(";"));
  }
  
  public static Set<FuncDep> getSet(String[] exprs) {
    Set<FuncDep> fds = new HashSet<>();
    byte b;
    int i;
    String[] arrayOfString;
    for (i = (arrayOfString = exprs).length, b = 0; b < i; ) {
      String s = arrayOfString[b];
      fds.add(of(s));
      b++;
    } 
    return fds;
  }
  
  public static FuncDep of(String expr) {
    String[] halves = expr.split("-->");
    return of(halves[0], halves[1]);
  }
  
  public static FuncDep of(String left, String right) {
    left = left.replaceAll("\\s+", "");
    right = right.replaceAll("\\s+", "");
    String[] lefts = left.split(",");
    String[] rights = right.split(",");
    Builder bd = new Builder();
    byte b;
    int i;
    String[] arrayOfString1;
    for (i = (arrayOfString1 = lefts).length, b = 0; b < i; ) {
      String s = arrayOfString1[b];
      bd.left(new Attribute[] { Attribute.of(s) });
      b++;
    } 
    for (i = (arrayOfString1 = rights).length, b = 0; b < i; ) {
      String s = arrayOfString1[b];
      bd.right(new Attribute[] { Attribute.of(s) });
      b++;
    } 
    return bd.build();
  }
  
  public FuncDep(Set<Attribute> left, Set<Attribute> right) {
    this.left = new HashSet<>(left);
    this.right = new HashSet<>(right);
  }
  
  public boolean equals(Object o) {
    if (o == this)
      return true; 
    if (!(o instanceof FuncDep))
      return false; 
    FuncDep fd = (FuncDep)o;
    return (this.left.equals(fd.left) && this.right.equals(fd.right));
  }
  
  public Set<Attribute> getLeft() {
    return new HashSet<>(this.left);
  }
  
  public Set<Attribute> getRight() {
    return new HashSet<>(this.right);
  }
  
  public int hashCode() {
    int result = 17;
    for (Attribute at : this.left)
      result = 31 * result + at.hashCode(); 
    for (Attribute at : this.right)
      result = 31 * result + at.hashCode(); 
    return result;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder((this.left.size() + this.right.size()) * 10);
    for (Attribute at : this.left) {
      sb.append(at.toString());
      sb.append(", ");
    } 
    sb.delete(sb.length() - 2, sb.length());
    sb.append(" --> ");
    for (Attribute at : this.right) {
      sb.append(at.toString());
      sb.append(", ");
    } 
    sb.delete(sb.length() - 2, sb.length());
    return sb.toString();
  }
}
