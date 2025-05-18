package de.jpx3.intave.anticheat.packet.wrap;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.reflection.WorldReflection;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.Nullable;

public class EntityPacketReader extends AbstractPacketReader {
   @Nullable
   public Entity getEntity(PacketEvent event) {
      return this.getEntity(event.getPlayer().getWorld());
   }

   public int getEntityId() {
      return this.getPacket().getIntegers().read(0);
   }

   @Nullable
   public Entity getEntity(World world) {
      int var2 = this.getPacket().getIntegers().read(0);
      return WorldReflection.getEntityFromWorld(world, var2);
   }
}
