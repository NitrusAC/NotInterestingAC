package de.jpx3.intave.anticheat.check.api;

import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.unknown.Unknown4;
import java.util.function.Consumer;
import org.bukkit.entity.Player;

public abstract class PartialCheck implements Check {
   private final AbstractCheck parent;

   private static Unknown4 b(Unknown4 var0) {
      return var0;
   }

   protected PartialCheck(AbstractCheck parent) {
      this.parent = parent;
   }

   public void a(PlayerData playerData, Consumer consumer) {
      this.parent.a(playerData, consumer);
   }

   public final AbstractCheck getParent() {
      return this.parent;
   }

   protected int flag(String name, Player player) {
      return this.parent.flag(name, player);
   }

   protected final PlayerData getPlayerData(Player player) {
      return PlayerDataManager.getPlayerData(player);
   }

   public boolean isEnabled() {
      return this.parent.isEnabled();
   }

   public String a() {
      return this.parent.k();
   }
}
