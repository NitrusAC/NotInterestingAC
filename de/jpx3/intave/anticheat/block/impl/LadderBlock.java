package de.jpx3.intave.anticheat.block.impl;

import de.jpx3.intave.bt;
import de.jpx3.intave.anticheat.block.Block;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.util.Direction;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.unknown.Unknown121;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class LadderBlock extends Block {
   private static final boolean modernVersion = MinecraftVersion.V_1_13.atOrAbove();

   @Override
   public Boxable getBounding(World world, Player player, int x, int y, int z, Material material, int data, Boxable box) {
      PlayerData var12 = PlayerDataManager.getPlayerData(player);
      Direction var13 = Direction.a(data);
      boolean var14 = var12.getStorage().getVersionHolder().isNewerVersion();
      if (var14) {
         return modernVersion ? box : this.a(var13);
      } else {
         return this.b(var13);
      }
   }

   // $FF: Unable to simplify switch on enum
   // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private Boxable b(Direction var1) {
      switch(bt.a[var1.ordinal()]) {
         case 1:
            return Box.ofMerged(0.0, 0.0, 0.875, 1.0, 1.0, 1.0);
         case 2:
            return Box.ofMerged(0.0, 0.0, 0.0, 1.0, 1.0, 0.125);
         case 3:
            return Box.ofMerged(0.875, 0.0, 0.0, 1.0, 1.0, 1.0);
         case 4:
            return Box.ofMerged(0.0, 0.0, 0.0, 0.125, 1.0, 1.0);
         default:
            return Unknown121.a();
      }
   }

   public LadderBlock() {
      super(new Material[]{Material.LADDER});
   }

   // $FF: Unable to simplify switch on enum
   // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private Boxable a(Direction var1) {
      switch(bt.a[var1.ordinal()]) {
         case 1:
            return Box.ofMerged(0.0, 0.0, 0.8125, 1.0, 1.0, 1.0);
         case 2:
            return Box.ofMerged(0.0, 0.0, 0.0, 1.0, 1.0, 0.1875);
         case 3:
            return Box.ofMerged(0.8125, 0.0, 0.0, 1.0, 1.0, 1.0);
         case 4:
            return Box.ofMerged(0.0, 0.0, 0.0, 0.1875, 1.0, 1.0);
         default:
            return Unknown121.a();
      }
   }
}
