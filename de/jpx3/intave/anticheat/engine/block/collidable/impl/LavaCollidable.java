package de.jpx3.intave.anticheat.engine.block.collidable.impl;

import com.comphenix.protocol.utility.MinecraftVersion;
import com.google.common.collect.ImmutableList;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.block.collidable.Collidable;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.unknown.Unknown105;
import de.jpx3.intave.unknown.Unknown360;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;

public final class LavaCollidable implements Collidable {
   private static final String c;
   private List materials;

   LavaCollidable() {
   }

   @Override
   public Motion handleMotion(PlayerData data, Location from, Location to, double motionX, double motionY, double motionZ) {
      VersionHolder var10 = data.getStorage().getVersionHolder();
      if (var10.isNewCollision()) {
         BukkitEnginePlayer var11 = data.getStorage().getPhysicsHolder();
         Unknown105 var12 = Unknown360.a(data, from);
         if (var12.a()) {
            var11.ap = true;
         }
      }

      return null;
   }

   @Override
   public void computeMaterial(MinecraftVersion version) {
      ArrayList var5 = new ArrayList();
      Material var6 = Material.getMaterial("STATIONARY_LAVA");
      if (var6 != null) {
         var5.add(var6);
      }

      var5.add(Material.LAVA);
      this.materials = ImmutableList.copyOf(var5);
   }

   @Override
   public List getMaterials() {
      return this.materials;
   }
}
