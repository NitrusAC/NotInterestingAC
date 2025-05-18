package de.jpx3.intave.anticheat.block.impl;

import de.jpx3.intave.anticheat.block.Block;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class BambooBlock extends Block {
   private static final Box coreBox = Box.of(6.5, 0.0, 6.5, 9.5, 16.0, 9.5);
   private static final Boxable[][] c = new Boxable[16][16];
   private static final String e;

   @Override
   public Boxable getBounding(World world, Player player, int x, int y, int z, Material material, int data, Boxable box) {
      if (box.a()) {
         return box;
      } else {
         long var12 = MathUtil.a(x, 0, z);
         int var14 = (int)(var12 & 15L);
         int var15 = (int)(var12 >> 8 & 15L);
         Boxable var16 = c[var14][var15];
         if (var16 == null) {
            double var17 = ((double)((float)var14 / 15.0F) - 0.5) * 0.5;
            double var19 = ((double)((float)var15 / 15.0F) - 0.5) * 0.5;
            double var21 = 0.0;
            var16 = c[var14][var15] = coreBox.add(var17, var21, var19);
         }

         return var16;
      }
   }

   BambooBlock() {
      super(new Material[0]);
   }

   @Override
   public boolean isMaterial(Material material) {
      String var4 = material.name();
      return var4.contains("BAMBOO");
   }
}
