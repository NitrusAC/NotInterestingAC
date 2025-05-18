package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.holder.ItemHolder;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.util.IntaveState;
import de.jpx3.intave.anticheat.util.PermissionUtil;
import de.jpx3.intave.anticheat.util.TimeFormatUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.world.WorldUnloadEvent;
import org.bukkit.inventory.ItemStack;

public final class Unknown311 extends UnknownCheck {
   @BukkitEventListener
   public void a(EntityShootBowEvent var1) {
      if (var1.getEntity() instanceof Player) {
         PlayerData var5 = PlayerDataManager.getPlayerData((Player)var1.getEntity());
         ItemHolder var6 = var5.getStorage().getItemHolder();
         if (var6.o) {
            boolean var7 = var6.g < 4;
            if (var7) {
               var1.setCancelled(true);
            }

            var6.o = false;
         }

      }
   }

   @BukkitEventListener
   public void a(WorldUnloadEvent var1) {
      World var2 = var1.getWorld();
      Unknown19.a(var2);
      Unknown19.a(var2.getUID());
      Unknown19.a(Unknown311::a);
   }

   @BukkitEventListener
   public void a(PlayerJoinEvent var1) {
      Player var5 = var1.getPlayer();
      boolean var6 = PermissionUtil.b(var5, "intave.command");
      if (var6) {
         String var7 = IntavePlugin.m();
         Unknown260 var8 = this.plugin.k().a(var7);
         if (var8 == null) {
            this.a(ChatColor.YELLOW + "This server is running an unlisted version of Intave (" + var7 + ")", var5);
            this.a(ChatColor.YELLOW + "It is possible that bugs occur", var5);
         } else if (var8.a() == IntaveState.OUTDATED) {
            long var9 = System.currentTimeMillis() - var8.f();
            String var11 = TimeFormatUtil.a(var9);
            this.a(ChatColor.RED + "This server is running an outdated version of Intave (" + var11 + " old)", var5);
            if (!Bukkit.getPluginManager().isPluginEnabled("IntaveBootstrap")) {
               this.a(ChatColor.RED + "Too lazy? Stay up-to-date automatically with IntaveBootstrap", var5);
            }

            this.a(ChatColor.RED + "We hope you understand why updating your *security* software might be important.", var5);
         }

      }
   }

   @BukkitEventListener(
      a = EventPriority.MONITOR
   )
   public void a(PlayerQuitEvent var1) {
      Player var2 = var1.getPlayer();
      Unknown19.a(var2);
      Unknown19.a(var2.getUniqueId());
   }

   @BukkitEventListener
   public void a(PlayerTeleportEvent var1) {
   }

   private static boolean a(World var0, Object var1) {
      return var1 instanceof Location && ((Location)var1).getWorld().equals(var0);
   }

   @BukkitEventListener(
      b = true
   )
   public void a(PlayerDropItemEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      ItemStack var7 = var5.getItemOnCursor();
      if (Unknown159.a(var7) && !Unknown241.a(var6.getPlayer())) {
         Material var8 = var7.getType();
         var6.getStorage().getItemHolder().r = true;
         var6.getStorage().getItemHolder().materialInHand = var8;
      }

   }

   private void b(String var1, CommandSender var2) {
      this.a(var1, var2);
   }

   private void a(String var1, CommandSender var2) {
      if (!Bukkit.isPrimaryThread()) {
         IntaveScheduler.runTask(this::b);
      } else {
         var2.sendMessage(IntavePlugin.getPrefix() + var1);
      }
   }
}
