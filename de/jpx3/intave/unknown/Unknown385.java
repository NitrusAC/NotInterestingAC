package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.IntavePlugin;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class Unknown385 extends Unknown405 {
   @Override
   public List a(CommandSender var1) {
      return null;
   }

   public Player[] a(CommandSender var1, String var2, String var3) {
      String[] var8 = var3.split(" ");
      List var9 = new ArrayList();

      for(String var13 : var8) {
         Player var14 = Bukkit.getPlayer(var13);
         if (!this.a(var14)) {
            var1.sendMessage(IntavePlugin.getPrefix() + ChatColor.RED + "Invalid argument \"" + var13 + "\": Unable to locate player");
            return null;
         }

         var9.add(var14);
      }

      var9 = (List)var9.stream().distinct().collect(Collectors.toList());
      return (Player[])var9.toArray(new Player[0]);
   }

   public Unknown385() {
      super(Player[].class);
   }

   private boolean a(OfflinePlayer var1) {
      return var1 != null && (var1.isOnline() || Bukkit.getPlayer(var1.getUniqueId()) != null);
   }

   @Override
   public Object a(CommandSender var1, String var2, String var3) {
      return this.a(var1, var2, var3);
   }
}
