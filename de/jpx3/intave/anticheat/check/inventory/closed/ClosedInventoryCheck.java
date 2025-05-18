package de.jpx3.intave.anticheat.check.inventory.closed;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.PartialCheck;
import de.jpx3.intave.anticheat.check.inventory.InventoryAnalysisCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.ItemHolder;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.wrap.modal.InventoryAction;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import de.jpx3.intave.anticheat.violation.Violation;
import java.util.Locale;
import org.bukkit.entity.Player;

public final class ClosedInventoryCheck extends PartialCheck {
   private static final Class clazz = MinecraftVersion.V_1_9.atOrAbove() ? ReflectionUtil.getClazz("InventoryClickType") : Object.class;
   private final IntavePlugin intavePlugin = IntavePlugin.getInstance();

   private InventoryAction readInventoryAction(PacketContainer packet) {
      if (MinecraftVersion.V_1_9.atOrAbove()) {
         return (InventoryAction)packet.getEnumModifier(InventoryAction.class, clazz).read(0);
      } else {
         Integer var5 = (Integer)packet.getIntegers().readSafely(3);
         return InventoryAction.values()[var5];
      }
   }

   public ClosedInventoryCheck(InventoryAnalysisCheckGroup group) {
      super(group);
   }

   @PacketListener(
      packetTypes = {ClientPacket.WINDOW_CLICK}
   )
   public void handle(PacketEvent event) {
      Player var6 = event.getPlayer();
      PlayerData var7 = this.getPlayerData(var6);
      PacketContainer var8 = event.getPacket();
      ItemHolder var9 = var7.getStorage().getItemHolder();
      StructureModifier var10 = var8.getIntegers();
      int var11 = var10.read(0);
      int var12 = var10.read(1);
      InventoryAction var13 = this.readInventoryAction(var8);
      boolean var14 = var11 == 0;
      boolean var15 = var7.getStorage().getItemHolder().d;
      if (var15) {
         if (!var9.j()) {
            if (var7.getStorage().getVersionHolder().isSub_1_11_1()) {
               Violation var16 = Violation.builder(InventoryAnalysisCheckGroup.class)
                  .player(var6)
                  .name("clicked in closed inventory")
                  .description(var13.name().toLowerCase(Locale.ROOT) + " on " + var12 + "s/" + var11 + "c")
                  .vl(5.0)
                  .build();
               MoudleLoader.violations().dispatchViolation(var16);
               IntaveScheduler.runTask(var6::updateInventory);
               event.setCancelled(true);
            } else if (var14) {
               var7.getStorage().getItemHolder().b(true);
            }
         }

      }
   }
}
