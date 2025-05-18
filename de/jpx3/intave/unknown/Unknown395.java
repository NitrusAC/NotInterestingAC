package de.jpx3.intave.unknown;

import com.comphenix.protocol.wrappers.BlockPosition;
import net.minecraft.server.v1_8_R3.Chunk;
import net.minecraft.server.v1_8_R3.WorldServer;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Unknown61
public final class Unknown395 implements Unknown252 {
   @Unknown61
   @Override
   public Object c(Block var1) {
      Material var2 = var1.getType();
      byte var3 = var1.getData();
      return net.minecraft.server.v1_8_R3.Block.getByCombinedId(var2.getId() | (var3 & 15) << 12);
   }

   @Override
   public int a(Block var1) {
      return var1.getData();
   }

   @Override
   public Material b(Block var1) {
      return var1.getType();
   }

   @Unknown61
   @Override
   public Object a(int var1) {
      return net.minecraft.server.v1_8_R3.Block.getById(var1);
   }

   @Unknown61
   @Override
   public boolean a(World var1, Player var2, BlockPosition var3) {
      WorldServer var4 = ((CraftWorld)var1).getHandle();
      Chunk var5 = var4.getChunkIfLoaded(var3.getX() >> 4, var3.getZ() >> 4);
      if (var5 == null) {
         return false;
      } else {
         net.minecraft.server.v1_8_R3.BlockPosition var6 = new net.minecraft.server.v1_8_R3.BlockPosition(var3.getX(), var3.getY(), var3.getZ());
         return var5.getBlockData(var6).getBlock().a(var4, var6);
      }
   }

   @Unknown61
   @Override
   public float a(Player var1, ItemStack var2, BlockPosition var3) {
      WorldServer var4 = ((CraftWorld)var1.getWorld()).getHandle();
      Chunk var5 = var4.getChunkIfLoaded(var3.getX() >> 4, var3.getZ() >> 4);
      if (var5 == null) {
         return 0.0F;
      } else {
         net.minecraft.server.v1_8_R3.BlockPosition var6 = new net.minecraft.server.v1_8_R3.BlockPosition(var3.getX(), var3.getY(), var3.getZ());
         return var5.getBlockData(var6).getBlock().getDamage(((CraftPlayer)var1).getHandle(), var4, var6);
      }
   }
}
