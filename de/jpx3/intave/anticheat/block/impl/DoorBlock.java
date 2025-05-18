package de.jpx3.intave.anticheat.block.impl;

import de.jpx3.intave.j6;
import de.jpx3.intave.l;
import de.jpx3.intave.anticheat.block.Block;
import de.jpx3.intave.anticheat.block.IntaveMaterial;
import de.jpx3.intave.anticheat.util.collision.BoundingBoxBuilder;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.unknown.Unknown129;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class DoorBlock extends Block {
   public DoorBlock() {
      super(new Material[]{IntaveMaterial.TRAP_DOOR});
   }

   @Override
   public Boxable getBounding(World world, Player player, int x, int y, int z, Material material, int data, Boxable box) {
      BoundingBoxBuilder var12 = BoundingBoxBuilder.of();
      l var13 = Unknown129.b(material, data);
      boolean var14 = var13.a(j6.class, "half") == j6.a;
      boolean var15 = var13.a("open");
      if (var15) {
         switch(data & 3) {
            case 0:
               var12.bounds(0.0F, 0.0F, 0.8125F, 1.0F, 1.0F, 1.0F);
               break;
            case 1:
               var12.bounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1875F);
               break;
            case 2:
               var12.bounds(0.8125F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
               break;
            case 3:
               var12.bounds(0.0F, 0.0F, 0.0F, 0.1875F, 1.0F, 1.0F);
         }
      } else if (var14) {
         var12.bounds(0.0F, 0.8125F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         var12.bounds(0.0F, 0.0F, 0.0F, 1.0F, 0.1875F, 1.0F);
      }

      return var12.create();
   }
}
