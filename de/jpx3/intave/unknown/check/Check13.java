package de.jpx3.intave.unknown.check;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.eQ;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactor;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.check.timer.TimerCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.unknown.Unknown171;
import de.jpx3.intave.unknown.Unknown354;
import de.jpx3.intave.unknown.Unknown394;
import de.jpx3.intave.unknown.unknown79;
import java.lang.reflect.InvocationTargetException;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.DelayQueue;
import org.bukkit.entity.Player;

public final class Check13 extends UnknownCheck {
   private boolean e;
   private boolean a;

   private long a(PlayerData var1) {
      unknown79 var5 = var1.getStorage().c();
      Map var6 = var5.m();
      long var7 = System.currentTimeMillis();

      for(Unknown171 var10 : var6.values()) {
         var7 = Math.min(var7, var10.a());
      }

      return System.currentTimeMillis() - var7;
   }

   private void a(Player var1, Object var2) {
      try {
         ProtocolLibrary.getProtocolManager().sendServerPacket(var1, PacketContainer.fromPacket(var2), true);
      } catch (InvocationTargetException var4) {
         var4.printStackTrace();
      }

   }

   @Override
   public void refreshConfig() {
      TimerCheckGroup var3 = (TimerCheckGroup)this.plugin.g().findCheck(TimerCheckGroup.class);
      this.e = var3.isReverseBlink();
      this.a = var3.isReverseLag();
   }

   @PacketListener(
      priority = IntaveListenerPriority.LOWEST,
      g = {ServerPacket.SPAWN_ENTITY, ServerPacket.SPAWN_ENTITY_EXPERIENCE_ORB, ServerPacket.SPAWN_ENTITY_LIVING, ServerPacket.NAMED_ENTITY_SPAWN, ServerPacket.SPAWN_ENTITY_PAINTING, ServerPacket.SPAWN_ENTITY_WEATHER, ServerPacket.ENTITY_LOOK, ServerPacket.ENTITY_MOVE_LOOK, ServerPacket.REL_ENTITY_MOVE, ServerPacket.REL_ENTITY_MOVE_LOOK, ServerPacket.ENTITY_DESTROY, ServerPacket.ENTITY_STATUS, ServerPacket.ENTITY_METADATA, ServerPacket.ENTITY_EQUIPMENT, ServerPacket.ENTITY_HEAD_ROTATION, ServerPacket.ENTITY_TELEPORT, ServerPacket.ENTITY_VELOCITY, ServerPacket.ENTITY_SOUND, ServerPacket.ENTITY_EFFECT, ServerPacket.REMOVE_ENTITY_EFFECT, ServerPacket.WORLD_PARTICLES, ServerPacket.CUSTOM_SOUND_EFFECT, ServerPacket.NAMED_SOUND_EFFECT, ServerPacket.ANIMATION, ServerPacket.CHAT}
   )
   public void a(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      unknown79 var7 = var6.getStorage().c();
      BukkitEnginePlayer var8 = var6.getStorage().getPhysicsHolder();
      PacketContainer var9 = var1.getPacket();
      PacketType var10 = var1.getPacketType();
      if (!var6.isRecentLogin() && (this.e || this.a) && !var6.getTrustFactor().atLeast(TrustFactor.YELLOW)) {
         if (!var7.l) {
            long var11 = var7.b() - Unknown354.c();
            boolean var13 = var11 > (long)var6.getAttributeValue("timer.pg");
            boolean var14 = System.currentTimeMillis() - var7.s < 60000L;
            boolean var15 = var13 || var14;
            long var16 = System.currentTimeMillis() - var7.j();
            long var18 = this.a(var6);
            long var20 = var6.getStorage().getVersionHolder().isLegacy() ? 0L : 1050L;
            long var22 = (long)var6.getAttributeValue("timer.lt");
            boolean var24 = var18 > var7.b() + Unknown354.c() / 2L + var22;
            boolean var25 = var8.isTrackingAttacked();
            boolean var26 = !var25 && var16 > var7.b() + Unknown354.c() / 2L + var22 + var20;
            boolean var27 = var10 == Server.ANIMATION || var10 == Server.ENTITY_STATUS || var10 == Server.ENTITY_METADATA || var10 == Server.ENTITY_VELOCITY;
            if (var27) {
               Integer var28 = (Integer)var9.getIntegers().read(0);
               if (var28 != null && var28 == var5.getEntityId()) {
                  return;
               }
            }

            Deque var39 = var7.f();
            DelayQueue var29 = var7.k();
            boolean var30 = var39.size() > 8000;
            boolean var31 = !var30 && !var5.isDead() && (var24 || var26);
            if (var31 && this.e) {
               if (!var29.isEmpty()) {
                  eQ[] var41 = (eQ[])var29.toArray(new eQ[0]);
                  var29.clear();

                  for(eQ var36 : var41) {
                     var39.offerLast(var36.a());
                  }
               }

               var39.offerLast(var9.getHandle());
               var7.k = System.currentTimeMillis();
               var1.setCancelled(true);
            } else if (!var39.isEmpty()) {
               int var32 = var39.size();
               if (var32 <= 100) {
                  while(!var39.isEmpty()) {
                     Object var43 = var39.pollFirst();
                     var7.l = true;
                     this.a(var5, var43);
                     var7.l = false;
                  }
               } else {
                  for(int var33 = 0; var33 < 10; ++var33) {
                     Object var34 = var39.pollFirst();
                     if (var34 == null) {
                        break;
                     }

                     var7.l = true;
                     this.a(var5, var34);
                     var7.l = false;
                  }

                  var39.offerLast(var9.getHandle());
                  var1.setCancelled(true);
               }

               if (var7.d + 30000L < System.currentTimeMillis()) {
                  var7.d = System.currentTimeMillis();
                  String var44 = "[AYCN] " + var5.getName() + " got " + var32 + " packets buffered.";
                  Unknown394.c(var44);
               }

               var7.k = System.currentTimeMillis();
            } else {
               eQ var40;
               if (!var29.isEmpty()) {
                  while((var40 = (eQ)var29.poll()) != null) {
                     Object var45 = var40.a();
                     var7.l = true;
                     this.a(var5, var45);
                     var7.l = false;
                  }
               }
            }

            if (var15 && this.a) {
               long var42 = Math.max(var14 ? 100L : 0L, (long)((double)Math.max(var11, 100L) / 2.0));
               long var48 = Math.min(var7.i++ / 2L, var42);
               long var49 = System.nanoTime() + var48 * 1000000L;
               var49 = Math.max(var7.t + 1L, var49);
               var7.t = var49;
               var29.add(new eQ(var9.getHandle(), var49));
               var1.setCancelled(true);
               if (var7.G + 30000L < System.currentTimeMillis()) {
                  var7.G = System.currentTimeMillis();
                  String var38 = "[AYCN] " + var5.getName() + " is being delayed by " + var42 + "ms.";
                  Unknown394.c(var38);
               }
            } else {
               var7.i = 0L;
            }

         }
      }
   }
}
