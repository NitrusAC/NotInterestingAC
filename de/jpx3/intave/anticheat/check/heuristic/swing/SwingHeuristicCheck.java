package de.jpx3.intave.anticheat.check.heuristic.swing;

import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.violate.Anomaly;
import de.jpx3.intave.unknown.Unknown227;
import org.bukkit.entity.Player;

public final class SwingHeuristicCheck extends PartialConfigurableCheck {
   private final IntavePlugin intavePlugin = IntavePlugin.getInstance();

   public SwingHeuristicCheck(HeuristicCheckGroup heuristics) {
      super(heuristics, SwingHeuristicStorage.class);
   }

   @PacketListener(
      packetTypes = {ClientPacket.FLYING, ClientPacket.POSITION, ClientPacket.POSITION_LOOK, ClientPacket.LOOK, ClientPacket.ARM_ANIMATION}
   )
   public void handleArmAnimation(PacketEvent event) {
      Player var2 = event.getPlayer();
      SwingHeuristicStorage var3 = (SwingHeuristicStorage)this.getStorage(var2);
      SwingHeuristicStorage.setSwung(var3, event.getPacketType() == Client.ARM_ANIMATION);
   }

   @PacketListener(
      packetTypes = {ClientPacket.USE_ENTITY}
   )
   public void handleEntityUse(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = this.getPlayerData(var5);
      VersionHolder var7 = var6.getStorage().getVersionHolder();
      SwingHeuristicStorage var8 = (SwingHeuristicStorage)this.getStorage(var5);
      PacketContainer var9 = event.getPacket();
      EntityUseAction var10 = (EntityUseAction)var9.getEntityUseActions().readSafely(0);
      if (var10 == null) {
         var10 = ((WrappedEnumEntityUseAction)var9.getEnumEntityUseActions().read(0)).getAction();
      }

      if (!var6.getStorage().getEntityHolder().isSpectator()) {
         if (var7.isLegacy() && var10 == EntityUseAction.ATTACK && !SwingHeuristicStorage.isSwinging(var8)) {
            String var11 = "swing not correlated with attack (" + var6.getStorage().getVersionHolder().getVersionString() + ")";
            Anomaly var12 = Anomaly.of("31", Certainty.LIKELY, CombatCheckType.KILLAURA, var11);
            ((HeuristicCheckGroup)this.getParent()).logAnomaly(var5, var12);
            var6.a(Unknown227.HT_LIGHT, "11");
         }

      }
   }
}
