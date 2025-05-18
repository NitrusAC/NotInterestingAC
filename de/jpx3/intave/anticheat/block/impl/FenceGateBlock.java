package de.jpx3.intave.anticheat.block.impl;

import de.jpx3.intave.anticheat.block.Block;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class FenceGateBlock extends Block {
   private static final String b;

   @Override
   public boolean isMaterial(Material material) {
      return material.name().contains("FENCE_GATE");
   }

   @Override
   public Boxable getBounding(World world, Player player, int x, int y, int z, Material material, int data, Boxable box) {
      return box;
   }

   FenceGateBlock() {
      super(new Material[0]);
   }
}
