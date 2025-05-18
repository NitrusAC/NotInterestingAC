package de.jpx3.intave.unknown;

import de.jpx3.intave.access.player.event.BucketAction;
import de.jpx3.intave.anticheat.IntavePlugin;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class Unknown268 {
   private static Unknown174 d;
   private static Unknown388 c;
   private static Unknown192 e;

   public static boolean a(Player var0, Block var1) {
      return d.a(var0, var1);
   }

   public static void a() {
      IntavePlugin var3 = IntavePlugin.getInstance();
      c = new Unknown272(var3);
      d = new Unknown310(var3);
      e = new Unknown386(var3);
   }

   public static boolean a(Player var0, BucketAction var1, Block var2, BlockFace var3, Material var4, ItemStack var5) {
      return e.a(var0, var1, var2, var3, var4, var5);
   }

   public static boolean a(Player var0, World var1, boolean var2, int var3, int var4, int var5, int var6, Material var7, int var8) {
      return c.a(var0, var1, var2, var3, var4, var5, var6, var7, var8);
   }
}
