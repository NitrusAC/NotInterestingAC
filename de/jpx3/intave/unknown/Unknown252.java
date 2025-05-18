package de.jpx3.intave.unknown;

import com.comphenix.protocol.wrappers.BlockPosition;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface Unknown252 {
   Object c(Block var1);

   float a(Player var1, ItemStack var2, BlockPosition var3);

   Material b(Block var1);

   boolean a(World var1, Player var2, BlockPosition var3);

   int a(Block var1);

   @Deprecated
   Object a(int var1);
}
