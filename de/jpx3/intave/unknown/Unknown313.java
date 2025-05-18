package de.jpx3.intave.unknown;

import de.jpx3.intave.access.IntaveBootFailureException;
import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.check.physics.PhysicsCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.packet.wrap.modal.Pose;
import de.jpx3.intave.anticheat.reflection.PlayerConnectionReflection;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.CollisionUtil;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.PotionEffectUtil;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.anticheat.util.nms.BlockPos;
import de.jpx3.intave.anticheat.util.nms.Direction;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.util.Vector;

public final class Unknown313 extends UnknownCheck {
   private boolean a;
   private PhysicsCheck g;
   private static final Set e = new HashSet(Arrays.asList(TeleportCause.NETHER_PORTAL, TeleportCause.UNKNOWN));
   private PlayerConnectionReflection f;

   private static void a(Unknown187 var0, Player var1, Object var2) {
      var0.c = true;
   }

   private Vector a(Player var1, double var2, double var4, double var6) {
      BlockPos var11 = new BlockPos(var2, var4, var6);
      double var12 = var2 - var11.x;
      double var14 = var6 - var11.z;
      Vector var16 = new Vector();
      byte var17 = -1;
      double var18 = 9999.0;
      if (this.b(var1, var11.d()) && var12 < var18) {
         var18 = var12;
         var17 = 0;
      }

      if (this.b(var1, var11.b()) && 1.0 - var12 < var18) {
         var18 = 1.0 - var12;
         var17 = 1;
      }

      if (this.b(var1, var11.e()) && var14 < var18) {
         var18 = var14;
         var17 = 4;
      }

      if (this.b(var1, var11.f()) && 1.0 - var14 < var18) {
         var17 = 5;
      }

      float var20 = 0.1F;
      if (var17 == 0) {
         var16.setX(-var20);
      }

      if (var17 == 1) {
         var16.setX(var20);
      }

      if (var17 == 4) {
         var16.setZ(-var20);
      }

      if (var17 == 5) {
         var16.setZ(var20);
      }

      if (this.b(var1, var11.a()) && this.b(var1, var11.a().a())) {
         var16.setY(var20);
      }

      return var16;
   }

   private void cacheWater(PlayerData data) {
      Player var2 = data.getPlayer();
      World var3 = var2.getWorld();
      BukkitEnginePlayer var4 = data.getStorage().getPhysicsHolder();
      var4.inWater = CollisionUtil.collideLiquid(var3, data, var4.getBoundingBox());
   }

   public void a(Player var1, Vector var2, int var3, boolean var4) {
      PlayerData var8 = PlayerDataManager.getPlayerData(var1);
      PlayerStorage var9 = var8.getStorage();
      BukkitEnginePlayer var10 = var9.getPhysicsHolder();
      Unknown187 var11 = var9.e();
      if (!var11.k) {
         if (var10.E != null) {
            var2 = var10.E;
            var10.E = null;
         }

         var11.k = true;
         this.e(var1, var2, var3, var3, var4);
      }
   }

   private boolean a(Player var1, BlockPos var2) {
      return de.jpx3.intave.anticheat.engine.util.CollisionUtil.isColliding(var1, Box.a(PlayerDataManager.getPlayerData(var1), var2));
   }

   private void b(Player var1, Vector var2, int var3, int var4, boolean var5) {
      this.e(var1, var2, var3 - 1, var4, var5);
   }

