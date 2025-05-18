package de.jpx3.intave.anticheat.check.api;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.storage.Storable;
import org.bukkit.entity.Player;

public abstract class BaseCheck extends AbstractCheck {
   private final Class clazz;

   protected Storable getStorage(Player player) {
      return this.getStorage(PlayerDataManager.getPlayerData(player));
   }

   protected Storable getStorage(PlayerData data) {
      return data.getStorage(this.clazz);
   }

   protected BaseCheck(String var1, String var2, Class var3) {
      super(var1, var2);
      this.clazz = var3;
   }
}
