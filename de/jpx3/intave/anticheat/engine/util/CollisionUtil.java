package de.jpx3.intave.anticheat.engine.util;

import de.jpx3.intave.Relocate;
import de.jpx3.intave.mG;
import de.jpx3.intave.anticheat.block.IntaveMaterial;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.interact.Interactable;
import de.jpx3.intave.anticheat.engine.world.IntaveWorld;
import de.jpx3.intave.anticheat.util.MaterialUtil;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import de.jpx3.intave.unknown.Unknown121;
import de.jpx3.intave.unknown.Unknown15;
import de.jpx3.intave.unknown.Unknown169;
import de.jpx3.intave.unknown.Unknown291;
import de.jpx3.intave.unknown.Unknown72;
import de.jpx3.intave.unknown.Unknown94;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.LongPredicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

@Relocate
@mG
public final class CollisionUtil {
   private static final Collector a = a(CollisionUtil::a);
   private static final Interactable d = Unknown291.a();
   private static final Collector c = a(CollisionUtil::b);
   private static final Collector b = Collectors.collectingAndThen(Collectors.toList(), Unknown121.d());
   private static final int e = 256;

   public static boolean isWorldBorder(World world, double posX, double posZ) {
      Location var5 = Unknown169.b(world);
      double var6 = Unknown169.a(world) / 2.0;
      double var8 = var5.getX() - var6 - 1.0;
      double var10 = var5.getZ() - var6 - 1.0;
      double var12 = var5.getX() + var6;
      double var14 = var5.getZ() + var6;
      return posX > var8 && posX < var12 && posZ > var10 && posZ < var14;
   }

   private static boolean a(long var0) {
      return var0 == 0L;
   }

   public static Object a(Player var0, Box var1, boolean var2, int var3, Collector var4) {
      Supplier var5 = var4.supplier();
      Object var6 = var2 ? var5.get() : null;
      BiConsumer var7 = var4.accumulator();
      Function var8 = var4.finisher();
      int var9 = MathUtil.floor(var1.minX);
      int var10 = MathUtil.floor(var1.maxX);
      int var11 = MathUtil.floor(var1.minY);
      int var12 = MathUtil.floor(var1.maxY);
      int var13 = MathUtil.floor(var1.minZ);
      int var14 = MathUtil.floor(var1.maxZ);
      int var15 = Math.max(var11 - 1, Unknown94.d);
      PlayerData var16 = PlayerDataManager.getPlayerData(var0);
      World var17 = var0.getWorld();
      BukkitEnginePlayer var18 = var16.getStorage().getPhysicsHolder();
      IntaveWorld var19 = var16.getWorld();
      boolean var20 = var18.a0;
      boolean var21 = a(var16);
      if (var20 && var21) {
         var18.a0 = false;
      } else if (!var20 && !var21) {
         var18.a0 = true;
      }

      int var22 = 256;
      int var23 = Math.min(var3, 256);

      for(int var24 = var9; var24 <= var10; ++var24) {
         for(int var25 = var13; var25 <= var14; ++var25) {
            for(int var26 = var15; var26 <= var12; ++var26) {
               if (var22-- <= 0) {
                  return var8.apply(var6);
               }

               Boxable var27 = var19.getBox(var24, var26, var25);
               Material var28 = var19.getMaterialAt(var24, var26, var25);
               if (Unknown72.a(var28)) {
                  var27 = Unknown72.a(var28, var16, var1, var24, var26, var25, var27);
               }

               boolean var29 = !isWorldBorder(var17, (double)var24, (double)var25);
               if (var29 && !var18.a0) {
                  Box var30 = Box.ofDouble((double)var24, (double)var26, (double)var25, (double)(var24 + 1), (double)var26, (double)(var25 + 1));
                  if (var30.isInside(var1)) {
                     if (!var2 && var6 == null) {
                        var6 = var5.get();
                     }

                     var7.accept(var6, var30);
                     if (--var23 <= 0) {
                        return var8.apply(var6);
                     }
                  }
               }

               if (var27.isInside(var1)) {
                  if (!var2 && var6 == null) {
                     var6 = var5.get();
                  }

                  var7.accept(var6, var27);
                  if (--var23 <= 0) {
                     return var8.apply(var6);
                  }
               }
            }
         }
      }

      return var8.apply(var6);
   }