   private Vector a(Vector var1, PlayerData var2, Box var3, boolean var4) {
      Player var8 = var2.getPlayer();
      BukkitEnginePlayer var9 = var2.getStorage().getPhysicsHolder();
      float var10 = var9.pitch;
      Vector var11 = var9.lookVector;
      double var12 = var1.getX();
      double var14 = var1.getY();
      double var16 = var1.getZ();
      if (var4) {
         if (var9.getPose() == Pose.ELYTRA) {
            float var18 = var10 * (float) (Math.PI / 180.0);
            double var19 = Math.sqrt(var11.getX() * var11.getX() + var11.getZ() * var11.getZ());
            double var21 = Math.sqrt(var12 * var12 + var16 * var16);
            double var23 = Math.sqrt(var11.lengthSquared());
            float var25 = MathUtil.cos(var18);
            var25 = (float)((double)var25 * (double)var25 * Math.min(1.0, var23 / 0.4));
            var14 += var9.ar * (-1.0 + (double)var25 * 0.75);
            if (var14 < 0.0 && var19 > 0.0) {
               double var26 = var14 * -0.1 * (double)var25;
               var14 += var26;
               var12 += var11.getX() * var26 / var19;
               var16 += var11.getZ() * var26 / var19;
            }

            if (var18 < 0.0F && var19 > 0.0) {
               double var39 = var21 * (double)(-MathUtil.sin(var18)) * 0.04;
               var14 += var39 * 3.2;
               var12 += -var11.getX() * var39 / var19;
               var16 += -var11.getZ() * var39 / var19;
            }

            if (var19 > 0.0) {
               var12 += (var11.getX() / var19 * var21 - var12) * 0.1;
               var16 += (var11.getZ() / var19 * var21 - var16) * 0.1;
            }

            var12 *= 0.99F;
            var14 *= 0.98F;
            var16 *= 0.99F;
         } else if (var9.inWater) {
            var14 = var1.getY() * 0.8F;
            var14 -= 0.02;
         } else {
            if (PotionEffectUtil.b(var8)) {
               int var34 = PotionEffectUtil.getAmplifier(var8, PotionEffectUtil.LEVITATION);
               var14 += (0.05 * (double)(var34 + 1) - var14) * 0.2;
               var2.getStorage().getPhysicsHolder().fallDistance = 0.0F;
            } else {
               var14 -= var9.ar;
            }

            var14 *= 0.98F;
         }
      }

      Vector var35 = a(var8, var3, var1.getX(), var14, var1.getZ());
      boolean var37 = var14 != var35.getY() && var14 < 0.0;
      var14 = var35.getY();
      double var20;
      if (!var4 || var9.getPose() == Pose.ELYTRA) {
         var20 = 1.0;
      } else if (var9.inWater) {
         var20 = 0.8F;
      } else {
         var20 = var37 ? 0.546F : 0.91F;
      }

      if (var9.onGround && !var9.contextGround) {
         var20 *= 0.6F;
      }

      var12 *= var20;
      var16 *= var20;
      if (var4) {
         if (var9.inWeb) {
            var12 *= 0.25;
            var14 *= 0.25;
            var16 *= 0.25;
         }

         var9.onGround = var9.contextGround;
         var9.contextGround = var37;
      }

      var35 = a(var8, var3, var12, var14, var16);
      var35.setX(this.a(var35.getX()));
      var35.setY(this.a(var35.getY()));
      var35.setZ(this.a(var35.getZ()));
      return var35;
   }

   private void setLocation(Player var1, Location var2) {
      PlayerData var6 = PlayerDataManager.getPlayerData(var1);
      BukkitEnginePlayer var7 = var6.getStorage().getPhysicsHolder();
      Box var8 = Box.of(var6, var2);
      var7.setBoundingBox(var8);
      var7.setLocation(var2.clone(), "Emulation-Setback");
      if (this.a && var6.getStorage().getItemHolder().j()) {
         var1.closeInventory();
      }

      this.a(var1, var2, var7.yaw, var7.pitch);
      this.cacheWater(var6);
   }

   private synchronized void a(Player var1, Location var2, float var3, float var4) {
      PlayerTeleportEvent var8 = this.b(var1, var2);
      this.plugin.d().a(var8);
      if (!var1.isDead() && !(var1.getHealth() <= 0.0) && var1.getPassenger() == null && var1.isOnline() && PlayerDataManager.isInjected(var1)) {
         if (!var8.isCancelled()) {
            try {
               PlayerData var9 = PlayerDataManager.getPlayerData(var1);
               if (!var9.exists()) {
                  return;
               }

               Object var10 = var9.s();
               Location var11 = var8.getTo();
               if (var11 == null) {
                  throw new IntaveBootFailureException("Setback location cannot be null");
               }

               if (Math.abs(var3) > 360.0F) {
                  this.f.a(var1, var11, var3 % 360.0F, var4, false);
               } else {
                  Field var12 = ReflectionUtil.getField("Entity", "yaw");
                  Field var13 = ReflectionUtil.getField("Entity", "pitch");
                  float var14 = var12.get(var10);
                  float var15 = var13.get(var10);
                  var12.set(var10, 0.0F);
                  var13.set(var10, 0.0F);
                  this.f.a(var1, var11, 0.0F, 0.0F, true);
                  var12.set(var10, var14);
                  var13.set(var10, var15);
               }
            } catch (IllegalAccessException var16) {
               throw new IntaveInternalException(var16);
            }
         }

      }
   }

   @Override
   public void refreshConfig() {
      this.g = (PhysicsCheck)this.plugin.g().findCheck(PhysicsCheck.class);
      this.a = this.g.isCloseInventory();
      this.f = new PlayerConnectionReflection();
   }

   @BukkitEventListener
   public void a(PlayerTeleportEvent var1) {
      if (!e.contains(var1.getCause())) {
         Player var5 = var1.getPlayer();
         PlayerData var6 = PlayerDataManager.getPlayerData(var5);
         PlayerStorage var7 = var6.getStorage();
         Unknown187 var8 = var7.e();
         if (var8.k) {
            var8.c = true;
         }

      }
   }

