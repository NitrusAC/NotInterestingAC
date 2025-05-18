package de.jpx3.intave.anticheat.check.physics;

import de.jpx3.intave.Relocate;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.engine.Motion;
import de.jpx3.intave.anticheat.engine.MotionContext;
import de.jpx3.intave.anticheat.engine.MovementConfiguration;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.unknown.Unknown77;

@Relocate
public final class PhysicsResult {
   private String d = "";
   private static final Unknown77 b = Unknown77.a(PhysicsResult::new);
   private MovementConfiguration moveConfig;
   private MotionContext motionContext;
   private static final PhysicsResult instance = new PhysicsResult(MovementConfiguration.k(), MotionContext.ofEmpty());

   public PhysicsResult copy() {
      return new PhysicsResult(this.moveConfig, this.motionContext);
   }

   private PhysicsResult() {
   }

   public static PhysicsResult getResult() {
      return instance;
   }

   public MovementConfiguration getMoveConfig() {
      return this.moveConfig;
   }

   public double a(Motion motion) {
      return MathUtil2.a(this.getMotion(), motion);
   }

   public void a(MovementConfiguration var1, MotionContext var2) {
      this.moveConfig = var1;
      this.motionContext = var2;
      this.d = "";
   }

   public static PhysicsResult of(PlayerData data, MovementConfiguration config, MotionContext motionContext) {
      PhysicsResult var3 = (PhysicsResult)b.a(data);
      var3.a(config, motionContext);
      return var3;
   }

   private PhysicsResult(MovementConfiguration moveConfig, MotionContext context) {
      this.moveConfig = moveConfig;
      this.motionContext = context;
   }

   public Motion getMotion() {
      return this.motionContext.getMotion();
   }

   public void a(String var1) {
      this.d = this.d + var1;
   }

   public String f() {
      return this.d;
   }

   public MotionContext getMotionContext() {
      return this.motionContext;
   }
}
