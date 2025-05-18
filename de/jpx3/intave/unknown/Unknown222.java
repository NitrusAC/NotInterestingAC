package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.unknown.HitboxSize;
import net.minecraft.server.v1_8_R3.Entity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;

@Unknown61
public final class Unknown222 implements Unknown146 {
   @Unknown61
   @Override
   public HitboxSize a(Object var1) {
      Entity var2 = (Entity)var1;
      return HitboxSize.of(var2.width, var2.length);
   }

   @Unknown61
   @Override
   public HitboxSize a(org.bukkit.entity.Entity var1) {
      Entity var2 = ((CraftEntity)var1).getHandle();
      return HitboxSize.of(var2.width, var2.length);
   }
}
