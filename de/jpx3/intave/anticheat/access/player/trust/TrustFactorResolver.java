package de.jpx3.intave.anticheat.access.player.trust;

import java.util.function.Consumer;
import org.bukkit.entity.Player;

public interface TrustFactorResolver {
   void resolve(Player player, Consumer action);
}
