package de.jpx3.intave.anticheat.check.heuristic;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;
import com.google.common.collect.Lists;
import de.jpx3.intave.b1;
import de.jpx3.intave.jk;
import de.jpx3.intave.k3;
import de.jpx3.intave.access.UnsupportedFallbackOperationException;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.CombatCheckType;
import de.jpx3.intave.anticheat.check.api.BaseCheck;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.violate.Anomaly;
import de.jpx3.intave.unknown.Unknown102;
import de.jpx3.intave.unknown.Unknown22;
import de.jpx3.intave.unknown.Unknown230;
import de.jpx3.intave.unknown.Unknown262;
import de.jpx3.intave.unknown.Unknown363;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

public final class HeuristicCheckGroup extends BaseCheck {
   private static final long q = 1800000L;
   private final Unknown102 n;
   private final IntavePlugin plugin;

   @Deprecated
   private void a(PlayerData data, Unknown230 var2) {
      var2.a(data);
   }

   public Certainty a(List var1) {
      return this.a((Certainty[])var1.toArray(new Certainty[0]));
   }

   private static boolean c(Anomaly anomaly) {
      return !anomaly.a();
   }

   private void a() {
      this.e(null);
   }

   private static boolean a(Anomaly var0, Anomaly var1) {
      return var1.getKey().equals(var0.getKey()) && var1.getConfidence().isOrAbove(var0.getConfidence());
   }

   private List c(List var1) {
      var1.removeIf(HeuristicCheckGroup::isConfidenceNone);
      ArrayList var5 = Lists.newArrayList();
      ArrayList var6 = Lists.newArrayList();

      for(Anomaly var8 : var1) {
         String var9 = var8.getKey();
         if (!var5.contains(var9)) {
            var5.add(var9);
            var6.add(var8);
         }
      }

      var1 = var6;
      if (var6.size() > 2) {
         var6.sort(Comparator.comparingInt(HeuristicCheckGroup::b));
         Collections.reverse(var6);
         ArrayList var11 = Lists.newArrayList();

         for(int var12 = 0; var12 <= 1; ++var12) {
            var11.add(var1.get(var12));
         }

         var1 = var11;
      }

      return var1;
   }

   public List d(List var1) {
      var1.sort(Comparator.comparingDouble(HeuristicCheckGroup::d));
      Collections.reverse(var1);
      HashMap var5 = new HashMap();
      ArrayList var6 = new ArrayList();

      for(Anomaly var8 : var1) {
         String var9 = var8.getKey();
         if (var5.getOrDefault(var9, 0) <= var8.g() || var8.g() == 0) {
            var6.add(var8.getConfidence());
         }

         var5.put(var9, var5.getOrDefault(var9, 0) + 1);
      }

      return var6;
   }

   public Certainty a(Certainty[] var1) {
      return Certainty.a(Certainty.sum(var1));
   }

   private void j() {
      this.a(null, false);
   }

   private static String a(Anomaly var0) {
      return "p[" + var0.getKey() + "]";
   }

   // $FF: Unable to simplify switch on enum
   // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Deprecated
   @k3
   private Unknown230 a(List var1, Certainty var2, Unknown230 var3) {
      boolean var7 = var1.stream().anyMatch(Anomaly::c);
      if (!var7) {
         return null;
      } else {
         Unknown230 var8 = null;
         boolean var9 = var3 == Unknown230.c;
         switch(b1.a[var2.ordinal()]) {
            case 1:
            case 2:
               var8 = Unknown230.c;
               break;
            case 3:
               var8 = this.b() && !var9 ? Unknown230.c : Unknown230.d;
               break;
            case 4:
               var8 = this.b() && !var9 ? Unknown230.c : Unknown230.e;
         }

         return var8;
      }
   }

   private native void b(Player var1, Anomaly var2);

   @PacketListener(
      packetTypes = {ClientPacket.USE_ENTITY}
   )
   public void handleAttack(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      HeuristicCheckStorage var6 = (HeuristicCheckStorage)this.getStorage(var5);
      PacketContainer var7 = var1.getPacket();
      EntityUseAction var8 = (EntityUseAction)var7.getEntityUseActions().readSafely(0);
      if (var8 == null) {
         var8 = ((WrappedEnumEntityUseAction)var7.getEnumEntityUseActions().read(0)).getAction();
      }

      if (var8 == EntityUseAction.ATTACK && var6.c++ == 0) {
         var6.a = System.currentTimeMillis();
      }

   }

