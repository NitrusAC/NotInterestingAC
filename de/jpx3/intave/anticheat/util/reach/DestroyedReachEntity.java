package de.jpx3.intave.anticheat.util.reach;

import de.jpx3.intave.anticheat.unknown.HitboxSize;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;

public final class DestroyedReachEntity extends TrackedEntity {
   private static final String I;

   @Override
   void v() {
   }

   public DestroyedReachEntity() {
      super(0, new ReachEntityType("destroyed", HitboxSize.ofEmpty(), -1, false, 8), false);
   }
}
