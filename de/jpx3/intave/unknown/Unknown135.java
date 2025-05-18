package de.jpx3.intave.unknown;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.kM;
import de.jpx3.intave.kX;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import org.bukkit.entity.Player;

public final class Unknown135 {
   private final BiConsumer h;
   private final Consumer f;
   private Object a;
   private final Set g;
   private final PlayerData i;
   private final Map j = new LinkedHashMap();
   private final Map e = new LinkedHashMap();
   private Object k;
   private final BiConsumer c;
   private int l;
   private final List m;
   private final BinaryOperator d;
   private final int b;

   public void b(int var1) {
      if (this.l != 0) {
         Object var5 = this.a(var1);
         if (var5 != null && !this.g.contains(var5) && this.f != null) {
            this.f.accept(this.i);
         }

      }
   }

   private kM b(Object var1) {
      return (kM)this.j.getOrDefault(var1, kM.a);
   }

   public int d() {
      return this.l;
   }

   public static Unknown57 a(Class var0) {
      return new Unknown57();
   }

   // $FF: Unable to simplify switch on enum
   // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void a() {
      if (this.j.isEmpty()) {
         this.l = 0;
      } else {
         Object var4 = null;
         Object var5 = null;

         for(Entry var7 : this.j.entrySet()) {
            Object var8 = var7.getKey();
            kM var9 = (kM)var7.getValue();
            switch(kX.a[var9.ordinal()]) {
               case 1:
               case 2:
               default:
                  break;
               case 3:
                  this.e.put(var8, this.e.getOrDefault(var8, 0) + 1);
                  var5 = var8;
                  break;
               case 4:
                  var4 = this.d == null ? var8 : this.d.apply(var4, var8);
            }
         }

         this.a = var4;
         this.k = var5;
         if (this.a != null) {
            this.l = this.k != null ? 2 : 1;
         } else {
            this.l = this.k != null ? 2 : 0;
         }

      }
   }

   public void c() {
      for(Entry var6 : this.j.entrySet()) {
         Object var7 = var6.getKey();
         kM var8 = (kM)var6.getValue();
         if (var8 == kM.c) {
            this.m.add(var7);
         }
      }

      for(Object var10 : this.m) {
         this.a(var10, kM.d);
      }

      this.m.clear();
      this.a = null;
      this.k = null;
   }

   public void c(int var1) {
      if (this.l != 0) {
         Object var5 = this.a(var1);
         this.a(var5);
      }
   }

   public void a(Object var1) {
      if (this.l != 0) {
         if (this.b(var1).a()) {
            if (!this.g.contains(var1)) {
               if (var1 != null) {
                  this.g.add(var1);
               }

               if (this.h != null && var1 != null) {
                  this.h.accept(this.i, var1);
               }

               if (this.c != null) {
                  this.c.accept(this.i, var1);
               }

            }
         }
      }
   }

   public void a(PacketEvent var1, Object var2) {
      this.a(var2, kM.a);
      MoudleLoader.m().a(this.i.getPlayer(), var1, var2, this::c, this::b);
   }

   Unknown135(PlayerData var1, BiConsumer var2, BiConsumer var3, Consumer var4, BinaryOperator var5, int var6) {
      this.g = new HashSet();
      this.m = new ArrayList();
      this.i = var1;
      this.h = var2;
      this.c = var3;
      this.f = var4;
      this.d = var5;
      this.b = var6;
   }

   // $FF: Unable to simplify switch on enum
   // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void a(Object var1, kM var2) {
      kM var6 = this.b(var1);
      if (var2.ordinal() > var6.ordinal() || var2 == kM.a) {
         if (var2.ordinal() <= var6.ordinal() + 1 || var2 == kM.d) {
            switch(kX.a[var2.ordinal()]) {
               case 1:
                  this.j.put(var1, var2);
                  this.e.put(var1, 0);
                  break;
               case 2:
                  if (!this.g.contains(var1)) {
                     this.a(var1);
                  }

                  this.j.put(var1, var2);
                  this.j.remove(var1);
                  this.e.remove(var1);
                  this.g.remove(var1);
                  if (this.a == var1) {
                     this.a = null;
                  } else if (this.k == var1) {
                     this.k = null;
                  }
                  break;
               case 3:
               case 4:
                  this.j.put(var1, var2);
            }

         }
      }
   }

   private void c(Player var1, Object var2) {
      this.a(var2, kM.b);
   }

   private Object a(int var1) {
      if (var1 >= 0 && var1 < this.l) {
         Object var5;
         if (this.l == 1) {
            var5 = this.a;
         } else if (this.a == null) {
            var5 = var1 == 0 ? this.k : null;
         } else {
            var5 = var1 == 0 ? this.a : this.k;
         }

         return var5;
      } else {
         return null;
      }
   }

   public void d(int var1) {
      if (this.l != 0) {
         Object var5 = this.a(var1);
         if (var5 != null && !this.g.contains(var5) && this.h != null) {
            this.h.accept(this.i, var5);
         }

      }
   }

   private void b(Player var1, Object var2) {
      this.a(var2, kM.c);
   }

   public void b() {
      for(Entry var5 : this.j.entrySet()) {
         Object var6 = var5.getKey();
         kM var7 = (kM)var5.getValue();
         int var8 = this.e.getOrDefault(var6, 0);
         if (var7 == kM.b && var8 >= this.b) {
            System.out.println(var6 + " timed out after " + var8 + " ticks");
            this.m.add(var6);
         }
      }

      for(Object var10 : this.m) {
         this.a(var10, kM.d);
      }

      this.m.clear();
   }
}
