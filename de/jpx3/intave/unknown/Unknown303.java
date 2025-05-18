package de.jpx3.intave.unknown;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedWatchableObject;
import com.comphenix.protocol.wrappers.EnumWrappers.Direction;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerDigType;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.l;
import de.jpx3.intave.l8;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactor;
import de.jpx3.intave.anticheat.check.api.CheckLoader;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.check.physics.PhysicsCheck;
import de.jpx3.intave.anticheat.check.reach.interact.InteractRaytraceCheck;
import de.jpx3.intave.anticheat.check.timer.TimerCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.DamageHolder;
import de.jpx3.intave.anticheat.data.holder.EntityHolder;
import de.jpx3.intave.anticheat.data.holder.ItemHolder;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.data.holder.PotionHolder;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.util.CollisionUtil;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.module.impl.TeleportModule;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.packet.wrap.PacketInterpreters;
import de.jpx3.intave.anticheat.packet.wrap.modal.EntityAction;
import de.jpx3.intave.anticheat.packet.wrap.modal.Pose;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.anticheat.util.nms.WrappedEntityAction;
import de.jpx3.intave.anticheat.violation.Violation;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

@Relocate
public final class Unknown303 extends UnknownCheck {
   private TimerCheckGroup i;
   private InteractRaytraceCheck f;
   private TeleportModule g;
   private static final Set h = Unknown253.a("SHULKER_BOX");
   private PhysicsCheck e;
   private final boolean a = MinecraftVersion.V_1_9.atOrAbove();

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      g = {ServerPacket.EXPLOSION}
   )
   public void c(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      PacketContainer var3 = var1.getPacket();
      MoudleLoader.m().a(var2, var3.getFloat(), Unknown303::a);
   }

   private void c(PlayerData data) {
      Player var2 = data.getPlayer();
      ProtocolManager var3 = ProtocolLibrary.getProtocolManager();
      ItemHolder var4 = data.getStorage().getItemHolder();
      var4.o = var4.g < 4 && Unknown159.c(var4.materialInHand) || Unknown159.c(var4.getMaterial());
      PacketContainer var5 = var3.createPacket(Client.BLOCK_DIG);
      var5.getBlockPositionModifier().write(0, new BlockPosition(0, 0, 0));
      var5.getDirections().write(0, Direction.DOWN);
      var5.getPlayerDigTypes().write(0, PlayerDigType.RELEASE_USE_ITEM);
      data.c();
      de.jpx3.intave.anticheat.packet.ProtocolManager.receivePacket(var2, var5);
      this.c(var2);
      IntaveScheduler.runTask(var2::updateInventory);
   }

   @BukkitEventListener
   public void a(PlayerRespawnEvent var1) {
      Player var2 = var1.getPlayer();
      PlayerData var3 = PlayerDataManager.getPlayerData(var2);
      PlayerStorage var4 = var3.getStorage();
      BukkitEnginePlayer var5 = var4.getPhysicsHolder();
      var5.fallDistance = 0.0F;
      var5.clearTrackedEntity();
      Unknown148 var6 = var4.getPlayerHolder().b();
      if (var6 != null) {
         var6.r();
      }

   }

   @BukkitEventListener
   public void a(PlayerChangedWorldEvent var1) {
      Player var2 = var1.getPlayer();
      PlayerData var3 = PlayerDataManager.getPlayerData(var2);
      PlayerStorage var4 = var3.getStorage();
      BukkitEnginePlayer var5 = var4.getPhysicsHolder();
      var5.clearTrackedEntity();
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      g = {ServerPacket.ENTITY_METADATA}
   )
   public void f(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      PacketContainer var3 = var1.getPacket();
      Integer var4 = (Integer)var3.getIntegers().read(0);
      if (this.a && var4 == var2.getEntityId()) {
         List var5 = (List)var3.getWatchableCollectionModifier().read(0);
         WrappedWatchableObject var6 = (WrappedWatchableObject)var5.stream().filter(Unknown303::a).findFirst().orElse(null);
         if (var6 != null) {
            PlayerData var7 = PlayerDataManager.getPlayerData(var2);
            PlayerStorage var8 = var7.getStorage();
            BukkitEnginePlayer var9 = var8.getPhysicsHolder();
            VersionHolder var10 = var8.getVersionHolder();
            if (var10.is1_9()) {
               byte var11 = var6.getValue();
               boolean var12 = (var11 & 128) != 0;
               Unknown176 var13 = Unknown303::a;
               MoudleLoader.m().a(var2, var12, var13);
            }
         }
      }
   }

   private static void a(BukkitEnginePlayer var0) {
      var0.E = null;
   }

   private static void b(BukkitEnginePlayer var0, BlockPosition var1, boolean var2, de.jpx3.intave.anticheat.util.Direction var3, Player var4, Object var5) {
      if (var0.a8.containsKey(var1)) {
         l8 var6 = (l8)var0.a8.get(var1);
         if (var2) {
            var6.d();
         } else {
            var6.c();
         }
      } else {
         l8 var7 = var2 ? l8.a(var3) : l8.b(var3);
         var0.a8.put(var1, var7);
         var0.bL.add(var1);
      }

      switch(Unknown275.a[var3.get().ordinal()]) {
         case 1:
            var0.A = 10;
            break;
         case 2:
            var0.b5 = 10;
            break;
         case 3:
            var0.bS = 10;
      }

   }

   private void b(PlayerData var1) {
      PotionHolder var2 = var1.getStorage().getPotionHolder();
      if (var2.getSpeedAmplifier() > 0 && --var2.speedEffectDuration <= 0) {
         var2.setSpeedAmplifier(0);
      }

      if (var2.getSlownessAmplifiier() > 0 && --var2.slownessEffectDuration <= 0) {
         var2.setSlownessAmplifier(0);
      }

      if (var2.getJumpBoostAmplifier() > 0 && --var2.jumpBoostEffectDuration <= 0) {
         var2.setJumpBoostAmplifier(0);
      }

   }

   @BukkitEventListener(
      a = EventPriority.LOWEST
   )
   public void a(EntityDamageEvent var1) {
      if (var1.getEntity() instanceof Player) {
         PlayerData var2 = PlayerDataManager.getPlayerData((Player)var1.getEntity());
         BukkitEnginePlayer var3 = var2.getStorage().getPhysicsHolder();
         if (var1.getCause() == DamageCause.FALL && !var3.N) {
            var1.setCancelled(true);
         }

      }
   }

   private static void a(BukkitEnginePlayer var0, Player var1, Boolean var2) {
      var0.isElytraFlying = var2;
      var0.y();
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.FLYING, ClientPacket.LOOK, ClientPacket.POSITION, ClientPacket.POSITION_LOOK, ClientPacket.VEHICLE_MOVE}
   )
   public void e(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      PacketContainer var3 = var1.getPacket();
      PlayerData var4 = PlayerDataManager.getPlayerData(var2);
      PlayerStorage var5 = var4.getStorage();
      BukkitEnginePlayer var6 = var5.getPhysicsHolder();
      EntityHolder var7 = var5.getEntityHolder();
      ItemHolder var8 = var5.getItemHolder();
      PacketType var9 = var1.getPacketType();
      boolean var10 = var9 == Client.VEHICLE_MOVE;
      boolean var11 = var10 || var3.getBooleans().read(1);
      boolean var12 = var10 || var3.getBooleans().read(2);

      for(Unknown135 var14 : var6.a()) {
         var14.c();
      }

      if (!var2.isDead() && !var6.teleporting) {
         if (var6.isTrackingAttacked() && !var10 && var12 && !var11) {
            var6.writeGroundPacket(var3);
         } else {
            if (!var1.isCancelled() && !var6.bG && !var6.a3) {
               this.e.a(var4, var11);
            }

            if (var1.isCancelled()) {
               var6.inWeb = false;
            }

            if (!var6.bG) {
               ++var6.teleportTicks;
            }

            var6.aO = false;
            var6.isMoving = false;
            var6.bG = false;
            var6.a3 = false;
            Map var18 = var6.a8;
            if (!var18.isEmpty()) {
               int var19 = 2048;
               Iterator var15 = var6.bL.iterator();

               while(var15.hasNext() && var19-- > 0) {
                  BlockPosition var16 = (BlockPosition)var15.next();
                  l8 var17 = (l8)var18.get(var16);
                  if (var17 == null) {
                     var15.remove();
                  } else if (var17.e()) {
                     var15.remove();
                     var18.remove(var16);
                  } else if (var17.g()) {
                     var17.b();
                  }
               }
            }

            if (var6.A > 0) {
               --var6.A;
            }

            if (var6.b5 > 0) {
               --var6.b5;
            }

            if (var6.bS > 0) {
               --var6.bS;
            }

            boolean var20 = var6.isElytraFlying;
            if (var20) {
               var6.bC = 0;
            } else {
               ++var6.bC;
            }

            if (var6.inWeb) {
               var6.bg = 0;
            } else {
               ++var6.bg;
            }

            if (var8.j()) {
               var6.aT = 0;
            } else {
               ++var6.aT;
            }

            if (var6.jumping) {
               var6.n = System.currentTimeMillis();
            }

            if (var6.isSneaking()) {
               ++var6.C;
               if (var6.C > 1) {
                  var6.af = System.currentTimeMillis();
               }
            } else {
               var6.C = 0;
            }

            ++var6.ab;
            ++var8.g;
            ++var8.b;
            ++var6.groundTicks;
            ++var6.velocityTicks;
            var6.ae = false;
            if (var11 || var12) {
               ++var6.l;
            }

            ++var6.bU;
            ++var7.lastHealthUpdate;
            var6.bm = false;
            var6.stepped = false;
            var6.sprint = var6.w();
            var6.X = var6.isSneaking;
            ++var6.ba;
            ++var6.bQ;
            if (!var8.h() && var8.l > 2) {
               var6.bX = 0;
            }

            if (!var1.isCancelled()) {
               var6.onGround = var6.contextGround;
               var6.serverX = var6.x;
               var6.serverY = var6.y;
               var6.serverZ = var6.z;
            }

            if (var8.h()) {
               ++var8.p;
               var8.l = 0;
            } else {
               ++var8.l;
               var8.p = 0;
            }

            if (var6.bi || !var7.d()) {
               var7.setFlying(false);
               var6.bi = false;
            }

            this.d(var4);
            var6.bn = false;
         }
      }
   }

   private boolean b(Player var1) {
      PlayerData var2 = PlayerDataManager.getPlayerData(var1);
      PlayerStorage var3 = var2.getStorage();
      ItemHolder var4 = var3.getItemHolder();
      return !var4.j();
   }

   public static void a(PlayerData data, Motion motion) {
      PlayerStorage var2 = data.getStorage();
      BukkitEnginePlayer var3 = var2.getPhysicsHolder();
      Unknown187 var4 = var2.e();
      var3.bT = var3.l;
      var3.Z = var3.lastDeltaX;
      var3.bV = var3.lastDeltaY;
      var3.bt = var3.lastDeltaZ;
      var3.aw = var3.deltaX;
      var3.a5 = var3.deltaY;
      var3.b6 = var3.deltaZ;
      var3.bY = var3.bh;
      if (!var4.k) {
         var3.lastDeltaX = var3.deltaX;
         var3.lastDeltaY = var3.deltaY;
         var3.lastDeltaZ = var3.deltaZ;
         var3.deltaX = motion.getX();
         var3.deltaY = motion.getY();
         var3.deltaZ = motion.getZ();
         var3.velocity = new Vector(motion.getX(), motion.getY(), motion.getZ());
      }

   }

   @PacketListener(
      priority = IntaveListenerPriority.MONITOR,
      b = Unknown116.b,
      g = {ServerPacket.ENTITY_VELOCITY}
   )
   public void a(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      PacketContainer var3 = var1.getPacket();
      StructureModifier var4 = var3.getIntegers();
      if (var3.getIntegers().readSafely(0) == var2.getEntityId()) {
         Vector var5 = new Vector(
            (double)((Integer)var4.readSafely(1)).intValue() / 8000.0,
            (double)((Integer)var4.readSafely(2)).intValue() / 8000.0,
            (double)((Integer)var4.readSafely(3)).intValue() / 8000.0
         );
         PlayerData var6 = PlayerDataManager.getPlayerData(var2);
         PlayerStorage var7 = var6.getStorage();
         BukkitEnginePlayer var8 = var7.getPhysicsHolder();
         if (var8.bh && var5.length() < 0.001) {
            var8.bh = false;
            var5 = var8.bo;
            var4.writeSafely(1, (int)(var5.getX() * 8000.0));
            var4.writeSafely(2, (int)(var5.getY() * 8000.0));
            var4.writeSafely(3, (int)(var5.getZ() * 8000.0));
            return;
         }

         int var9 = var8.al.get();
         if (var9 > 1 && var6.getStorage().getPlayerHolder().g()) {
            if (var9 >= 6) {
               if (var1.isReadOnly()) {
                  var1.setReadOnly(false);
               }

               var1.setCancelled(true);
               return;
            }

            var5.setX(var5.getX() / (double)var9);
            var5.setY(Math.min(0.0, var5.getY()));
            var5.setZ(var5.getZ() / (double)var9);
            var4.writeSafely(1, (int)(var5.getX() * 8000.0));
            var4.writeSafely(2, (int)(var5.getY() * 8000.0));
            var4.writeSafely(3, (int)(var5.getZ() * 8000.0));
         }

         var8.al.incrementAndGet();
         var8.E = var5.clone();
         if (var8.isSneaking) {
            var8.bR = var5.clone();
         }

         Motion var10 = Motion.clone(var5);
         MoudleLoader.m().a(var2, var5, this::setVelocity);
      }

   }

   public static void b(PlayerData data, @Nullable Motion motion) {
      if (motion != null) {
         PlayerStorage var2 = data.getStorage();
         BukkitEnginePlayer var3 = var2.getPhysicsHolder();
         IntaveScheduler.runTask(Unknown303::a);
         var3.velocityTicks = 0;
         var3.al.decrementAndGet();
         if (!var3.bh) {
            var3.l = 0;
         }

         var3.bh = false;
      }

   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      g = {ServerPacket.RESPAWN}
   )
   public void d(PacketEvent event) {
      Player var2 = event.getPlayer();
      PlayerData var3 = PlayerDataManager.getPlayerData(var2);
      PlayerStorage var4 = var3.getStorage();
      Unknown187 var5 = var4.e();
      var5.b = 0.0;
      var5.a = Math.max(0.0, var5.a - 10.0);
      this.a(var2);
   }

   private static void a(Player var0, PlayerData var1) {
      BukkitEnginePlayer var2 = var1.getStorage().getPhysicsHolder();
      VersionHolder var3 = var1.getStorage().getVersionHolder();
      var2.isSneaking = false;
      var2.setSprinting(false);
      if (var3.getVersionId() >= VersionHolder.V_1_16) {
         var2.J();
         var1.i();
      }

      var2.deltaX = 0.0;
      var2.deltaY = 0.0;
      var2.deltaZ = 0.0;
      var1.getWorld().a();
      var1.getStorage().getPotionHolder().resetEffects();
   }

   private static void a(PlayerData var0, Player var1, Integer var2) {
      PlayerStorage var3 = var0.getStorage();
      if (var2 <= 6) {
         var3.getPhysicsHolder().setSprinting(false);
      }

      var3.getEntityHolder().foodLevel = var2;
   }

   @BukkitEventListener
   public void b(PlayerChangedWorldEvent var1) {
      Player var2 = var1.getPlayer();
      PlayerData var3 = PlayerDataManager.getPlayerData(var2);
      BukkitEnginePlayer var4 = var3.getStorage().getPhysicsHolder();
      var4.T();
      var3.getWorld().a();
      var3.i();
   }

   private void a(Player var1) {
      MoudleLoader.m().a(var1, PlayerDataManager.getPlayerData(var1), Unknown303::a);
   }

   private void d(PlayerData var1) {
      PlayerStorage var2 = var1.getStorage();
      BukkitEnginePlayer var3 = var2.getPhysicsHolder();
      Pose var4 = var3.getPose();
      var3.jumpStep = var4.getWidth(var1);
      var3.height = var4.getHeight(var1);
   }

   private static void a(Player var0, StructureModifier var1) {
      PlayerData var2 = PlayerDataManager.getPlayerData(var0);
      BukkitEnginePlayer var3 = var2.getStorage().getPhysicsHolder();
      Float var4 = (Float)var1.read(1);
      Float var5 = (Float)var1.read(2);
      Float var6 = (Float)var1.read(3);
      var3.deltaX += (double)var4.floatValue();
      var3.deltaY += (double)var5.floatValue();
      var3.deltaZ += (double)var6.floatValue();
   }

   private void c(Player var1) {
      PlayerData var2 = PlayerDataManager.getPlayerData(var1);
      ItemHolder var3 = var2.getStorage().getItemHolder();
      var3.resetItem();
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.ENTITY_ACTION}
   )
   public void j(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      PlayerData var3 = PlayerDataManager.getPlayerData(var2);
      PlayerStorage var4 = var3.getStorage();
      BukkitEnginePlayer var5 = var4.getPhysicsHolder();
      VersionHolder var6 = var4.getVersionHolder();
      DamageHolder var7 = var4.getDamageHolder();
      PacketContainer var8 = var1.getPacket();
      EntityAction var9 = WrappedEntityAction.readEntityAction(var8);
      switch(Unknown275.b[var9.ordinal()]) {
         case 1:
            if (this.b(var2)) {
               var5.setSprinting(true);
            }
            break;
         case 2:
            var5.setSprinting(false);
            break;
         case 3:
         case 4:
            if (System.currentTimeMillis() - var7.b < 2000L) {
               var1.setCancelled(true);
            }

            if (var5.isTrackingAttacked()) {
               var5.clearTrackedEntity();
               var5.isSneaking = false;
            } else {
               var5.isSneaking = true;
            }
            break;
         case 5:
         case 6:
            var5.isSneaking = false;
            break;
         case 7:
            if (var5.isWearingElytra() && var6.is1_9() && var6.isSuperModern()) {
               var5.isElytraFlying = true;
               var5.setPose(Pose.ELYTRA);
            }
      }

   }

   @PacketListener(
      g = {ServerPacket.BLOCK_ACTION}
   )
   public void i(PacketEvent var1) {
      Player var4 = var1.getPlayer();
      PlayerData var5 = PlayerDataManager.getPlayerData(var4);
      BukkitEnginePlayer var6 = var5.getStorage().getPhysicsHolder();
      PacketContainer var7 = var1.getPacket();
      Unknown214 var8 = (Unknown214)PacketInterpreters.getInterpreter(var7);
      Material var9 = var8.c();
      if (h.contains(var9)) {
         BlockPosition var10 = var8.d();
         World var11 = var4.getWorld();
         l var12 = WorldUtil.a(var5, var10.toLocation(var11));
         de.jpx3.intave.anticheat.util.Direction var13 = (de.jpx3.intave.anticheat.util.Direction)var12.a(
            de.jpx3.intave.anticheat.util.Direction.class, "facing"
         );
         boolean var14 = var8.b() == 1;
         MoudleLoader.m().a(var4, Unknown303::b);
      }

      var8.reset();
   }

   @PacketListener(
      e = Unknown5.b,
      g = {ServerPacket.UPDATE_HEALTH}
   )
   public void b(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      PlayerData var3 = PlayerDataManager.getPlayerData(var2);
      Integer var4 = (Integer)var1.getPacket().getIntegers().read(0);
      Unknown176 var5 = Unknown303::a;
      MoudleLoader.m().a(var2, var4, var5, Unknown228.c);
   }

   @PacketListener(
      priority = IntaveListenerPriority.LOW,
      packetTypes = {ClientPacket.FLYING, ClientPacket.LOOK, ClientPacket.POSITION, ClientPacket.POSITION_LOOK, ClientPacket.VEHICLE_MOVE}
   )
   public void h(PacketEvent var1) {
      Player var4 = var1.getPlayer();
      if (!var4.isDead() && !var1.isCancelled()) {
         PacketContainer var5 = var1.getPacket();
         PlayerData var6 = PlayerDataManager.getPlayerData(var4);
         PlayerStorage var7 = var6.getStorage();
         BukkitEnginePlayer var8 = var7.getPhysicsHolder();
         PlayerHolder var9 = var7.getPlayerHolder();
         ItemHolder var10 = var7.getItemHolder();
         Unknown187 var11 = var7.e();
         unknown79 var12 = var7.c();
         VersionHolder var13 = var7.getVersionHolder();
         PacketType var14 = var1.getPacketType();
         boolean var15 = var14 == Client.VEHICLE_MOVE;
         boolean var16 = var15 || var5.getBooleans().read(1);
         boolean var17 = var15 || var5.getBooleans().read(2);
         if (var11.c) {
            var11.c = false;
            var11.k = false;
            var8.a3 = true;
         }

         if (var8.isTrackingAttacked() && !var15 && var17 && !var16) {
            var8.writeGroundPacket(var5);
            var8.yaw = var5.getFloat().read(0);
            var8.pitch = var5.getFloat().read(1);
         } else {
            if (var16) {
               StructureModifier var18 = var5.getDoubles();

               for(int var19 = 0; var19 < 3; ++var19) {
                  if (Double.isInfinite(var18.read(var19))) {
                     var6.error("Infinite position?");
                     return;
                  }
               }
            }

            if (var17) {
               StructureModifier var31 = var5.getFloat();

               for(int var36 = 0; var36 < 2; ++var36) {
                  if (Double.isInfinite((double)((Float)var31.read(var36)).floatValue())) {
                     var6.error("Infinite rotation?");
                     return;
                  }
               }
            }

            if (!var16 && !var8.isTrackingAttacked()) {
               if (++var8.aL > 20 && !var6.getTrustFactor().atLeast(TrustFactor.BYPASS)) {
                  var6.error("Missing position update after 20 ticks");
               }
            } else {
               var8.aL = 0;
            }

            if (var13.is1_17() && !var8.teleporting && !var8.V && var5.getType() == Client.POSITION_LOOK) {
               StructureModifier var32 = var5.getDoubles();
               double var37 = var32.read(0);
               double var21 = var32.read(1);
               double var23 = var32.read(2);
               double var25 = var37 - var8.serverX;
               double var27 = var21 - var8.serverY;
               double var29 = var23 - var8.serverZ;
               if (MathUtil2.getLength(var25, var27, var29) < 1.0E-5) {
                  var8.a3 = true;
                  return;
               }
            }

            var12.c();
            var8.handleFlying(var5, var16, var17);
            this.g.a(var1);

            for(Unknown135 var38 : var8.a()) {
               var38.b();
            }

            for(Unknown135 var39 : var8.a()) {
               var39.a();
            }

            if (!var8.teleporting && !var8.V) {
               double var35 = MathUtil2.a(var8.serverX, var8.serverY, var8.serverZ, var8.x, var8.y, var8.z);
               if (var35 > 50.0) {
                  var1.setCancelled(true);
                  Vector var40 = new Vector(var8.deltaX, var8.deltaY, var8.deltaZ);
                  MoudleLoader.o().b().a(var4, var40, 10, false);
                  String var42 = "sent unsafe position";
                  String var43 = "moved " + MathUtil2.getStringRounded(var35, 2) + " blocks";
                  Violation var44 = Violation.builder(PhysicsCheck.class).player(var4).name(var42).description(var43).vl(25.0).build();
                  MoudleLoader.violations().dispatchViolation(var44);
               } else {
                  TrackedEntity var20 = var8.getTrackedEntity();
                  if (var20 != null && !var20.a() && var20.q() && var20.r().e()) {
                     var8.clearTrackedEntity();
                  }

                  if (var10.r) {
                     this.c(var6);
                     var10.r = false;
                     var10.materialInHand = Material.AIR;
                  }

                  if (var11.k) {
                     var1.setCancelled(true);
                  } else if (!var8.bG
                     && var8.bD
                     && var8.deltaX == 0.0
                     && var8.deltaY == 0.0
                     && var8.deltaZ == 0.0
                     && var8.getMotionX() == 0.0
                     && var8.getMotionY() == 0.0
                     && var8.getMotionZ() == 0.0) {
                     var8.bD = false;
                  } else {
                     if (!var8.bG) {
                        this.f.b(var1);
                        if (!var16 && !var17) {
                           this.e.i(var6);
                        } else {
                           this.e.run(var6);
                        }

                        this.i.a(var1);
                        boolean var41 = var15 ? var4.isOnGround() : var5.getBooleans().read(0);
                        boolean var22 = var8.e();
                        if (!var15 && !var22) {
                           var8.writeGroundPacket(var5);
                        }

                        if (var8.contextGround && !var41 && var8.stepped) {
                           var8.contextGround = false;
                        }

                        if (var22) {
                           var8.contextGround = var41;
                        }

                        var9.calculateOffsets();
                        this.b(var6);
                        var8.bD = false;
                     } else {
                        var8.bD = true;
                     }

                     if (var8.aO && var11.k) {
                        var8.V = true;
                        var1.setCancelled(true);
                     }

                  }
               }
            } else {
               var1.setCancelled(true);
               var8.a3 = true;
            }
         }
      }
   }

   private void setVelocity(Player player, Vector velocity) {
      PlayerData var3 = PlayerDataManager.getPlayerData(player);
      PlayerStorage var4 = var3.getStorage();
      Unknown187 var5 = var4.e();
      BukkitEnginePlayer var6 = var4.getPhysicsHolder();
      if (!var5.k) {
         var6.lastDeltaX = var6.deltaX;
         var6.lastDeltaY = var6.deltaY;
         var6.lastDeltaZ = var6.deltaZ;
         var6.deltaX = velocity.getX();
         var6.deltaY = velocity.getY();
         var6.deltaZ = velocity.getZ();
         var6.velocity = velocity.clone();
         if (!var6.bh) {
            var6.l = 0;
         }

         var6.bh = false;
      }

      IntaveScheduler.runTask(Unknown303::c);
      var6.velocityTicks = 0;
      var6.al.decrementAndGet();
   }

   @BukkitEventListener(
      a = EventPriority.MONITOR
   )
   public void handleRespawn(PlayerRespawnEvent event) {
      Player var2 = event.getPlayer();
      PlayerData var3 = PlayerDataManager.getPlayerData(var2);
      Location var4 = event.getRespawnLocation().clone();
      World var5 = var4.getWorld();
      int var6 = 5;

      for(Box var7 = Box.of(var3, var4);
         var4.getY() < (double)Unknown94.MAX_HEIGHT
            && var6-- > 0
            && CollisionUtil.a(var5, var2, var7)
            && CollisionUtil.collidesWithBlock(var5, var2, var7.add(0.0, 0.5, 0.0));
         var7 = Box.of(var3, var4)
      ) {
         var4.add(0.0, 0.1, 0.0);
      }

      event.setRespawnLocation(var4);
   }

   private static boolean a(WrappedWatchableObject var0) {
      return var0.getIndex() == 0;
   }

   @BukkitEventListener
   public void handlePlayerMove(PlayerMoveEvent event) {
      Player var2 = event.getPlayer();
      PlayerData var3 = PlayerDataManager.getPlayerData(var2);
      PlayerStorage var4 = var3.getStorage();
      BukkitEnginePlayer var5 = var4.getPhysicsHolder();
      if (var5.isTrackingAttacked()) {
         Location var6 = event.getTo();
         VersionHolder var7 = var4.getVersionHolder();
         if (var7.getVersionId() < VersionHolder.V_1_9) {
            var5.lastX = var5.x;
            var5.lastY = var5.y;
            var5.lastZ = var5.z;
            var5.x = var6.getX();
            var5.y = var6.getY();
            var5.z = var6.getZ();
            var5.lastYaw = var5.yaw;
            var5.lastPitch = var5.pitch;
            var5.yaw = var6.getYaw();
            var5.pitch = var6.getPitch();
         }
      }
   }

   private static void c(BukkitEnginePlayer var0) {
      var0.E = null;
   }

   @PacketListener(
      packetTypes = {ClientPacket.STEER_VEHICLE}
   )
   public void g(PacketEvent var1) {
      Player var4 = var1.getPlayer();
      PlayerData var5 = PlayerDataManager.getPlayerData(var4);
      BukkitEnginePlayer var6 = var5.getStorage().getPhysicsHolder();
      PacketContainer var7 = var1.getPacket();
      int var8 = (int)(var7.getFloat().read(0) / 0.98F);
      int var9 = (int)(var7.getFloat().read(1) / 0.98F);
      if (Math.abs(var8) <= 1 && Math.abs(var9) <= 1) {
         Boolean var10 = (Boolean)var7.getBooleans().read(0);
         var6.bn = true;
         var6.D = var8;
         var6.G = var9;
         var6.c = var10;
      } else {
         var5.error("Invalid key input");
      }
   }

   public static void a(PlayerData var0) {
      PlayerStorage var1 = var0.getStorage();
      BukkitEnginePlayer var2 = var1.getPhysicsHolder();
      var2.l = var2.bT;
      var2.lastDeltaX = var2.Z;
      var2.lastDeltaY = var2.bV;
      var2.lastDeltaZ = var2.bt;
      var2.deltaX = var2.aw;
      var2.deltaY = var2.a5;
      var2.deltaZ = var2.b6;
      var2.bh = var2.bY;
   }

   @BukkitEventListener
   public void handleTeleport(PlayerTeleportEvent event) {
      Player var2 = event.getPlayer();
      PlayerData var3 = PlayerDataManager.getPlayerData(var2);
      TeleportCause var4 = event.getCause();
      if (var4 != TeleportCause.NETHER_PORTAL && var4 != TeleportCause.UNKNOWN) {
         Location var5 = event.getFrom();
         Location var6 = event.getTo();
         World var7 = var6.getWorld();
         if (var6.getWorld() != var2.getWorld() || var6.distance(var5) > 8.0) {
            Box var8 = Box.of(var3, var6);

            for(int var9 = 5;
               var6.getY() < (double)Unknown94.MAX_HEIGHT
                  && var9-- > 0
                  && CollisionUtil.a(var7, var2, var8)
                  && CollisionUtil.collidesWithBlock(var7, var2, var8.add(0.0, 0.5, 0.0));
               var8 = Box.of(var3, var6)
            ) {
               var6.add(0.0, 0.1, 0.0);
            }

            event.setTo(var6);
         }

         BukkitEnginePlayer var10 = var3.getStorage().getPhysicsHolder();
         var10.fallDistance = 0.0F;
      }
   }

   @Override
   public void refreshConfig() {
      CheckLoader var3 = this.plugin.g();
      this.e = (PhysicsCheck)var3.findCheck(PhysicsCheck.class);
      this.f = (InteractRaytraceCheck)var3.findCheck(InteractRaytraceCheck.class);
      this.i = (TimerCheckGroup)var3.findCheck(TimerCheckGroup.class);
      this.g = new TeleportModule();
      this.g.a();
   }
}
