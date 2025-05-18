package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.IntavePlugin;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public final class Unknown404 extends Unknown405 {
   @Override
   public List a(CommandSender var1) {
      return null;
   }

   public Unknown404() {
      super(Integer.class);
   }

   @Override
   public Object a(CommandSender var1, String var2, String var3) {
      return this.a(var1, var2, var3);
   }

   public Integer a(CommandSender var1, String var2, String var3) {
      try {
         return Integer.parseInt(var2);
      } catch (Exception var7) {
         var1.sendMessage(IntavePlugin.getPrefix() + ChatColor.RED + "Invalid argument " + var2 + ": Must be valid integer");
         return null;
      }
   }
}
