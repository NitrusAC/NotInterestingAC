package de.jpx3.intave.anticheat.engine.heading;

import de.jpx3.intave.anticheat.check.physics.PhysicsCheck;
import de.jpx3.intave.anticheat.check.physics.PhysicsResult;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.EnginePlayer;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.MovementConfiguration;

public abstract class HeadingHandler {
   private PhysicsCheck physicsCheck;

   public final void setParent(PhysicsCheck physicsCheck) {
      this.physicsCheck = physicsCheck;
   }

   public abstract void moveWithHeading(PlayerData data, double motionX, double motionY, double motionZ);

   public abstract PhysicsResult moveWithHeaving(PlayerData data, Motion motion, EnginePlayer enginePlayer, MovementConfiguration moveConfig);

   @Deprecated
   protected PhysicsCheck getPhysicsCheck() {
      return this.physicsCheck;
   }

   public String getName() {
      return "";
   }

   public float getStepHeight() {
      return 0.6F;
   }

   public abstract void moveEntityHandle(PlayerData data, double x, double y, double z, double motionX, double motionY, double motionZ);

   public boolean e() {
      return true;
   }
}
