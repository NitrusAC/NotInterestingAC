package de.jpx3.intave.unknown;

import net.minecraft.server.v1_8_R3.EnumWorldBorderState;
import net.minecraft.server.v1_8_R3.WorldBorder;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;

@Unknown61
public final class Unknown352 implements Unknown91 {
   @Override
   public Location a(World var1) {
      return var1.getWorldBorder().getCenter();
   }

   @Unknown61
   @Override
   public double b(World var1) {
      WorldBorder var2 = ((CraftWorld)var1).getHandle().getWorldBorder();
      long var3 = var2.i();
      return var2.getState() != EnumWorldBorderState.STATIONARY && var3 <= 500L ? 0.0 : var2.getSize();
   }
}
