package de.jpx3.intave.anticheat.engine.block.collidable.impl;

import com.comphenix.protocol.utility.MinecraftVersion;
import de.jpx3.intave.l;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.block.collidable.Collidable;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.unknown.Unknown360;
import java.util.Collections;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;

public final class BubbleColumnCollidable implements Collidable {
   private Material material;

   @Override
   public void computeMaterial(MinecraftVersion version) {
      this.material = Material.getMaterial("BUBBLE_COLUMN");
   }

   @Override
   public boolean isNullMaterial() {
      return this.material != null;
   }

   private Motion a(PlayerData var1, boolean var2, double var3, double var5, double var7) {
      BukkitEnginePlayer var12 = var1.getStorage().getPhysicsHolder();
      if (var2) {
         var5 = Math.max(-0.3, var5 - 0.03);
      } else {
         var5 = Math.min(0.7, var5 + 0.06);
      }

      var12.fallDistance = 0.0F;
      return new Motion(var3, var5, var7);
   }

   @Override
   public Motion handleMotion(PlayerData data, Location from, Location to, double motionX, double motionY, double motionZ) {
      VersionHolder var13 = data.getStorage().getVersionHolder();
      if (var13.isNewCollision()) {
         boolean var14 = Unknown360.a(data, from.clone().add(0.0, 1.0, 0.0)).c();
         l var15 = WorldUtil.a(data, from);
         boolean var16 = var15.a("drag");
         return var14 ? this.a(data, var16, motionX, motionY, motionZ) : this.a(var16, motionX, motionY, motionZ);
      } else {
         return null;
      }
   }

   private Motion a(boolean var1, double var2, double var4, double var6) {
      if (var1) {
         var4 = Math.max(-0.9, var4 - 0.03);
      } else {
         var4 = Math.min(1.8, var4 + 0.1);
      }

      return new Motion(var2, var4, var6);
   }

   @Override
   public List getMaterials() {
      return Collections.singletonList(this.material);
   }

   BubbleColumnCollidable() {
   }
}
