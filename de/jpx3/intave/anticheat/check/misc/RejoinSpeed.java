package de.jpx3.intave.anticheat.check.misc;

import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.util.PlayerIdentifier;
import de.jpx3.intave.unknown.Unknown334;
import de.jpx3.intave.unknown.Unknown373;
import java.net.InetAddress;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

public final class RejoinSpeed extends UnknownCheck {
   private final Map uuidJoinMap = new ConcurrentHashMap();
   private final Map ipJoinMap = new ConcurrentHashMap();
   private boolean shouldRefresh;
   private long rejoinDelay;
   private String rejoinMessage;

   @BukkitEventListener
   public void onPlayerJoin(AsyncPlayerPreLoginEvent event) {
      long var5 = System.currentTimeMillis() - this.uuidJoinMap.getOrDefault(event.getUniqueId(), 0L);
      long var7 = System.currentTimeMillis() - this.ipJoinMap.getOrDefault(event.getAddress(), 0L);
      if (var5 < this.rejoinDelay || var7 < this.rejoinDelay) {
         String var9 = this.rejoinMessage;
         PlayerIdentifier var10 = new PlayerIdentifier(event.getName(), event.getUniqueId(), event.getAddress());
         var9 = Unknown334.a(var9, new Unknown373[]{Unknown334.a, var10});
         var9 = ChatColor.translateAlternateColorCodes('&', var9);
         event.setKickMessage(var9);
         event.setLoginResult(Result.KICK_WHITELIST);
         if (this.shouldRefresh) {
            this.store(event.getAddress(), event.getUniqueId(), "rejoin");
         }
      }

   }

   @Override
   public void refreshConfig() {
      YamlConfiguration var3 = this.plugin.getConfig();
      this.rejoinDelay = (long)var3.getInt("rejoin.delay") * 50L;
      this.shouldRefresh = var3.getBoolean("rejoin.refresh");
      this.rejoinMessage = var3.getString("rejoin.message");
      this.plugin.d().b(this);
   }

   public void store(InetAddress var1, UUID var2, String var3) {
      if (!var1.getHostAddress().contains("127.0.0.1")) {
         this.ipJoinMap.put(var1, System.currentTimeMillis());
      }

      this.uuidJoinMap.put(var2, System.currentTimeMillis());
   }
}
