package de.jpx3.intave.anticheat.util.reach;

import de.jpx3.intave.anticheat.util.nms.WrappedVec3d;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;

public final class ReachResult {
   private final IntaveVector hitPos;
   private final double distance;
   private final IntaveVector eyeLocation;

   public IntaveVector getEyeLocation() {
      return this.eyeLocation;
   }

   public double getDistance() {
      return this.distance;
   }

   public ReachResult(IntaveVector eyeLocation, IntaveVector hitPos, double distance) {
      this.eyeLocation = eyeLocation;
      this.hitPos = hitPos;
      this.distance = distance;
   }

   public IntaveVector getHitPos() {
      return this.hitPos;
   }

   public static ReachResult of(WrappedVec3d eyeLocation, WrappedVec3d hitPos, double distance) {
      return new ReachResult(eyeLocation.copy(), hitPos == null ? null : hitPos.copy(), distance);
   }
}
