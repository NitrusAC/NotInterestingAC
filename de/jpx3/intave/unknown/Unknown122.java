package de.jpx3.intave.unknown;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactor;
import de.jpx3.intave.anticheat.data.PlayerData;
import java.util.Map;
import org.bukkit.entity.Player;

public final class Unknown122 implements Unknown373 {
   private final PlayerData data;

   @Override
   public Map build() {
      if (!this.data.exists()) {
         return ImmutableMap.of();
      } else {
         Player var4 = this.data.getPlayer();
         Builder var5 = ImmutableMap.builder();
         TrustFactor var6 = this.data.getTrustFactor();
         var5.put("trust", var6.baseName());
         var5.put("trust-color", var6.coloredBaseName());
         var5.put("latency", String.valueOf(this.data.getLatency()));
         var5.put("jitter", String.valueOf(this.data.getJitter()));
         var5.put("version", this.data.getStorage().getVersionHolder().getVersionString());
         var5.put("client", this.data.getStorage().getVersionHolder().getClientName());
         var5.put("world", var4.getWorld().getName());
         return var5.build();
      }
   }

   public Unknown122(PlayerData data) {
      this.data = data;
   }
}
