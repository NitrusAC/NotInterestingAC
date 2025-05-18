package de.jpx3.intave.unknown;

import com.google.common.collect.Lists;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Predicate;

public final class Unknown19 {
   private static final List d = Lists.newCopyOnWriteArrayList();
   private static final List b = Lists.newCopyOnWriteArrayList();
   private static final List a = Lists.newCopyOnWriteArrayList();

   public static void a(Object var0) {
      a.forEach(Unknown19::c);
      d.forEach(Unknown19::b);
      b.forEach(Unknown19::a);
   }

   private Unknown19() {
      throw new UnsupportedOperationException();
   }

   public static Set a(Set var0) {
      b.add(new WeakReference(var0));
      return var0;
   }

   private static void b(Object var0, Reference var1) {
      List var5;
      if ((var5 = (List)var1.get()) != null) {
         var5.remove(var0);
      }

   }

   private static void a(Object var0, Reference var1) {
      Set var5;
      if ((var5 = (Set)var1.get()) != null) {
         var5.remove(var0);
      }

   }

   public static List a(List var0) {
      d.add(new WeakReference(var0));
      return var0;
   }

   private static void c(Predicate var0, Reference var1) {
      List var5 = (List)var1.get();
      if (var5 != null) {
         var5.removeIf(var0);
      }

   }

   private static boolean a(Predicate var0, Entry var1) {
      return var0.test(var1.getKey());
   }

   public static void a(Predicate var0) {
      a.forEach(Unknown19::a);
      d.forEach(Unknown19::c);
      b.forEach(Unknown19::b);
   }

   private static void b(Predicate var0, Reference var1) {
      Set var5 = (Set)var1.get();
      if (var5 != null) {
         var5.removeIf(var0);
      }

   }

   private static void c(Object var0, Reference var1) {
      Map var5;
      if ((var5 = (Map)var1.get()) != null) {
         var5.remove(var0);
      }

   }

   private static void a(Predicate var0, Reference var1) {
      Map var5 = (Map)var1.get();
      if (var5 != null) {
         var5.entrySet().removeIf(Unknown19::a);
      }

   }

   public static void a() {
      Unknown86.b(Unknown19::b);
   }

   public static Map a(Map var0) {
      a.add(new WeakReference(var0));
      return var0;
   }

   public static void b() {
      a.clear();
      d.clear();
      b.clear();
   }
}
