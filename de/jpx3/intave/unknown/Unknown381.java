package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.IntavePlugin;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class Unknown381 extends Unknown405 {
   private boolean a(OfflinePlayer var1) {
      return var1 != null && (var1.isOnline() || Bukkit.getPlayer(var1.getUniqueId()) != null);
   }

   public Player a(CommandSender var1, String var2, String var3) {
      Player var7 = Bukkit.getPlayer(var2);
      if (!this.a(var7)) {
         var1.sendMessage(IntavePlugin.getPrefix() + ChatColor.RED + "Invalid argument \"" + var2 + "\": Unable to locate player");
         return null;
      } else {
         return var7;
      }
   }

   public Unknown381() {
      super(Player.class);
   }

   @Override
   public List a(CommandSender var1) {
      ArrayList var5 = new ArrayList();

      for(Player var7 : Bukkit.getOnlinePlayers()) {
         boolean var8 = true;
         if (var1 instanceof Player) {
            var8 = ((Player)var1).canSee(var7);
         }

         if (var8) {
            var5.add(var7.getName());
         }
      }

      return var5;
   }

   @Override
   public Object a(CommandSender var1, String var2, String var3) {
      return this.a(var1, var2, var3);
   }
}
