package de.jpx3.intave.unknown;

import com.google.common.base.Function;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.UnaryOperator;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageModifier;

public final class Unknown190 {
   private static final Field a;

   private static Map a(EntityDamageEvent var0) {
      try {
         return (Map)a.get(var0);
      } catch (IllegalAccessException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public static void b(EntityDamageEvent var0) {
      Map var4 = a(var0);
      double var5 = var0.getDamage(DamageModifier.BASE);

      for(DamageModifier var10 : DamageModifier.values()) {
         if (var4.containsKey(var10)) {
            float var11 = ((Double)((Function)var4.get(var10)).apply(var5)).floatValue();
            var5 += (double)var11;
            if (!var10.equals(DamageModifier.BASE)) {
               var0.setDamage(var10, (double)var11);
            }
         }
      }

   }

   static {
      try {
         a = EntityDamageEvent.class.getDeclaredField("modifierFunctions");
         a.setAccessible(true);
      } catch (NoSuchFieldException var7) {
         throw new IllegalStateException(var7);
      }
   }

   public static void a(EntityDamageEvent var0, DamageModifier var1, UnaryOperator var2) {
      Map var7 = a(var0);
      var7.put(var1, var2::apply);
      double var8 = var0.getDamage(DamageModifier.BASE);

      for(DamageModifier var13 : DamageModifier.values()) {
         if (var7.containsKey(var13)) {
            float var14 = ((Double)((Function)var7.get(var13)).apply(var8)).floatValue();
            var8 += (double)var14;
            if (!var13.equals(DamageModifier.BASE)) {
               var0.setDamage(var13, (double)var14);
            }
         }
      }

   }
}
