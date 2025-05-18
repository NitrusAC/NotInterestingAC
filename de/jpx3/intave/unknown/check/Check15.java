package de.jpx3.intave.unknown.check;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedWatchableObject;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.EntityHolder;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.event.EntityMoveEvent;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.packet.wrap.PacketInterpreters;
import de.jpx3.intave.anticheat.packet.wrap.modal.Pose;
import de.jpx3.intave.anticheat.reflection.WorldReflection;
import de.jpx3.intave.anticheat.unknown.HitboxSize;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.ServerUtil;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.anticheat.util.reach.DestroyedReachEntity;
import de.jpx3.intave.anticheat.util.reach.ReachEntityType;
import de.jpx3.intave.anticheat.util.reach.ReachPosition;
import de.jpx3.intave.unknown.Unknown148;
import de.jpx3.intave.unknown.Unknown176;
import de.jpx3.intave.unknown.Unknown22;
import de.jpx3.intave.unknown.Unknown221;
import de.jpx3.intave.unknown.Unknown296;
import de.jpx3.intave.unknown.Unknown340;
import de.jpx3.intave.unknown.Unknown76;
import de.jpx3.intave.unknown.unknown79;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public final class Check15 extends UnknownCheck {
   private final boolean m;
   private static final int h = MinecraftVersion.V_1_17.atOrAbove() ? 9 : 8;
   private final boolean e = ServerUtil.getServerVersion().isAtLeast(MinecraftVersion.V_1_9);
   private static final int i = 1;
   private static final int g = 16;
   private final boolean l;
   private static final int f = 4;
   private final IntavePlugin k;
   private final Unknown76 j;
   private final BiConsumer a = MoudleLoader.e().c();

   private static double b(TrackedEntity var0) {
      return var0.z;
   }

   public Check15(IntavePlugin var1) {
      this.m = MinecraftVersion.V_1_10.atOrAbove();
      this.l = MinecraftVersion.V_1_14.atOrAbove();
      this.k = var1;
      this.j = new Unknown76(var1);
   }

   private void c(Player var1, int var2) {
      PlayerData var6 = PlayerDataManager.getPlayerData(var1);
      PlayerHolder var7 = var6.getStorage().getPlayerHolder();
      unknown79 var8 = var6.getStorage().c();
      BukkitEnginePlayer var9 = var6.getStorage().getPhysicsHolder();
      TrackedEntity var10 = var8.a(var2);
      if (var10 != null && var9.getTrackedEntity() == var10) {
         var9.clearTrackedEntity();
      }

      var8.b(var2);
      if (var7.getAttacked() != null && var7.l() == var2) {
         var7.clearAttacker();
      }

      if (this.e) {
         for(TrackedEntity var12 : var8.i()) {
            if (var12.getParent() != null && var12.getParent().i() == var2) {
               var12.clearParent();
            }
         }
      }

   }

   @PacketListener(
      g = {ServerPacket.MOUNT, ServerPacket.ATTACH_ENTITY},
      c = false
   )
   public void i(PacketEvent var1) {
      PacketContainer var5 = var1.getPacket();
      Player var6 = var1.getPlayer();
      if (var1.getPacketType() == Server.MOUNT) {
         int[] var7 = (int[])var1.getPacket().getIntegerArrays().read(0);
         int var8 = var5.getIntegers().read(0);

         for(int var12 : var7) {
            this.a(var6, var12, var8);
         }
      } else if (var1.getPacketType() == Server.ATTACH_ENTITY && !this.e) {
         int var13 = var5.getIntegers().read(0);
         if (var13 == 0) {
            int var14 = var5.getIntegers().read(1);
            int var15 = var5.getIntegers().read(2);
            this.a(var6, var14, var15);
         }
      }

   }

   @Nullable
   public static TrackedEntity a(PlayerData var0, int var1) {
      unknown79 var2 = var0.getStorage().c();
      return var2.a(var1);
   }

   @Override
   public void refreshConfig() {
      int var1 = Bukkit.getScheduler().scheduleAsyncRepeatingTask(this.k, this::b, 0L, 20L);
      Unknown22.a(var1);
   }

   private TrackedEntity e(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      PacketContainer var7 = var1.getPacket();
      int var8 = var7.getIntegers().read(0);
      TrackedEntity var9 = a(var6, var8);
      if (var9 == null) {
         Entity var10 = a(var5, var8);
         if (var10 != null) {
            return this.a(var6, var10);
         }
      }

      return var9;
   }

   private void a(Player var1, PacketEvent var2) {
      PlayerData var6 = PlayerDataManager.getPlayerData(var1);
      PlayerHolder var7 = var6.getStorage().getPlayerHolder();
      PacketType var8 = var2.getPacketType();
      PacketContainer var9 = var2.getPacket();
      boolean var11 = false;
      Integer var12 = (Integer)var9.getIntegers().read(0);
      ReachEntityType var10;
      if (var8 == Server.SPAWN_ENTITY) {
         var10 = this.j.a(var2);
      } else if (var8 == Server.SPAWN_ENTITY_LIVING) {
         var10 = this.j.b(var2);
      } else {
         Unknown148 var13 = var7.b();
         String var14;
         if (var13 != null && var13.a() == var12) {
            var14 = "Intave-Bot";
         } else {
            var14 = "Player";
         }

         HitboxSize var15 = HitboxSize.ofPlayer();
         var11 = true;
         var10 = new ReachEntityType(var14, var15, 105, true, 1);
      }

      if (var10 != null) {
         this.a(var6, var2.getPacketType(), var10, var9, var12, var11);
      }
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      g = {ServerPacket.ENTITY_STATUS},
      c = false
   )
   public void b(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      if (var6 != null && var6.exists()) {
         PacketContainer var7 = var1.getPacket();
         Integer var8 = (Integer)var7.getIntegers().read(0);
         Byte var9 = (Byte)var7.getBytes().read(0);
         TrackedEntity var10 = a(var6, var8.intValue());
         if (var10 != null && var9 == 3) {
            boolean var11 = var10.y && var10.u();
            if (var11) {
               Unknown176 var12 = this::a;
               MoudleLoader.m().a(var5, var10, var12, var10.d());
            } else {
               this.a(var10);
            }

         }
      }
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      g = {ServerPacket.ENTITY_METADATA},
      c = false
   )
   public void f(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      PacketContainer var7 = var1.getPacket();
      Integer var8 = (Integer)var7.getIntegers().read(0);
      if (var5.getEntityId() == var8) {
         this.a(var5, var7);
      } else {
         TrackedEntity var9 = a(var6, var8.intValue());
         if (var9 != null) {
            ReachEntityType var10 = var9.r();
            if (var10 != null) {
               boolean var11 = var9.r().e();
               int var12 = var10.g();
               boolean var13 = var10.getEntityType() != null && var10.getEntityType().contains("Firework");
               List var14 = (List)var7.getWatchableCollectionModifier().read(0);
               if (var13) {
                  this.a(var5, var14);
               } else if (var11 && var14 != null) {
                  this.a(var5, var9, var14);
                  ReachEntityType var15 = this.j.a(var1, var12, var14);
                  if (var15 != null) {
                     var9.a(var15);
                  }
               }

            }
         }
      }
   }

   private TrackedEntity a(PlayerData var1, int var2, ReachEntityType var3, boolean var4) {
      return new TrackedEntity(var2, var3, var4);
   }

   private void a(Player var1, int var2, int var3) {
      PlayerData var7 = PlayerDataManager.getPlayerData(var1);
      PlayerStorage var8 = var7.getStorage();
      BukkitEnginePlayer var9 = var8.getPhysicsHolder();
      unknown79 var10 = var8.c();
      TrackedEntity var11 = var10.a(var2);
      if (var11 != null) {
         if (var3 == -1) {
            var11.clearParent();
         } else {
            TrackedEntity var12 = var10.a(var3);
            if (var12 != null) {
               var11.setParent(var12);
            }
         }
      } else if (var2 == var1.getEntityId()) {
         this.b(var7, var3);
         MoudleLoader.m().a(var1, var10.a(var3), Check15::a);
      }

   }

   @Nullable
   public static Entity a(Player var0, int var1) {
      return var1 < 0 ? null : WorldReflection.getEntityFromWorld(var0.getWorld(), var1);
   }

   private TrackedEntity a(PlayerData var1, Entity var2) {
      Location var6 = var2.getLocation();
      int var7 = var2.getEntityId();
      long var8;
      long var10;
      long var12;
      if (this.e) {
         var8 = MathUtil.e(var6.getX());
         var10 = MathUtil.e(var6.getY());
         var12 = MathUtil.e(var6.getZ());
      } else {
         var8 = (long)MathUtil.floor(var6.getX() * 32.0);
         var10 = (long)MathUtil.floor(var6.getY() * 32.0);
         var12 = (long)MathUtil.floor(var6.getZ() * 32.0);
      }

      ReachEntityType var14 = this.j.c(var2);
      TrackedEntity var15 = this.a(var1, var7, var14, var8, var10, var12, var2.getType() == EntityType.PLAYER);
      if (var2 instanceof LivingEntity) {
         LivingEntity var16 = (LivingEntity)var2;
         var15.D = (float)var16.getHealth();
      }

      return var15;
   }

   private void a(Player var1, Integer var2) {
      this.b(var1, var2);
   }

   private Float a(List var1) {
      for(WrappedWatchableObject var6 : var1) {
         int var7 = var6.getIndex();
         byte var8;
         if (MinecraftVersion.V_1_17.atOrAbove()) {
            var8 = 9;
         } else if (this.l) {
            var8 = 8;
         } else if (this.m) {
            var8 = 7;
         } else {
            var8 = 6;
         }

         if (var7 == var8) {
            return this.a(var6);
         }
      }

      return null;
   }

   private void a(TrackedEntity var1, PacketContainer var2, Player var3, Player var4, PacketEvent var5) {
      var1.f = false;
      var1.handleEntityTeleport(var2);
      this.b(var3, var1);
   }

   private void a(TrackedEntity var1, float var2) {
      var1.D = var2;
   }

   private void b(PlayerData var1, int var2) {
      Entity var6 = a(var1.getPlayer(), var2);
      if (var6 != null && var1.getStorage().c().a(var2) == null) {
         this.a(var1, var6);
      }

   }

   private void b() {
      for(Player var5 : Bukkit.getOnlinePlayers()) {
         this.a(var5);
      }

   }

   private void a(PlayerData var1, ReachEntityType var2, int var3, double var4, double var6, double var8, boolean var10) {
      unknown79 var11 = var1.getStorage().c();
      TrackedEntity var12 = this.a(var1, var3, var2, var10);
      var12.serverX = MathUtil.e(var4);
      var12.serverY = MathUtil.e(var6);
      var12.serverZ = MathUtil.e(var8);
      var12.a(var4, var6, var8, var6);
      var11.a(var12);
   }

   private void a(Float var1, Player var2, TrackedEntity var3) {
      this.a(var3, var1);
   }

   private static void b(EntityHolder var0, Player var1, Float var2) {
      var0.playerMaxHealth = var2;
      var0.lastHealthUpdate = 0;
   }

   private boolean a(Player var1, int var2, Object var3) {
      PlayerData var7 = PlayerDataManager.getPlayerData(var1);
      if (var2 == 7) {
         if (!(var3 instanceof Integer)) {
            return false;
         } else {
            int var8 = (Integer)var3;
            BukkitEnginePlayer var9 = var7.getStorage().getPhysicsHolder();
            if (var9.getPose() == Pose.ELYTRA && var8 == var1.getEntityId()) {
               var9.ba = 0;
            }

            return true;
         }
      } else {
         return false;
      }
   }

   private void a(Player var1, TrackedEntity var2, List var3) {
      Float var7 = this.a(var3);
      if (var7 != null) {
         boolean var8 = var2.y && var2.u();
         if (var8) {
            Unknown340 var9 = var2.d();
            MoudleLoader.m().a(var1, var2, this::a, var9);
         } else {
            this.a(var2, var7);
         }
      }

   }

   private void a(Player var1, List var2) {
      if (MinecraftVersion.V_1_11.atOrAbove()) {
         for(WrappedWatchableObject var7 : var2) {
            if (var7 != null) {
               int var8 = var7.getIndex();
               Object var9 = var7.getValue();
               if (MinecraftVersion.V_1_14.atOrAbove()) {
                  if (this.b(var1, var8, var9)) {
                     return;
                  }
               } else if (this.a(var1, var8, var9)) {
                  return;
               }
            }
         }

      }
   }

   private void b(Player var1, TrackedEntity var2) {
      Unknown296 var3 = MoudleLoader.e();
      if (var3.d(PlayerDataManager.getPlayerData(var1))) {
         ReachPosition var4 = var2.position;
         ReachPosition var5 = var2.lastPosition;
         EntityMoveEvent var6 = new EntityMoveEvent(var2.i(), var4.posX, var4.posY, var4.posZ, var5.posX, var5.posY, var5.posZ, 0.0F, 0.0F, 0.0F, 0.0F);
         this.a.accept(PlayerDataManager.getPlayerData(var1), var6::accept);
      }
   }

   private static void a(BukkitEnginePlayer var0, Player var1, TrackedEntity var2) {
      if (var0.isTrackingAttacked()) {
         var0.clearTrackedEntity();
      }

      if (var2 != null && !(var2 instanceof DestroyedReachEntity)) {
         var0.setAttacked(var2);
      }

   }

   private void a(PlayerData var1, PacketType var2, ReachEntityType var3, PacketContainer var4, int var5, boolean var6) {
      if (this.e) {
         double var10 = var4.getDoubles().read(0);
         double var12 = var4.getDoubles().read(1);
         double var14 = var4.getDoubles().read(2);
         this.a(var1, var3, var5, var10, var12, var14, var6);
      } else {
         Integer var11;
         Integer var16;
         Integer var17;
         if (var2 == Server.SPAWN_ENTITY_LIVING) {
            var16 = (Integer)var4.getIntegers().read(2);
            var11 = (Integer)var4.getIntegers().read(3);
            var17 = (Integer)var4.getIntegers().read(4);
         } else {
            var16 = (Integer)var4.getIntegers().read(1);
            var11 = (Integer)var4.getIntegers().read(2);
            var17 = (Integer)var4.getIntegers().read(3);
         }

         this.a(var1, var5, var3, (long)var16.intValue(), (long)var11.intValue(), (long)var17.intValue(), var6);
      }

   }

   private TrackedEntity a(PlayerData var1, int var2, ReachEntityType var3, long var4, long var6, long var8, boolean var10) {
      unknown79 var11 = var1.getStorage().c();
      double var12 = (double)var4 / 32.0;
      double var14 = (double)var6 / 32.0;
      double var16 = (double)var8 / 32.0;
      TrackedEntity var18 = this.a(var1, var2, var3, var10);
      var18.serverX = var4;
      var18.serverY = var6;
      var18.serverZ = var8;
      var18.a(var12, var14, var16, var14);
      var11.a(var18);
      return var18;
   }

   private void a(Player var1, TrackedEntity var2) {
      this.a(var2);
   }

   private void a(Player var1, PacketContainer var2) {
      List var3 = (List)var2.getWatchableCollectionModifier().read(0);
      if (var3 != null) {
         Float var4 = this.a(var3);
         if (var4 != null) {
            EntityHolder var5 = PlayerDataManager.getPlayerData(var1).getStorage().getEntityHolder();
            var5.playerHealth = var4;
            MoudleLoader.m().a(var1, var4, Check15::b);
         }

      }
   }

   private Float a(WrappedWatchableObject var1) {
      Object var5 = var1.getRawValue();
      if (var5 instanceof OptionalInt) {
         OptionalInt var6 = (OptionalInt)var5;
         if (!var6.isPresent()) {
            return null;
         }

         var5 = var6.getAsInt();
      }

      return ((Number)var5).floatValue();
   }

   private void b(TrackedEntity var1, PacketContainer var2, Player var3, Player var4, PacketEvent var5) {
      var1.f = false;
      var1.handleEntityMove(var2);
      var1.y = true;
      this.b(var3, var1);
   }

   private void b(Player var1, int var2) {
      this.c(var1, var2);
   }

   private void a(TrackedEntity var1) {
      var1.h = true;
      var1.D = 0.0F;
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      g = {ServerPacket.ENTITY_TELEPORT},
      c = false
   )
   public void h(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PacketContainer var6 = var1.getPacket();
      TrackedEntity var7 = this.e(var1);
      if (var7 != null) {
         var7.a(var6);
         if (var7.r().e() && var7.u()) {
            Unknown176 var8 = this::b;
            Unknown340 var9 = var7.d();
            MoudleLoader.m().a(var5, var1, var8, var9);
         } else {
            var7.handleEntityMove(var6);
            var7.y = false;
         }

      }
   }

   @PacketListener(
      g = {ServerPacket.SPAWN_ENTITY_LIVING, ServerPacket.SPAWN_ENTITY, ServerPacket.NAMED_ENTITY_SPAWN},
      c = false
   )
   public void g(PacketEvent var1) {
      this.a(var1.getPlayer(), var1);
   }

   private void a(Player var1) {
      PlayerData var5 = PlayerDataManager.getPlayerData(var1);
      if (var5.exists()) {
         unknown79 var6 = var5.getStorage().c();
         Vector var7 = var1.getLocation().toVector();
         ArrayList var8 = new ArrayList();

         for(TrackedEntity var10 : var6.i()) {
            boolean var11 = false;
            if (var10.r() != null) {
               double var12 = var10.a(var7);
               if (var12 <= 16.0) {
                  var8.add(var10);
                  var10.z = var12;
                  var10.A = false;
                  var11 = true;
               }
            }

            var10.a(var11);
         }

         var8.sort(Comparator.comparingDouble(Check15::b));
         int var14 = 0;
         var6.e().clear();

         for(TrackedEntity var16 : var8) {
            boolean var17 = var14 < 4;
            if (var17) {
               var6.e().add(var16);
            }

            var16.a(var17);
            var16.A = var17 && var14 < 1;
            ++var14;
         }

      }
   }

   private boolean b(Player var1, int var2, Object var3) {
      PlayerData var7 = PlayerDataManager.getPlayerData(var1);
      if (var2 == h && var3 instanceof OptionalInt) {
         OptionalInt var8 = (OptionalInt)var3;
         if (!var8.isPresent()) {
            return false;
         } else {
            int var9 = var8.getAsInt();
            BukkitEnginePlayer var10 = var7.getStorage().getPhysicsHolder();
            if (var10.getPose() == Pose.ELYTRA && var9 == var1.getEntityId()) {
               var10.ba = 0;
            }

            return true;
         }
      } else {
         return false;
      }
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      g = {ServerPacket.REL_ENTITY_MOVE, ServerPacket.REL_ENTITY_MOVE_LOOK, ServerPacket.ENTITY_LOOK},
      c = false
   )
   public void a(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      PacketContainer var7 = var1.getPacket();
      int var8 = var7.getIntegers().read(0);
      TrackedEntity var9 = a(var6, var8);
      if (var9 != null) {
         var9.d(var7);
         if (var9.r().e() && var9.u()) {
            Unknown176 var10 = this::a;
            Unknown340 var11 = var9.d();
            MoudleLoader.m().a(var5, var1, var10, var11);
         } else {
            var9.handleEntityTeleport(var7);
            var9.y = false;
         }

      }
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGHEST,
      packetTypes = {ClientPacket.POSITION, ClientPacket.POSITION_LOOK, ClientPacket.LOOK, ClientPacket.FLYING}
   )
   public void d(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      unknown79 var7 = var6.getStorage().c();
      BukkitEnginePlayer var8 = var6.getStorage().getPhysicsHolder();
      if (var8.teleportTicks != 0) {
         for(TrackedEntity var10 : var7.i()) {
            int var11 = var10.position.ticks;
            var10.update();
            if (var10.u() && var11 > 0) {
               this.b(var5, var10);
            }
         }

      }
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      g = {ServerPacket.ENTITY_DESTROY},
      c = false
   )
   public void c(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      PacketContainer var3 = var1.getPacket();
      Unknown221 var4 = (Unknown221)PacketInterpreters.getInterpreter(var3);
      var4.a(this::a);
      var4.reset();
   }
}
