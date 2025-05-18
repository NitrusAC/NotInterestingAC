package de.jpx3.intave.anticheat.command.impl;

import de.jpx3.intave.iW;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.command.AbstractCommandRegistrar;
import de.jpx3.intave.anticheat.command.Arg;
import de.jpx3.intave.anticheat.command.Command;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.PermissionUtil;
import de.jpx3.intave.unknown.Unknown131;
import de.jpx3.intave.unknown.Unknown16;
import de.jpx3.intave.unknown.Unknown194;
import de.jpx3.intave.unknown.Unknown199;
import de.jpx3.intave.unknown.Unknown205;
import de.jpx3.intave.unknown.Unknown343;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.HoverEvent.Action;
import net.md_5.bungee.chat.ComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public final class NotifyCommand extends AbstractCommandRegistrar {
   private static NotifyCommand l;
   private final DateFormat j = new SimpleDateFormat("HH:mm dd/MM/yy");

   private static boolean c(List var0, Player var1) {
      return var0.contains(var1.getUniqueId());
   }

   @Command(
      aliases = {"notify", "notifications"},
      e = "[<player...>]",
      a = "Toggle notifications",
      d = "intave.command.notify"
   )
   public void handleNotify(PlayerData var1, @Arg Player[] var2) {
      Player var6 = var1.getPlayer();
      boolean var7 = var1.a(Unknown131.b);
      if (var1.a(Unknown131.b) && var2 != null && !var1.c(Unknown131.b)) {
         List var11 = (List)Arrays.stream(var2).map(Entity::getUniqueId).distinct().collect(Collectors.toList());
         var1.a(Unknown131.b, NotifyCommand::c);
         String var12 = ChatColor.RED + b((List)Arrays.stream(var2).map(CommandSender::getName).map(NotifyCommand::g).collect(Collectors.toList()));
         var6.sendMessage(IntavePlugin.getPrefix() + "You have specified notifications to " + var12);
      } else {
         var1.e(Unknown131.b);
         var1.d(Unknown131.b);
         if (var7) {
            var6.sendMessage(IntavePlugin.getPrefix() + "You are " + ChatColor.RED + "no longer " + IntavePlugin.l() + "receiving notifications");
         } else if (var2 == null) {
            String var8 = ChatColor.RED + "everyone";
            var6.sendMessage(IntavePlugin.getPrefix() + "You are " + ChatColor.GREEN + "now " + IntavePlugin.l() + "receiving notifications for " + var8);
         } else {
            List var10 = (List)Arrays.stream(var2).map(Entity::getUniqueId).distinct().collect(Collectors.toList());
            var1.a(Unknown131.b, NotifyCommand::d);
            String var9 = ChatColor.RED + b((List)Arrays.stream(var2).map(CommandSender::getName).map(NotifyCommand::e).collect(Collectors.toList()));
            var6.sendMessage(IntavePlugin.getPrefix() + "You are " + ChatColor.GREEN + "now" + IntavePlugin.l() + " receiving notifications for " + var9);
         }

      }
   }

   private static String a(String var0) {
      return ChatColor.RED + var0;
   }

   private void a(CommandSender var1, String var2, UUID var3) {
      if (var3 == null) {
         var1.sendMessage(IntavePlugin.getPrefix() + ChatColor.RED + "Player \"" + var2 + "\" not found");
      } else {
         MoudleLoader.f().b(var3, this::a);
      }

   }

   @Command(
      aliases = {"verbose"},
      e = "[<player...>]",
      a = "Toggle verbose messages",
      d = "intave.command.verbose"
   )
   public void handleVerbose(PlayerData var1, @Arg Player[] var2) {
      Player var6 = var1.getPlayer();
      boolean var7 = var1.a(Unknown131.a);
      if (var1.a(Unknown131.a) && var2 != null && !var1.c(Unknown131.a)) {
         List var11 = (List)Arrays.stream(var2).map(Entity::getUniqueId).distinct().collect(Collectors.toList());
         var1.a(Unknown131.a, NotifyCommand::b);
         String var12 = ChatColor.RED + b((List)Arrays.stream(var2).map(CommandSender::getName).map(NotifyCommand::c).collect(Collectors.toList()));
         var6.sendMessage(IntavePlugin.getPrefix() + "You have specified verbose output to " + var12);
      } else {
         var1.e(Unknown131.a);
         var1.d(Unknown131.a);
         if (var7) {
            var6.sendMessage(IntavePlugin.getPrefix() + "You are " + ChatColor.RED + "no longer " + IntavePlugin.l() + "receiving verbose output");
         } else if (var2 == null) {
            String var8 = ChatColor.RED + "everyone";
            var6.sendMessage(IntavePlugin.getPrefix() + "You are " + ChatColor.GREEN + "now " + IntavePlugin.l() + "receiving verbose output for " + var8);
         } else {
            List var10 = (List)Arrays.stream(var2).map(Entity::getUniqueId).distinct().collect(Collectors.toList());
            var1.a(Unknown131.a, NotifyCommand::a);
            String var9 = ChatColor.RED + b((List)Arrays.stream(var2).map(CommandSender::getName).map(NotifyCommand::a).collect(Collectors.toList()));
            var6.sendMessage(IntavePlugin.getPrefix() + "You are " + ChatColor.GREEN + "now" + IntavePlugin.l() + " receiving verbose output for " + var9);
         }

      }
   }

   private static boolean a(List var0, Player var1) {
      return var0.contains(var1.getUniqueId());
   }

   private void a(CommandSender var1, String var2, UUID var3, Unknown343 var4) {
      if (var4 == null) {
         var1.sendMessage(IntavePlugin.getPrefix() + ChatColor.RED + "Player has never played before");
      } else {
         this.a(var1, var2, var3, (Unknown16)var4.a(Unknown16.class));
      }

   }

   private static String b(List var0) {
      int var4 = var0.size();
      String var5 = IntavePlugin.l();
      if (var4 == 0) {
         return var5 + "nobody";
      } else {
         return var4 == 1 ? (String)var0.get(0) : var5 + String.join(var5 + ", ", var0.subList(0, var4 - 1)) + var5 + " and " + (String)var0.get(var4 - 1);
      }
   }

   private Unknown205 a(String var1, Unknown205 var2) {
      return var2.b(NotifyCommand::b);
   }

   @Command(
      aliases = {"root"},
      e = "",
      a = "",
      d = "sibyl",
      b = true
   )
   @Unknown199(
      a = RootCommand.class
   )
   public void a(PlayerData var1) {
   }

   private boolean a(OfflinePlayer var1) {
      return var1 != null && (var1.isOnline() || Bukkit.getPlayer(var1.getUniqueId()) != null);
   }

   private String a(long var1) {
      return this.j.format(new Date(var1));
   }

   private static boolean b(List var0, Player var1) {
      return var0.contains(var1.getUniqueId());
   }

   private String h(String var1) {
      IntavePlugin var4 = IntavePlugin.getInstance();
      return var4.g().findCheck(var1).k();
   }

   @Command(
      aliases = {"alert", "alerts"},
      b = true,
      a = ""
   )
   public void handleAlerts(CommandSender var1) {
      if (!PermissionUtil.b(var1, "intave.command.verbose")) {
         this.a(var1);
      } else {
         var1.sendMessage(IntavePlugin.getPrefix() + "Did you mean verbose or notify?");
      }

   }

   private void a(CommandSender var1, String var2, UUID var3, Unknown16 var4) {
      Unknown205 var8 = var4.a();
      var1.sendMessage(String.format("%sHistory of " + ChatColor.RED + "%s%s:", IntavePlugin.getPrefix(), var2, IntavePlugin.l()));
      if (var8.b()) {
         var1.sendMessage(IntavePlugin.getPrefix() + ChatColor.GREEN + "No violations found");
      } else {
         this.a(var1, "Reach", this.a("attackraytrace", var8));
         this.a(var1, "KillAura", this.a("heuristics", var8));
         this.a(var1, "Fly/Speed", this.a("physics", var8));
         this.a(var1, "Scaffold", this.a("placementanalysis", var8));
         this.a(var1, "ChestStealer", this.a("inventoryAnalysis", var8));
      }
   }

   private static boolean b(String var0, Unknown194 var1) {
      return var1.e().equalsIgnoreCase(var0);
   }

   private void a(CommandSender var1, String var2, Unknown205 var3) {
      if (!var3.b()) {
         if (var3.d() == 1) {
            Unknown194 var15 = var3.f();
            String var16 = MessageFormat.format("{0}- detected for using {1}{2}{0} {3}", IntavePlugin.l(), ChatColor.RED, var2, this.b(var15.b()));
            String var17 = IntavePlugin.l();
            TextComponent var18 = new TextComponent(var16);
            var18.setHoverEvent(
               new HoverEvent(
                  Action.SHOW_TEXT,
                  new TextComponent[]{
                     new TextComponent(var17 + "Check " + ChatColor.RED + this.h(var15.e())),
                     new TextComponent(var17 + " reached " + ChatColor.RED + var15.f() + var17 + "VL"),
                     new TextComponent(var17 + " on " + ChatColor.RED + this.a(var15.c()))
                  }
               )
            );
            if (var1 instanceof Player) {
               ((Player)var1).spigot().sendMessage(var18);
            } else {
               var1.sendMessage(var16);
            }

         } else {
            String var7 = IntavePlugin.l()
               + "- detected multiple times for using "
               + ChatColor.RED
               + var2
               + IntavePlugin.l()
               + ", last was "
               + this.b(var3.c().b());
            String var8 = IntavePlugin.l();
            TextComponent var9 = new TextComponent(ComponentSerializer.parse("{text: \"\n\"}"));
            TextComponent[] var10 = new TextComponent[var3.d()];
            int var11 = 0;

            for(Unknown194 var13 : var3) {
               TextComponent var14 = new TextComponent(
                  new BaseComponent[]{
                     new TextComponent(var8 + "Check " + ChatColor.RED + this.h(var13.e())),
                     new TextComponent(var8 + " reached " + ChatColor.RED + var13.f() + var8 + "VL"),
                     new TextComponent(var8 + " on " + ChatColor.RED + this.a(var13.c()))
                  }
               );
               if (var11 != var3.d() - 1) {
                  var14.addExtra(var9);
               }

               var10[var11++] = var14;
            }

            TextComponent var19 = new TextComponent(var7);
            var19.setHoverEvent(new HoverEvent(Action.SHOW_TEXT, var10));
            if (var1 instanceof Player) {
               ((Player)var1).spigot().sendMessage(var19);
            } else {
               var1.sendMessage(var7);
            }

         }
      }
   }

   private NotifyCommand() {
      super(null, "/intave");
   }

   private static String g(String var0) {
      return ChatColor.RED + var0;
   }

   @Command(
      aliases = {"proxy"},
      e = "",
      a = "Access proxy related features",
      d = "intave.command.proxy"
   )
   @Unknown199(
      a = ProxyCommand.class
   )
   public void e(CommandSender var1) {
   }

   public static NotifyCommand of() {
      if (l == null) {
         l = new NotifyCommand();
      }

      return l;
   }

   @Command(
      aliases = {"internals"},
      e = "",
      a = "Console-reserved commands",
      d = "intave.command.internals.*"
   )
   @Unknown199(
      a = InternalCommand.class
   )
   public void b(PlayerData var1) {
   }

   private static String e(String var0) {
      return ChatColor.RED + var0;
   }

   private native void c(CommandSender var1);

   @Command(
      aliases = {"history", "logs"},
      e = "<player>",
      a = "View a player's violation history",
      d = "intave.command.history"
   )
   public void b(CommandSender var1, String var2) {
      Player var6 = Bukkit.getPlayer(var2);
      if (this.a(var6)) {
         PlayerData var7 = PlayerDataManager.getPlayerData(var6);
         String var8 = var6.getName();
         UUID var9 = var6.getUniqueId();
         Unknown16 var10 = (Unknown16)var7.b(Unknown16.class);
         this.a(var1, var8, var9, var10);
      } else {
         var1.sendMessage(IntavePlugin.getPrefix() + ChatColor.YELLOW + "Loading history..");
         iW.a(var2, this::a);
      }

   }

   @Command(
      aliases = {"version"},
      e = "",
      a = "Show version info"
   )
   public void b(CommandSender var1) {
      this.c(var1);
   }

   private static String c(String var0) {
      return ChatColor.RED + var0;
   }

   private static boolean d(List var0, Player var1) {
      return var0.contains(var1.getUniqueId());
   }

   @Command(
      aliases = {"diagnostics"},
      e = "",
      a = "Runtime and performance data output",
      d = "intave.command.diagnostics.*"
   )
   @Unknown199(
      a = PerformanceDiagnosticCommand.class
   )
   public void f(CommandSender var1) {
   }

   private String b(long var1) {
      long var6 = var1 / 1000L;
      long var8 = var6 / 60L;
      long var10 = var8 / 60L;
      long var12 = var10 / 24L;
      if (var12 > 0L) {
         return var12 + " days ago";
      } else if (var10 > 0L) {
         return var10 + " hours ago";
      } else if (var8 > 0L) {
         return var8 + " minutes ago";
      } else {
         return var6 > 0L ? var6 + " seconds ago" : "a few seconds ago";
      }
   }

   @Override
   protected void a(CommandSender var1) {
      boolean var5 = PermissionUtil.b(var1, "intave.command");
      if (var5) {
         super.a(var1);
      } else {
         this.c(var1);
      }

   }
}
