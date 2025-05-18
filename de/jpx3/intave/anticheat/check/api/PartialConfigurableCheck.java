package de.jpx3.intave.anticheat.check.api;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.storage.Storable;
import org.bukkit.entity.Player;

public abstract class PartialConfigurableCheck extends PartialCheck {
   private final Class c;

   public Storable getStorage(PlayerData data) {
      return data.getStorage(this.c);
   }

   public Storable getStorage(Player var1) {
      return this.getStorage(PlayerDataManager.getPlayerData(var1));
   }

   protected PartialConfigurableCheck(AbstractCheck var1, Class var2) {
      super(var1);
      this.c = var2;
   }
}
