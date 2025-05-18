package de.jpx3.intave.anticheat.engine.block.collidable.impl;

import com.comphenix.protocol.utility.MinecraftVersion;
import de.jpx3.intave.anticheat.block.IntaveMaterial;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.block.collidable.Collidable;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import java.util.Collections;
import java.util.List;
import org.bukkit.Location;

public final class WebCollidable implements Collidable {
   private List materials;

   @Override
   public void computeMaterial(MinecraftVersion version) {
      this.materials = Collections.singletonList(IntaveMaterial.WEB);
   }

   WebCollidable() {
   }

   @Override
   public List getMaterials() {
      return this.materials;
   }

   @Override
   public Motion handleMotion(PlayerData data, Location from, Location to, double motionX, double motionY, double motionZ) {
      VersionHolder var10 = data.getStorage().getVersionHolder();
      BukkitEnginePlayer var11 = data.getStorage().getPhysicsHolder();
      var11.inWeb = true;
      var11.fallDistance = 0.0F;
      return var10.getVersionId() >= VersionHolder.V_1_15 ? new Motion(motionX * 0.25, motionY * 0.05F, motionZ * 0.25) : null;
   }
}
