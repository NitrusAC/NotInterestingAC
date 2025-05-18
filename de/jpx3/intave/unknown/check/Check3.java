package de.jpx3.intave.unknown.check;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;
import com.google.common.util.concurrent.AtomicDouble;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.util.HitResult;
import de.jpx3.intave.anticheat.util.ReachUtil;
import de.jpx3.intave.anticheat.util.nms.WrappedVec3d;
import de.jpx3.intave.check.api.CheckOfSomeKind;
import de.jpx3.intave.unknown.Unknown24;
import de.jpx3.intave.unknown.Unknown323;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public abstract class Check3 extends CheckOfSomeKind {
   private final boolean f;
   private final boolean g;
   private final int e;

   public double getAverage(List var1) {
      return var1.stream().mapToDouble(Number::doubleValue).average().orElse(0.0);
   }

   public Check3(HeuristicCheckGroup var1, Class var2, int var3) {
      super(var1, var2);
      this.e = var3;
      this.f = true;
      this.g = false;
   }

   private boolean a(PlayerData var1) {
      Player var5 = var1.getPlayer();
      World var6 = var1.getPlayer().getWorld();
      BukkitEnginePlayer var7 = var1.getStorage().getPhysicsHolder();
      Location var8 = new Location(var6, var7.lastX, var7.lastY, var7.lastZ, var7.yaw, var7.pitch);

      HitResult var9;
      try {
         var9 = ReachUtil.a(var5, var8);
      } catch (Exception var11) {
         var11.printStackTrace();
         return true;
      }

      return var9 != null && var9.pos != WrappedVec3d.c;
   }

   public double getStandardDeviation(List var1) {
      double var2 = this.getAverage(var1);
      AtomicDouble var4 = new AtomicDouble(0.0);
      var1.forEach(Check3::b);
      return Math.sqrt(var4.get() / (double)var1.size());
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.BLOCK_PLACE}
   )
   public void b(PacketEvent var1) {
      PlayerData var2 = this.getPlayerData(var1.getPlayer());
      Unknown24 var3 = (Unknown24)this.getStorage(var2);
      var3.a = true;
   }

   public Check3(HeuristicCheckGroup var1, Class var2, int var3, boolean var4, boolean var5) {
      super(var1, var2);
      this.e = var3;
      this.f = var4;
      this.g = var5;
   }

   public double getTickAverage(List var1) {
      return 20.0 / this.getAverage(var1);
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.FLYING, ClientPacket.LOOK, ClientPacket.POSITION, ClientPacket.POSITION_LOOK}
   )
   public void c(PacketEvent var1) {
      PlayerData var6 = this.getPlayerData(var1.getPlayer());
      Unknown24 var7 = (Unknown24)this.getStorage(var6);

      for(Unknown323 var9 : var7.c) {
         if (var7.h <= 0 || !this.a(var6)) {
            if (var9.a == 0) {
               ++var7.f;
            }

            var7.j.add(Math.abs(var9.a - var9.b));
            var7.g.add(var9.a);
            if (var7.g.size() == this.e) {
               this.handle(var6, var7.g);
               var7.g.clear();
            }
         }
      }

      var7.c.clear();
      ++var7.d;
      ++var7.h;
      var7.a = false;
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.USE_ENTITY}
   )
   public void a(PacketEvent var1) {
      PlayerData var5 = this.getPlayerData(var1.getPlayer());
      Unknown24 var6 = (Unknown24)this.getStorage(var5);
      PacketContainer var7 = var1.getPacket();
      EntityUseAction var8 = (EntityUseAction)var7.getEntityUseActions().readSafely(0);
      if (var8 == null) {
         var8 = ((WrappedEnumEntityUseAction)var7.getEnumEntityUseActions().read(0)).getAction();
      }

      if (var8 == EntityUseAction.ATTACK) {
         var6.h = 0;
      }

   }

   private static void b(AtomicDouble var0, double var1, Integer var3) {
      var0.getAndAdd(Math.pow(var3.doubleValue() - var1, 2.0));
   }

   public abstract void handle(PlayerData data, List clicks);

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.ARM_ANIMATION}
   )
   public void d(PacketEvent var1) {
      PlayerData var5 = this.getPlayerData(var1.getPlayer());
      Unknown24 var6 = (Unknown24)this.getStorage(var5);
      if (var5.getStorage().getVersionHolder().isLegacy()) {
         if (!var5.getStorage().getPlayerHolder().digging && !var6.a) {
            boolean var7 = !this.g || var6.h <= 10;
            boolean var8 = !this.f || var6.d > 0;
            if (var6.d <= 15 && var6.e <= 15 && var7 && var8) {
               Unknown323 var9 = new Unknown323(var6.d, var6.e);
               var6.c.add(var9);
            }

            var6.e = var6.d;
            var6.d = 0;
         }
      }
   }
}
