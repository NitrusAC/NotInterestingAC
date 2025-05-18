package de.jpx3.intave.anticheat.check.clickspeed;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.BaseCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.violation.ImmutableViolation;
import de.jpx3.intave.anticheat.violation.Violation;
import org.bukkit.entity.Player;

public final class ClickSpeedCheck extends BaseCheck {
   private final int o;
   private final IntavePlugin plugin;

   public ClickSpeedCheck(IntavePlugin plugin) {
      super("ClickSpeedLimiter", "clickspeedlimiter", ClickSpeedStorage.class);
      this.plugin = plugin;
      this.o = this.b().b().a("max-cps", 8, 40, 20);
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.USE_ENTITY}
   )
   public void handleAction(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getData(var5);
      ClickSpeedStorage var7 = (ClickSpeedStorage)this.getStorage(var6);
      PacketContainer var8 = event.getPacket();
      EntityUseAction var9 = (EntityUseAction)var8.getEntityUseActions().readSafely(0);
      if (var9 == null) {
         var9 = ((WrappedEnumEntityUseAction)var8.getEnumEntityUseActions().read(0)).getAction();
      }

      if (var9 == EntityUseAction.ATTACK) {
         if (var6.getStorage().getVersionHolder().getVersionId() <= VersionHolder.V_1_8_8) {
            int var10002 = var7.f[var7.g]++;
         } else {
            var7.e.add(System.currentTimeMillis());
         }
      }

      double var10 = (double)(System.currentTimeMillis() - ClickSpeedStorage.a(var7)) / 1000.0;
      if (var10 < 1.0) {
         event.setCancelled(true);
      }

   }

   private void a(ClickSpeedStorage storage, PacketType type) {
      storage.e.clear();
      storage.h = type;
      ++storage.g;
      if (storage.g > 19) {
         storage.g = 0;
      }

      storage.f[storage.g] = 0;
      storage.a = System.currentTimeMillis();
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.FLYING, ClientPacket.LOOK, ClientPacket.POSITION, ClientPacket.POSITION_LOOK}
   )
   public void handleFlying(PacketEvent event) {
      Player var6 = event.getPlayer();
      PlayerData var7 = this.getData(var6);
      ClickSpeedStorage var8 = (ClickSpeedStorage)this.getStorage(var7);
      PacketType var9 = event.getPacketType();
      if (var7.getStorage().getVersionHolder().getVersionId() <= VersionHolder.V_1_8_8) {
         var8.d = 20;
      } else {
         BukkitEnginePlayer var10 = var7.getStorage().getPhysicsHolder();
         if (!var10.b(0) && !var8.h.name().equals("FLYING") && var8.h != Client.LOOK) {
            var8.f[var8.g] = var8.e.size();
            ++var8.d;
         } else {
            var8.d = 0;
            long var11 = System.currentTimeMillis();
            long var13 = var11 - var8.a;
            int var15 = (int)((float)var13 / 50.0F);
            int var16 = var8.g + var15;

            while(var16 > 19) {
               var16 -= 20;
            }

            while(var16 < 0) {
               var16 += 20;
            }

            var8.g = var16;

            for(int var17 = 1; var17 <= var15; ++var17) {
               int var18 = var8.g - var17;

               while(var18 > 19) {
                  var18 -= 20;
               }

               while(var18 < 0) {
                  var18 += 20;
               }

               var8.f[var18] = 0;
            }

            for(long var30 : var8.e) {
               var13 = var11 - var30;
               var15 = (int)((float)var13 / 50.0F);
               if (var15 < 20) {
                  int var20 = var8.g - var15;

                  while(var20 > 19) {
                     var20 -= 20;
                  }

                  while(var20 < 0) {
                     var20 += 20;
                  }

                  int var10002 = var8.f[var20]++;
               }
            }
         }
      }

      int var21 = 0;

      for(int var14 : var8.f) {
         var21 += var14;
      }

      if (var21 > this.o) {
         byte var23 = 1;
         if (var8.d > 20) {
            var23 = 3;
         }

         Violation var24 = Violation.builder(ClickSpeedCheck.class)
            .player(var6)
            .name("attacked too quickly")
            .description(var21 + " c/s")
            .vl((double)var23)
            .build();
         ImmutableViolation var27 = MoudleLoader.violations().dispatchViolation(var24);
         if (var27.m()) {
            ClickSpeedStorage.a(var8, System.currentTimeMillis());
         }
      }

      this.a(var8, var9);
   }
}
