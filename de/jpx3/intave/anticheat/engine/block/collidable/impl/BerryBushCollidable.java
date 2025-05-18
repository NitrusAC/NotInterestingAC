package de.jpx3.intave.anticheat.engine.block.collidable.impl;

import com.comphenix.protocol.utility.MinecraftVersion;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.block.collidable.Collidable;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import java.util.Collections;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.util.Vector;

public final class BerryBushCollidable implements Collidable {
   private List materials;
   private static final String d;
   private boolean nullCache;

   @Override
   public Motion handleMotion(PlayerData data, Location from, Location to, double motionX, double motionY, double motionZ) {
      BukkitEnginePlayer var10 = data.getStorage().getPhysicsHolder();
      var10.resetFall(new Vector(0.8F, 0.75, 0.8F));
      return null;
   }

   BerryBushCollidable() {
   }

   @Override
   public List getMaterials() {
      return this.materials;
   }

   @Override
   public boolean isNullMaterial() {
      return this.nullCache;
   }

   @Override
   public void computeMaterial(MinecraftVersion version) {
      Material var4 = Material.getMaterial("SWEET_BERRY_BUSH");
      this.materials = Collections.singletonList(var4);
      this.nullCache = var4 != null;
   }
}
