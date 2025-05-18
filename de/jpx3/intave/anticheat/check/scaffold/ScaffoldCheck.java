package de.jpx3.intave.anticheat.check.scaffold;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;
import de.jpx3.intave.nW;
import de.jpx3.intave.nr;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.ReachUtil;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import de.jpx3.intave.anticheat.util.WorldUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.anticheat.util.reach.DestroyedReachEntity;
import de.jpx3.intave.anticheat.util.reach.ReachPosition;
import de.jpx3.intave.anticheat.util.reach.ReachResult;
import de.jpx3.intave.anticheat.util.reach.ReachType;
import de.jpx3.intave.anticheat.violate.Anomaly;
import de.jpx3.intave.unknown.Unknown232;
import de.jpx3.intave.unknown.Unknown283;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public final class ScaffoldCheck extends PartialConfigurableCheck {
   private void a(ScaffoldStorage storage, double var2, PlayerData data) {
      BukkitEnginePlayer var5 = data.getStorage().getPhysicsHolder();
      ScaffoldStorage.a(storage, var5.moveForward);
      ScaffoldStorage.e(storage, var5.moveStrafe);
      storage.l = var5.lastX;
      storage.g = var5.lastY;
      storage.k = var5.lastZ;
      ScaffoldStorage.f(storage)[1] = ScaffoldStorage.f(storage)[0];
      ScaffoldStorage.f(storage)[0] = var2;
      ScaffoldStorage.d(storage)[1] = ScaffoldStorage.d(storage)[0];
      ScaffoldStorage.d(storage)[0] = nW.a;
      ScaffoldStorage.k(storage)[1] = ScaffoldStorage.k(storage)[0];
      ScaffoldStorage.k(storage)[0] = null;
      ScaffoldStorage.c(storage);
      ScaffoldStorage.l(storage);
      ScaffoldStorage.e(storage);
   }

   public native boolean d();

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.BLOCK_PLACE}
   )
   public void b(PacketEvent var1) {
      Player var4 = var1.getPlayer();
      PlayerData var5 = this.getPlayerData(var4);
      BlockPosition var6 = (BlockPosition)var1.getPacket().getModifier().withType(ReflectionUtil.getClazz("BlockPosition"), Unknown283.c()).read(0);
      int var7 = var1.getPacket().getIntegers().read(0);
      if (var6 != null && var7 != 255) {
         Material var8 = WorldUtil.getMaterialAt(var5, var6.toLocation(var4.getWorld()));
         boolean var9 = Unknown232.a(var8);
         if (!var9) {
            ScaffoldStorage var10 = (ScaffoldStorage)this.getStorage(var5);
            ScaffoldStorage.b(var10, 0);
         }
      }

   }

   public ScaffoldCheck(HeuristicCheckGroup var1) {
      super(var1, ScaffoldStorage.class);
   }

   private double a(double var1, double var3) {
      return var1 - Math.floor(var1 / var3) * var3;
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.POSITION_LOOK, ClientPacket.LOOK}
   )
   public void a(PacketEvent event) {
      ScaffoldStorage.n((ScaffoldStorage)this.getStorage(this.getPlayerData(event.getPlayer())));
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.USE_ENTITY}
   )
   public void handleUseEntity(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      ScaffoldStorage var7 = (ScaffoldStorage)this.getStorage(var6);
      PacketContainer var8 = event.getPacket();
      EntityUseAction var9 = (EntityUseAction)var8.getEntityUseActions().readSafely(0);
      if (var9 == null) {
         var9 = ((WrappedEnumEntityUseAction)var8.getEnumEntityUseActions().read(0)).getAction();
      }

      if (var9 == EntityUseAction.ATTACK) {
         ScaffoldStorage.setAttackTicks(var7, 0);
      }

   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.ARM_ANIMATION}
   )
   public void d(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      PlayerData var3 = this.getPlayerData(var2);
      ScaffoldStorage var4 = (ScaffoldStorage)this.getStorage(var3);
      ScaffoldStorage.f(var4, 0);
   }

   private double a(double var1, boolean var3, PlayerData var4, boolean var5) {
      ScaffoldStorage var9 = (ScaffoldStorage)this.getStorage(var4);
      double var10 = 7.0;
      if (var1 > 360.0) {
         var10 = 120.0;
      } else if (var1 > 178.0) {
         var10 = 50.0;
      } else if (var1 > 90.0) {
         var10 = 20.0;
      } else if (var1 > 50.0) {
         var10 = 10.0;
      }

      if (ScaffoldStorage.m(var9) < 3) {
         var10 *= 1.5;
      }

      if (var3) {
         var10 *= 2.0;
      }

      if (ScaffoldStorage.d(var9)[1] == nW.c) {
         var10 *= 3.0;
      } else if (ScaffoldStorage.d(var9)[1] == nW.b) {
         var10 *= 1.7;
      }

      if (var5) {
         var10 += 10.0;
      }

      var10 /= 2.0;
      var10 /= 3.0;
      if (var10 > 160.0 && var1 < 360.0) {
         var10 = 160.0;
      }

      return var10;
   }

   private int a(boolean var1) {
      short var5;
      if (var1) {
         var5 = 256;
      } else {
         var5 = 512;
      }

      return var5 | 7;
   }

   private double a(int var1, int var2) {
      return Math.toDegrees(Math.atan2((double)var1, (double)var2)) - 90.0;
   }

   @Override
   public boolean isEnabled() {
      return !MinecraftVersion.V_1_9.atOrAbove() && super.isEnabled();
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.FLYING, ClientPacket.LOOK, ClientPacket.POSITION, ClientPacket.POSITION_LOOK}
   )
   public void c(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      BukkitEnginePlayer var7 = var6.getStorage().getPhysicsHolder();
      if (var7.teleportTicks != 0) {
         ScaffoldStorage var8 = (ScaffoldStorage)this.getStorage(var6);
         if (var7.getMotionX() != 0.0 && var7.getMotionZ() != 0.0) {
            ScaffoldStorage.c(var8, (int)((double)ScaffoldStorage.a(var8) - 0.01));
            if (ScaffoldStorage.a(var8) < 0) {
               ScaffoldStorage.c(var8, 0);
            }
         }

         double var9 = (double)Math.abs(var7.lastYaw - var7.yaw);
         PlayerHolder var11 = var6.getStorage().getPlayerHolder();
         if (var9 > 40.0 && ScaffoldStorage.f(var8)[1] < 9.0 || var9 > 25.0 && ScaffoldStorage.f(var8)[1] == 0.0) {
            if (ScaffoldStorage.g(var8) != var7.moveStrafe || ScaffoldStorage.b(var8) != var7.moveForward) {
               double var12 = (double)var7.yaw + this.a(ScaffoldStorage.g(var8), ScaffoldStorage.b(var8));
               double var14 = (double)var7.lastYaw + this.a(var7.moveStrafe, var7.moveForward);
               var14 = this.a(var14, 360.0);
               var12 = this.a(var12, 360.0);
               boolean var16 = (int)(MathUtil.f(var12 - var14) / 45.0) == 0;
               if (var7.moveForward != ScaffoldStorage.b(var8) || var7.moveStrafe != ScaffoldStorage.g(var8)) {
                  if (!var16 || var7.moveForward == 0 && var7.moveStrafe == 0 || ScaffoldStorage.b(var8) == 0 && ScaffoldStorage.g(var8) == 0) {
                     ScaffoldStorage.d(var8)[0] = nW.b;
                  } else {
                     ScaffoldStorage.d(var8)[0] = nW.c;
                  }
               }
            }

            nr var26 = new nr(var8.l, var8.g, var8.k, var7.lastYaw, var7.lastPitch);
            ScaffoldStorage.k(var8)[0] = var26;

            for(Entry var31 : var6.getStorage().c().d().entrySet()) {
               TrackedEntity var15 = (TrackedEntity)var31.getValue();
               if (var15 != null && !(var15 instanceof DestroyedReachEntity)) {
                  var8.c.put(var31.getKey(), var15.potentials.get(Math.max(var15.potentials.size() - 1, 0)));
               }
            }
         }

         boolean var27 = ScaffoldStorage.f(var8)[1] == 0.0 && ScaffoldStorage.f(var8)[0] > 25.0 && ScaffoldStorage.f(var8)[0] > 9.0;
         boolean var29 = var27 && ScaffoldStorage.d(var8)[1] == nW.c && ScaffoldStorage.h(var8) > 10 && var7.teleportTicks > 7;
         var27 = ScaffoldStorage.f(var8)[1] < 9.0 && ScaffoldStorage.f(var8)[0] > 40.0 && var9 < 9.0;
         if (var27 && (ScaffoldStorage.j(var8) <= 3 || ScaffoldStorage.i(var8) <= 3) && ScaffoldStorage.h(var8) > 10 && var7.teleportTicks > 7) {
            double var32 = ScaffoldStorage.f(var8)[0];
            String var35 = "rotation snap ["
               + MathUtil2.getStringRounded(ScaffoldStorage.f(var8)[1], 2)
               + "/"
               + MathUtil2.getStringRounded(ScaffoldStorage.f(var8)[0], 2)
               + "/"
               + MathUtil2.getStringRounded(var9, 2)
               + "]";
            if (ScaffoldStorage.d(var8)[1] == nW.c) {
               var35 = var35 + " silent";
            } else if (ScaffoldStorage.d(var8)[1] == nW.b) {
               var35 = var35 + " changed";
            }

            boolean var17 = false;
            if (var11.getAttacked() != null && var11.getAttacked().potentials.size() > 2) {
               TrackedEntity var18 = var11.getAttacked();
               nr var19 = ScaffoldStorage.k(var8)[1];
               Map var20 = var8.c;
               ReachPosition var21 = (ReachPosition)var20.get(var18.i());
               if (var21 != null && var19 != null) {
                  Box var22 = TrackedEntity.getBoundingBox(var21, var18);
                  ReachResult var23 = ReachUtil.raytrace(var5, var22, 0.0, var19.e, var19.c, var19.a, var19.b, var19.d, 0.1F, ReachType.BLOCK);
                  ReachResult var24 = ReachUtil.raytrace(
                     var5, var18.getBoundingBox(), 0.0, var7.lastX, var7.lastY, var7.lastZ, var7.lastYaw, var7.lastPitch, 0.1F, ReachType.BLOCK
                  );
                  var17 = var23.getDistance() != 10.0 != (var24.getDistance() != 10.0);
                  if (var17) {
                     var35 = var35 + " lookEn";
                  }
               }
            }

            double var36 = this.a(var32, var17, var6, var29);
            var29 = false;
            if (var36 >= 40.0) {
            }

            if (var36 > 70.0) {
            }

            this.a(var6, "102", (int)var36, var35);
            var8.c.clear();
         }

         if (var29) {
            String var33 = "rotation snap scaffold [" + MathUtil2.getStringRounded(ScaffoldStorage.f(var8)[0], 2) + "]";
            byte var34 = 30;
            this.a(var6, "103", var34, var33);
         }

         this.a(var8, var9, var6);
      }
   }

   private void a(PlayerData var1, String var2, int var3, String var4) {
      ScaffoldStorage var8 = (ScaffoldStorage)this.getStorage(var1);
      Player var9 = var1.getPlayer();
      ScaffoldStorage.c(var8, ScaffoldStorage.a(var8) + var3);
      Certainty var10 = Certainty.a(ScaffoldStorage.a(var8));
      if (var10.getLevel() >= 30) {
         ScaffoldStorage.c(var8, ScaffoldStorage.a(var8) - var10.getLevel());
         if (var1.getStorage().getVersionHolder().getVersionId() > 47) {
            var4 = var4 + " " + var1.getStorage().getVersionHolder().getVersionId();
         }

         var4 = var4 + " conf:" + var10.getLevel() + "/" + ScaffoldStorage.a(var8);
         Anomaly var11 = Anomaly.of(var2, var10, CombatCheckType.KILLAURA, var4, this.a(this.d()));
         ((HeuristicCheckGroup)this.getParent()).logAnomaly(var9, var11);
      } else if (var10.getLevel() > 0) {
         var4 = var4 + " nonflag(" + var3 + "/" + var10.getLevel() + "/" + ScaffoldStorage.a(var8) + ")";
         Anomaly var14 = Anomaly.of(var2, Certainty.NONE, CombatCheckType.KILLAURA, var4, this.a(this.d()));
         ((HeuristicCheckGroup)this.getParent()).logAnomaly(var9, var14);
      }

   }
}
