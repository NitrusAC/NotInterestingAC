package de.jpx3.intave.anticheat.check.autoclicker;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.anticheat.check.api.AbstractCheck;
import de.jpx3.intave.anticheat.check.api.PartialCheck;
import de.jpx3.intave.anticheat.check.api.config.CheckConfigValue;
import de.jpx3.intave.anticheat.check.autoclicker.invariant.InvariantAutoclickerCheck;
import de.jpx3.intave.anticheat.check.autoclicker.relative.RelativeAutoclickerCheck;
import de.jpx3.intave.anticheat.check.autoclicker.spike.SpikeAutoclickerCheck;
import de.jpx3.intave.anticheat.check.autoclicker.variance.VarianceCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.violation.Violation;
import org.bukkit.entity.Player;

@Relocate
public final class AutoClickerCheckGroup extends AbstractCheck {
   private final CheckConfigValue l;
   private static final double m = 16.0;

   @PacketListener(
      packetTypes = {ClientPacket.ARM_ANIMATION}
   )
   public void a(PacketEvent event) {
      Player var2 = event.getPlayer();
      PlayerData var3 = this.getData(var2);
      this.l.a(var3, 0.008333333333333333);
   }

   public AutoClickerCheckGroup() {
      super("ClickPatterns", "clickpatterns");
      this.setupChildren();
      this.l = new CheckConfigValue(this, 0.26666666666666666);
   }

   private void setupChildren() {
      this.addChildren(
         new PartialCheck[]{new VarianceCheck(this), new InvariantAutoclickerCheck(this), new SpikeAutoclickerCheck(this), new RelativeAutoclickerCheck(this)}
      );
   }

   public void flag(Player var1, String var2, String var3, double var4) {
      Violation var8 = Violation.builder(AutoClickerCheckGroup.class).player(var1).name("clicks suspiciously").description(var2).vl(var4).thresholds().build();
      MoudleLoader.violations().dispatchViolation(var8);
   }
}
