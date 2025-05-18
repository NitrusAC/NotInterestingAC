package de.jpx3.intave.anticheat.engine;

import de.jpx3.intave.anticheat.util.MathUtil2;

public final class MotionContext {
   private final boolean onGround;
   private final boolean collideHorizontally;
   private final boolean collideZ;
   private final boolean stepped;
   private final boolean collideX;
   private final Motion motion;
   private static final String k;
   private final boolean collideVertically;
   private static final MotionContext DEFAULT = new MotionContext(
      new Motion(2.147483647E9, 2.147483647E9, 2.147483647E9), false, false, false, false, false, false
   );

   public boolean isStep() {
      return this.stepped;
   }

   public boolean isCollideVertical() {
      return this.collideVertically;
   }

   public boolean isCollideX() {
      return this.collideX;
   }

   public double a(Motion var1) {
      return MathUtil2.a(this.motion, var1);
   }

   public MotionContext(
      Motion motion, boolean onGround, boolean collideHorizontally, boolean collideVertically, boolean collideX, boolean collideZ, boolean stepped
   ) {
      if (motion == null) {
         throw new IllegalArgumentException("Context cannot be null");
      } else {
         this.motion = motion;
         this.onGround = onGround;
         this.collideHorizontally = collideHorizontally;
         this.collideVertically = collideVertically;
         this.collideX = collideX;
         this.collideZ = collideZ;
         this.stepped = stepped;
      }
   }

   public boolean isCollideHorizontal() {
      return this.collideHorizontally;
   }

   public boolean isOnGround() {
      return this.onGround;
   }

   public static MotionContext ofEmpty() {
      return DEFAULT;
   }

   public boolean isCollideZ() {
      return this.collideZ;
   }

   private static IllegalArgumentException a(IllegalArgumentException var0) {
      return var0;
   }

   public Motion getMotion() {
      return this.motion;
   }
}
