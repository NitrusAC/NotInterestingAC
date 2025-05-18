package de.jpx3.intave.anticheat.util;

import com.google.common.collect.ImmutableMap;
import de.jpx3.intave.unknown.Unknown373;
import java.net.InetAddress;
import java.util.Map;
import java.util.UUID;
import org.bukkit.entity.Player;

public final class PlayerIdentifier implements Unknown373 {
   private final String playerName;
   private final UUID playerId;
   private final InetAddress playerAddress;

   @Override
   public Map build() {
      return ImmutableMap.of(
         "player",
         String.valueOf(this.playerName),
         "playername",
         String.valueOf(this.playerName),
         "uuid",
         String.valueOf(this.playerId),
         "ip",
         this.playerAddress.getHostAddress(),
         "address",
         this.playerAddress.getHostAddress()
      );
   }

   public PlayerIdentifier(String playerName, UUID playerId, InetAddress playerAddress) {
      this.playerName = playerName;
      this.playerId = playerId;
      this.playerAddress = playerAddress;
   }

   public static PlayerIdentifier ofEmpty() {
      return new PlayerIdentifier("", new UUID(0L, 0L), InetAddress.getLoopbackAddress());
   }

   public static PlayerIdentifier of(Player var0) {
      return new PlayerIdentifier(var0.getName(), var0.getUniqueId(), var0.getAddress().getAddress());
   }
}
