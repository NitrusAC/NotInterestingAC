package de.jpx3.intave.anticheat.engine.interact;

import de.jpx3.intave.anticheat.util.collision.Boxable;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public interface Interactable {
   default void a(Material var1) {
   }

   Boxable interact(World var1, Player var2, Material var3, int var4, int var5, int var6, int var7);
}
