package de.jpx3.intave.unknown;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.bukkit.Location;
import org.bukkit.World;

public final class Unknown128 implements Unknown91 {
   private final Map d = Unknown19.a(new ConcurrentHashMap());
   private static final long a = TimeUnit.MICROSECONDS.toMillis(200L);
   private final Unknown91 c;
   private final Map b = Unknown19.a(new ConcurrentHashMap());

   static long a() {
      return a;
   }

   @Override
   public Location a(World var1) {
      Unknown85 var5 = (Unknown85)this.b.get(var1);
      if (var5 == null) {
         var5 = new Unknown85(this.c.a(var1));
         this.b.put(var1, var5);
      } else if (var5.a()) {
         var5.a(this.c.a(var1));
      }

      return (Location)var5.b();
   }

   @Override
   public double b(World var1) {
      Unknown85 var5 = (Unknown85)this.d.get(var1);
      if (var5 == null) {
         var5 = new Unknown85(this.c.b(var1));
         this.d.put(var1, var5);
      } else if (var5.a()) {
         var5.a(this.c.b(var1));
      }

      return var5.b();
   }

   public Unknown128(Unknown91 var1) {
      this.c = var1;
   }
}
