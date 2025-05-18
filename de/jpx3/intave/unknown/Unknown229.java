package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.command.AbstractCommandRegistrar;
import de.jpx3.intave.anticheat.command.impl.BotCommand;
import de.jpx3.intave.anticheat.command.impl.InternalCommand;
import de.jpx3.intave.anticheat.command.impl.NotifyCommand;
import de.jpx3.intave.anticheat.command.impl.PerformanceDiagnosticCommand;
import de.jpx3.intave.anticheat.command.impl.ProxyCommand;
import de.jpx3.intave.anticheat.command.impl.RootCommand;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

public final class Unknown229 implements CommandExecutor, TabCompleter {
   private final AbstractCommandRegistrar a = NotifyCommand.of();

   public List onTabComplete(CommandSender var1, Command var2, String var3, String[] var4) {
      if (var4.length == 0) {
         return Collections.emptyList();
      } else {
         String var8 = ((String)Arrays.stream(var4).map(Unknown229::b).collect(Collectors.joining())).trim();
         List var9 = this.a.b(var1, var8);
         if (var9 == null) {
            return null;
         } else {
            ArrayList var10 = new ArrayList();
            StringUtil.copyPartialMatches(var4[var4.length - 1], var9, var10);
            return var10;
         }
      }
   }

   private static String a(String var0) {
      return var0 + " ";
   }

   static {
      NotifyCommand.of();
      InternalCommand.of();
      BotCommand.of();
      RootCommand.a();
      PerformanceDiagnosticCommand.a();
      ProxyCommand.a();
   }

   public boolean onCommand(CommandSender var1, Command var2, String var3, String[] var4) {
      if (var1 instanceof CommandBlock) {
         return false;
      } else {
         String var8 = ((String)Arrays.stream(var4).map(Unknown229::a).collect(Collectors.joining())).trim();
         this.a.a(var1, var8);
         return false;
      }
   }

   private static String b(String var0) {
      return var0 + " ";
   }
}
