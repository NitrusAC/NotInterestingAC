package de.jpx3.intave.anticheat.check.breakspeed;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.AbstractCheck;
import de.jpx3.intave.anticheat.check.breakspeed.breaking.BreakBlockCheck;
import de.jpx3.intave.anticheat.check.breakspeed.fastbreak.FastBreakCheck;

public final class BreakSpeedCheckGroup extends AbstractCheck {
   public void setupChildren() {
      this.addChild(new FastBreakCheck(this));
      this.addChild(new BreakBlockCheck(this));
   }

   public BreakSpeedCheckGroup(IntavePlugin intavePlugin) {
      super("BreakSpeedLimiter", "breakspeedlimiter");
      this.setupChildren();
   }
}
