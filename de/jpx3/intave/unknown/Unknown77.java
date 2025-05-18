package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.data.PlayerData;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Supplier;

public final class Unknown77 {
   private final Map b = Unknown19.a(new ConcurrentHashMap());
   private final Function a;
   private static final String d;

   private Object a(PlayerData var1, UUID var2) {
      return this.a.apply(var1);
   }

   public Object a(PlayerData var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("User must not be null");
      } else if (!var1.exists()) {
         return this.a.apply(var1);
      } else {
         UUID var5 = var1.getPlayer().getUniqueId();
         return this.b.computeIfAbsent(var5, this::a);
      }
   }

   public static Unknown77 a(Object var0) {
      return new Unknown77(Unknown77::b);
   }

   private static Object a(Supplier var0, PlayerData var1) {
      return var0.get();
   }

   public static Unknown77 a(Function var0) {
      return new Unknown77(var0);
   }

   private static Object b(Object var0, PlayerData var1) {
      return var0;
   }

   private Unknown77(Function var1) {
      this.a = var1;
   }

   private Unknown77(Supplier var1) {
      this.a = Unknown77::a;
   }

   public static Unknown77 a(Supplier var0) {
      return new Unknown77(var0);
   }
}
