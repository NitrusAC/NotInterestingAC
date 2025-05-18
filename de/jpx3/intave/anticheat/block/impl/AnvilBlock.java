package de.jpx3.intave.anticheat.block.impl;

import de.jpx3.intave.d1;
import de.jpx3.intave.anticheat.block.Block;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.anticheat.util.nms.Direction;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class AnvilBlock extends Block {
   private static final boolean modernVersion = MinecraftVersion.V_1_14.atOrAbove();

   private Direction readDirection(int data) {
      if (modernVersion) {
         switch(data) {
            case 1:
               return Direction.Z;
            case 2:
               return Direction.X;
         }
      }

      return de.jpx3.intave.anticheat.util.Direction.parse(data & 3).get();
   }

   public AnvilBlock() {
      super(new Material[]{Material.ANVIL});
   }

   private Boxable getBoxByDirectionLegacy(Direction direction) {
      return direction == Direction.X ? Box.ofMerged(0.0, 0.0, 0.125, 1.0, 1.0, 0.875) : Box.ofMerged(0.125, 0.0, 0.0, 0.875, 1.0, 1.0);
   }

   @Override
   public Boxable getBounding(World world, Player player, int x, int y, int z, Material material, int data, Boxable box) {
      PlayerData var12 = PlayerDataManager.getPlayerData(player);
      boolean var13 = var12.getStorage().getVersionHolder().getVersionId() < VersionHolder.V_1_13;
      Direction var14 = this.readDirection(data);
      return var13 ? this.getBoxByDirectionLegacy(var14) : this.getBoxByDirectionModern(var14);
   }

   private Boxable getBoxByDirectionModern(Direction direction) {
      d1 var5 = d1.b();
      if (direction == Direction.X) {
         var5.a(2.0, 0.0, 2.0, 14.0, 4.0, 14.0);
         var5.a(3.0, 4.0, 4.0, 13.0, 5.0, 12.0);
         var5.a(4.0, 5.0, 6.0, 12.0, 10.0, 10.0);
         var5.a(0.0, 10.0, 3.0, 16.0, 16.0, 13.0);
      } else {
         var5.a(2.0, 0.0, 2.0, 14.0, 4.0, 14.0);
         var5.a(4.0, 4.0, 3.0, 12.0, 5.0, 13.0);
         var5.a(6.0, 5.0, 4.0, 10.0, 10.0, 12.0);
         var5.a(3.0, 10.0, 0.0, 13.0, 16.0, 16.0);
      }

      return var5.a();
   }
}
