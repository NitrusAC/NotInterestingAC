package de.jpx3.intave.anticheat.check.inventory;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.AbstractCheck;
import de.jpx3.intave.anticheat.check.api.config.CheckConfigValue;
import de.jpx3.intave.anticheat.check.inventory.analysis.InventoryAnalysisCheck;
import de.jpx3.intave.anticheat.check.inventory.closed.ClosedInventoryCheck;
import de.jpx3.intave.anticheat.check.inventory.itemslot.ItemSlotInventoryCheck;
import de.jpx3.intave.anticheat.check.inventory.walking.WalkingInventoryCheck;

public final class InventoryAnalysisCheckGroup extends AbstractCheck {
   private final boolean highTolerance;
   private final CheckConfigValue n = new CheckConfigValue(this, 1.0);
   public static final double m = 1.0;

   public InventoryAnalysisCheckGroup(IntavePlugin var1) {
      super("InventoryClickAnalysis", "inventoryclickanalysis");
      this.highTolerance = this.b().b().getBoolean("high-tolerance", true);
      this.setupChildren();
   }

   private void setupChildren() {
      this.addChild(new WalkingInventoryCheck(this));
      this.addChild(new ClosedInventoryCheck(this));
      this.addChild(new ItemSlotInventoryCheck(this, this.highTolerance));
      this.addChild(new InventoryAnalysisCheck(this));
   }
}
