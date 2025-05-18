package de.jpx3.intave.anticheat.engine.runner;

import de.jpx3.intave.Relocate;
import de.jpx3.intave.anticheat.check.physics.PhysicsResult;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.ItemHolder;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.MovementConfiguration;
import de.jpx3.intave.anticheat.engine.heading.HeadingHandler;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.util.AccurateMathUtil;
import de.jpx3.intave.clean.Clean1;
import de.jpx3.intave.unknown.Unknown135;
import de.jpx3.intave.unknown.Unknown159;
import de.jpx3.intave.unknown.Unknown249;
import de.jpx3.intave.unknown.Unknown65;
import de.jpx3.intave.unknown.check.Check9;
import de.jpx3.intave.unknown.what.What1;
import java.util.List;

@Relocate
public final class IntaveEngineRunner implements EngineRunner {
   private static final boolean[] a = new boolean[]{true, false};
   private static final double g = 0.002;
   private static final int[] moveStrafe = new int[]{0, -1, -1, -1, 0, 1, 1, 1, 0};
   private final boolean h;
   private static final boolean[] k = new boolean[]{false};
   private static final int[] moveForward = new int[]{1, 1, 0, -1, -1, -1, 0, 1, 1};
   private static final boolean[] c = new boolean[]{false, true};
   private static final int[][] pairs = new int[][]{{1, 0}, {0, 0}, {1, -1}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
   private static final boolean[] f = new boolean[]{true};
   private static final double e = 0.02;
   private static final double j = 0.1;

   @Override
   public PhysicsResult execute(PlayerData data, HeadingHandler var2) {
      BukkitEnginePlayer var3 = data.getStorage().getPhysicsHolder();
      boolean var4 = var2.e();
      if (var3.bn) {
         return this.a(data, var2, var3.G, var3.D, var3.c);
      } else {
         return var4 ? this.d(data, var2) : this.a(data, var2, 0, 0, false);
      }
   }

   @Override
   public PhysicsResult a(PlayerData var1, HeadingHandler var2, int var3, int var4, boolean var5) {
      PlayerStorage var6 = var1.getStorage();
      BukkitEnginePlayer var7 = var6.getPhysicsHolder();
      var5 &= var7.onGround;
      var7.moveForward = var3;
      var7.moveStrafe = var4;
      var7.jumping = var5;
      Unknown249.logMoveKeys(var7.moveForward, var7.moveStrafe);
      Motion var8 = var7.motion.copy();
      var8.a(var7);
      MovementConfiguration var9 = MovementConfiguration.of(var3, var4, false, var7.w(), var5, var6.getItemHolder().h());
      return var2.moveWithHeaving(var1, var8, var7, var9);
   }

   private static int a(int var0) {
      return var0 == -1 ? 0 : moveStrafe[var0];
   }

   private static int b(int var0) {
      return var0 == -1 ? 0 : moveForward[var0];
   }

   private double b(double var1, double var3, float var5) {
      if (AccurateMathUtil.deltaXZ(var1, var3) > 0.001) {
         double var6 = Math.toDegrees(Math.atan2(var3, var1)) - 90.0;
         var6 -= (double)var5;
         var6 %= 360.0;
         if (var6 < 0.0) {
            var6 += 360.0;
         }

         var6 = Math.abs(var6);
         var6 /= 45.0;
         return Math.abs(var6 - (double)((int)Math.round(var6)));
      } else {
         return 0.0;
      }
   }

   private Unknown65 iterate(PlayerData var1, HeadingHandler var2) {
      What1.f.h();
      PlayerStorage var3 = var1.getStorage();
      ItemHolder var4 = var3.getItemHolder();
      BukkitEnginePlayer var5 = var3.getPhysicsHolder();
      VersionHolder var6 = var3.getVersionHolder();
      Unknown65 var7 = Unknown65.a(var1);
      boolean var8 = var5.isCollideLava();
      boolean var9 = var5.isCollideWater();
      boolean var10 = var5.isOnGround();
      boolean var11 = Math.abs(var5.getMotionY() - (double)(1.0F - var1.getHitboxSize(var5.getPose()).getHeight() % 1.0F)) < 1.0E-5
         || Math.abs(var5.getMotionY() - var5.getJumpBoostHeight()) < 1.0E-4;
      boolean var12 = !var6.isModern() && var5.sprinting;
      int var13 = 0;
      int var14 = -2;
      int var15 = -2;
      double var16 = Double.MAX_VALUE;
      List var18 = var5.a();
      int[] var19 = new int[var18.size()];

      label182:
      for(int var20 = 0; var20 < 1; ++var20) {
         Object var21 = null;
         byte var22 = 1;

         for(int var23 = 0; var23 < Math.max(var22, 1); ++var23) {
            for(boolean var27 : !var5.w() && !var5.be ? k : c) {
               var5.updateAcceleration(var27);

               for(boolean var31 : var4.h() ? a : c) {
                  if (!var12 || !var31) {
                     Clean1.d.a();

                     for(boolean var35 : c) {
                        if (!var35 || var5.slowdownTicks < 1 && !Check9.e) {
                           Clean1.e.a();

                           for(boolean var39 : var11 ? a : c) {
                              if ((!var39 || var10 || var8 || var9) && (!var39 || !var5.F())) {
                                 Clean1.c.a();
                                 boolean var40 = var16 < 1.0;

                                 for(int var41 = var40 ? -1 : 0; var41 < 9; ++var41) {
                                    int var42;
                                    int var43;
                                    if (var41 >= 0) {
                                       int[] var44 = pairs[var41];
                                       var42 = var44[0];
                                       var43 = var44[1];
                                       if (var40 && var42 == var14 && var43 == var15) {
                                          continue;
                                       }
                                    } else {
                                       var42 = var14;
                                       var43 = var15;
                                    }

                                    if (!var27 || var42 == 1) {
                                       ++var13;
                                       MovementConfiguration var48 = MovementConfiguration.of(var42, var43, var35, var27, var39, var31);
                                       PhysicsResult var45 = this.a(var1, var2, var7, var48, false);
                                       double var46 = var45.a(var5.getMotion());
                                       if (var46 < var16) {
                                          var16 = var46;
                                          var14 = var42;
                                          var15 = var43;
                                       }

                                       if (var7.f() <= (var5.b(2) ? 0.02 : 0.002)) {
                                          break label182;
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if (var7.c()) {
         this.a(var1, var2, var7, MovementConfiguration.k(), true);
      }

      Clean1.d.d();
      Clean1.e.d();
      Clean1.c.d();
      Clean1.a(var13);
      What1.f.g();
      return var7;
   }

   private double a(double var1, double var3, float var5) {
      if (AccurateMathUtil.deltaXZ(var1, var3) > 0.001) {
         double var6 = Math.toDegrees(Math.atan2(var3, var1)) - 90.0;
         var6 -= (double)var5;
         var6 %= 360.0;
         if (var6 < 0.0) {
            var6 += 360.0;
         }

         var6 = Math.abs(var6);
         var6 /= 45.0;
         return (double)((int)Math.round(var6));
      } else {
         return -1.0;
      }
   }

   private PhysicsResult e(PlayerData data, HeadingHandler var2) {
      What1.d.h();
      What1.m.h();
      BukkitEnginePlayer var3 = data.getStorage().getPhysicsHolder();
      ItemHolder var4 = data.getStorage().getItemHolder();
      Motion var5 = var3.motion;
      double var6 = var3.deltaX;
      double var8 = var3.deltaZ;
      boolean var10 = false;
      boolean var11 = var3.w() || var3.be;
      if (var3.onGround && !var3.F()) {
         double var12 = var3.getMotionY();
         var10 = Math.abs(var12 - 0.2) < 1.0E-5 || var12 == var3.getJumpBoostHeight();
         if (var10 && var11) {
            var6 -= (double)(var3.G() * 0.2F);
            var8 += (double)(var3.getRotationZ() * 0.2F);
         }
      }

      if (var3.inWater && !var3.F()) {
         var10 = var3.getMotionY() > 0.0;
      }

      double var23 = var3.getMotionX() - var6;
      double var14 = var3.getMotionZ() - var8;
      float var16 = var3.yaw;
      boolean var17 = var4.j();
      double var18 = this.a(var23, var14, var16);
      int var20 = (int)Math.round(var18);
      if (var17 || !(var18 < 0.0) && !(Math.abs(var18 - (double)var20) > 0.1)) {
         MovementConfiguration var21 = MovementConfiguration.k();
         var21 = var21.a(b(var20), a(var20));
         if (var10) {
            var21 = var21.m();
         }

         if (var4.h()) {
            var21 = var21.o();
         }

         if (!Check9.e && var3.w() && var3.slowdownTicks == 0) {
            var21 = var21.e();
         }

         if (var11 && var21.getForward() != 1) {
            var21 = var21.p();
         } else if (var11) {
            var21 = var21.b();
         }

         if (var17) {
            var21 = var21.g();
            var21 = var21.p();
         }

         var3.jumping = var10;
         var5.a(var3);
         var3.moveForward = var21.getForward();
         var3.moveStrafe = var21.getStrafe();
         var3.updateAcceleration(var11);
         PhysicsResult var22 = var2.moveWithHeaving(data, var5, var3, var21);
         What1.m.g();
         What1.d.g();
         return var22;
      } else {
         var3.jumping = false;
         var3.moveForward = -2;
         var3.moveStrafe = -2;
         var5.a(var3);
         What1.d.g();
         What1.m.g();
         return PhysicsResult.getResult();
      }
   }

   private PhysicsResult c(PlayerData var1, HeadingHandler var2) {
      What1.d.h();
      What1.n.h();
      BukkitEnginePlayer var3 = var1.getStorage().getPhysicsHolder();
      ItemHolder var4 = var1.getStorage().getItemHolder();
      Motion var5 = var3.motion;
      int var6 = var3.lastMoveForward;
      int var7 = var3.lastMoveStrafe;
      boolean var8 = var4.j();
      if (!var8 && var6 == var3.moveForward && var7 == var3.moveStrafe) {
         What1.n.g();
         What1.d.g();
         return PhysicsResult.getResult();
      } else {
         MovementConfiguration var9 = MovementConfiguration.k();
         var9 = var9.a(var6, var7);
         if (!Check9.e && var3.w() && var1.getStorage().getPhysicsHolder().slowdownTicks == 0) {
            var9 = var9.e();
         }

         boolean var10 = var3.w();
         if (var3.onGround && !var3.F()) {
            double var11 = var3.getMotionY();
            if (Math.abs(var11 - 0.2) < 1.0E-5 || var11 == var3.getJumpBoostHeight()) {
               var9 = var9.m();
            }
         }

         if (var3.inWater && !var3.F() && var3.getMotionY() > 0.0) {
            var9 = var9.m();
         }

         if (var4.h()) {
            var9 = var9.o();
         }

         if (var10 && var6 != 1) {
            var9 = var9.p();
         } else if (var10) {
            var9 = var9.b();
         }

         if (var4.j()) {
            var9 = var9.p();
         }

         var3.jumping = var9.isJump();
         var5.a(var3);
         var3.moveForward = var9.getForward();
         var3.moveStrafe = var9.getStrafe();
         var3.updateAcceleration(var10);
         PhysicsResult var14 = var2.moveWithHeaving(var1, var5, var3, var9);
         What1.n.g();
         What1.d.g();
         return var14;
      }
   }

   private void a(PlayerData data, Unknown65 var2) {
      PlayerStorage var3 = data.getStorage();
      BukkitEnginePlayer var4 = var3.getPhysicsHolder();
      ItemHolder var5 = var3.getItemHolder();
      if (var4.slowdownTicks == 0 && var4.sprinting && !var2.isAttackReduce()) {
         var4.ae = true;
      }

      boolean var6 = var2.isHandActive();
      boolean var7 = var5.h();
      if (var7 && !var6) {
         boolean var8 = AccurateMathUtil.deltaXZ(var4.getMotionX(), var4.getMotionZ()) > 0.3 || var4.teleportTicks >= 2;
         boolean var9 = Unknown159.c(var3.getItemHolder().getMaterial());
         if (var8 && !var9 && this.h) {
            var3.getItemHolder().g();
         }
      }

      var4.moveForward = var2.getFoward();
      var4.moveStrafe = var2.h();
      var4.jumping = var2.isJump();
   }

   private PhysicsResult a(PlayerData var1, HeadingHandler var2, Unknown65 var3, MovementConfiguration var4, boolean var5) {
      BukkitEnginePlayer var6 = var1.getStorage().getPhysicsHolder();
      ItemHolder var7 = var1.getStorage().getItemHolder();
      Motion var8 = var6.motion;
      var8.a(var6);
      PhysicsResult var9 = var2.moveWithHeaving(var1, var8, var6, var4);
      double var10 = var9.a(var6.getMotion());
      if (var5 || var7.h() == var4.isHandActive() || var10 < 0.001) {
         var9 = var9.copy();
         var3.b(var9, var10);
      }

      return var9;
   }

   private PhysicsResult d(PlayerData var1, HeadingHandler var2) {
      BukkitEnginePlayer var3 = var1.getStorage().getPhysicsHolder();
      List var4 = var3.a();

      for(Unknown135 var6 : var4) {
         var6.d(0);
      }

      PhysicsResult var12 = this.e(var1, var2);
      double var13 = var12.a(var3.getMotion());
      boolean var8 = var13 > 0.002;
      if (var8) {
         var12 = this.c(var1, var2);
         var13 = var12.a(var3.getMotion());
         var8 = var13 > 0.002;
      }

      for(Unknown135 var10 : var4) {
         var10.b(0);
      }

      boolean var15 = !var1.getStorage().getItemHolder().j();
      if (var8 && var15) {
         Unknown65 var17 = this.iterate(var1, var2);
         var12 = var17.k();
         this.a(var1, var17);
      } else {
         for(Unknown135 var11 : var4) {
            var11.c(0);
         }
      }

      Unknown249.logMoveKeys(var3.moveForward, var3.moveStrafe);
      return var12;
   }

   public IntaveEngineRunner(boolean var1) {
      this.h = var1;
   }
}
