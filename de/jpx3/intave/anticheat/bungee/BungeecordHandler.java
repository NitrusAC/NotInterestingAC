package de.jpx3.intave.anticheat.bungee;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.jpx3.intave.ic;
import de.jpx3.intave.mN;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.threading.BackgroundThreadingPool;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.unknown.Unknown139;
import de.jpx3.intave.unknown.Unknown265;
import de.jpx3.intave.unknown.Unknown353;
import de.jpx3.intave.unknown.Unknown86;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.Messenger;
import org.spigotmc.SpigotConfig;

public final class BungeecordHandler {
   public static final String c;
   private final boolean proxyEnabled;
   private final Unknown139 e = new Unknown139();
   public static final int i = 5;
   private final IntavePlugin intavePlugin;
   private Map d = null;
   private boolean h;
   public static final String a;

   public void unregister() {
      if (this.d != null) {
         this.d.clear();
      }

      Messenger var4 = Bukkit.getServer().getMessenger();
      var4.unregisterIncomingPluginChannel(this.intavePlugin);
      var4.unregisterOutgoingPluginChannel(this.intavePlugin);
      this.h = false;
   }

   private void register() {
      this.d = Maps.newHashMap();
      ic.a().entrySet().stream().filter(BungeecordHandler::a).map(Entry::getValue).forEach(this::a);
      Messenger var3 = Bukkit.getServer().getMessenger();
      var3.registerOutgoingPluginChannel(this.intavePlugin, "BungeeCord");
      var3.registerIncomingPluginChannel(this.intavePlugin, "intave:proxy", new mN(this.intavePlugin, this));
      this.h = true;
   }

   public boolean d() {
      return this.h;
   }

   public void a(Class var1, Unknown265 var2) {
      if (this.d()) {
         ((List)this.d.get(var1)).add(var2);
      }
   }

   private static boolean a(Entry var0) {
      return var0.getKey() >= 100;
   }

   public void a(Player var1, Unknown353 var2) {
      if (this.d() && this.proxyEnabled) {
         BackgroundThreadingPool.submit(this::b);
      }
   }

   private void a(Player var1, ByteArrayDataOutput var2) {
      var1.sendPluginMessage(this.intavePlugin, "BungeeCord", var2.toByteArray());
   }

   private void b(Unknown353 var1, Player var2) {
      ByteArrayDataOutput var5 = ByteStreams.newDataOutput();
      var5.writeUTF("IPC_BEGIN");
      var5.writeInt(5);
      var5.writeInt(ic.a(var1.getClass()));
      var5.write(this.e.a(var1));
      var5.writeUTF("IPC_END");
      IntaveScheduler.runTask(this::a);
   }

   public BungeecordHandler(IntavePlugin var1) {
      this.intavePlugin = var1;
      boolean var6 = SpigotConfig.bungee;
      boolean var7 = var1.getServer().getOnlineMode();
      Logger var8 = var1.getLogger();
      this.proxyEnabled = var1.getConfig().getBoolean("proxy.enable", false);
      if (this.proxyEnabled) {
         if (var6) {
            if (var7) {
               var8.info(ChatColor.RED + "Spigot expecting proxy connections in online mode?");
               var8.info(ChatColor.RED + "Proxy connection offline");
            } else {
               var8.info("Proxy connection online");
               this.register();
               Unknown86.b(this::unregister);
            }
         } else {
            var8.info(ChatColor.RED + "Spigot is not in bungee mode");
            var8.info(ChatColor.RED + "Proxy connection offline");
         }
      }
   }

   private void a(Class var1) {
      List var10000 = (List)this.d.put(var1, Lists.newCopyOnWriteArrayList());
   }

   public Map e() {
      return this.d;
   }
}
