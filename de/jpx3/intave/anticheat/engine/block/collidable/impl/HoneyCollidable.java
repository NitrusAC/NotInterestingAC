package de.jpx3.intave.anticheat.engine.block.collidable.impl;

import com.comphenix.protocol.utility.MinecraftVersion;
import com.google.common.collect.ImmutableList;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.block.collidable.Collidable;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;

public final class HoneyCollidable implements Collidable {
   private Material material;
   private static final String c;

   HoneyCollidable() {
   }

   private Motion c(PlayerData var1, double var2, double var4, double var6) {
      BukkitEnginePlayer var11 = var1.getStorage().getPhysicsHolder();
      var11.fallDistance = 0.0F;
      if (var4 < -0.13) {
         double var12 = -0.05 / var4;
         return new Motion(var2 * var12, -0.05, var6 * var12);
      } else {
         return new Motion(var2, -0.05, var6);
      }
   }

   @Override
   public List getMaterials() {
      return ImmutableList.of(this.material);
   }

   @Override
   public Motion handleMotion(PlayerData data, Location from, Location to, double motionX, double motionY, double motionZ) {
      return this.a(data, from, motionY) ? this.c(data, motionX, motionY, motionZ) : null;
   }

   private boolean a(PlayerData var1, Location var2, double var3) {
      BukkitEnginePlayer var8 = var1.getStorage().getPhysicsHolder();
      if (var8.contextGround) {
         return false;
      } else if (var8.y > var2.getY() + 0.9375 - 1.0E-7) {
         return false;
      } else if (var3 >= -0.08) {
         return false;
      } else {
         double var9 = Math.abs(var2.getX() + 0.5 - var8.x);
         double var11 = Math.abs(var2.getZ() + 0.5 - var8.z);
         double var13 = 0.4375 + (double)(var8.jumpStep / 2.0F);
         return var9 + 1.0E-7 > var13 || var11 + 1.0E-7 > var13;
      }
   }

   @Override
   public boolean isNullMaterial() {
      return this.material != null;
   }

   @Override
   public void computeMaterial(MinecraftVersion version) {
      this.material = Material.getMaterial("HONEY_BLOCK");
   }
}
