package de.jpx3.intave.anticheat.util.vector;

import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.nms.BlockPos;
import java.io.Serializable;
import org.bukkit.util.Vector;

public final class IntaveVector extends Vector implements Serializable {
   public boolean isNaN() {
      return Double.isNaN(this.x) || Double.isNaN(this.y) || Double.isNaN(this.z);
   }

   public Vector clone() {
      return this.copy();
   }

   public Object clone() {
      return this.copy();
   }

   public static IntaveVector c() {
      return new IntaveVector();
   }

   public IntaveVector() {
   }

   public IntaveVector copy() {
      return (IntaveVector)super.clone();
   }

   public IntaveVector(double x, double y, double z) {
      super(x, y, z);
   }

   public BlockPos a() {
      return new BlockPos(MathUtil.floor(this.x), MathUtil.floor(this.y), MathUtil.floor(this.z));
   }
}
