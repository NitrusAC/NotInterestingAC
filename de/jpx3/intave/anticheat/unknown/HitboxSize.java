package de.jpx3.intave.anticheat.unknown;

public final class HitboxSize {
   private final float width;
   private final float height;

   public static HitboxSize of(float width, float length) {
      return new HitboxSize(width, length);
   }

   public float getHeight() {
      return this.height;
   }

   private HitboxSize(float width, float height) {
      this.width = width;
      this.height = height;
   }

   public static HitboxSize ofEmpty() {
      return new HitboxSize(0.0F, 0.0F);
   }

   public String toString() {
      return "HitboxSize{width=" + this.width + ", height=" + this.height + '}';
   }

   public static HitboxSize ofPlayer() {
      return new HitboxSize(0.6F, 1.8F);
   }

   public float getWidth() {
      return this.width;
   }
}
