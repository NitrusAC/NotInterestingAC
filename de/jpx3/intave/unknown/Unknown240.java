package de.jpx3.intave.unknown;

import com.google.common.collect.Maps;
import de.jpx3.intave.mG;
import de.jpx3.intave.anticheat.block.IntaveMaterial;
import de.jpx3.intave.anticheat.engine.interact.Interactable;
import de.jpx3.intave.anticheat.engine.util.AccurateMathUtil;
import de.jpx3.intave.anticheat.engine.world.IntaveWorld;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import de.jpx3.intave.anticheat.world.IntaveWorldBlock;
import java.util.Map;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@mG
public final class Unknown240 implements IntaveWorld {
   private int a;
   private final Player b;
   private long f;
   private int i;
   private final Map d = Maps.newConcurrentMap();
   private int e;
   private final Unknown180 g;
   private int h;
   private final Interactable c;

   private IntaveWorldBlock a(World var1, Block var2, int var3, int var4, int var5) {
      if (var2.getY() < Unknown94.d) {
         return IntaveWorldBlock.d();
      } else {
         Material var6 = IntaveMaterial.parse(var2, this.b);
         if (var6 == Material.AIR) {
            return IntaveWorldBlock.d();
         } else {
            Unknown258.d();
            int var7 = Unknown15.b(var2);
            Boxable var8 = this.c.interact(var1, this.b, var6, var7, var3, var4, var5);
            return new IntaveWorldBlock(var8, var6, var7);
         }
      }
   }

   public static Unknown240 a(Player var0) {
      return a(var0, Unknown291.a());
   }

   @Override
   public void a(int var1, int var2, int var3, int var4) {
      this.g.a(var1, var2, var3, var4);
   }

   @Override
   public IntaveWorldBlock d(int var1, int var2, int var3) {
      long var4 = this.compress(var1, var2, var3);
      return this.g.c(var4);
   }

   @NotNull
   @Override
   public Boxable getBox(int x, int y, int z) {
      if (y >= Unknown94.d && Unknown94.MAX_HEIGHT >= y) {
         int var4 = x >> 4;
         int var5 = z >> 4;
         ++Unknown258.f;
         if (var4 != this.h || var5 != this.a) {
            this.h = var4;
            this.a = var5;
            double var6 = AccurateMathUtil.deltaXZ((double)(var4 - this.e), (double)(var5 - this.i));
            if (var6 > 2.0 || this.d.size() > 4096) {
               this.e = var4;
               this.i = var5;
               this.d.clear();
            }

            this.c();
         }

         long var11 = this.compress(x, y, z);
         IntaveWorldBlock var8 = this.g.c(var11);
         if (var8 != null) {
            return var8.getBox();
         } else {
            var8 = (IntaveWorldBlock)this.d.get(var11);
            if (var8 == null) {
               World var9 = this.b.getWorld();
               Block var10 = WorldUtil.getBlockAt(var9, x, y, z);
               var8 = this.a(var9, var10, x, y, z);
               if (var10.getY() >= 0) {
                  this.d.put(var11, var8);
               }
            }

            return var8.getBox();
         }
      } else {
         return Unknown121.a();
      }
   }

   @Deprecated
   @Override
   public Map a() {
      return this.g.d();
   }

   @Override
   public boolean e(int var1, int var2, int var3) {
      long var4 = this.compress(var1, var2, var3);
      return this.g.a(var4);
   }

   private long compress(int x, int y, int z) {
      return ((long)x & 4194303L) << 42 | (long)y & 1048575L | ((long)z & 4194303L) << 20;
   }

