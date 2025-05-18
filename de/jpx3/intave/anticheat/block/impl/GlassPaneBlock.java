package de.jpx3.intave.anticheat.block.impl;

import de.jpx3.intave.anticheat.block.Block;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.collision.Box;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class GlassPaneBlock extends Block {
   private static final Box[] c = new Box[]{
      Box.of(7.0, 0.0, 7.0, 9.0, 16.0, 9.0),
      Box.of(7.0, 0.0, 0.0, 9.0, 16.0, 9.0),
      Box.of(7.0, 0.0, 7.0, 16.0, 16.0, 9.0),
      Box.of(7.0, 0.0, 7.0, 9.0, 16.0, 16.0),
      Box.of(0.0, 0.0, 7.0, 9.0, 16.0, 9.0)
   };
   private static final Box[] b = new Box[]{
      new Box(0.0, 0.0, 0.4375, 1.0, 1.0, 0.5625),
      new Box(0.4375, 0.0, 0.0, 0.5625, 1.0, 1.0),
      new Box(0.4375, 0.0, 0.0, 0.5625, 1.0, 0.5),
      new Box(0.5, 0.0, 0.4375, 1.0, 1.0, 0.5625),
      new Box(0.4375, 0.0, 0.5, 0.5625, 1.0, 1.0),
      new Box(0.0, 0.0, 0.4375, 0.5, 1.0, 0.5625)
   };

   @Override
   public boolean isMaterial(Material material) {
      String var5 = material.name();
      return var5.contains("GLASS_PANE") || var5.contains("THIN_GLASS") || var5.contains("IRON_BAR") || var5.contains("IRON_FENCE");
   }

   private int b(Box box) {
      int var5 = 0;

      for(int var6 = c.length; var5 < var6; ++var5) {
         Box var7 = c[var5];
         if (var7.equals(box)) {
            return var5;
         }
      }

      return -1;
   }

   private int a(Box var1) {
      int var5 = 0;

      for(int var6 = b.length; var5 < var6; ++var5) {
         Box var7 = b[var5];
         if (var7.equals(var1)) {
            return var5;
         }
      }

      return -1;
   }

   public GlassPaneBlock() {
      super(new Material[0]);
      Arrays.stream(b).forEach(Box::a);
      Arrays.stream(c).forEach(Box::a);
   }

   @Override
   protected boolean a() {
      return true;
   }

   @Override
   protected List _getBounding(World world, Player player, int x, int y, int z, Material material, int data, List bbs) {
      PlayerData var12 = PlayerDataManager.getPlayerData(player);
      if (MinecraftVersion.V_1_9.atOrAbove()) {
         if (!var12.getStorage().getVersionHolder().isNewerVersion()) {
            int var13 = 0;
            int[] var14 = new int[bbs.size()];

            for(Box var16 : bbs) {
               var14[var13++] = this.b(var16);
            }

            boolean var25 = false;
            boolean var28 = false;
            boolean var17 = false;
            boolean var18 = false;

            for(int var22 : var14) {
               var25 |= var22 == 1;
               var18 |= var22 == 2;
               var28 |= var22 == 3;
               var17 |= var22 == 4;
            }

            ArrayList var33 = new ArrayList(var13 + 2);
            boolean var36 = var17 || var18 || var25 || var28;
            if ((!var17 || !var18) && var36) {
               if (var17) {
                  var33.add(b[5]);
               } else if (var18) {
                  var33.add(b[3]);
               }
            } else {
               var33.add(b[0]);
            }

            if ((!var25 || !var28) && var36) {
               if (var25) {
                  var33.add(b[2]);
               } else if (var28) {
                  var33.add(b[4]);
               }
            } else {
               var33.add(b[1]);
            }

            return var33;
         }
      } else if (var12.getStorage().getVersionHolder().isNewerVersion()) {
         int var23 = 0;
         int[] var24 = new int[bbs.size()];

         for(Box var29 : bbs) {
            var24[var23++] = this.a(var29);
         }

         boolean var27 = false;
         boolean var30 = false;
         boolean var31 = false;
         boolean var32 = false;

         for(int var39 : var24) {
            var27 |= var39 == 2 || var39 == 1;
            var30 |= var39 == 3 || var39 == 0;
            var31 |= var39 == 4 || var39 == 1;
            var32 |= var39 == 5 || var39 == 0;
         }

         if (!var27 && !var30 && !var31 && !var32 && var12.getStorage().getVersionHolder().isNewCollision()) {
            var32 = true;
            var30 = true;
            var31 = true;
            var27 = true;
         }

         ArrayList var35 = new ArrayList(var23);
         var35.add(c[0]);
         if (var27) {
            var35.add(c[1]);
         }

         if (var30) {
            var35.add(c[2]);
         }

         if (var31) {
            var35.add(c[3]);
         }

         if (var32) {
            var35.add(c[4]);
         }

         return var35;
      }

      return bbs;
   }
}
