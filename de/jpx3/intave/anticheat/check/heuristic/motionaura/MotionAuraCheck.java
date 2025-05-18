package de.jpx3.intave.anticheat.check.heuristic.motionaura;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.ItemHolder;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.util.AccurateMathUtil;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.util.MathHelperTable;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.violate.Anomaly;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public final class MotionAuraCheck extends PartialConfigurableCheck {
   private final IntavePlugin intavePlugin = IntavePlugin.getInstance();

   private void moveHeading(float motionX, float motionZ, Vector motion) {
      motion.setX(motion.getX() - (double)(motionX * 0.2F));
      motion.setZ(motion.getZ() + (double)(motionZ * 0.2F));
   }

   public MotionAuraCheck(HeuristicCheckGroup heuristics) {
      super(heuristics, MotionAuraStorage.class);
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.POSITION, ClientPacket.POSITION_LOOK, ClientPacket.LOOK}
   )
   public void handle(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      MotionAuraStorage var7 = (MotionAuraStorage)this.getStorage(var6);
      BukkitEnginePlayer var8 = var6.getStorage().getPhysicsHolder();
      PlayerHolder var9 = var6.getStorage().getPlayerHolder();
      ItemHolder var10 = var6.getStorage().getItemHolder();
      boolean var11 = var9.hasAttacked(1000L);
      boolean var12 = Math.abs(var8.getJumpBoostHeight() - var8.getMotionY()) < 1.0E-5;
      if (var12 && var8.sprinting && var8.teleportTicks > 5 && var8.isMoving && !var8.collidedHorizontally) {
         float var13 = var8.yaw;
         float var14 = MathHelperTable.sin(var13 * (float) Math.PI / 180.0F, false);
         float var15 = MathHelperTable.cos(var13 * (float) Math.PI / 180.0F, false);
         double var16 = var8.deltaX;
         double var18 = var8.deltaZ;
         ItemStack var20 = var10.getItemInHand();
         boolean var21 = var20 != null && var20.containsEnchantment(Enchantment.KNOCKBACK);
         if (!var21 && var8.slowdownTicks == 0) {
            var16 *= 0.6;
            var18 *= 0.6;
         }

         Vector var22 = new Vector(var16, 0.0, var18);
         float var23 = var8.getAcceleration();
         float var24 = (float)var8.moveForward * 0.98F;
         float var25 = (float)var8.moveStrafe * 0.98F;
         this.moveHeading(var14, var15, var22);
         this.moveFriction(var22, var23, var14, var15, var24, var25);
         double var26 = AccurateMathUtil.deltaXZ(var22.getX() - var8.getMotionX(), var22.getZ() - var8.getMotionZ());
         double var28 = 0.001;
         if (var26 > var28) {
            var22 = new Vector(var16, 0.0, var18);
            this.moveFriction(var22, var23, var14, var15, var24, var25);
            double var30 = AccurateMathUtil.deltaXZ(var22.getX() - var8.getMotionX(), var22.getZ() - var8.getMotionZ());
            if (Math.abs(var30 - 0.2) < var28 * 2.0) {
               MotionAuraStorage.increaseBuffer(var7);
               String var32 = "horizontal motion not correlated with jump vl:" + MathUtil2.getStringRounded(MotionAuraStorage.getBuffer(var7), 1);
               if (var11) {
                  var32 = var32 + " | attacked";
               }

               var32 = var32 + " | pre-dist:" + var26 + ", alt-dist:" + var30;
               var32 = var32 + " | " + var6.getStorage().getVersionHolder().getVersionString();
               byte var33 = 24;
               Anomaly var34 = Anomaly.of("61", Certainty.NONE, CombatCheckType.KILLAURA, var32, var33);
               ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var34);
            }
         } else {
            MotionAuraStorage.setBuffer(var7, MotionAuraStorage.getBuffer(var7) - (MotionAuraStorage.getBuffer(var7) > 0.0 ? 0.2 : 0.0));
         }
      }

   }

   private void moveFriction(Vector motion, float friction, float moveX, float moveZ, float moveForward, float moveStrafe) {
      float var10 = moveStrafe * moveStrafe + moveForward * moveForward;
      if (var10 >= 1.0E-4F) {
         var10 = (float)Math.sqrt((double)var10);
         var10 = friction / Math.max(1.0F, var10);
         moveStrafe *= var10;
         moveForward *= var10;
         motion.setX(motion.getX() + (double)(moveStrafe * moveZ - moveForward * moveX));
         motion.setZ(motion.getZ() + (double)(moveForward * moveZ + moveStrafe * moveX));
      }

   }
}