   @Override
   public int a(int var1, int var2, int var3) {
      if (var2 >= Unknown94.d && Unknown94.MAX_HEIGHT >= var2) {
         int var4 = var1 >> 4;
         int var5 = var3 >> 4;
         ++Unknown258.f;
         if (var4 != this.h || var5 != this.a) {
            this.h = var4;
            this.a = var5;
            double var6 = AccurateMathUtil.deltaXZ((double)(var4 - this.e), (double)(var5 - this.i));
            if (var6 > 2.0 || this.d.size() > 4096) {
               this.e = var4;
               this.i = var5;
               this.d.clear();
            }

            this.c();
         }

         long var11 = this.compress(var1, var2, var3);
         IntaveWorldBlock var8 = this.g.c(var11);
         if (var8 != null) {
            return var8.getData();
         } else {
            var8 = (IntaveWorldBlock)this.d.get(var11);
            if (var8 == null) {
               World var9 = this.b.getWorld();
               Block var10 = WorldUtil.getBlockAt(var9, var1, var2, var3);
               var8 = this.a(var9, var10, var1, var2, var3);
               if (var10.getY() >= 0) {
                  this.d.put(var11, var8);
               }
            }

            return var8.getData();
         }
      } else {
         return 0;
      }
   }

   @Override
   public void a(World var1, int var2, int var3, int var4, Material var5, int var6) {
      long var7 = this.compress(var2, var3, var4);
      this.g.b(var7);
      IntaveWorldBlock var9;
      if (var5 == Material.AIR) {
         var9 = IntaveWorldBlock.d();
      } else {
         Boxable var10 = this.c.interact(var1, this.b, var5, var6, var2, var3, var4);
         var9 = new IntaveWorldBlock(var10, var5, var6);
      }

      IntaveVector var11 = new IntaveVector((double)var2, (double)var3, (double)var4);
      this.g.a(var11, var9);
   }

   @Override
   public void a() {
      this.b();
      this.g.b();
   }

   @NotNull
   @Override
   public Material getMaterialAt(int x, int y, int z) {
      if (y >= Unknown94.d && Unknown94.MAX_HEIGHT >= y) {
         int var4 = x >> 4;
         int var5 = z >> 4;
         ++Unknown258.f;
         if (var4 != this.h || var5 != this.a) {
            this.h = var4;
            this.a = var5;
            double var6 = AccurateMathUtil.deltaXZ((double)(var4 - this.e), (double)(var5 - this.i));
            if (var6 > 2.0 || this.d.size() > 4096) {
               this.e = var4;
               this.i = var5;
               this.d.clear();
            }

            this.c();
         }

         long var11 = this.compress(x, y, z);
         IntaveWorldBlock var8 = this.g.c(var11);
         if (var8 != null) {
            return var8.getMaterial();
         } else {
            var8 = (IntaveWorldBlock)this.d.get(var11);
            if (var8 == null) {
               World var9 = this.b.getWorld();
               Block var10 = WorldUtil.getBlockAt(var9, x, y, z);
               var8 = this.a(var9, var10, x, y, z);
               if (var10.getY() >= 0) {
                  this.d.put(var11, var8);
               }
            }

            return var8.getMaterial();
         }
      } else {
         return Material.AIR;
      }
   }

   public void c() {
      if (System.currentTimeMillis() - this.f > 500L) {
         this.f = System.currentTimeMillis();
         this.g.a();
      }

   }

   private Unknown240(Player var1, Interactable var2) {
      this.f = System.currentTimeMillis();
      this.b = var1;
      this.c = var2;
      this.g = new Unknown180(var1);
   }

   public static Unknown240 a(Player var0, Interactable var1) {
      return new Unknown240(var0, var1);
   }

   private long a(Location var1) {
      return this.compress(var1.getBlockX(), var1.getBlockY(), var1.getBlockZ());
   }

   @Override
   public void b() {
      this.d.clear();
   }

   @Override
   public void a(int var1, int var2, int var3) {
      this.d.remove(this.compress(var1, var2, var3));
   }

   @Override
   public void c(int var1, int var2, int var3) {
      long var4 = this.compress(var1, var2, var3);
      this.g.b(var4);
   }

   @Deprecated
   @Override
   public Map b() {
      return this.g.e();
   }
}
