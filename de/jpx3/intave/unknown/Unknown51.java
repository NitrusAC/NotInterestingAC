package de.jpx3.intave.unknown;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class Unknown51 implements Collection {
   private List a;

   public Unknown51(Collection var1) {
      this.a = new ArrayList(var1);
   }

   public boolean contains(Object var1) {
      return this.a.contains(var1);
   }

   public synchronized boolean remove(Object var1) {
      ArrayList var5 = new ArrayList();
      boolean var6 = false;

      for(Comparable var8 : this.a) {
         if (!Objects.equal(var1, var8)) {
            var5.add(var8);
         } else {
            var6 = true;
         }
      }

      this.a = var5;
      return var6;
   }

   public int size() {
      return this.a.size();
   }

   @NotNull
   public Iterator iterator() {
      return this.a.iterator();
   }

   public void clear() {
      this.a = new ArrayList();
   }

   public synchronized boolean a(Comparable var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("value cannot be NULL");
      } else {
         ArrayList var5 = new ArrayList();

         for(Comparable var6 : this.a) {
            if (var1 != null && var1.compareTo(var6) < 0) {
               var5.add(var1);
               var1 = null;
            }

            var5.add(var6);
         }

         if (var1 != null) {
            var5.add(var1);
         }

         this.a = var5;
         return true;
      }
   }

   public Unknown51(Collection var1, boolean var2) {
      this.a = new ArrayList(var1);
      if (var2) {
         Collections.sort(this.a);
      }

   }

   public Comparable b(int var1) {
      return (Comparable)this.a.get(var1);
   }

   public String toString() {
      return this.a.toString();
   }

   public boolean add(Object var1) {
      return this.a((Comparable)var1);
   }

   public synchronized void a(int var1) {
      ArrayList var2 = new ArrayList(this.a);
      var2.remove(var1);
      this.a = var2;
   }

   public boolean isEmpty() {
      return this.a.isEmpty();
   }

   public Object[] toArray(Object[] var1) {
      return this.a.toArray(var1);
   }

   public Unknown51() {
      this.a = new ArrayList();
   }

   public Object[] toArray() {
      return this.a.toArray();
   }

   public boolean removeAll(Collection var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("values cannot be NULL");
      } else if (var1.size() == 0) {
         return false;
      } else {
         ArrayList var5 = new ArrayList(this.a);
         var5.removeAll(var1);
         this.a = var5;
         return true;
      }
   }

   public boolean containsAll(Collection var1) {
      return this.a.containsAll(var1);
   }

   public synchronized boolean addAll(Collection var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("values cannot be NULL");
      } else if (var1.size() == 0) {
         return false;
      } else {
         ArrayList var5 = new ArrayList();
         var5.addAll(this.a);
         var5.addAll(var1);
         Collections.sort(var5);
         this.a = var5;
         return true;
      }
   }

   public boolean retainAll(Collection var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("values cannot be NULL");
      } else if (var1.size() == 0) {
         return false;
      } else {
         ArrayList var5 = new ArrayList(this.a);
         var5.removeAll(var1);
         this.a = var5;
         return true;
      }
   }
}
