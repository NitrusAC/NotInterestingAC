package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.util.WorldUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.CraftChunk;
import org.bukkit.craftbukkit.v1_8_R3.block.CraftBlock;

@Unknown61
public class Unknown153 extends CraftBlock {
   private final PlayerData b;
   private final Location a = this.getLocation();

   @Unknown61
   @Unknown213
   public Unknown153(PlayerData var1, CraftChunk var2, int var3, int var4, int var5) {
      super(var2, var3, var4, var5);
      this.b = var1;
   }

   public Material getType() {
      return WorldUtil.getMaterialAt(this.b, this.a);
   }
}
