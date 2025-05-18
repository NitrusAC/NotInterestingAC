package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.holder.DamageHolder;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public final class Unknown318 extends UnknownCheck {
   private void b(PlayerData var1, Unknown227 var2, String var3) {
      Unknown80 var4 = var1.getStorage().getDamageHolder().a(var2);
      this.a(var1, var4, var3);
      var4.c();
   }

   @BukkitEventListener
   public void a(EntityDamageByEntityEvent var1) {
      Entity var5 = var1.getDamager();
      if (var5 instanceof Player && var1.getCause() == DamageCause.ENTITY_ATTACK) {
         Player var6 = (Player)var5;
         DamageHolder var7 = PlayerDataManager.getPlayerData(var6).getStorage().getDamageHolder();

         for(Unknown80 var9 : var7.a()) {
            if (var9.b() && !var9.e()) {
               var9.d().accept(var1);
            }
         }

         Entity var13 = var1.getEntity();
         if (var13 instanceof Player) {
            Player var14 = (Player)var13;
            var7 = PlayerDataManager.getPlayerData(var14).getStorage().getDamageHolder();

            for(Unknown80 var11 : var7.a()) {
               if (var11.b() && var11.e()) {
                  var11.d().accept(var1);
               }
            }

         }
      }
   }

   @Deprecated
   public void c(PlayerData var1, Unknown227 var2, String var3) {
      IntaveScheduler.runTask(this::b);
   }

   private native void a(PlayerData var1, Unknown80 var2, String var3);
}
