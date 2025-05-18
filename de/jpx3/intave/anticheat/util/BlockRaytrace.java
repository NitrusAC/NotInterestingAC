package de.jpx3.intave.anticheat.util;

public final class BlockRaytrace {
   private final double lengthOffset;
   private final Direction direction;
   private static final BlockRaytrace defaultRaytrace = new BlockRaytrace(null, 2.147483647E9);

   public BlockRaytrace(Direction direction, double lengthOffset) {
      this.direction = direction;
      this.lengthOffset = lengthOffset;
   }

   public Direction getDirection() {
      return this.direction;
   }

   public String toString() {
      return "BlockRaytrace{direction=" + this.direction + ", lengthOffset=" + this.lengthOffset + '}';
   }

   public static BlockRaytrace of(Direction direction, double lengthOffset) {
      return new BlockRaytrace(direction, lengthOffset);
   }

   public static BlockRaytrace getDefaultRaytrace() {
      return defaultRaytrace;
   }

   public double getLengthOffset() {
      return this.lengthOffset;
   }

   public BlockRaytrace a(BlockRaytrace var1) {
      return var1 != defaultRaytrace && var1 != null ? (var1.lengthOffset < this.lengthOffset ? var1 : this) : this;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         BlockRaytrace var5 = (BlockRaytrace)var1;
         if (Double.compare(var5.lengthOffset, this.lengthOffset) != 0) {
            return false;
         } else {
            return this.direction == var5.direction;
         }
      } else {
         return false;
      }
   }
}
