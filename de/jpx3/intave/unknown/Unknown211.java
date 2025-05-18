package de.jpx3.intave.unknown;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public final class Unknown211 implements Set {
   private final Set a;

   public synchronized int size() {
      return this.a.size();
   }

   public synchronized boolean addAll(@NotNull Collection var1) {
      return this.a.addAll(var1);
   }

   public Unknown211(Set var1) {
      this.a = var1;
   }

   public synchronized boolean add(Object var1) {
      return this.a.add(var1);
   }

   public synchronized void clear() {
      this.a.clear();
   }

   public synchronized Iterator iterator() {
      return this.a.iterator();
   }

   public synchronized boolean removeAll(@NotNull Collection var1) {
      return this.a.removeAll(var1);
   }

   public synchronized Object[] toArray(@NotNull Object[] var1) {
      return this.a.toArray(var1);
   }

   public synchronized boolean remove(Object var1) {
      return this.a.remove(var1);
   }

   public synchronized boolean retainAll(@NotNull Collection var1) {
      return this.a.retainAll(var1);
   }

   public synchronized boolean contains(Object var1) {
      return this.a.contains(var1);
   }

   public synchronized Object[] toArray() {
      return this.a.toArray();
   }

   public synchronized boolean isEmpty() {
      return this.a.isEmpty();
   }

   public synchronized boolean containsAll(@NotNull Collection var1) {
      return this.a.containsAll(var1);
   }
}
