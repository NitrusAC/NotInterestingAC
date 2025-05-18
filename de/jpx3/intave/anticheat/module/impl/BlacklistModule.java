package de.jpx3.intave.anticheat.module.impl;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.listener.PacketListener;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import de.jpx3.intave.anticheat.util.http.RequestEncryption;
import de.jpx3.intave.unknown.Unknown83;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public final class BlacklistModule implements PacketListener {
   private final HTTPRequest apiRequest = Unknown83.a("https:..service.intave.de.blacklist", "blacklist", TimeUnit.DAYS.toMillis(7L));
   private static final String kickReason = ChatColor.RED + "You can't join this server";
   private final IntavePlugin intavePlugin;
   private RequestEncryption encryption;

   public void prepare() {
      if (this.isBlacklistEnabled()) {
         try {
            this.initEncryption();
            this.g();
            this.checkOnline();
         } catch (Exception var5) {
            var5.printStackTrace();
         }

      }
   }

   private void g() {
      this.intavePlugin.d().b(this);
   }

   private void vincentMeow(Player player) {
      this.kickPlayer(player);
   }

   @BukkitEventListener
   public void onJoin(PlayerJoinEvent playerJoinEvent) {
      Player var5 = playerJoinEvent.getPlayer();
      if (this.isBlacklisted(var5)) {
         this.kickPlayer(var5);
      }

   }

   private boolean isBlacklisted(Player player) {
      String var5 = player.getName();
      UUID var6 = player.getUniqueId();
      return this.encryption != null && (this.encryption.isBlacklisted(var5) || this.encryption.isInRequest(var6));
   }

   private void checkOnline() {
      Bukkit.getOnlinePlayers().stream().filter(this::isBlacklisted).forEach(this::runKickSync);
   }

   private void runKickSync(Player player) {
      IntaveScheduler.runTask(this::vincentMeow);
   }

   private void kickPlayer(Player player) {
      player.kickPlayer(kickReason);
   }

   public BlacklistModule(IntavePlugin intavePlugin) {
      this.intavePlugin = intavePlugin;
   }

   private void initEncryption() {
      this.encryption = RequestEncryption.init(this.apiRequest.stream());
   }

   public boolean isBlacklistEnabled() {
      return this.intavePlugin.getConfig().getBoolean("blacklist.apply");
   }
}
