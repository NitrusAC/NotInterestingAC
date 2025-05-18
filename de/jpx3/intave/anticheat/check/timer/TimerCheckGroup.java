package de.jpx3.intave.anticheat.check.timer;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.check.api.AbstractCheck;
import de.jpx3.intave.anticheat.check.api.config.CheckConfig;
import de.jpx3.intave.anticheat.check.api.config.CheckConfigValue;
import de.jpx3.intave.anticheat.logger.Logger;

public final class TimerCheckGroup extends AbstractCheck {
   private final CheckConfigValue q = new CheckConfigValue(this, 0.2);
   private final de.jpx3.intave.anticheat.check.timer.main.TimerCheck timerCheck;
   private final boolean highTolerance;
   private final boolean reverseBlink;
   private final boolean reverseLag;

   public boolean isHighTolerance() {
      return this.highTolerance;
   }

   public void a(PacketEvent var1) {
      this.timerCheck.b(var1);
   }

   public CheckConfigValue d() {
      return this.q;
   }

   public TimerCheckGroup() {
      super("Timer", "timer");
      CheckConfig var5 = this.b().b();
      this.highTolerance = var5.getBoolean("high-tolerance", false);
      this.reverseBlink = var5.getBoolean("reverse-blink", false);
      this.reverseLag = var5.getBoolean("reverse-lag", false);
      if (this.highTolerance) {
         Logger.getLogger().info("Enabled high ping tolerance");
      }

      this.timerCheck = new de.jpx3.intave.anticheat.check.timer.main.TimerCheck(this);
      this.addChild(this.timerCheck);
   }

   public boolean isReverseBlink() {
      return this.reverseBlink;
   }

   public boolean isReverseLag() {
      return this.reverseLag;
   }

   @Override
   public boolean isEnabled() {
      return true;
   }

   @Override
   public boolean e() {
      return true;
   }
}
