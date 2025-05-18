package de.jpx3.intave.unknown;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.wrap.PacketInterpreters;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public final class Unknown317 extends UnknownCheck {
   private final Unknown124 e = Unknown124.a();
   private final IntavePlugin f;
   private final Map a = Unknown19.a(new HashMap());

   private Unknown342 a(String var1) {
      return var1.equalsIgnoreCase("ignore") ? null : (Unknown342)this.e.b().stream().filter(Unknown317::b).findFirst().orElse(null);
   }

   public Unknown317(IntavePlugin var1) {
      this.f = var1;
   }

   private static void e(Player var0, Unknown342 var1) {
      var0.sendMessage("");
      var0.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "WARNING " + ChatColor.RED + var1.f());
      var0.sendMessage("");
   }

   private static boolean c(String var0, Unknown342 var1) {
      return var1.c().equalsIgnoreCase(var0);
   }

   private void c(Player var1, Unknown342 var2) {
      this.f(var1, var2);
   }

   private void f(Player var1, Unknown342 var2) {
      Long var6 = (Long)this.a.computeIfAbsent(var1.getUniqueId(), Unknown317::a);
      if (System.currentTimeMillis() - var6 >= 1000L) {
         this.a.put(var1.getUniqueId(), System.currentTimeMillis());
         PlayerDataManager.getPlayerData(var1).getStorage().getVersionHolder().a(var2.d());
         String var7 = var2.g();
         switch(var7) {
            case "message":
               IntaveScheduler.runTask(Unknown317::e);
               break;
            case "kick":
               IntaveScheduler.runTask(Unknown317::b);
         }

      }
   }

   private void a(Player var1, Unknown342 var2) {
      this.f(var1, var2);
   }

   private static boolean b(String var0, Unknown342 var1) {
      return var0.toLowerCase(Locale.ROOT).contains(var1.e().toLowerCase(Locale.ROOT));
   }

   @PacketListener(
      packetTypes = {ClientPacket.CUSTOM_PAYLOAD}
   )
   public void a(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PacketContainer var6 = var1.getPacket();
      Unknown209 var7 = (Unknown209)PacketInterpreters.getInterpreter(var6);
      String var8 = var7.b();
      if (var8.endsWith("Brand")) {
         String var9 = var7.a();
         Unknown342 var10 = this.a(var9);
         if (var10 != null) {
            IntaveScheduler.runTask(this::a);
         }
      } else {
         Unknown342 var11 = this.b(var8);
         if (var11 != null) {
            IntaveScheduler.runTask(this::c);
         }
      }

      var7.reset();
   }

   private Unknown342 b(String var1) {
      return var1.equalsIgnoreCase("ignore") ? null : (Unknown342)this.e.b().stream().filter(Unknown317::c).findFirst().orElse(null);
   }

   private static Long a(UUID var0) {
      return 0L;
   }

   private static void b(Player var0, Unknown342 var1) {
      var0.kickPlayer(ChatColor.RED + var1.f());
   }
}
