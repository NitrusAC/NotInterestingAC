package de.jpx3.intave.anticheat.block.impl;

import de.jpx3.intave.anticheat.block.Block;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.unknown.Unknown121;
import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class PortalFrameBlock extends Block {
   private final Box modernBounds;
   private static final String f;
   private final Box legacyBounds;
   private final Box baseBounds = Box.of(0.0, 0.0, 0.0, 16.0, 13.0, 16.0);

   PortalFrameBlock() {
      super(new Material[0]);
      this.legacyBounds = Box.of(5.0, 13.0, 5.0, 11.0, 16.0, 11.0);
      this.modernBounds = Box.of(4.0, 13.0, 4.0, 12.0, 16.0, 12.0);
   }

   @Override
   protected Boxable getBounding(World world, Player player, int x, int y, int z, Material material, int data, Boxable box) {
      ArrayList var12 = new ArrayList();
      var12.add(this.baseBounds);
      if ((data & 4) != 0) {
         PlayerData var13 = PlayerDataManager.getPlayerData(player);
         if (var13.getStorage().getVersionHolder().isNewCollision()) {
            var12.add(this.modernBounds);
         } else {
            var12.add(this.legacyBounds);
         }
      }

      return Unknown121.c(var12);
   }

   @Override
   public boolean isMaterial(Material material) {
      return material.name().endsWith("PORTAL_FRAME");
   }
}
