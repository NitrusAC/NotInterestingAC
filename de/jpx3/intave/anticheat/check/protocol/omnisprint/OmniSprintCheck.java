package de.jpx3.intave.anticheat.check.protocol.omnisprint;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.check.api.PartialCheck;
import de.jpx3.intave.anticheat.check.protocol.ProtocolCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.util.AccurateMathUtil;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.util.Hands;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import org.bukkit.entity.Player;
import org.bukkit.inventory.MainHand;

public final class OmniSprintCheck extends PartialCheck {
   private static final String g;
   private static final boolean isModern = MinecraftVersion.V_1_9.atOrAbove();
   private static Class enumMainHandClazz;

   @PacketListener(
      packetTypes = {ClientPacket.SETTINGS}
   )
   public void handleUseEntity(PacketEvent event) {
      Player var6 = event.getPlayer();
      PlayerData var7 = this.getPlayerData(var6);
      PacketContainer var8 = event.getPacket();
      VersionHolder var9 = var7.getStorage().getVersionHolder();
      if (isModern && var9.isNewerVersion()) {
         if (enumMainHandClazz == null) {
            enumMainHandClazz = ReflectionUtil.getClazz("EnumMainHand");
         }

         Hands var10 = (Hands)var8.getEnumModifier(Hands.class, enumMainHandClazz).read(0);
         if (!this.check(var6.getMainHand(), var10)) {
            return;
         }
      }

      BukkitEnginePlayer var15 = var7.getStorage().getPhysicsHolder();
      int var11 = var15.moveForward;
      int var12 = var15.moveStrafe;
      double var13 = AccurateMathUtil.deltaXZ(var15.getMotionX(), var15.getMotionZ());
      if (!var15.inWeb && !var15.b(2)) {
         if ((var11 != 0 || var12 != 0) && var13 > 0.1) {
            event.setCancelled(true);
         }

      }
   }

   private boolean check(Object offHand, Hands hand) {
      return offHand == MainHand.LEFT && hand == Hands.LEFT_HAND || offHand == MainHand.RIGHT && hand == Hands.LEGACY;
   }

   public OmniSprintCheck(ProtocolCheckGroup group) {
      super(group);
   }
}
