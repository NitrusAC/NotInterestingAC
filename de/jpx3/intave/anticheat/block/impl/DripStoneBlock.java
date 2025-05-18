package de.jpx3.intave.anticheat.block.impl;

import de.jpx3.intave.fL;
import de.jpx3.intave.l;
import de.jpx3.intave.lM;
import de.jpx3.intave.anticheat.block.Block;
import de.jpx3.intave.anticheat.util.Direction;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.unknown.Unknown129;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class DripStoneBlock extends Block {
   private final Box d = Box.of(5.0, 0.0, 5.0, 11.0, 16.0, 11.0);
   private final Box f;
   private final Box g = Box.of(5.0, 0.0, 5.0, 11.0, 11.0, 11.0);
   private final Box c;
   private final Box h;
   private final Box b = Box.of(5.0, 5.0, 5.0, 11.0, 16.0, 11.0);
   private final Box e = Box.of(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);

   DripStoneBlock() {
      super(new Material[0]);
      this.h = Box.of(3.0, 0.0, 3.0, 13.0, 16.0, 13.0);
      this.f = Box.of(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);
      this.c = Box.of(6.0, 0.0, 6.0, 10.0, 16.0, 10.0);
   }

   // $FF: Unable to simplify switch on enum
   // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public Boxable getBounding(World world, Player player, int x, int y, int z, Material material, int data, Boxable box) {
      Box var16;
      l var13 = Unknown129.b(material, data);
      fL var14 = (fL)var13.a(fL.class, "thickness");
      Direction var15 = (Direction)var13.a(Direction.class, "vertical_direction");
      label16:
      switch(lM.a[var14.ordinal()]) {
         case 1:
            var16 = this.d;
            break;
         case 2:
            switch(lM.b[var15.ordinal()]) {
               case 1:
                  var16 = this.g;
                  break label16;
               case 2:
                  var16 = this.b;
                  break label16;
               default:
                  throw new IllegalStateException("Unexpected vertical direction: " + var15);
            }
         case 3:
            var16 = this.h;
            break;
         case 4:
            var16 = this.e;
            break;
         case 5:
            var16 = this.f;
            break;
         default:
            var16 = this.c;
      }

      float var17 = 0.125F;
      long var18 = MathUtil.a(x, 0, z);
      double var20 = MathUtil2.clamp((double)(-var17), ((double)((float)(var18 & 15L) / 15.0F) - 0.5) * 0.5, (double)var17);
      double var22 = MathUtil2.clamp((double)(-var17), ((double)((float)(var18 >> 8 & 15L) / 15.0F) - 0.5) * 0.5, (double)var17);
      double var24 = 0.0;
      Box var26 = var16.add(var20, var24, var22);
      var26.a();
      return var26;
   }

   @Override
   public boolean isMaterial(Material material) {
      return material.name().endsWith("_DRIPSTONE");
   }
}
