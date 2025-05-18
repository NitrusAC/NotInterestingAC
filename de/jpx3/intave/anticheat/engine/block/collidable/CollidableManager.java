package de.jpx3.intave.anticheat.engine.block.collidable;

import com.comphenix.protocol.utility.MinecraftVersion;
import de.jpx3.intave.k3;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.block.collidable.impl.BedCollidable;
import de.jpx3.intave.anticheat.engine.block.collidable.impl.BerryBushCollidable;
import de.jpx3.intave.anticheat.engine.block.collidable.impl.BubbleColumnCollidable;
import de.jpx3.intave.anticheat.engine.block.collidable.impl.HoneyCollidable;
import de.jpx3.intave.anticheat.engine.block.collidable.impl.LavaCollidable;
import de.jpx3.intave.anticheat.engine.block.collidable.impl.SlimeCollidable;
import de.jpx3.intave.anticheat.engine.block.collidable.impl.SoulSandCollidable;
import de.jpx3.intave.anticheat.engine.block.collidable.impl.WebCollidable;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Location;
import org.bukkit.Material;

public final class CollidableManager {
   private static final MinecraftVersion b = MinecraftVersion.getCurrentVersion();
   private static final Map a = new HashMap();

   private static void a(Class var0) {
      try {
         Collidable var4 = (Collidable)var0.newInstance();
         var4.computeMaterial(b);
         if (var4.isNullMaterial()) {
            for(Material var6 : var4.getMaterials()) {
               a.put(var6, var4);
            }
         }
      } catch (IllegalAccessException | InstantiationException var7) {
         var7.printStackTrace();
      }

   }

   public static void a() {
      a(BedCollidable.class);
      a(SlimeCollidable.class);
      a(WebCollidable.class);
      a(SoulSandCollidable.class);
      a(BerryBushCollidable.class);
      a(HoneyCollidable.class);
      a(WebCollidable.class);
      a(LavaCollidable.class);
      a(BubbleColumnCollidable.class);
   }

   private static Collidable a(Material var0) {
      return (Collidable)a.get(var0);
   }

   @k3
   public static Motion a(PlayerData var0, Material var1, double var2, double var4, double var6) {
      Collidable var11 = a(var1);
      return var11 != null ? var11.a(var0, var2, var4, var6) : null;
   }

   public static void a(PlayerData var0, Material var1) {
      Collidable var5 = a(var1);
      if (var5 != null) {
         var5.onFall(var0);
      }

   }

   @k3
   public static Motion a(PlayerData var0, Material var1, Location var2, Location var3, double var4, double var6, double var8) {
      Collidable var13 = a(var1);
      return var13 != null ? var13.handleMotion(var0, var2, var3, var4, var6, var8) : null;
   }

   @k3
   public static Motion b(PlayerData var0, Material var1, double var2, double var4, double var6) {
      Collidable var11 = a(var1);
      return var11 != null ? var11.collide(var0, var2, var4, var6) : null;
   }
}
