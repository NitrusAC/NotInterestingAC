package de.jpx3.intave.anticheat.block.impl;

import de.jpx3.intave.anticheat.block.Block;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.unknown.Unknown121;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class SoilBlock extends Block {
   @Override
   public boolean isMaterial(Material material) {
      String var5 = material.name();
      return var5.equals("SOIL") || var5.equals("FARMLAND");
   }

   @Override
   protected Boxable getBounding(World world, Player player, int x, int y, int z, Material material, int data, Boxable box) {
      PlayerData var9 = PlayerDataManager.getPlayerData(player);
      return (Boxable)(var9.getStorage().getVersionHolder().getVersionId() > 210 ? Box.ofMerged(0.0, 0.0, 0.0, 1.0, 0.9375, 1.0) : Unknown121.b());
   }

   SoilBlock() {
      super(new Material[0]);
   }
}
