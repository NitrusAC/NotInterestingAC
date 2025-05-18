package de.jpx3.intave.anticheat.engine;

public final class MovementConfiguration {
   private final boolean sprinting;
   private final boolean jumped;
   private final int index;
   private static final MovementConfiguration e;
   private static final int g = 4;
   private static final MovementConfiguration[] i = new MovementConfiguration[(int)(Math.pow(4.0, 2.0) * Math.pow(2.0, 4.0)) + 1];
   private final int forward;
   private final boolean handActive;
   private final int strafe;
   private final boolean attackReduce;

   public MovementConfiguration o() {
      return a(this.index | 1);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         MovementConfiguration var5 = (MovementConfiguration)var1;
         return this.index == var5.index;
      } else {
         return false;
      }
   }

   public static MovementConfiguration of(int var0, int var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      if (Math.abs(var0) <= 1 && Math.abs(var1) <= 1) {
         int var8 = var0 + 1 << 6 | var1 + 1 << 4 | (var2 ? 8 : 0) | (var3 ? 4 : 0) | (var4 ? 2 : 0) | (var5 ? 1 : 0);
         return a(var8);
      } else {
         throw new IllegalStateException("That key can not exist " + var0 + " " + var1);
      }
   }

   public boolean isHandActive() {
      return this.handActive;
   }

   public int hashCode() {
      return this.index;
   }

   public boolean isAttackReduce() {
      return this.attackReduce;
   }

   private MovementConfiguration(int index, int forward, int strafe, boolean attackReduce, boolean sprinting, boolean jumped, boolean handActive) {
      this.index = index;
      this.forward = forward;
      this.strafe = strafe;
      this.attackReduce = attackReduce;
      this.sprinting = sprinting;
      this.jumped = jumped;
      this.handActive = handActive;
   }

   public MovementConfiguration p() {
      return this.a(0, 0);
   }

   public int getStrafe() {
      return this.strafe;
   }

   public MovementConfiguration a(int var1, int var2) {
      if (Math.abs(var1) <= 1 && Math.abs(var2) <= 1) {
         int var6 = (var1 + 1 & 3) << 6;
         int var7 = (var2 + 1 & 3) << 4;
         return a(var6 | var7 | this.h().index);
      } else {
         throw new IllegalStateException("That key can not exist (" + var1 + "/" + var2 + ")");
      }
   }

   public MovementConfiguration i() {
      return a(this.index & -2);
   }

   public String toString() {
      return "MovementConfiguration{index="
         + this.index
         + ", forward="
         + this.forward
         + ", strafe="
         + this.strafe
         + ", attackReduce="
         + this.attackReduce
         + ", sprinting="
         + this.sprinting
         + ", jumped="
         + this.jumped
         + ", handActive="
         + this.handActive
         + '}';
   }

   public static MovementConfiguration k() {
      return e;
   }

   public MovementConfiguration g() {
      return a(this.index & -5);
   }

   public MovementConfiguration b() {
      return a(this.index | 4);
   }

   public MovementConfiguration n() {
      return a(this.index & -9);
   }

   public int getForward() {
      return this.forward;
   }

   public static MovementConfiguration a(int var0) {
      MovementConfiguration var3 = i[var0];
      if (var3 == null) {
         throw new IllegalStateException("Unable to lookup " + var0);
      } else {
         return var3;
      }
   }

   private MovementConfiguration h() {
      return a(this.index & (int)(Math.pow(4.0, 2.0) - 1.0));
   }

   public boolean isJump() {
      return this.jumped;
   }

   public boolean isSprint() {
      return this.sprinting;
   }

   public MovementConfiguration e() {
      return a(this.index | 8);
   }

   public MovementConfiguration f() {
      return a(this.index & -3);
   }

   static {
      for(int var11 = -1; var11 <= 1; ++var11) {
         for(int var12 = -1; var12 <= 1; ++var12) {
            for(int var13 = 0; (double)var13 < Math.pow(4.0, 2.0); ++var13) {
               int var14 = (var11 + 1 & 3) << 6 | (var12 + 1 & 3) << 4 | var13;
               i[var14] = new MovementConfiguration(var14, var11, var12, (var13 & 8) != 0, (var13 & 4) != 0, (var13 & 2) != 0, (var13 & 1) != 0);
            }
         }
      }

      e = of(0, 0, false, false, false, false);
   }

   public MovementConfiguration m() {
      return a(this.index | 2);
   }
}
