package de.jpx3.intave.anticheat.util.reach;

import de.jpx3.intave.access.IntaveInternalException;

public class ReachPosition implements Cloneable {
   public double otherPlayerMPY;
   public double x;
   public double y;
   public double posZ;
   public double otherPlayerMPX;
   public double z;
   public double posY;
   public int ticks;
   public final long timestamp = System.currentTimeMillis();
   public double posX;
   public double otherPlayerMPZ;

   public Object clone() {
      return this.copy();
   }

   public ReachPosition copy() {
      try {
         return (ReachPosition)super.clone();
      } catch (CloneNotSupportedException var2) {
         throw new IntaveInternalException(var2);
      }
   }

   public String toString() {
      return "[" + this.posX + "," + this.posY + "," + this.posZ + "]";
   }
}
