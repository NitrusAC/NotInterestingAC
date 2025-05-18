package de.jpx3.intave.anticheat.check.protocol;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.AbstractCheck;
import de.jpx3.intave.anticheat.check.api.PartialCheck;
import de.jpx3.intave.anticheat.check.protocol.dupe.InventorySlotDupeCheck;
import de.jpx3.intave.anticheat.check.protocol.omnisprint.OmniSprintCheck;
import de.jpx3.intave.anticheat.check.protocol.pitch.InvalidPitchCheck;

public final class ProtocolCheckGroup extends AbstractCheck {
   private final IntavePlugin plugin;

   public ProtocolCheckGroup(IntavePlugin plugin) {
      super("ProtocolScanner", "protocolscanner");
      this.plugin = plugin;
      this.addChildren(new PartialCheck[]{new InventorySlotDupeCheck(this), new InvalidPitchCheck(this), new OmniSprintCheck(this)});
   }
}
