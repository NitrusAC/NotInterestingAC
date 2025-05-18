package de.jpx3.intave.unknown;

import java.util.ArrayDeque;
import java.util.Deque;

public final class Unknown86 {
   private static final Deque a = new ArrayDeque();

   public static void b(Runnable var0) {
      if (var0 == null) {
         throw new NullPointerException("Null shutdown task");
      } else {
         a.offerLast(var0);
      }
   }

   public static void a(Runnable var0) {
      if (var0 == null) {
         throw new NullPointerException("Null shutdown task");
      } else {
         a.offerFirst(var0);
      }
   }

   private Unknown86() {
      throw new UnsupportedOperationException("Initialization of helper class");
   }

   public static void a() {
      for(Runnable var4 : a) {
         try {
            var4.run();
         } catch (Exception var6) {
            System.out.println("[Intave] Shutdown task " + var4 + " failed to complete");
            var6.printStackTrace();
         }
      }

   }
}
