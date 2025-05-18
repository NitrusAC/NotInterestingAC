package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.engine.world.IntaveWorld;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.anticheat.world.IntaveWorldBlock;
import java.util.Collections;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

public final class Unknown204 implements IntaveWorld {
   @Override
   public void c(int var1, int var2, int var3) {
   }

   @Override
   public void a(World var1, int var2, int var3, int var4, Material var5, int var6) {
   }

   @NotNull
   @Override
   public Boxable getBox(int x, int y, int z) {
      return Unknown121.a();
   }

   @Override
   public Map a() {
      return Collections.emptyMap();
   }

   @Override
   public void b() {
   }

   @Override
   public void a() {
   }

   @Override
   public IntaveWorldBlock d(int var1, int var2, int var3) {
      return null;
   }

   @Override
   public void a(int var1, int var2, int var3) {
   }

   @Override
   public Map b() {
      return Collections.emptyMap();
   }

   @Override
   public int a(int var1, int var2, int var3) {
      return 0;
   }

   @Override
   public void a(int var1, int var2, int var3, int var4) {
   }

   @NotNull
   @Override
   public Material getMaterialAt(int x, int y, int z) {
      return Material.AIR;
   }

   @Override
   public boolean e(int var1, int var2, int var3) {
      return false;
   }
}
