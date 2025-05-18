package de.jpx3.intave.anticheat.engine.block.collidable.impl;

import com.comphenix.protocol.utility.MinecraftVersion;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.block.collidable.Collidable;
import java.util.Collections;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;

public final class SoulSandCollidable implements Collidable {
   private List materials;

   SoulSandCollidable() {
   }

   @Override
   public List getMaterials() {
      return this.materials;
   }

   @Override
   public Motion handleMotion(PlayerData data, Location from, Location to, double motionX, double motionY, double motionZ) {
      boolean var10 = this.isModernVersion(data);
      return var10 ? new Motion(motionX * 0.4, motionY, motionZ * 0.4) : null;
   }

   private boolean isModernVersion(PlayerData data) {
      VersionHolder var5 = data.getStorage().getVersionHolder();
      return var5.getVersionId() < VersionHolder.V_1_15;
   }

   @Override
   public void computeMaterial(MinecraftVersion version) {
      this.materials = Collections.singletonList(Material.SOUL_SAND);
   }
}
