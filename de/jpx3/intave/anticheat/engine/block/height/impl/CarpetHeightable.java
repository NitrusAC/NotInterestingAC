package de.jpx3.intave.anticheat.engine.block.height.impl;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.block.height.Heightable;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.unknown.Unknown121;
import java.util.EnumSet;
import org.bukkit.Material;

public final class CarpetHeightable extends Heightable {
   private static final String g;
   private static final Boxable e = Box.of(0.0, -1.0, 0.0, 16.0, 0.0, 16.0);
   private final EnumSet c = EnumSet.noneOf(Material.class);
   private static final Boxable d = Box.of(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);

   @Override
   public boolean isMaterial(Material material) {
      boolean var5 = material.name().contains("CARPET");
      if (var5) {
         this.c.add(material);
      }

      return var5;
   }

   @Override
   public Boxable collide(PlayerData data, Box box, int x, int y, int z, Boxable boxable) {
      if (data.getStorage().getVersionHolder().getVersionId() <= 5) {
         Material var10 = WorldUtil.getMaterialAt(data, x, y - 1, z);
         boolean var11 = this.c.contains(var10);
         if (var11) {
            return e.b(x, y, z);
         } else {
            return box.maxY <= (double)y + 0.1 ? d.b(x, y, z) : Unknown121.a();
         }
      } else {
         return boxable;
      }
   }
}
