package de.jpx3.intave.anticheat.engine.block.collidable;

import com.comphenix.protocol.utility.MinecraftVersion;
import de.jpx3.intave.k3;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.Motion;
import java.util.List;
import org.bukkit.Location;

public interface Collidable {
   default void onFall(PlayerData data) {
   }

   void computeMaterial(MinecraftVersion version);

   @k3
   default Motion handleMotion(PlayerData data, Location from, Location to, double motionX, double motionY, double motionZ) {
      return null;
   }

   List getMaterials();

   @k3
   default Motion collide(PlayerData data, double motionX, double motionY, double motionZ) {
      return null;
   }

   default boolean isNullMaterial() {
      return true;
   }

   @k3
   default Motion a(PlayerData data, double var2, double var4, double var6) {
      return null;
   }
}
