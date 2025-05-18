package de.jpx3.intave.anticheat.world;

import de.jpx3.intave.anticheat.util.collision.Boxable;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public interface IntaveWorld {
   @NotNull
   Material getMaterialAt(int x, int y, int z);

   int a(int x, int y, int z);

   @NotNull
   Boxable getBox(int x, int y, int z);
}
