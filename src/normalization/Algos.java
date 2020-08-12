package normalization;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Algos {
  public static Set<FuncDep> check3NF(Set<Attribute> attrs, Set<FuncDep> fds) {
    Set<Set<Attribute>> keys = keys(attrs, fds);
    Set<Attribute> primes = new HashSet<>();
    for (Set<Attribute> k : keys)
      primes.addAll(k); 
    Set<FuncDep> violating = new HashSet<>();
    for (FuncDep fd : fds) {
      if (!primes.containsAll(fd.getRight())) {
        boolean contains = false;
        for (Set<Attribute> k : keys) {
          if (fd.getLeft().containsAll(k)) {
            contains = true;
            break;
          } 
        } 
        if (!contains)
          violating.add(fd); 
      } 
    } 
    return violating;
  }
  
  public static Set<FuncDep> checkBCNF(Set<Attribute> attrs, Set<FuncDep> fds) {
    Set<Set<Attribute>> keys = keys(attrs, fds);
    Set<FuncDep> violating = new HashSet<>();
    for (FuncDep fd : fds) {
      boolean contains = false;
      for (Set<Attribute> k : keys) {
        if (fd.getLeft().containsAll(k)) {
          contains = true;
          break;
        } 
      } 
      if (!contains)
        violating.add(fd); 
    } 
    return violating;
  }
  
  public static Set<FuncDep> checkLossyDecomposition(Set<Attribute> attrs, Set<FuncDep> fds, Set<Set<Attribute>> subattrs) {
    Set<FuncDep> lost = new HashSet<>();
    Set<FuncDep> decomposed = new HashSet<>();
    for (Set<Attribute> sa : subattrs)
      decomposed.addAll(projection(sa, fds)); 
    for (FuncDep fd : fds) {
      Set<Attribute> left = fd.getLeft();
      Set<Attribute> closure = closure(left, decomposed);
      if (!closure.containsAll(fd.getRight()))
        lost.add(fd); 
    } 
    return lost;
  }
  
  public static Set<Attribute> closure(Set<Attribute> attrs, Set<FuncDep> fds) {
    Set<Attribute> result = new HashSet<>(attrs);
    boolean found = true;
    while (found) {
      found = false;
      for (FuncDep fd : fds) {
        if (result.containsAll(fd.left) && !result.containsAll(fd.right)) {
          result.addAll(fd.right);
          found = true;
        } 
      } 
    } 
    return result;
  }
  
  public static void combineRight(Set<FuncDep> fds) {
    Map<Set<Attribute>, Set<Attribute>> map = new HashMap<>();
    for (FuncDep fd : fds) {
      if (map.containsKey(fd.left)) {
        ((Set<Attribute>)map.get(fd.left)).addAll(fd.right);
        continue;
      } 
      map.put(fd.left, fd.getRight());
    } 
    fds.clear();
    for (Set<Attribute> left : map.keySet())
      fds.add((new FuncDep.Builder()).left(left).right(map.get(left)).build()); 
  }
  
  public static boolean equivalent(Set<FuncDep> a, Set<FuncDep> b) {
    Set<Attribute> names = new HashSet<>();
    for (FuncDep fd : a) {
      names.addAll(fd.getLeft());
      names.addAll(fd.getRight());
    } 
    for (FuncDep fd : b) {
      names.addAll(fd.getLeft());
      names.addAll(fd.getRight());
    } 
    Set<Set<Attribute>> powerset = reducedPowerSet(names);
    for (Set<Attribute> sa : powerset) {
      Set<Attribute> closureInA = closure(sa, a);
      Set<Attribute> closureInB = closure(sa, b);
      if (!closureInA.equals(closureInB))
        return false; 
    } 
    return true;
  }
  
  public static Set<Set<Attribute>> keys(Set<Attribute> attrs, Set<FuncDep> fds) {
    Set<Set<Attribute>> superkeys = superKeys(attrs, fds);
    Set<Set<Attribute>> toRemove = new HashSet<>();
    for (Set<Attribute> key : superkeys) {
      for (Attribute a : key) {
        Set<Attribute> remaining = new HashSet<>(key);
        remaining.remove(a);
        if (superkeys.contains(remaining)) {
          toRemove.add(key);
          break;
        } 
      } 
    } 
    superkeys.removeAll(toRemove);
    return superkeys;
  }
  
  public static Set<FuncDep> minimalBasis(Set<FuncDep> fds) {
    Set<FuncDep> result = new HashSet<>(fds);
    splitRight(result);
    removeTrivial(result);
    int count = 1;
    while (count > 0)
      count = removeUnnecessaryLeftSide(result) + removeUnnecessaryEntireFD(result); 
    return result;
  }
  
  public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
    Set<Set<T>> sets = new HashSet<>();
    if (originalSet.isEmpty()) {
      sets.add(new HashSet<>());
      return sets;
    } 
    List<T> list = new ArrayList<>(originalSet);
    T head = list.get(0);
    Set<T> rest = new HashSet<>(list.subList(1, list.size()));
    for (Set<T> set : powerSet(rest)) {
      Set<T> newSet = new HashSet<>();
      newSet.add(head);
      newSet.addAll(set);
      sets.add(newSet);
      sets.add(set);
    } 
    return sets;
  }
  
  public static Set<FuncDep> projection(Set<Attribute> attrs, Set<FuncDep> fds) {
    Set<Attribute> appeared = new HashSet<>();
    for (FuncDep fd : fds) {
      appeared.addAll(fd.getLeft());
      appeared.addAll(fd.getRight());
    } 
    if (attrs.containsAll(appeared))
      return new HashSet<>(fds); 
    Set<Attribute> notin = new HashSet<>(appeared);
    notin.removeAll(attrs);
    Set<Set<Attribute>> powerset = reducedPowerSet(attrs);
    Set<FuncDep> result = new HashSet<>();
    for (Set<Attribute> sa : powerset) {
      Set<Attribute> closure = closure(sa, fds);
      closure.removeAll(notin);
      result.add((new FuncDep.Builder()).left(sa).right(closure).build());
    } 
    return minimalBasis(result);
  }
  
  public static <T> Set<Set<T>> reducedPowerSet(Set<T> originalSet) {
    Set<Set<T>> result = powerSet(originalSet);
    result.remove(new HashSet());
    return result;
  }
  
  public static void removeTrivial(Set<FuncDep> fds) {
    Set<FuncDep> toRemove = new HashSet<>();
    Set<FuncDep> toAdd = new HashSet<>();
    for (FuncDep fd : fds) {
      if (fd.left.containsAll(fd.right)) {
        toRemove.add(fd);
        continue;
      } 
      Set<Attribute> toRemoveFromRight = new HashSet<>();
      for (Attribute a : fd.right) {
        if (fd.left.contains(a))
          toRemoveFromRight.add(a); 
      } 
      if (!toRemoveFromRight.isEmpty()) {
        Set<Attribute> right = fd.getRight();
        right.removeAll(toRemoveFromRight);
        toRemove.add(fd);
        toAdd.add((new FuncDep.Builder()).left(fd.left).right(right).build());
      } 
    } 
    fds.addAll(toAdd);
    fds.removeAll(toRemove);
  }
  
  public static int removeUnnecessaryEntireFD(Set<FuncDep> fds) {
    int count = 0;
    while (true) {
      FuncDep toRemove = null;
      boolean found = false;
      for (FuncDep fd : fds) {
        Set<FuncDep> remaining = new HashSet<>(fds);
        remaining.remove(fd);
        if (equivalent(remaining, fds)) {
          count++;
          found = true;
          toRemove = fd;
          break;
        } 
      } 
      if (!found)
        break; 
      fds.remove(toRemove);
    } 
    return count;
  }
  
  public static int removeUnnecessaryLeftSide(Set<FuncDep> fds) {
    int loop, count = 0;
    do {
      boolean found = false;
      FuncDep toRemove = null;
      FuncDep toAdd = null;
      loop = 0;
      for (FuncDep fd : fds) {
        Set<Attribute> left = fd.getLeft();
        Set<Attribute> right = fd.getRight();
        if (left.size() > 1)
          for (Attribute a : left) {
            Set<Attribute> remaining = new HashSet<>(left);
            remaining.remove(a);
            Set<FuncDep> alternative = new HashSet<>(fds);
            alternative.remove(fd);
            toAdd = (new FuncDep.Builder()).left(remaining).right(right).build();
            alternative.add(toAdd);
            if (equivalent(alternative, fds)) {
              found = true;
              toRemove = fd;
              count++;
              break;
            } 
          }  
        if (found)
          break; 
        loop++;
      } 
      if (!found)
        continue; 
      fds.remove(toRemove);
      fds.add(toAdd);
    } while (loop != fds.size());
    return count;
  }
  
  public static void splitRight(Set<FuncDep> fds) {
    Set<FuncDep> toRemove = new HashSet<>();
    Set<FuncDep> toAdd = new HashSet<>();
    for (FuncDep fd : fds) {
      if (fd.right.size() > 1) {
        for (Attribute a : fd.right) {
          toAdd.add((new FuncDep.Builder()).left(fd.left).right(new Attribute[] { a }).build());
        } 
        toRemove.add(fd);
      } 
    } 
    fds.addAll(toAdd);
    fds.removeAll(toRemove);
  }
  
  public static Set<Set<Attribute>> superKeys(Set<Attribute> attrs, Set<FuncDep> fds) {
    Set<Set<Attribute>> keys = new HashSet<>();
    if (attrs.isEmpty())
      for (FuncDep fd : fds) {
        attrs.addAll(fd.left);
        attrs.addAll(fd.right);
      }  
    Set<Set<Attribute>> powerset = reducedPowerSet(attrs);
    for (Set<Attribute> sa : powerset) {
      if (closure(sa, fds).equals(attrs))
        keys.add(sa); 
    } 
    return keys;
  }
}
