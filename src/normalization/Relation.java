package normalization;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class Relation {
  private final Set<Attribute> attrs;
  
  private final Set<FuncDep> fds;
  
  public Relation(Set<Attribute> attrs, Set<FuncDep> fds) {
    this.attrs = new HashSet<>(attrs);
    this.fds = new HashSet<>(fds);
  }
  
  public Relation(String names, String exprs) {
    this.attrs = Attribute.getSet(names);
    this.fds = FuncDep.getSet(exprs);
  }
  
  public Relation(String[] names, String[] exprs) {
    this.attrs = Attribute.getSet(names);
    this.fds = FuncDep.getSet(exprs);
  }
  
  public Set<Relation> decomposeTo3NF() {
    Set<Relation> result = new HashSet<>();
    Set<FuncDep> mb = Algos.minimalBasis(this.fds);
    for (FuncDep fd : mb) {
      Set<Attribute> attrsNow = new HashSet<>(fd.getLeft());
      attrsNow.addAll(fd.getRight());
      Set<FuncDep> proj = Algos.projection(attrsNow, mb);
      result.add(new Relation(attrsNow, proj));
    } 
    Set<Relation> toRemove = new HashSet<>();
    for (Relation a : result) {
      for (Relation b : result) {
        if (a != b && a.attrs.containsAll(b.attrs))
          toRemove.add(b); 
      } 
    } 
    result.removeAll(toRemove);
    Set<Set<Attribute>> keys = Algos.keys(this.attrs, mb);
    boolean contains = false;
    for (Relation r : result) {
      for (Set<Attribute> k : keys) {
        if (r.attrs.containsAll(k)) {
          contains = true;
          break;
        } 
      } 
      if (contains)
        break; 
    } 
    if (!contains) {
      Set<Attribute> key = null;
      Iterator<Set<Attribute>> iterator = keys.iterator();
      if (iterator.hasNext()) {
        Set<Attribute> k = iterator.next();
        key = k;
      } 
      Set<FuncDep> proj = Algos.projection(key, mb);
      result.add(new Relation(key, proj));
    } 
    return result;
  }
  
  public Set<Relation> decomposeToBCNF() {
    Set<Relation> result = new HashSet<>();
    Set<FuncDep> violating = getFdsViolatingBCNF();
    if (violating.isEmpty()) {
      result.add(this);
      return result;
    } 
    FuncDep pick = null;
    Iterator<FuncDep> iterator = violating.iterator();
    if (iterator.hasNext()) {
      FuncDep fd = iterator.next();
      pick = fd;
    } 
    Set<Attribute> lefts = pick.getLeft();
    Set<Attribute> attrs1 = Algos.closure(lefts, this.fds);
    Set<Attribute> attrs2 = new HashSet<>(this.attrs);
    attrs2.removeAll(attrs1);
    attrs2.addAll(lefts);
    Set<FuncDep> fds1 = Algos.projection(attrs1, this.fds);
    Set<FuncDep> fds2 = Algos.projection(attrs2, this.fds);
    Relation r1 = new Relation(attrs1, fds1);
    Relation r2 = new Relation(attrs2, fds2);
    result.addAll(r1.decomposeToBCNF());
    result.addAll(r2.decomposeToBCNF());
    return result;
  }
  
  public boolean equals(Object o) {
    if (o == this)
      return true; 
    if (!(o instanceof Relation))
      return false; 
    Relation r = (Relation)o;
    return (r.attrs.equals(this.attrs) && r.fds.equals(this.fds));
  }
  
  public Set<Attribute> getAttributes() {
    return new HashSet<>(this.attrs);
  }
  
  public Set<FuncDep> getFdsViolating3NF() {
    return Algos.check3NF(this.attrs, this.fds);
  }
  
  public Set<FuncDep> getFdsViolatingBCNF() {
    return Algos.checkBCNF(this.attrs, this.fds);
  }
  
  public Set<FuncDep> getFuncDeps() {
    return new HashSet<>(this.fds);
  }
  
  public Set<Set<Attribute>> getKeys() {
    return Algos.keys(this.attrs, this.fds);
  }
  
  public Set<Set<Attribute>> getSuperkeys() {
    return Algos.superKeys(this.attrs, this.fds);
  }
  
  public int hashCode() {
    int hash = 17;
    for (Attribute a : this.attrs)
      hash = 31 * hash + a.hashCode(); 
    for (FuncDep fd : this.fds)
      hash = 31 * hash + fd.hashCode(); 
    return hash;
  }
  
  public boolean is3NF() {
    return Algos.check3NF(this.attrs, this.fds).isEmpty();
  }
  
  public boolean isBCNF() {
    return Algos.checkBCNF(this.attrs, this.fds).isEmpty();
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder(500);
    sb.append("Attributes:\n");
    for (Attribute a : this.attrs) {
      sb.append(a);
      sb.append(", ");
    } 
    sb.delete(sb.length() - 2, sb.length() - 1);
    sb.append("\nFunctional Dependencies: \n");
    for (FuncDep fd : this.fds) {
      sb.append(fd);
      sb.append('\n');
    } 
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }
}
