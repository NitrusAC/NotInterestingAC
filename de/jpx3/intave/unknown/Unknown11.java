package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.block.BlockManager;
import de.jpx3.intave.anticheat.engine.interact.Interactable;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

final class Unknown11 implements Interactable {
   private final Interactable a;

   public Unknown11(Interactable var1) {
      this.a = var1;
   }

   @Override
   public void a(Material var1) {
      this.a.a(var1);
   }

   @Override
   public Boxable interact(World var1, Player var2, Material var3, int var4, int var5, int var6, int var7) {
      Boxable var8 = this.a.interact(var1, var2, var3, var4, var5, var6, var7);
      return var2 == null ? var8 : BlockManager.getBounding(var1, var2, var5, var6, var7, var3, var4, var8);
   }
}
