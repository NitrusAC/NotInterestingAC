package de.jpx3.intave.unknown;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import de.jpx3.intave.anticheat.world.IntaveWorldBlock;
import java.util.Map;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.entity.Player;

final class Unknown180 {
   private final Map a;
   private final Player c;
   private final Set b;
   private final Map d = Maps.newConcurrentMap();

   public boolean a(long var1) {
      return this.a.containsKey(var1);
   }

   public void a() {
      for(IntaveVector var5 : this.b) {
         IntaveWorldBlock var6 = (IntaveWorldBlock)this.d.get(var5);
         if (var6 == null || var6.f()) {
            this.b.remove(var5);
            this.d.remove(var5);
            this.a.remove(this.a(var5));
         }
      }

   }

   public Set c() {
      return this.b;
   }

   public Map e() {
      return this.a;
   }

   public IntaveWorldBlock c(long var1) {
      return (IntaveWorldBlock)this.a.get(var1);
   }

   private long a(int var1, int var2, int var3) {
      return ((long)var1 & 4194303L) << 42 | (long)var2 & 1048575L | ((long)var3 & 4194303L) << 20;
   }

   public Map d() {
      return this.d;
   }

   Unknown180(Player var1) {
      this.a = Maps.newConcurrentMap();
      this.b = Sets.newConcurrentHashSet();
      this.c = var1;
   }

   public void b(long var1) {
      this.a.remove(var1);
   }

   public void b() {
      this.d.clear();
      this.a.clear();
      this.b.clear();
   }

   private long a(IntaveVector var1) {
      return this.a(var1.getBlockX(), var1.getBlockY(), var1.getBlockZ());
   }

   public void a(int var1, int var2, int var3, int var4) {
      for(IntaveVector var9 : this.d.keySet()) {
         if (var9.getX() >= (double)var1 && var9.getX() < (double)var2 && var9.getZ() >= (double)var3 && var9.getZ() < (double)var4) {
            long var10 = this.a(var9);
            this.d.remove(var9);
            this.b.remove(var9);
            this.a.remove(var10);
         }
      }

   }

   public void a(IntaveVector var1, IntaveWorldBlock var2) {
      this.d.put(var1, var2);
      this.b.add(var1);
      this.a.put(this.a(var1), var2);
   }

   private long a(Location var1) {
      return this.a(var1.getBlockX(), var1.getBlockY(), var1.getBlockZ());
   }
}
