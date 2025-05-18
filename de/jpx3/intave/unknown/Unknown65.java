package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.check.physics.PhysicsResult;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.MovementConfiguration;

public final class Unknown65 {
   private double a = 2.147483647E9;
   private static final Unknown77 c = Unknown77.a(Unknown65::new);
   private PhysicsResult d;
   private static final int b = Integer.MAX_VALUE;

   private void a(PhysicsResult var1, double var2) {
      this.d = var1;
      this.a = var2;
   }

   public boolean isAttackReduce() {
      return this.d().isAttackReduce();
   }

   public boolean isHandActive() {
      return this.d().isHandActive();
   }

   public double f() {
      return this.a;
   }

   public static Unknown65 a(PlayerData var0) {
      Unknown65 var1 = (Unknown65)c.a(var0);
      var1.i();
      return var1;
   }

   public boolean c() {
      return this.d == null || this.a == 2.147483647E9;
   }

   public int getFoward() {
      return this.d().getForward();
   }

   public MovementConfiguration d() {
      return this.d.getMoveConfig();
   }

   public int h() {
      return this.d().getStrafe();
   }

   public PhysicsResult k() {
      return this.d;
   }

   public boolean isJump() {
      return this.d().isJump();
   }

   public boolean isSprint() {
      return this.d().isSprint();
   }

   public void i() {
      this.d = PhysicsResult.getResult();
      this.a = 2.147483647E9;
   }

   public void b(PhysicsResult var1, double var2) {
      if (var2 < this.a) {
         this.a(var1, var2);
      }

   }
}
