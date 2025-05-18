package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.collision.Boxable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

public final class Unknown121 {
   private static final Boxable a = new Unknown245();

   public static Boxable b() {
      return new Unknown376(0, 0, 0);
   }

   public static Function d() {
      return Unknown121::b;
   }

   public static Boxable c(@NotNull List var0) {
      switch(var0.size()) {
         case 0:
            return a();
         case 1:
            return (Boxable)var0.get(0);
         case 2:
            return new Unknown408((Boxable)var0.get(0), (Boxable)var0.get(1));
         default:
            return new Unknown350(new ArrayList(var0));
      }
   }

   public static Boxable a(int var0, int var1, int var2) {
      return new Unknown376(var0, var1, var2);
   }

   public static Boxable a() {
      return a;
   }

   private static Boxable b(List var0) {
      if (var0 == null) {
         return a();
      } else {
         switch(var0.size()) {
            case 0:
               return a();
            case 1:
               return (Boxable)var0.get(0);
            case 2:
               return a((Boxable)var0.get(0), (Boxable)var0.get(1));
            default:
               return new Unknown350(var0);
         }
      }
   }

   public static Boxable a(@NotNull Boxable var0, @NotNull Boxable var1) {
      if (var0.a()) {
         return var1;
      } else if (var1.a()) {
         return var0;
      } else {
         return (Boxable)(var0 == var1 ? var0 : new Unknown408(var0, var1));
      }
   }

   public static Boxable a(Boxable[] var0) {
      return new Unknown350(Arrays.asList(var0));
   }
}
