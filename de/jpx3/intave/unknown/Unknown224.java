package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import java.util.ArrayList;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.IBlockData;
import net.minecraft.server.v1_8_R3.WorldServer;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.Player;

@Unknown61
public final class Unknown224 extends Unknown223 {
   private static final Unknown188 a = new Unknown188();

   @Unknown61
   @Override
   public Boxable interact(World var1, Player var2, Material var3, int var4, int var5, int var6, int var7) {
      BlockPosition var8 = new BlockPosition(var5, var6, var7);
      IBlockData var9 = (IBlockData)Unknown129.a(var3, var4);
      if (var9 == null) {
         return Unknown121.a();
      } else {
         ArrayList var10 = new ArrayList();
         WorldServer var11 = ((CraftWorld)var1).getHandle();

         try {
            var9.getBlock().a(var11, var8, var9, a, var10, null);
            return this.a(var10);
         } catch (IllegalArgumentException var13) {
            return Box.ofMerged(0.25, 0.25, 0.25, 0.75, 0.75, 0.75).b(var5, var6, var7);
         }
      }
   }
}
