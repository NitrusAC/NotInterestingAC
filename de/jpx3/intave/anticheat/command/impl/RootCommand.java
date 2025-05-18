package de.jpx3.intave.anticheat.command.impl;

import de.jpx3.intave.dT;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.access.player.trust.TrustFactor;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.command.AbstractCommandRegistrar;
import de.jpx3.intave.anticheat.command.Arg;
import de.jpx3.intave.anticheat.command.Command;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.violate.Anomaly;
import de.jpx3.intave.anticheat.world.IntaveWorldBlock;
import de.jpx3.intave.unknown.Unknown125;
import de.jpx3.intave.unknown.Unknown230;
import de.jpx3.intave.unknown.Unknown58;
import java.text.DecimalFormat;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class RootCommand extends AbstractCommandRegistrar {
   private final IntavePlugin k = IntavePlugin.getInstance();
   private static RootCommand j;
   private static final Map l = new HashMap();

   @Command(
      aliases = {"statistics"},
      e = "",
      a = "Output check statistics",
      d = "sibyl"
   )
   public native void handleStatistics(PlayerData var1);

   @Command(
      aliases = {"invisibleBlock"},
      e = "",
      a = "",
      d = "sibyl"
   )
   public native void handleInvisibleBlock(PlayerData var1);

   private RootCommand() {
      super(NotifyCommand.of(), "root");
   }

   private static String a(Anomaly var0) {
      return "p[" + var0.getKey() + "]";
   }

   private static AtomicLong a(TrustFactor var0) {
      return new AtomicLong();
   }

   @Command(
      aliases = {"record"},
      e = "",
      a = "Record timings",
      d = "sibyl"
   )
   public native void b(PlayerData var1, @Arg Player var2);

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

   private static void c(String var0, Player var1, Unknown125 var2) {
      if (var2.u()) {
         boolean var6 = var2.t() > 0.5;
         boolean var7 = var2.t() > 1.5;
         String var8 = String.format(
            "%s: %s::%sms (%s ms/c)",
            var2.o(),
            var2.getCalls(),
            MathUtil2.getStringRounded(var2.b(), 4),
            (var6 ? (var7 ? ChatColor.RED : ChatColor.YELLOW) : ChatColor.GREEN) + "" + MathUtil2.getStringRounded(var2.t(), 8) + ChatColor.WHITE
         );
         if (!var0.isEmpty() && !var2.getName().toLowerCase(Locale.ROOT).contains(var0)) {
            var8 = IntavePlugin.l() + ChatColor.stripColor(var8);
         }

         var1.sendMessage(ChatColor.translateAlternateColorCodes('&', var8));
      }
   }

   @Command(
      aliases = {"eventtimings"},
      e = "",
      a = "Output timing data",
      d = "sibyl"
   )
   public native void handleEventTimings(PlayerData var1, @Arg String[] var2);

   @Command(
      aliases = {"biasec"},
      e = "",
      a = "",
      d = "sibyl"
   )
   public native void handleBiasec(PlayerData var1);

   @Command(
      aliases = {"settrust"},
      e = "<trustfactor> [<target>]",
      a = "",
      d = "sibyl"
   )
   public native void handleSetTrust(PlayerData var1, TrustFactor var2, @Arg Player var3);

   public static String format(double var0) {
      DecimalFormat var4 = new DecimalFormat("###,###,###");
      return var4.format(var0);
   }

   @Command(
      aliases = {"playback"},
      e = "",
      a = "Playback recorded timings",
      d = "sibyl"
   )
   public native void handlePlayback(PlayerData var1, @Arg Player var2);

   public static RootCommand a() {
      if (j == null) {
         j = new RootCommand();
      }

      return j;
   }

   private static String a(String var0) {
      return var0 + " ";
   }

   @Command(
      aliases = {"bbaf"},
      e = "",
      a = "",
      d = "sibyl"
   )
   public native void handleBbaf(PlayerData var1);

   @Command(
      aliases = {"timings"},
      e = "",
      a = "Output timing data",
      d = "sibyl"
   )
   public native void handleTimings(PlayerData var1, @Arg String[] var2);

   @Command(
      aliases = {"trustmap"},
      e = "",
      d = "sibyl"
   )
   public native void handleTrustmap(PlayerData var1);

   private static void a(Player var0, String var1, Unknown58 var2) {
      var0.sendMessage(var1 + " -> " + var2.b() + " with " + var2.c() * 100.0 + "% sucess");
   }

   @Command(
      aliases = {"asyncmessage"},
      e = "",
      a = "",
      d = "sibyl"
   )
   public native void handleAsyncMessage(PlayerData var1);

   private static void a(Player var0, String var1, Double var2) {
      if (var1.trim().isEmpty()) {
         var1 = "N";
      }

      var0.sendMessage("Key " + var1 + " " + MathUtil2.getStringRounded(var2 * 100.0, 4) + "%");
   }

   private static String d(String var0) {
      return var0 + " ";
   }

   @Command(
      aliases = {"memtrace2"},
      e = "",
      a = "",
      d = "sibyl"
   )
   public native void handleMemTrace2(PlayerData var1);

   @Command(
      aliases = {"keys"},
      e = "",
      a = "",
      d = "sibyl"
   )
   public native void handleKeys(PlayerData var1);

   private static void a(String var0, Player var1, Unknown125 var2) {
      if (!var2.k() && !var2.u()) {
         boolean var6 = var2.t() > 0.5;
         boolean var7 = var2.t() > 1.5;
         ChatColor var9 = var6 ? (var7 ? ChatColor.RED : ChatColor.YELLOW) : ChatColor.GREEN;
         String var8 = String.format(
            "%s: %s::%s%s (%s&f %s/c)",
            var2.o(),
            var2.getCalls(),
            MathUtil2.getStringRounded(var2.b() / 1000.0, 2),
            "s",
            var9 + "" + format((double)((long)var2.c())),
            "ns"
         );
         if (!var0.isEmpty() && !var0.equals("ns") && !var2.getName().toLowerCase(Locale.ROOT).contains(var0)) {
            var8 = IntavePlugin.l() + ChatColor.stripColor(var8);
         }

         var1.sendMessage(ChatColor.translateAlternateColorCodes('&', var8));
      }
   }

   @Command(
      aliases = {"iter"},
      e = "",
      a = "",
      d = "sibyl"
   )
   public native void handleIter(PlayerData var1);

   @Command(
      aliases = {"trust"},
      e = "[<target>]",
      a = "",
      d = "sibyl"
   )
   public native void handleTrust(PlayerData var1, @Arg Player var2);

   private static String a(long var0) {
      if (-1000L < var0 && var0 < 1000L) {
         return var0 + "B";
      } else {
         StringCharacterIterator var5 = new StringCharacterIterator("kMGTPE");

         while(var0 <= -999950L || var0 >= 999950L) {
            var0 /= 1000L;
            var5.next();
         }

         return String.format("%.1f%cB", (double)var0 / 1000.0, var5.current());
      }
   }

   @Command(
      aliases = {"latencies"},
      e = "",
      a = "",
      d = "sibyl"
   )
   public native void handleLatencies(PlayerData var1);

   @Command(
      aliases = {"packettimings"},
      e = "",
      a = "Output timing data",
      d = "sibyl"
   )
   public native void handlepacketTimings(PlayerData var1, @Arg String[] var2);

   private static void a(AtomicBoolean var0, HeuristicCheckGroup var1, Player var2, UUID var3, Certainty var4) {
      if (var4.isOrAbove(Certainty.PROBABLE)) {
         var0.set(true);
         Player var8 = Bukkit.getPlayer(var3);
         List var9 = var1.a(PlayerDataManager.getPlayerData(var8), false);
         String var10 = (String)var9.stream().map(RootCommand::a).distinct().collect(Collectors.joining(","));
         var2.sendMessage(ChatColor.RED + var4.name() + " " + ChatColor.GRAY + var8.getName() + " | " + var10);
      }
   }

   @Command(
      aliases = {"mine"},
      e = "",
      a = "",
      d = "sibyl"
   )
   public native void handleMine(PlayerData var1, Unknown230 var2, @Arg Player var3);

   @Command(
      aliases = {"badboys"},
      e = "",
      a = "",
      d = "sibyl"
   )
   public native void handleBadBoys(PlayerData var1);

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
      aliases = {"replacements"},
      e = "",
      a = "",
      d = "sibyl"
   )
   public native void handleReplacements(PlayerData var1);

   @Command(
      aliases = {"memtrace"},
      e = "",
      a = "",
      d = "sibyl"
   )
   public native void handleMemTrace(PlayerData var1);

   private void b(Player var1, Map var2) {
      Map var6 = this.a(var2);

      for(Entry var8 : var6.entrySet()) {
         var1.sendMessage((String)var8.getKey() + " requires " + a(var8.getValue()));
      }

   }

   private static void a(Player var0, String var1, Long var2) {
      if (var2 > 200L) {
         var0.sendMessage(a(var2) + " by " + (var1.contains("intave") ? ChatColor.GRAY : ChatColor.DARK_GRAY) + var1);
      }

   }

   @Command(
      aliases = {"resync"},
      e = "",
      d = "sibyl",
      a = ""
   )
   public void handleResync(CommandSender var1) {
      var1.sendMessage(IntavePlugin.getPrefix() + "Loading data..");
      Map var5 = dT.a();
      if (var5.isEmpty()) {
         var1.sendMessage(ChatColor.GREEN + "No hard re-syncs on record");
      } else {
         var5 = this.a(var5);
         var5.forEach(RootCommand::a);
      }

   }

   private static void b(String var0, Player var1, Unknown125 var2) {
      if (var2.k()) {
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

   private static void a(Player var0, Map var1, Class var2, AtomicLong var3) {
      var0.sendMessage(var3 + " " + (String)l.get(var2) + " (" + a(var1.get(var2)) + ")");
   }

   @Command(
      aliases = {"traping"},
      e = "[<target>]",
      a = "",
      d = "sibyl"
   )
   public native void handletraping(PlayerData var1, @Arg Player var2);

   private static String c(String var0) {
      return var0 + " ";
   }

   // $FF: Removed empty exception range
   static {
      l.put(Box.class, "BoundingBoxes");
      l.put(IntaveWorldBlock.class, "BlockStates");
   }
}
