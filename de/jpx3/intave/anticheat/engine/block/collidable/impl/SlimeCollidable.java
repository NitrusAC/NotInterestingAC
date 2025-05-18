package de.jpx3.intave.anticheat.engine.block.collidable.impl;

import com.comphenix.protocol.utility.MinecraftVersion;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.block.collidable.Collidable;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import java.util.Collections;
import java.util.List;
import org.bukkit.Material;

public final class SlimeCollidable implements Collidable {
   private List materials;

   @Override
   public Motion a(PlayerData var1, double var2, double var4, double var6) {
      BukkitEnginePlayer var11 = var1.getStorage().getPhysicsHolder();
      if (Math.abs(var4) < 0.1 && !var11.isSneaking) {
         double var12 = 0.4 + Math.abs(var4) * 0.2;
         var2 *= var12;
         var6 *= var12;
         return new Motion(var2, var4, var6);
      } else {
         return null;
      }
   }

   @Override
   public Motion collide(PlayerData data, double motionX, double motionY, double motionZ) {
      BukkitEnginePlayer var11 = data.getStorage().getPhysicsHolder();
      return motionY < 0.0 && !var11.isSneaking ? new Motion(motionX, -motionY, motionZ) : null;
   }

   SlimeCollidable() {
   }

   @Override
   public void onFall(PlayerData data) {
      BukkitEnginePlayer var5 = data.getStorage().getPhysicsHolder();
      if (!var5.isSneaking) {
         var5.fallDistance = 0.0F;
      }

   }

   @Override
   public void computeMaterial(MinecraftVersion version) {
      this.materials = Collections.singletonList(Material.SLIME_BLOCK);
   }

   @Override
   public List getMaterials() {
      return this.materials;
   }
}
