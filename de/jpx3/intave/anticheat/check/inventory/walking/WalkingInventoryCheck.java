package de.jpx3.intave.anticheat.check.inventory.walking;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.PartialCheck;
import de.jpx3.intave.anticheat.check.inventory.InventoryAnalysisCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.engine.heading.Headings;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.util.AccurateMathUtil;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.violation.Violation;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

public final class WalkingInventoryCheck extends PartialCheck {
   private static final String e;
   private final IntavePlugin plugin = IntavePlugin.getInstance();

   @BukkitEventListener
   public void handle(InventoryClickEvent event) {
      HumanEntity var5 = event.getWhoClicked();
      if (var5 instanceof Player) {
         Player var6 = ((Player)var5).getPlayer();
         PlayerData var7 = this.getPlayerData(var6);
         PlayerStorage var8 = var7.getStorage();
         ClickType var9 = event.getClick();
         if (var9 != ClickType.CREATIVE) {
            BukkitEnginePlayer var10 = var8.getPhysicsHolder();
            int var11 = var10.moveForward;
            int var12 = var10.moveStrafe;
            if (var10.getHeadingHandler() != Headings.ELYTRA) {
               if (!var10.inWeb && !var10.b(2)) {
                  double var13 = AccurateMathUtil.deltaXZ(var10.getMotionX(), var10.getMotionZ());
                  if ((var11 != 0 || var12 != 0) && var13 > 0.1) {
                     String var15 = "performed inventory-click whilst walking";
                     Violation var16 = Violation.builder(InventoryAnalysisCheckGroup.class).player(var6).name(var15).vl(0.0).build();
                     MoudleLoader.violations().dispatchViolation(var16);
                     IntaveScheduler.runTask(var6::closeInventory);
                     event.setCancelled(true);
                  }

               }
            }
         }
      }
   }

   public WalkingInventoryCheck(InventoryAnalysisCheckGroup group) {
      super(group);
   }
}
