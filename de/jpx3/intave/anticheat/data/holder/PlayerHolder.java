package de.jpx3.intave.anticheat.data.holder;

import de.jpx3.intave.Relocate;
import de.jpx3.intave.k3;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.anticheat.util.reach.ReachPosition;
import de.jpx3.intave.unknown.Unknown148;
import de.jpx3.intave.unknown.Unknown230;
import de.jpx3.intave.unknown.Unknown363;
import de.jpx3.intave.unknown.check.Check15;
import org.bukkit.entity.Player;

@Relocate
public final class PlayerHolder {
   private long lastEntitySwitch;
   public double h;
   private long l;
   @k3
   private Unknown148 p;
   public boolean digging;
   public double e;
   @k3
   public Unknown363 s;
   private TrackedEntity lastAttacked;
   @k3
   public Unknown230 m;
   private final Player player;
   private float lastDimensionalOffset;
   private float horizontalAngle;
   private long lastAttack;
   private double hitDistance;
   private float dimensionalOffset;
   private float lastHorizontalAngle;
   public long lastDig;
   public double f;
   private int attackedEntitiyId = -1;

   @k3
   public TrackedEntity getAttacked() {
      return this.lastAttacked;
   }

   public float getDimensionalAngle() {
      return this.dimensionalOffset;
   }

   public boolean g() {
      return System.currentTimeMillis() - this.l < 2000L;
   }

   public void j() {
      this.l = System.currentTimeMillis();
   }

   public int l() {
      return this.attackedEntitiyId;
   }

   public boolean hasAttacked(long time) {
      return System.currentTimeMillis() - this.lastAttack <= time;
   }

   public void setHitDistance(double distance) {
      this.hitDistance = distance;
   }

   public double getHitDistance() {
      return this.hitDistance;
   }

   public void setAttackedEntityId(int entityId) {
      this.attackedEntitiyId = entityId;
      TrackedEntity var2 = this.lastAttacked;
      TrackedEntity var3 = Check15.a(PlayerDataManager.getPlayerData(this.player), entityId);
      if (var3 != null && var3 != var2) {
         this.lastEntitySwitch = System.currentTimeMillis();
      }

      this.lastAttacked = var3;
      this.lastAttack = System.currentTimeMillis();
   }

   public boolean hasSwitchedTargets(long time) {
      return System.currentTimeMillis() - this.lastEntitySwitch <= time;
   }

   public PlayerHolder(Player player) {
      this.lastAttack = 0L;
      this.lastEntitySwitch = 0L;
      this.l = 0L;
      this.player = player;
   }

   public void clearAttacker() {
      this.attackedEntitiyId = 0;
      this.lastAttacked = null;
   }

   public float getLastDimensionalAngle() {
      return this.lastDimensionalOffset;
   }

   public void calculateOffsets() {
      PlayerData var1 = PlayerDataManager.getPlayerData(this.player);
      BukkitEnginePlayer var2 = var1.getStorage().getPhysicsHolder();
      double var3 = var2.x;
      double var5 = var2.y;
      double var7 = var2.z;
      double var9 = var2.lastX;
      double var11 = var2.lastY;
      double var13 = var2.lastZ;
      if (this.lastAttacked != null) {
         ReachPosition var15 = this.lastAttacked.position;
         ReachPosition var16 = this.lastAttacked.lastPosition;
         this.horizontalAngle = getHorizontalAngle(var15, var3, var7);
         this.dimensionalOffset = getDimensionalAngle(var15, var3, var5, var7);
         this.lastHorizontalAngle = getHorizontalAngle(var16, var9, var13);
         this.lastDimensionalOffset = getDimensionalAngle(var16, var9, var11, var13);
      }

   }

   public float getLastHorizontalAngle() {
      return this.lastHorizontalAngle;
   }

   public float getHorizontalAngle() {
      return this.horizontalAngle;
   }

   private static float getHorizontalAngle(ReachPosition position, double x, double z) {
      double var5 = position.posX - x;
      double var7 = position.posZ - z;
      return (float)Math.toDegrees(Math.atan2(var7, var5)) - 90.0F;
   }

   private static float getDimensionalAngle(ReachPosition position, double x, double y, double z) {
      double var7 = position.posY + 1.62F - (y + 1.62F);
      double var9 = position.posX - x;
      double var11 = position.posZ - z;
      double var13 = Math.sqrt(var9 * var9 + var11 * var11);
      return (float)(-Math.atan2(var7, var13) * 180.0 / Math.PI);
   }

   public Unknown148 b() {
      return this.p;
   }

   public void a(Unknown148 var1) {
      this.p = var1;
   }
}
