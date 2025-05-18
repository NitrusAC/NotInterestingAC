package de.jpx3.intave.anticheat.engine.block.height.impl;

import com.comphenix.protocol.wrappers.BlockPosition;
import de.jpx3.intave.l8;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.block.height.Heightable;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import org.bukkit.Material;

public final class ShulkerHeightable extends Heightable {
   private static final String d;

   @Override
   public boolean isMaterial(Material material) {
      return material.name().contains("SHULKER_BOX");
   }

   @Override
   public Boxable collide(PlayerData data, Box box, int x, int y, int z, Boxable boxable) {
      BlockPosition var11 = new BlockPosition(x, y, z);
      l8 var12 = (l8)data.getStorage().getPhysicsHolder().a8.get(var11);
      return var12 != null ? var12.a().b(x, y, z) : boxable;
   }
}
