package de.jpx3.intave.unknown.check;

import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers.Hand;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.access.player.event.BucketAction;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.block.IntaveMaterial;
import de.jpx3.intave.anticheat.check.api.Check;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.engine.util.CollisionUtil;
import de.jpx3.intave.anticheat.engine.util.GameMode;
import de.jpx3.intave.anticheat.engine.world.IntaveWorld;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.util.Direction;
import de.jpx3.intave.anticheat.util.MaterialUtil;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.anticheat.util.reach.Interaction;
import de.jpx3.intave.unknown.Unknown112;
import de.jpx3.intave.unknown.Unknown113;
import de.jpx3.intave.unknown.Unknown15;
import de.jpx3.intave.unknown.Unknown170;
import de.jpx3.intave.unknown.Unknown232;
import de.jpx3.intave.unknown.Unknown268;
import de.jpx3.intave.unknown.Unknown300;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.util.NumberConversions;

@Relocate
public final class Check2 implements Check {
   private final IntavePlugin a;

   public Check2(IntavePlugin var1) {
      this.a = var1;
      this.a();
   }

   @BukkitEventListener
   public void a(PlayerBucketFillEvent var1) {
      Player var2 = var1.getPlayer();
      Block var3 = var1.getBlockClicked().getRelative(var1.getBlockFace());
      IntaveWorld var4 = this.a(var2).getWorld();
      var4.b(var3.getX(), var3.getY(), var3.getZ());
      var4.c(var3.getX(), var3.getY(), var3.getZ());
   }

   private void a(Player var1, Block var2) {
      World var3 = var1.getWorld();
      IntaveWorld var4 = this.a(var1).getWorld();
      Material var5 = IntaveMaterial.parse(var2, var1);
      switch(Unknown170.b[var5.ordinal()]) {
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 9:
            int var12 = Unknown15.b(var2);
            boolean var15 = (var12 & 8) != 0;
            int var13;
            if (var15) {
               var13 = Unknown15.b(var2 = var2.getRelative(BlockFace.DOWN));
            } else {
               var13 = var12;
               var12 = Unknown15.b(var2.getRelative(BlockFace.UP));
            }

            var13 = (var13 & 4) != 0 ? var13 ^ 4 : var13 | 4;
            var4.a(var3, var2.getX(), var2.getY(), var2.getZ(), var5, var13);
            var4.a(var3, var2.getX(), var2.getY() + 1, var2.getZ(), var5, var12);
            IntaveScheduler.runTask(Check2::c);
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         default:
            break;
         case 16:
            int var6 = Unknown15.b(var2);
            boolean var7 = (var6 & 4) != 0;
            byte var8 = 4;
            byte var9 = (byte)(!var7 ? var6 | var8 : var6 & ~var8);
            Material var10 = IntaveMaterial.parse(var2, var1);
            var4.a(var3, var2.getX(), var2.getY(), var2.getZ(), var10, var9);
            IntaveScheduler.runTask(Check2::b);
      }

   }

   @BukkitEventListener
   public void a(PlayerBucketEmptyEvent var1) {
      Player var2 = var1.getPlayer();
      Block var3 = var1.getBlockClicked().getRelative(var1.getBlockFace());
      IntaveWorld var4 = this.a(var2).getWorld();
      var4.b(var3.getX(), var3.getY(), var3.getZ());
      var4.c(var3.getX(), var3.getY(), var3.getZ());
   }

   @BukkitEventListener(
      b = true
   )
   public void a(BlockPlaceEvent var1) {
      if (var1.getClass().equals(BlockPlaceEvent.class)) {
         Block var2 = var1.getBlock();
         IntaveWorld var3 = this.a(var1.getPlayer()).getWorld();
         var3.b(var2.getX(), var2.getY(), var2.getZ());
      }

   }

   private void a() {
      this.a.d().b(this);
   }

   private PlayerData a(Player var1) {
      return PlayerDataManager.getPlayerData(var1);
   }

   @BukkitEventListener(
      b = true
   )
   public void a(BlockBreakEvent var1) {
      if (var1.getClass().equals(BlockBreakEvent.class)) {
         Block var2 = var1.getBlock();
         IntaveWorld var3 = this.a(var1.getPlayer()).getWorld();
         var3.b(var2.getX(), var2.getY(), var2.getZ());
      }

   }

   private Unknown112 b(Player var1, Interaction var2) {
      PlayerData var5 = this.a(var1);
      World var6 = var2.h();
      ((Unknown300)this.a.E().a(Unknown300.class)).b();
      Location var7 = var2.f().toLocation(var6);
      Location var8 = var7.clone().add(Direction.a(var2.j()).p().toVector());
      boolean var9 = Unknown232.a(var6, var1, new BlockPosition(var7.toVector()));
      Location var10 = var9 ? var7 : var8;
      Material var11 = var2.e();
      int var12 = var10.getBlockX();
      int var13 = var10.getBlockY();
      int var14 = var10.getBlockZ();
      byte var15 = 0;
      boolean var16 = CollisionUtil.a(var5, var6, var12, var13, var14, var11, var15);
      if (var16) {
         return Unknown112.b;
      } else {
         Material var17 = var2.e();
         byte var18 = 0;
         Hand var19 = var2.k();
         boolean var20 = Unknown268.a(var1, var6, var19 == null || var19 == Hand.MAIN_HAND, var12, var13, var14, var2.j(), var17, var18);
         if (var20) {
            if (var17 == IntaveMaterial.WEB) {
               boolean var21 = CollisionUtil.a(var5, var6, var12, var13, var14, Material.STONE, 0);
               if (var21) {
                  var5.getStorage().getPhysicsHolder().b3 = true;
               }
            }

            var5.getStorage().getPhysicsHolder().ab = 0;
            IntaveWorld var22 = var5.getWorld();
            var22.a(var6, var12, var13, var14, var17, var18);
            var22.b(var12, var13, var14);
            return Unknown112.a;
         } else {
            return Unknown112.b;
         }
      }
   }

