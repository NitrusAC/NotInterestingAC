package de.jpx3.intave.unknown;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.WrappedAttribute;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.holder.EntityHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import java.util.List;
import org.bukkit.entity.Player;

public final class Unknown321 extends UnknownCheck {
   private void b(PlayerData var1, WrappedAttribute var2) {
      EntityHolder var6 = var1.getStorage().getEntityHolder();
      BukkitEnginePlayer var7 = var1.getStorage().getPhysicsHolder();
      if (var6.getAttribute(var2.getAttributeKey()) != null) {
         List var8 = var6.b(var2);
         var8.clear();
         var7.be = var2.getModifiers().contains(BukkitEnginePlayer.sprintAttributeKey);
         var8.addAll(var2.getModifiers());
      }

   }

   private List a(PlayerData var1, List var2) {
      return var2;
   }

   private void b(PlayerData var1, Player var2, List var3) {
      var3.forEach(this::a);
   }

   private void a(PlayerData var1, WrappedAttribute var2) {
      this.b(var1, var2);
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      g = {ServerPacket.UPDATE_ATTRIBUTES}
   )
   public void a(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      PacketContainer var7 = var1.getPacket();
      if (var7.getIntegers().read(0) == var5.getEntityId()) {
         StructureModifier var8 = var7.getAttributeCollectionModifier();
         List var9 = this.a(var6, (List)var8.read(0));
         var8.write(0, var9);
         MoudleLoader.m().a(var5, var9, this::b);
      }

   }
}
