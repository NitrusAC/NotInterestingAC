package de.jpx3.intave.anticheat.engine.block.collidable.impl;

import com.comphenix.protocol.utility.MinecraftVersion;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.block.collidable.Collidable;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.bukkit.Material;

public final class BedCollidable implements Collidable {
   private List materials;

   private boolean isMaterial(Material material) {
      return material.name().toLowerCase().contains("bed") && material != Material.BEDROCK;
   }

   private List getCompatibleMaterials() {
      return (List)Arrays.stream(Material.values()).filter(this::isMaterial).collect(Collectors.toList());
   }

   @Override
   public Motion collide(PlayerData data, double motionX, double motionY, double motionZ) {
      PlayerStorage var11 = data.getStorage();
      BukkitEnginePlayer var12 = var11.getPhysicsHolder();
      VersionHolder var13 = var11.getVersionHolder();
      if (var13.getVersionId() < VersionHolder.V_1_12) {
         return null;
      } else {
         if (motionY < 0.0) {
            motionY = -motionY * 0.66F;
         }

         return var12.isSneaking ? null : new Motion(motionX, motionY, motionZ);
      }
   }

   @Override
   public List getMaterials() {
      return this.materials;
   }

   @Override
   public void computeMaterial(MinecraftVersion version) {
      if (version.isAtLeast(de.jpx3.intave.anticheat.util.MinecraftVersion.V_1_12)) {
         this.materials = this.getCompatibleMaterials();
      } else {
         this.materials = Collections.singletonList(Material.getMaterial("BED_BLOCK"));
      }

   }

   BedCollidable() {
   }
}