   private static boolean a(PlayerData data) {
      World var1 = data.getPlayer().getWorld();
      BukkitEnginePlayer var2 = data.getStorage().getPhysicsHolder();
      double var3 = var2.serverX;
      double var5 = var2.serverZ;
      Location var7 = Unknown169.b(var1);
      double var8 = Unknown169.a(var1) / 2.0;
      double var10 = var7.getX() - var8;
      double var12 = var7.getZ() - var8;
      double var14 = var7.getX() + var8;
      double var16 = var7.getZ() + var8;
      if (var2.a0) {
         ++var10;
         ++var12;
         --var14;
         --var16;
      } else {
         --var10;
         --var12;
         ++var14;
         ++var16;
      }

      return var3 > var10 && var3 < var14 && var5 > var12 && var5 < var16;
   }

   @Deprecated
   public static List b(Player var0, Box var1) {
      int var2 = MathUtil.floor(var1.minX);
      int var3 = MathUtil.floor(var1.maxX + 1.0);
      int var4 = MathUtil.floor(var1.minY);
      int var5 = MathUtil.floor(var1.maxY + 1.0);
      int var6 = MathUtil.floor(var1.minZ);
      int var7 = MathUtil.floor(var1.maxZ + 1.0);
      int var8 = Math.max(var4 - 1, Unknown94.d);
      Object var9 = null;
      PlayerData var10 = PlayerDataManager.getPlayerData(var0);
      BukkitEnginePlayer var11 = var10.getStorage().getPhysicsHolder();
      boolean var12 = var11.a0;
      boolean var13 = a(var10);
      if (var12 && var13) {
         var11.a0 = false;
      } else if (!var12 && !var13) {
         var11.a0 = true;
      }

      IntaveWorld var14 = var10.getWorld();
      World var15 = var0.getWorld();
      int var16 = 256;

      label106:
      for(int var17 = var2 >> 4; var17 <= var3 - 1 >> 4; ++var17) {
         int var18 = var17 << 4;

         for(int var19 = var6 >> 4; var19 <= var7 - 1 >> 4; ++var19) {
            if (var15.isChunkLoaded(var17, var19)) {
               int var20 = var19 << 4;
               int var21 = Math.max(var2, var18);
               int var22 = Math.max(var6, var20);
               int var23 = Math.min(var3, var18 + 16);
               int var24 = Math.min(var7, var20 + 16);

               for(int var25 = var21; var25 < var23; ++var25) {
                  for(int var26 = var22; var26 < var24; ++var26) {
                     for(int var27 = var8; var27 < var5; ++var27) {
                        if (var16-- <= 0) {
                           break label106;
                        }

                        Boxable var28 = var14.getBox(var25, var27, var26);
                        Material var29 = var14.getMaterialAt(var25, var27, var26);
                        if (Unknown72.a(var29)) {
                           var28 = Unknown72.a(var29, var10, var1, var25, var27, var26, var28);
                        }

                        boolean var30 = !isWorldBorder(var15, (double)var25, (double)var26);
                        if (var30 && !var11.a0) {
                           if (var9 == null) {
                              var9 = new ArrayList();
                           }

                           ((List)var9).add(new Box((double)var25, (double)var27, (double)var26, (double)(var25 + 1), (double)var27, (double)(var26 + 1)));
                        }

                        if (var28 != null && !var28.a() && var28.isInside(var1)) {
                           if (var9 == null) {
                              var9 = new ArrayList(var28.b());
                           } else {
                              ((List)var9).addAll(var28.b());
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if (var9 == null) {
         var9 = Collections.emptyList();
      } else {
         ((List)var9).removeIf(CollisionUtil::isAinsideB);
         if (((List)var9).isEmpty()) {
            var9 = Collections.emptyList();
         }
      }

      return (List)var9;
   }

   public static boolean a(World var0, Box var1, Material var2) {
      return a(var0, var1, CollisionUtil::b);
   }

   @Deprecated
   public static boolean a(World var0, Player var1, Box var2) {
      return !collidesWithBlock(var0, var1, var2);
   }

   private static Boolean b(Material var0, Material var1) {
      return var1 == var0;
   }

   public static Boxable d(Player var0, Box var1) {
      return (Boxable)a(var0, var1, false, 256, b);
   }

   public static boolean a(World var0, Box var1) {
      int var2 = MathUtil.floor(var1.minX);
      int var3 = MathUtil.floor(var1.maxX);
      int var4 = MathUtil.floor(var1.minY);
      int var5 = MathUtil.floor(var1.maxY);
      int var6 = MathUtil.floor(var1.minZ);
      int var7 = MathUtil.floor(var1.maxZ);

      for(int var8 = var2; var8 <= var3; ++var8) {
         for(int var9 = var4; var9 <= var5; ++var9) {
            for(int var10 = var6; var10 <= var7; ++var10) {
               Block var11 = WorldUtil.getBlockAt(var0, var8, var9, var10);
               Material var12 = IntaveMaterial.from(var11);
               if (!MaterialUtil.isLiquid(var12) && IntaveMaterial.from(var11) != Material.AIR) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private static boolean a(Box var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      return var0.maxX > (double)var1
         && var0.minX < (double)var4
         && var0.maxY > (double)var2
         && var0.minY < (double)var5
         && var0.maxZ > (double)var3
         && var0.minZ < (double)var6;
   }

   public static Object collectCollide(Player player, Box box, int height, Collector collector) {
      Object var4 = collector.supplier().get();
      BiConsumer var5 = collector.accumulator();
      Function var6 = collector.finisher();
      int var7 = MathUtil.floor(box.minX);
      int var8 = MathUtil.floor(box.maxX);
      int var9 = MathUtil.floor(box.minY);
      int var10 = MathUtil.floor(box.maxY);
      int var11 = MathUtil.floor(box.minZ);
      int var12 = MathUtil.floor(box.maxZ);
      int var13 = Math.max(var9 - 1, Unknown94.d);
      PlayerData var14 = PlayerDataManager.getPlayerData(player);
      IntaveWorld var15 = var14.getWorld();
      int var16 = 256;
      int var17 = Math.min(height, 256);

      for(int var18 = var7; var18 <= var8; ++var18) {
         for(int var19 = var11; var19 <= var12; ++var19) {
            for(int var20 = var13; var20 <= var10; ++var20) {
               if (var16-- <= 0) {
                  return var6.apply(var4);
               }

               Boxable var21 = var15.getBox(var18, var20, var19);
               if (var21.isInside(box)) {
                  var5.accept(var4, new IntaveVector((double)var18, (double)var20, (double)var19));
                  if (--var17 <= 0) {
                     return var6.apply(var4);
                  }
               }
            }
         }
      }

      return var6.apply(var4);
   }

   private static boolean isAinsideB(Box a, Box b) {
      return !b.isInside(a);
   }

   public static boolean a(World var0, Box var1, Function var2) {
      int var3 = MathUtil.floor(var1.minX);
      int var4 = MathUtil.floor(var1.maxX);
      int var5 = MathUtil.floor(var1.minY);
      int var6 = MathUtil.floor(var1.maxY);
      int var7 = MathUtil.floor(var1.minZ);
      int var8 = MathUtil.floor(var1.maxZ);

      for(int var9 = var3; var9 <= var4; ++var9) {
         for(int var10 = var5; var10 <= var6; ++var10) {
            for(int var11 = var7; var11 <= var8; ++var11) {
               Block var12 = WorldUtil.getBlockAt(var0, var9, var10, var11);
               if (var2.apply(IntaveMaterial.from(var12))) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public static boolean a(PlayerData var0, World var1, int var2, int var3, int var4, Material var5, int var6) {
      Boxable var7 = d.interact(var1, var0.getPlayer(), var5, var6, var2, var3, var4);
      if (var7 != null && !var7.a()) {
         Box var8 = var0.getStorage().getPhysicsHolder().getBoundingBox();
         var8 = var8.shrink(0.001);
         return var7.isInside(var8);
      } else {
         return false;
      }
   }

   @Deprecated
   public static boolean collidesWithBlock(World world, Player player, Box other) {
      int var3 = MathUtil.floor(other.minX);
      int var4 = MathUtil.floor(other.maxX);
      int var5 = MathUtil.floor(other.minY);
      int var6 = MathUtil.floor(other.maxY);
      int var7 = MathUtil.floor(other.minZ);
      int var8 = MathUtil.floor(other.maxZ);
      int var9 = Math.max(var5 - 1, Unknown94.d);
      int var10 = 256;

      for(int var11 = var3; var11 <= var4; ++var11) {
         for(int var12 = var7; var12 <= var8; ++var12) {
            for(int var13 = var9; var13 <= var6; ++var13) {
               if (var10-- <= 0) {
                  return true;
               }

               Block var14 = WorldUtil.getBlockAt(world, var11, var13, var12);
               Material var15 = IntaveMaterial.parse(var14, player);
               int var16 = Unknown15.b(var14);
               Boxable var17 = d.interact(world, player, var15, var16, var11, var13, var12);
               if (var17.isInside(other)) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   private static Collector a(LongPredicate var0) {
      return Collectors.collectingAndThen(Collectors.counting(), var0::test);
   }

   public static boolean a(Player player, Box other) {
      return a(player, other, true, 1, c);
   }

   private static boolean b(long var0) {
      return var0 > 0L;
   }

   public static boolean isColliding(Player var0, Box other) {
      return a(var0, other, true, 1, a);
   }
}