   private static double a(Location var0, BlockPosition var1) {
      return Math.sqrt(
         NumberConversions.square((double)(var0.getBlockX() - var1.getX()))
            + NumberConversions.square((double)(var0.getBlockY() - var1.getY()))
            + NumberConversions.square((double)(var0.getBlockZ() - var1.getZ()))
      );
   }

   private static void c(IntaveWorld var0, Block var1) {
      var0.c(var1.getX(), var1.getY() - 1, var1.getZ());
      var0.c(var1.getX(), var1.getY(), var1.getZ());
      var0.c(var1.getX(), var1.getY() + 1, var1.getZ());
   }

   private static void b(IntaveWorld var0, Block var1) {
      var0.c(var1.getX(), var1.getY(), var1.getZ());
   }

   private Unknown112 c(Player var1, Interaction var2) {
      PlayerData var5 = this.a(var1);
      World var6 = var2.h();
      ((Unknown300)this.a.E().a(Unknown300.class)).a();
      BlockPosition var7 = var2.f();
      Location var8 = var7.toLocation(var6);
      boolean var9 = Unknown268.a(var1, WorldUtil.getBlockAt(var8));
      if (var9) {
         int var10 = var8.getBlockX();
         int var11 = var8.getBlockY();
         int var12 = var8.getBlockZ();
         IntaveWorld var13 = this.a(var1).getWorld();
         Location var14 = var5.getStorage().getPhysicsHolder().getLocation();
         if (a(var14, var7) < 2.0 && var7.getY() < var14.getBlockY()) {
            var5.getStorage().getPhysicsHolder().T = 0;
         }

         Material var15 = var13.getMaterialAt(var10, var11, var12);
         if (var15 == IntaveMaterial.WEB) {
            boolean var16 = CollisionUtil.a(var5, var6, var10, var11, var12, Material.STONE, 0);
            if (var16) {
               var5.getStorage().getPhysicsHolder().b3 = true;
            }
         }

         var13.a(var6, var10, var11, var12, Material.AIR, 0);
         var13.b(var10, var11, var12);
      }

      return var9 ? Unknown112.a : Unknown112.b;
   }

   private Unknown112 a(Player var1, Interaction var2) {
      World var3 = var2.h();
      Location var4 = var2.f().toLocation(var3);
      Block var5 = WorldUtil.getBlockAt(var4);
      Material var6 = var2.e();
      Location var7 = var4.clone().add(Direction.a(var2.j()).p().toVector());
      this.a(var1, var5, var7, var6);
      this.a(var1, var5);
      return Unknown112.a;
   }

   public Unknown112 a(Interaction var1) {
      Player var2 = var1.a();
      Unknown113 var4 = var1.d();
      Unknown112 var3;
      switch(Unknown170.a[var4.ordinal()]) {
         case 1:
            var3 = this.b(var2, var1);
            break;
         case 2:
            var3 = this.a(var2, var1);
            break;
         case 3:
            var3 = this.c(var2, var1);
            break;
         default:
            var3 = Unknown112.b;
      }

      return var3;
   }

   private void a(Player var1, Block var2, Location var3, Material var4) {
      PlayerData var5 = this.a(var1);
      IntaveWorld var6 = var5.getWorld();
      World var7 = var1.getWorld();
      switch(Unknown170.b[var4.ordinal()]) {
         case 1:
            Material var10 = WorldUtil.getMaterialAt(var5, var3);
            if (MaterialUtil.isLiquid(var10) && Unknown268.a(var1, BucketAction.FILL_BUCKET, var2, BlockFace.SELF, var4, null)) {
               var6.a(var7, var3.getBlockX(), var3.getBlockY(), var3.getBlockZ(), Material.AIR, 0);
            }
            break;
         case 2:
         case 3:
            Material var8 = WorldUtil.getMaterialAt(var5, var3);
            boolean var9 = var5.getStorage().getEntityHolder().isGamemodeWtf(GameMode.ADVENTURE);
            if (var8 == Material.AIR && !var9 && Unknown268.a(var1, BucketAction.EMPTY_BUCKET, var2, BlockFace.SELF, var4, null)) {
               var6.a(var7, var3.getBlockX(), var3.getBlockY(), var3.getBlockZ(), var4 == Material.WATER_BUCKET ? Material.WATER : Material.LAVA, 15);
            }
      }

   }
}
