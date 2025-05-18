package de.jpx3.intave.anticheat.command.impl;

import de.jpx3.intave.bn;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.command.AbstractCommandRegistrar;
import de.jpx3.intave.anticheat.command.Arg;
import de.jpx3.intave.anticheat.command.Command;
import de.jpx3.intave.unknown.Unknown368;
import de.jpx3.intave.unknown.Unknown378;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class ProxyCommand extends AbstractCommandRegistrar {
   private static ProxyCommand k;
   private final IntavePlugin plugin = IntavePlugin.getInstance();

   private ProxyCommand() {
      super(NotifyCommand.of(), "proxy");
   }

   private static String e(String var0) {
      return var0 + " ";
   }

   private void a(Player var1, bn var2, String var3) {
      long var6 = System.currentTimeMillis() + 3600000L;
      Unknown368 var8 = new Unknown368(var1.getUniqueId(), var2, var3.trim(), var6);
      this.plugin.i().a(var1, var8);
   }

   public static ProxyCommand a() {
      if (k == null) {
         k = new ProxyCommand();
      }

      return k;
   }

   @Command(
      aliases = {"proxban"},
      e = "<player> [<message...>]",
      d = "intave.command.proxy",
      a = "Remotely bans the target player from the proxy"
   )
   public void handleProxBan(CommandSender var1, Player var2, @Arg String[] var3) {
      if (!this.plugin.i().d()) {
         var1.sendMessage(IntavePlugin.getPrefix() + ChatColor.RED + "Not connected to a proxy");
      } else {
         String var7 = var3 == null ? "None provided" : ((String)Arrays.stream(var3).map(ProxyCommand::c).collect(Collectors.joining())).trim();
         this.a(var2, bn.c, var7);
         var1.sendMessage(IntavePlugin.getPrefix() + "Remote ban execution issued");
      }
   }

   @Command(
      aliases = {"proxtempban"},
      e = "<player> [<message...>]",
      d = "intave.command.proxy",
      a = "Remotely temp-bans the target player from the proxy"
   )
   public void handleProxTempBan(CommandSender var1, Player var2, @Arg String[] var3) {
      if (!this.plugin.i().d()) {
         var1.sendMessage(IntavePlugin.getPrefix() + ChatColor.RED + "Not connected to a proxy");
      } else {
         String var7 = var3 == null ? "None provided" : ((String)Arrays.stream(var3).map(ProxyCommand::f).collect(Collectors.joining())).trim();
         this.a(var2, bn.b, var7);
         var1.sendMessage(IntavePlugin.getPrefix() + "Remote temp-ban execution issued");
      }
   }

   @Command(
      aliases = {"proxkick"},
      e = "<player> [<message...>]",
      d = "intave.command.proxy",
      a = "Remotely kicks the target player from the proxy"
   )
   public void handleProxKick(CommandSender var1, Player var2, @Arg String[] var3) {
      if (!this.plugin.i().d()) {
         var1.sendMessage(IntavePlugin.getPrefix() + ChatColor.RED + "Not connected to a proxy");
      } else {
         String var7 = var3 == null ? "None provided" : ((String)Arrays.stream(var3).map(ProxyCommand::d).collect(Collectors.joining())).trim();
         this.a(var2, bn.a, var7);
         var1.sendMessage(IntavePlugin.getPrefix() + "Remote kick execution issued");
      }
   }

   private static String c(String var0) {
      return var0 + " ";
   }

   private static String f(String var0) {
      return var0 + " ";
   }

   @Command(
      aliases = {"proxcommand"},
      e = "<player> <command...>",
      d = "intave.command.proxy",
      a = "Remotely executes commands on the proxy"
   )
   public void handleProxCommand(CommandSender var1, Player var2, String[] var3) {
      if (!this.plugin.i().d()) {
         var1.sendMessage(IntavePlugin.getPrefix() + ChatColor.RED + "Not connected to a proxy");
      } else {
         String var7 = ((String)Arrays.stream(var3).map(ProxyCommand::e).collect(Collectors.joining())).trim();
         Unknown378 var8 = new Unknown378(var2.getUniqueId(), var7);
         this.plugin.i().a(var2, var8);
         var1.sendMessage(IntavePlugin.getPrefix() + "Remote command execution of \"/" + var7 + "\" issued");
      }
   }

   private static String d(String var0) {
      return var0 + " ";
   }
}
