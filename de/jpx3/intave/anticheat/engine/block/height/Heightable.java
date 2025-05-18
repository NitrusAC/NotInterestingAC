package de.jpx3.intave.anticheat.engine.block.height;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import java.util.Arrays;
import org.bukkit.Material;

public abstract class Heightable {
   private Material[] a;

   public boolean isMaterial(Material material) {
      return Arrays.asList(this.a).contains(material);
   }

   protected Heightable() {
   }

   protected Heightable(Material[] var1) {
      this.a = var1;
   }

   public abstract Boxable collide(PlayerData data, Box box, int x, int y, int z, Boxable boxable);
}