   private void d(Player var1, Vector var2, int var3, int var4, boolean var5) {
      this.e(var1, var2, var3, var4, var5);
   }

   private double a(double var1) {
      return MathUtil.clamp(var1, -4.0, 4.0);
   }

   private PlayerTeleportEvent b(Player var1, Location var2) {
      return new Unknown53(this, var1, var1.getLocation().clone(), var2.clone(), TeleportCause.NETHER_PORTAL);
   }

   private boolean b(Player var1, BlockPos var2) {
      return this.a(var1, var2) && this.a(var1, var2.a());
   }

   public static Vector a(Player var0, Box var1, double var2, double var4, double var6) {
      var2 = MathUtil2.clamp(-4.0, var2, 4.0);
      var4 = MathUtil2.clamp(-4.0, var4, 4.0);
      var6 = MathUtil2.clamp(-4.0, var6, 4.0);
      Boxable var12 = de.jpx3.intave.anticheat.engine.util.CollisionUtil.d(var0, var1.addCoord(var2, var4, var6));
      var4 = var12.calculateOffset(Direction.Y, var1, var4);
      var1 = var1.add(0.0, var4, 0.0);
      var2 = var12.calculateOffset(Direction.X, var1, var2);
      var1 = var1.add(var2, 0.0, 0.0);
      var6 = var12.calculateOffset(Direction.Z, var1, var6);
      return new Vector(var2, var4, var6);
   }

   private void e(Player var1, Vector var2, int var3, int var4, boolean var5) {
      if (!Bukkit.isPrimaryThread()) {
         IntaveScheduler.a(this::d, 0);
      } else {
         PlayerData var9 = PlayerDataManager.getPlayerData(var1);
         if (var9.exists()) {
            PlayerStorage var10 = var9.getStorage();
            BukkitEnginePlayer var11 = var10.getPhysicsHolder();
            Unknown187 var12 = var10.e();
            if (var12.k) {
               Location var13 = var11.getLocation();
               Box var14 = Box.of(var9, var13);
               Vector var15 = var11.E;
               if (var15 != null) {
                  var2 = this.a(var15, var9, var14, true);
                  var11.E = null;
               } else {
                  var2 = this.a(var2, var9, var14, var4 > var3);
               }

               if (var2.getY() < 0.0) {
                  var11.fallDistance = (float)((double)var11.fallDistance + -var2.getY());
               }

               if (!de.jpx3.intave.anticheat.engine.util.CollisionUtil.a(var1, Box.of(var9, var13.clone().add(var2)))) {
                  var13 = var13.clone().add(var2);
               }

               var13.setYaw(var11.yaw);
               var13.setPitch(var11.pitch);
               if ((!(Math.abs(var2.getX()) < 0.01) || !(Math.abs(var2.getZ()) < 0.01) || var2.getY() != 0.0 || !var5) && var3 > 0) {
                  var14 = Box.of(var9, var13);
                  boolean var29 = de.jpx3.intave.anticheat.engine.util.CollisionUtil.a(var9.getPlayer(), var14);
                  if (var29) {
                     double var17 = (var14.minX + var14.maxX) / 2.0;
                     double var19 = (var14.minY + var14.maxY) / 2.0;
                     double var21 = (var14.minZ + var14.maxZ) / 2.0;
                     Vector var23 = this.a(var1, var17, var19, var21);
                     Location var24 = var13.add(var23);
                     this.setLocation(var1, var24);
                  } else {
                     this.setLocation(var1, var13);
                  }

                  Vector var30 = var2.clone();
                  IntaveScheduler.a(this::b, 1);
                  Vector var18 = this.a(var2, var9, var14, true);
                  var11.bh = true;
                  var11.bo = var18;
                  var1.setVelocity(new Vector(0, 0, 0));
               } else {
                  var13.subtract(0.0, 0.02, 0.0);
                  var14 = Box.of(var9, var13);
                  var13.add(0.0, de.jpx3.intave.anticheat.engine.util.CollisionUtil.isColliding(var1, var14) ? 0.03 : 0.0201, 0.0);
                  var14 = Box.of(var9, var13);
                  MoudleLoader.m().a(var1, Unknown313::a);
                  this.setLocation(var1, var13);
                  Vector var16 = this.a(var2, var9, var14, true);
                  var11.bh = true;
                  var1.setVelocity(var16);
                  var11.deltaX = var16.getX();
                  var11.deltaY = var16.getY();
                  var11.deltaZ = var16.getZ();
                  if (var11.contextGround) {
                     this.g.computeFall(var9);
                     var11.fallDistance = 0.0F;
                  }
               }

            }
         }
      }
   }
}
