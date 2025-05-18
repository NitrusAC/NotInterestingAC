package de.jpx3.intave.anticheat.command.impl;

import com.comphenix.protocol.utility.MinecraftVersion;
import de.jpx3.intave.dT;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.AbstractCheck;
import de.jpx3.intave.anticheat.command.AbstractCommandRegistrar;
import de.jpx3.intave.anticheat.command.Arg;
import de.jpx3.intave.anticheat.command.Command;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import de.jpx3.intave.unknown.Unknown109;
import de.jpx3.intave.unknown.Unknown125;
import de.jpx3.intave.unknown.Unknown162;
import de.jpx3.intave.unknown.Unknown63;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class PerformanceDiagnosticCommand extends AbstractCommandRegistrar {
   private static final DateTimeFormatter l = DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm.ss.SSS");
   private static final DateTimeFormatter k = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
   private static PerformanceDiagnosticCommand j;
   private final IntavePlugin m = IntavePlugin.getInstance();

   private static Long b(AbstractCheck var0) {
      return var0.h().h();
   }

   @Command(
      aliases = {"resources"},
      e = "",
      d = "intave.command.diagnostics.performance",
      a = ""
   )
   public void handleResources(CommandSender var1) {
      var1.sendMessage(IntavePlugin.getPrefix() + "Resources");
      Unknown162.a().forEach(PerformanceDiagnosticCommand::a);
   }

   @Command(
      aliases = {"resync"},
      e = "",
      d = "intave.command.diagnostics.performance",
      a = "Output packet re-synchronizations"
   )
   public void handleResync(CommandSender var1) {
      var1.sendMessage(IntavePlugin.getPrefix() + "Loading data..");
      Map var5 = dT.a();
      if (var5.isEmpty()) {
         var1.sendMessage(ChatColor.GREEN + "No hard re-syncs on record");
      } else {
         var5 = this.a(var5);
         var5.forEach(PerformanceDiagnosticCommand::a);
      }

   }

   public static PerformanceDiagnosticCommand a() {
      if (j == null) {
         j = new PerformanceDiagnosticCommand();
      }

      return j;
   }

   @Command(
      aliases = {"statistics"},
      e = "",
      d = "intave.command.diagnostics.statistics",
      a = "Output check statistics"
   )
   public void e(CommandSender var1) {
      var1.sendMessage(IntavePlugin.getPrefix() + "Loading check statistics...");
      ArrayList var5 = new ArrayList(this.m.g().getChecks());
      var5.sort(Comparator.comparing(PerformanceDiagnosticCommand::b));
      boolean var6 = false;

      for(AbstractCheck var8 : var5) {
         Unknown63 var9 = var8.h();
         long var10 = var9.f();
         long var12 = var9.b();
         if (var10 != 0L && var8.isEnabled()) {
            String var14 = MathUtil2.getStringRounded((double)var12 / (double)var10 * 100.0, 5);
            String var15 = ChatColor.RED + var8.k();
            String var16 = var15 + IntavePlugin.l() + ": " + var12 + " detections in " + var10 + " processes (" + var14 + "%)";
            var1.sendMessage(var16);
            var6 = true;
         }
      }

      if (!var6) {
         var1.sendMessage(IntavePlugin.getPrefix() + "No check statistics available");
      }

   }

   @Command(
      aliases = {"threaddump"},
      e = "",
      d = "intave.command.diagnostics.statistics",
      a = "Create and save thread dumps"
   )
   public void handleThreadDump(CommandSender var1) {
      File var5 = new File(this.m.r(), "dumps");
      File var6 = new File(var5, b());

      try {
         var5.mkdir();
         var6.createNewFile();
      } catch (IOException var10) {
         var10.printStackTrace();
         return;
      }

      try {
         FileOutputStream var7 = new FileOutputStream(var6);
         PrintStream var8 = new PrintStream(var7);
         var8.println("Static environment");
         var8.println(" Time: " + LocalDateTime.now().format(l));
         var8.println(" Intave: " + IntavePlugin.m());
         var8.println(" ProtocolLib: " + Bukkit.getPluginManager().getPlugin("ProtocolLib").getDescription().getVersion());
         if (Bukkit.getPluginManager().getPlugin("ViaVersion") != null) {
            var8.println(" ViaVersion: " + Bukkit.getPluginManager().getPlugin("ViaVersion").getDescription().getVersion());
         } else {
            var8.println(" ViaVersion not present");
         }

         var8.println(" Server: " + Bukkit.getVersion() + "/" + Bukkit.getBukkitVersion());
         var8.println(" Minecraft: " + MinecraftVersion.getCurrentVersion().toString());
         var8.println("Players");
         var8.println(" Thread dump creator: " + var1.getName());
         var8.println(
            " Players online: "
               + Bukkit.getOnlinePlayers().size()
               + "/"
               + Bukkit.getOnlinePlayers().stream().map(OfflinePlayer::getName).collect(Collectors.toList())
         );
         var8.println(" ");
         Thread.getAllStackTraces().forEach(PerformanceDiagnosticCommand::a);
         var8.flush();
         var8.close();
      } catch (FileNotFoundException var9) {
         var9.printStackTrace();
      }

      var1.sendMessage(IntavePlugin.getPrefix() + ChatColor.GREEN + "Threaddump created");
      var1.sendMessage(IntavePlugin.getPrefix() + "You can find it under " + var6.getAbsolutePath());
   }

   @Command(
      aliases = {"performance"},
      e = "",
      a = "Output performance data",
      d = "intave.command.diagnostics.performance"
   )
   public void handlePerformance(CommandSender var1) {
      var1.sendMessage(IntavePlugin.getPrefix() + ChatColor.RED + "Currently unavailable");
   }

   private static void a(CommandSender var0, String var1, Long var2) {
      var0.sendMessage(
         ChatColor.RED
            + var1.toLowerCase(Locale.ROOT)
            + IntavePlugin.l()
            + " packets hit a total of "
            + ChatColor.RED
            + var2
            + IntavePlugin.l()
            + " hard re-syncs"
      );
   }

   @Command(
      aliases = {"timings"},
      e = "",
      a = "Output timing data",
      d = "intave.command.diagnostics.performance"
   )
   public native void handleTimings(PlayerData var1, @Arg String[] var2);

   private static void a(CommandSender var0, String var1, HTTPRequest var2) {
      var0.sendMessage(IntavePlugin.getPrefix() + " " + var1.substring(0, 2) + " of " + Unknown109.a(var2.stream()));
   }

   private PerformanceDiagnosticCommand() {
      super(NotifyCommand.of(), "diagnostics");
   }

   public Map a(Map var1) {
      ArrayList var5 = new ArrayList(var1.keySet());
      ArrayList var6 = new ArrayList(var1.values());
      Collections.sort(var6);
      Collections.reverse(var6);
      Collections.sort(var5);
      LinkedHashMap var7 = new LinkedHashMap();

      for(Comparable var9 : var6) {
         Iterator var10 = var5.iterator();

         while(var10.hasNext()) {
            Comparable var11 = (Comparable)var10.next();
            if (((Comparable)var1.get(var11)).equals(var9)) {
               var10.remove();
               var7.put(var11, var9);
               break;
            }
         }
      }

      return var7;
   }

   private static void a(String var0, Player var1, Unknown125 var2) {
      if (!var2.k() && !var2.u()) {
         boolean var6 = var2.t() > 0.5;
         boolean var7 = var2.t() > 1.5;
         String var8 = String.format(
            "%s: %s::%sms (%s&f ms/c)",
            var2.o(),
            var2.getCalls(),
            MathUtil2.getStringRounded(var2.b(), 4),
            (var6 ? (var7 ? ChatColor.RED : ChatColor.YELLOW) : ChatColor.GREEN) + "" + MathUtil2.getStringRounded(var2.t(), 8)
         );
         if (!var0.isEmpty() && !var2.getName().toLowerCase(Locale.ROOT).contains(var0)) {
            var8 = IntavePlugin.l() + ChatColor.stripColor(var8);
         }

         var1.sendMessage(ChatColor.translateAlternateColorCodes('&', var8));
      }
   }

   private static String a(String var0) {
      return var0 + " ";
   }

   private static String b() {
      return "intave-threaddump-" + LocalDateTime.now().format(k).toLowerCase(Locale.ROOT) + ".txt";
   }

   private static void a(PrintStream var0, Thread var1, StackTraceElement[] var2) {
      String var6 = var1.getName();
      if (var6.contains("Netty") || var6.contains("Intave") || var6.contains("Server thread")) {
         var0.println("Thread " + var6);
         Exception var7 = new Exception();
         var7.setStackTrace(var2);
         var7.printStackTrace(var0);
      }

   }

   @Command(
      aliases = {"invalidatecaches"},
      e = "",
      d = "intave.command.diagnostics.performance",
      a = ""
   )
   public void handleInvalidateCaches(CommandSender var1) {
      var1.sendMessage(IntavePlugin.getPrefix() + "Invalidating caches..");

      for(HTTPRequest var6 : Unknown162.a().values()) {
         var6.b();
      }

      var1.sendMessage(IntavePlugin.getPrefix() + "Done, please restart Intave");
   }
}
