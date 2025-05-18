package de.jpx3.intave.anticheat.data.holder;

import com.google.common.collect.Lists;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.unknown.Unknown190;
import de.jpx3.intave.unknown.Unknown227;
import de.jpx3.intave.unknown.Unknown355;
import de.jpx3.intave.unknown.Unknown80;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageModifier;

@Relocate
public final class DamageHolder {
   private static final long k = 15000L;
   private static final long o = 5000L;
   public int e;
   public static final long i = 40000L;
   private static final long l = 120000L;
   private static final long n = 60000L;
   public int g;
   public long f;
   private final Map m;
   private final Map c = new HashMap();
   private static final long h = 5000L;
   private static final long d = 40000L;
   public long b;
   private long a;
   private final List j;

   private static void e(EntityDamageByEntityEvent var0) {
      var0.setDamage(DamageModifier.BASE, var0.getDamage(DamageModifier.BASE) * 0.9);
      Unknown190.b(var0);
   }

   private void b(EntityDamageByEntityEvent var1) {
      int var2 = var1.getEntity().getEntityId();
      long var3 = System.currentTimeMillis() - this.m.computeIfAbsent(var2, DamageHolder::a);
      if (var3 < this.a) {
         var1.setCancelled(true);
      } else {
         int var5 = ThreadLocalRandom.current().nextInt(-10, 10);
         if (var5 < 0) {
            this.a = 550L;
         } else if (var5 < 5) {
            this.a = 600L;
         } else {
            this.a = 650L;
         }

         this.m.put(var2, System.currentTimeMillis());
      }

   }

   public DamageHolder(Player var1) {
      this.e = -1;
      this.g = -1;
      this.m = new ConcurrentHashMap();
      this.a = 600L;
      this.j = Lists.newArrayList(
         new Unknown80[]{
            new Unknown80(Unknown227.CANCEL, 5000L, DamageHolder::f),
            new Unknown80(Unknown227.CANCEL_FIRST, 60000L, DamageHolder::c),
            new Unknown80(Unknown227.DMG_MEDIUM, 40000L, DamageHolder::a),
            new Unknown80(Unknown227.DM_LIGHT, 40000L, DamageHolder::e),
            new Unknown80(Unknown227.HT_MEDIUM, 40000L, this::a),
            new Unknown80(Unknown227.HT_LIGHT, 40000L, DamageHolder::b),
            new Unknown80(Unknown227.BLOCKING, 15000L, DamageHolder::d, true),
            new Unknown80(Unknown227.GARBAGE_HIT, 120000L, this::b)
         }
      );

      for(Unknown80 var3 : this.j) {
         this.c.put(Unknown80.a(var3), var3);
      }

   }

   public List a() {
      return this.j;
   }

   private static Long a(Integer var0) {
      return 0L;
   }

   private static void c(EntityDamageByEntityEvent var0) {
   }

   private static Double a(Double var0) {
      return -0.0;
   }

   private static void f(EntityDamageByEntityEvent var0) {
      var0.setCancelled(true);
   }

   public Unknown80 a(Unknown227 var1) {
      return (Unknown80)this.c.get(var1);
   }

   private static void b(Player var0, EntityDamageByEntityEvent var1) {
      int var2 = -ThreadLocalRandom.current().nextInt(3, 4);
      Unknown355.a(var0, 800, var2);
   }

   private void a(Player var1, EntityDamageByEntityEvent var2) {
      int var3 = -ThreadLocalRandom.current().nextInt(4, 7);
      Unknown355.a(var1, 800, var3);
      this.a(var2.getEntity());
   }

   private static void a(EntityDamageByEntityEvent var0) {
      var0.setDamage(DamageModifier.BASE, var0.getDamage(DamageModifier.BASE) * 0.7);
      Unknown190.b(var0);
   }

   private void a(Entity var1) {
      if (var1 instanceof Player) {
         Player var2 = (Player)var1;
         byte var3 = 2;
         Unknown355.a(var2, 100, var3);
      }
   }

   private static void d(EntityDamageByEntityEvent var0) {
      Unknown190.a(var0, DamageModifier.BLOCKING, DamageHolder::a);
   }
}
