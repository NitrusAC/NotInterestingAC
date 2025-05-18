package de.jpx3.intave.anticheat.block.impl;

import de.jpx3.intave.anticheat.block.Block;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class WaterLilyBlock extends Block {
   private static final String c;

   @Override
   public boolean isMaterial(Material material) {
      String var4 = material.name();
      return var4.contains("WATER_LILY");
   }

   @Override
   public Boxable getBounding(World world, Player player, int x, int y, int z, Material material, int data, Boxable box) {
      PlayerData var9 = PlayerDataManager.getPlayerData(player);
      if (var9.getStorage().getVersionHolder().isNewerVersion()) {
         return Box.ofMerged(0.0625, 0.0, 0.0625, 0.9375, 0.09375, 0.9375);
      } else {
         float var10 = 0.5F;
         float var11 = 0.015625F;
         return Box.ofMerged((double)(0.5F - var10), 0.0, (double)(0.5F - var10), (double)(0.5F + var10), (double)var11, (double)(0.5F + var10));
      }
   }

   WaterLilyBlock() {
      super(new Material[0]);
   }
}