   @PacketListener(
      packetTypes = {ClientPacket.POSITION, ClientPacket.POSITION_LOOK, ClientPacket.LOOK, ClientPacket.FLYING, ClientPacket.VEHICLE_MOVE}
   )
   @Deprecated
   public void b(PacketEvent var1) {
      if (!var1.isCancelled()) {
         Player var5 = var1.getPlayer();
         PlayerData var6 = this.getData(var5);
         PlayerHolder var7 = var6.getStorage().getPlayerHolder();
         Unknown363 var8 = var7.s;
         if (var8 != null) {
            jk var9 = var8.b();
            if (var9.f > 0.0) {
               var9.f -= 0.002;
            }

         }
      }
   }

   @NotNull
   public native List a(PlayerData var1, boolean var2);

   private static double d(Anomaly var0) {
      return (double)var0.getConfidence().getLevel();
   }

   private void a(IntavePlugin intavePlugin) {
      int var2 = Bukkit.getScheduler().scheduleAsyncRepeatingTask(intavePlugin, this::h, 0L, 400L);
      Unknown22.a(var2);
   }

   private static boolean isConfidenceNone(Anomaly anomaly) {
      return anomaly.getConfidence() == Certainty.NONE;
   }

   @BukkitEventListener
   @Deprecated
   public void handleDamageEvent(EntityDamageByEntityEvent var1) {
      Entity var5 = var1.getDamager();
      if (var5 instanceof Player) {
         Player var6 = (Player)var5;
         PlayerData var7 = this.getData(var6);
         PlayerHolder var8 = var7.getStorage().getPlayerHolder();
         if (var8.s != null) {
            jk var9 = var8.s.b();
            var9.a(var1);
         }

      }
   }

   public void d() {
      Unknown262.a(this::e);
      Unknown262.a(this::g);
      Unknown262.a(this::j);
      Unknown262.a(this::a);
   }

   public native void a(Player var1, boolean var2);

   @Deprecated
   private boolean b() {
      return ThreadLocalRandom.current().nextBoolean();
   }

   private void e() {
      this.b(null, null);
   }

   public void logAnomaly(Player player, Anomaly var2) {
      if (var2.getConfidence().getLevel() > Certainty.NONE.getLevel()) {
         HeuristicCheckStorage var6 = (HeuristicCheckStorage)this.getStorage(player);
         int var7 = var2.g();
         int var8 = (int)var6.d.stream().filter(HeuristicCheckGroup::a).count();
         if (var7 == 0 || var8 <= var7) {
            var6.d.add(var2);
         }
      }

      IntaveScheduler.runTask(this::a);
   }

   public HeuristicCheckGroup(IntavePlugin plugin) {
      super("Heuristics", "heuristics", HeuristicCheckStorage.class);
      this.plugin = plugin;
      this.n = new Unknown102(this);
      this.i();
      this.a(plugin);
      this.d();
   }

   private native String e(List var1);

   private native String f(List var1);

   @Deprecated
   private void a(Unknown363 var1) {
      jk var2 = var1.b();
      boolean var3 = var2.c();
      if (var3) {
         var2.h();
      }

   }

   public native void i();

   private static boolean f(Anomaly var0) {
      return !var0.j();
   }

   private CombatCheckType b(List var1) {
      return (CombatCheckType)((Entry)((Map)var1.stream().collect(Collectors.groupingBy(Anomaly::l, Collectors.counting())))
            .entrySet()
            .stream()
            .max(Comparator.comparingLong(Entry::getValue))
            .orElseThrow(IllegalStateException::new))
         .getKey();
   }

   private void a(Player var1, Anomaly var2) {
      this.b(var1, var2);
   }

   private static int b(Anomaly var0) {
      return var0.getConfidence().getLevel();
   }

   @BukkitEventListener
   public void handleQuitEvent(PlayerQuitEvent event) {
      Player var2 = event.getPlayer();
      this.a(var2, true);
   }

   private void g() {
      this.a(null, false);
   }

   private void h() {
      for(Player var5 : Bukkit.getOnlinePlayers()) {
         try {
            this.a(var5, false);
         } catch (UnsupportedFallbackOperationException var7) {
         }
      }

   }
}
