package de.jpx3.intave.unknown;

import org.bukkit.Location;
import org.bukkit.World;

public final class Unknown157 implements Unknown91 {
   @Override
   public Location a(World var1) {
      return var1.getWorldBorder().getCenter();
   }

   @Override
   public double b(World var1) {
      return var1.getWorldBorder().getSize();
   }
}
