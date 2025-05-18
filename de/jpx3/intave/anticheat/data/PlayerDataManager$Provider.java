package de.jpx3.intave.anticheat.data;

import de.jpx3.intave.anticheat.data.impl.FallbackUser;
import de.jpx3.intave.anticheat.data.impl.PlayerUser;
import org.bukkit.entity.Player;

public final class PlayerDataManager$Provider {
   public static PlayerData ofEmpty() {
      return new FallbackUser();
   }

   public static PlayerData ofPLayer(Player player) {
      return new PlayerUser(player);
   }
}
