package de.jpx3.intave.anticheat.engine;

import de.jpx3.intave.anticheat.packet.wrap.modal.Pose;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import org.bukkit.util.Vector;

public interface EnginePlayer {
   boolean isContextGround();

   float getAcceleration();

   Pose getPose();

   boolean isCollideLava();

   double getServerZ();

   boolean isSneaking();

   double getLastX();

   double getJumpBoostHeight();

   double y();

   double getServerY();

   double getMinimumMotion();

   double getMotionY();

   default IntaveVector D() {
      return new IntaveVector(this.getX(), this.getY(), this.getZ());
   }

   default IntaveVector getIntaveVector() {
      return new IntaveVector(this.getLastX(), this.getLastY(), this.getLastZ());
   }

   boolean isInWeb();

   float getYaw();

   double getLastZ();

   Vector getLookVector();

   double getMotionZ();

   Vector getMoveVector();

   default Motion getMotion() {
      return new Motion(this.getMotionX(), this.getMotionY(), this.getMotionZ());
   }

   float getPitch();

   double getLastY();

   boolean isCollideWater();

   float getRotationZ();

   double getX();

   double getY();

   double getMotionX();

   double getServerX();

   boolean isOnGround();

   float G();

   float getMovementSpeed(boolean sprinting);

   double getZ();

   default IntaveVector getServerVector() {
      return new IntaveVector(this.getServerX(), this.getServerY(), this.getServerZ());
   }
}
