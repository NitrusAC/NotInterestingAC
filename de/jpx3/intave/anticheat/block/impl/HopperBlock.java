package de.jpx3.intave.anticheat.block.impl;

import com.comphenix.protocol.utility.MinecraftVersion;
import de.jpx3.intave.gd;
import de.jpx3.intave.l;
import de.jpx3.intave.anticheat.block.Block;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.util.Direction;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.unknown.Unknown121;
import de.jpx3.intave.unknown.Unknown129;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class HopperBlock extends Block {
   private static final Boxable g = Box.of(4.0, 4.0, 4.0, 12.0, 10.0, 12.0);
   private static final Boxable f = Box.of(2.0, 11.0, 14.0, 16.0, 16.0, 16.0);
   private static final Boxable e = Unknown121.a(HopperBlock.k, Box.of(0.0, 4.0, 6.0, 4.0, 8.0, 10.0));
   private static final Boxable j = Box.of(2.0, 11.0, 0.0, 16.0, 16.0, 2.0);
   private static final Boxable o = Box.of(0.0, 10.0, 0.0, 16.0, 11.0, 16.0);
   private static final Boxable i = Box.of(14.0, 11.0, 2.0, 16.0, 16.0, 14.0);
   private static final Boxable b = Box.of(0.0, 11.0, 0.0, 2.0, 16.0, 16.0);
   private static final Boxable c = Unknown121.a(HopperBlock.k, Box.of(6.0, 4.0, 0.0, 10.0, 8.0, 4.0));
   private static final Boxable d = Unknown121.a(new Boxable[]{b, j, f, i});
   private static final Boxable p = Unknown121.a(HopperBlock.k, Box.of(6.0, 4.0, 12.0, 10.0, 8.0, 16.0));
   private static final float m = 2.0F;
   private static final Boxable l = Unknown121.a(d, Box.of(0.0, 0.0, 0.0, 16.0, 10.0, 16.0));
   private static final Boxable k = Unknown121.a(new Boxable[]{d, o, g});
   private static final Boxable n = Unknown121.a(k, Box.of(12.0, 4.0, 6.0, 16.0, 8.0, 10.0));
   private static final float h = 5.0F;
   private static final Boxable q = Unknown121.a(k, Box.of(6.0, 0.0, 6.0, 10.0, 4.0, 10.0));

   @Override
   public boolean isMaterial(Material material) {
      return material.name().contains("HOPPER");
   }

   private Direction a(int var1) {
      l var4 = Unknown129.b(Material.HOPPER, var1);
      return (Direction)var4.a(Direction.class, "facing");
   }

   HopperBlock() {
      super(new Material[0]);
   }

   // $FF: Unable to simplify switch on enum
   // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   protected Boxable getBounding(World world, Player player, int x, int y, int z, Material material, int data, Boxable box) {
      PlayerData var12 = PlayerDataManager.getPlayerData(player);
      if (var12.getStorage().getVersionHolder().getVersionId() >= VersionHolder.V_1_13) {
         if (MinecraftVersion.AQUATIC_UPDATE.atOrAbove()) {
            return box;
         } else {
            Direction var14 = this.a(data);
            Boxable var13;
            switch(gd.a[var14.ordinal()]) {
               case 1:
                  var13 = q;
                  break;
               case 2:
                  var13 = n;
                  break;
               case 3:
                  var13 = p;
                  break;
               case 4:
                  var13 = e;
                  break;
               case 5:
                  var13 = c;
                  break;
               default:
                  var13 = k;
            }

            return var13;
         }
      } else {
         return MinecraftVersion.AQUATIC_UPDATE.atOrAbove() ? l : box;
      }
   }
}
