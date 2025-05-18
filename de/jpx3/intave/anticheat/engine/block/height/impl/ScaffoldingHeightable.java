package de.jpx3.intave.anticheat.engine.block.height.impl;

import de.jpx3.intave.l;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.block.height.Heightable;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.unknown.Unknown121;
import de.jpx3.intave.unknown.Unknown94;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public final class ScaffoldingHeightable extends Heightable {
   private boolean a(PlayerData var1, World var2, int var3, int var4, int var5) {
      Block var9 = WorldUtil.getBlockAt(var2, var3, var4, var5);
      if (var9.getY() < Unknown94.d) {
         return false;
      } else {
         l var10 = WorldUtil.c(var1, var2, var3, var4, var5);
         int var11 = var10.a("distance");
         boolean var12 = var10.a("bottom");
         return var12 && var11 != 0;
      }
   }

   private boolean a(PlayerData var1, double var2) {
      BukkitEnginePlayer var7 = var1.getStorage().getPhysicsHolder();
      return var7.y >= var2 + 1.0 - 1.0E-5F;
   }

   @Override
   public Boxable collide(PlayerData data, Box box, int x, int y, int z, Boxable boxable) {
      if (this.a(data, (double)y)) {
         double var10 = 0.875;
         double var12 = 1.0;
         return Box.ofDouble((double)x, (double)y + var10, (double)z, (double)(x + 1), (double)y + var12, (double)(z + 1));
      } else {
         return (Boxable)(this.a(data, data.getPlayer().getWorld(), x, y, z) && this.a(data, (double)(y - 1))
            ? Box.ofDouble((double)x, (double)y, (double)z, (double)x + 1.0, (double)y + 0.125, (double)z + 1.0)
            : Unknown121.a());
      }
   }

   @Override
   public boolean isMaterial(Material material) {
      String var4 = material.name();
      return var4.contains("SCAFFOLDING");
   }
}
