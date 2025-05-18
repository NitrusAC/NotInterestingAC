package de.jpx3.intave.anticheat.block;

import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.unknown.Unknown121;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public abstract class Block {
   private final Material[] materials;

   protected Block(Material[] materials) {
      this.materials = materials;
   }

   private static boolean isMaterial(Material var0, Material var1) {
      return var1 == var0;
   }

   @Deprecated
   protected List _getBounding(World world, Player player, int x, int y, int z, Material material, int data, List bbs) {
      return bbs;
   }

   protected boolean a() {
      return false;
   }

   protected Boxable getBounding(World world, Player player, int x, int y, int z, Material material, int data, Boxable box) {
      List var12 = box.b();
      List var13 = this._getBounding(world, player, x, y, z, material, data, var12);
      return var12.equals(var13) ? box : Unknown121.c(var13);
   }

   public boolean isMaterial(Material material) {
      return Arrays.stream(this.materials).anyMatch(Block::isMaterial);
   }
}
