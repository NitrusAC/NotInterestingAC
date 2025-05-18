package de.jpx3.intave.unknown.check;

import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.packet.wrap.EntityPacketReader;
import de.jpx3.intave.anticheat.packet.wrap.PacketInterpreters;
import de.jpx3.intave.unknown.Unknown254;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public final class Check5 extends Unknown254 {
   private static final String g;
   private final IntavePlugin d;

   @Override
   protected boolean c() {
      return false;
   }

   private void a(WrappedDataWatcher var1) {
      if (var1 != null && var1.getObject(6) != null && var1.getFloat(6) != 0.0F) {
         var1.setObject(6, Float.NaN);
      }

   }

   public Check5(IntavePlugin var1) {
      super("health");
      this.d = var1;
   }

   @PacketListener(
      g = {ServerPacket.ENTITY_METADATA}
   )
   public void a(PacketEvent var1) {
      if (this.c()) {
         try {
            if (var1.getPacket().getIntegers().getValues().isEmpty()) {
               return;
            }

            PacketContainer var5 = var1.getPacket();
            EntityPacketReader var6 = (EntityPacketReader)PacketInterpreters.getInterpreter(var5);
            Entity var7 = var6.getEntity(var1);
            var6.reset();
            if (var7 == null) {
               return;
            }

            if (var7 instanceof LivingEntity && var7.getUniqueId() != var1.getPlayer().getUniqueId() && var5.getWatchableCollectionModifier().read(0) != null) {
               var5 = var5.deepClone();
               var1.setPacket(var5);
               if (var1.getPacket().getType() == Server.ENTITY_METADATA) {
                  WrappedDataWatcher var8 = new WrappedDataWatcher((List)var5.getWatchableCollectionModifier().read(0));
                  this.a(var8);
                  var5.getWatchableCollectionModifier().write(0, var8.getWatchableObjects());
               }
            }
         } catch (Exception var9) {
         }

      }
   }
}
