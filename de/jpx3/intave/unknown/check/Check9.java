package de.jpx3.intave.unknown.check;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedAttribute;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import com.comphenix.protocol.wrappers.EnumWrappers.EntityUseAction;
import com.google.common.collect.Lists;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.check.heuristic.HeuristicCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.ItemHolder;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ProtocolManager;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.unknown.Unknown148;
import de.jpx3.intave.unknown.Unknown190;
import de.jpx3.intave.unknown.unknown79;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDamageEvent.DamageModifier;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

public final class Check9 extends UnknownCheck {
   private static final String[] f = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
   private static final int[] g = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
   public static boolean e;

   private static Double b(Double var0) {
      return -0.0;
   }

   @Override
   public void refreshConfig() {
      e = !MinecraftVersion.V_1_9.atOrAbove()
         && ((HeuristicCheckGroup)this.plugin.g().findCheck(HeuristicCheckGroup.class)).b().b().getBoolean("disable-reducing", true);

      for(Player var5 : Bukkit.getOnlinePlayers()) {
         this.a(var5);
      }

   }

   @PacketListener(
      priority = IntaveListenerPriority.LOW,
      packetTypes = {ClientPacket.USE_ENTITY}
   )
   public void a(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      if (var5.isDead()) {
         var1.setCancelled(true);
      } else {
         PlayerData var6 = PlayerDataManager.getPlayerData(var5);
         PlayerStorage var7 = var6.getStorage();
         PlayerHolder var8 = var7.getPlayerHolder();
         unknown79 var9 = var7.c();
         BukkitEnginePlayer var10 = var7.getPhysicsHolder();
         PacketContainer var11 = var1.getPacket();
         Integer var12 = (Integer)var11.getIntegers().read(0);
         EntityUseAction var13 = (EntityUseAction)var11.getEntityUseActions().readSafely(0);
         if (var13 == null) {
            var13 = ((WrappedEnumEntityUseAction)var11.getEnumEntityUseActions().read(0)).getAction();
         }

         ItemHolder var14 = var6.getStorage().getItemHolder();
         ItemStack var15 = var14.getItemInHand();
         boolean var16 = var15 != null && var15.containsEnchantment(Enchantment.KNOCKBACK);
         TrackedEntity var17 = var9.a(var12);
         if (var17 != null) {
            if (var13 == EntityUseAction.ATTACK) {
               var8.setAttackedEntityId(var12);
               if (var17.g) {
                  var10.slowdownTicks = 0;
                  if (!e && var16) {
                     var10.deltaX *= 0.6;
                     var10.deltaZ *= 0.6;
                  }
               }

               Unknown148 var18 = var8.b();
               if (var18 != null) {
                  var18.n();
                  if (var18.a() == var12) {
                     Consumer var19 = var18.h();
                     Vector var20 = var18.b().s.toVector();
                     Vector var21 = new Vector(var8.e, var8.h, var8.f);
                     if (var20.distance(var21) < 0.1) {
                        var19.accept(var18);
                     }
                  }
               }
            }

         }
      }
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      g = {ServerPacket.RESPAWN}
   )
   public void b(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      IntaveScheduler.a(this::c, 4);
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      g = {ServerPacket.SET_SLOT}
   )
   public void c(PacketEvent var1) {
      PacketContainer var5 = var1.getPacket();
      ItemStack var6 = ((ItemStack)var5.getItemModifier().read(0)).clone();
      if (e && var6.containsEnchantment(Enchantment.DAMAGE_ALL)) {
         int var7 = var6.getEnchantmentLevel(Enchantment.DAMAGE_ALL);
         var6.removeEnchantment(Enchantment.DAMAGE_ALL);
         ItemMeta var8 = var6.getItemMeta().clone();
         if (!var8.hasItemFlag(ItemFlag.HIDE_ENCHANTS)) {
            ArrayList var9 = var8.getLore() == null ? new ArrayList() : new ArrayList(var8.getLore());
            var9.add(ChatColor.GRAY + "Sharpness " + a(var7));
            var8.setLore(var9);
         }

         if (!var8.hasEnchants()) {
            var8.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
            var8.addEnchant(Enchantment.DURABILITY, 0, true);
         }

         var6.setItemMeta(var8);
      }

      var5.getItemModifier().write(0, var6);
   }

   private void c(Player var1) {
      this.a(var1);
   }

   @BukkitEventListener
   public void a(PlayerJoinEvent var1) {
      this.a(var1.getPlayer());
   }

   @BukkitEventListener
   public void a(EntityDamageByEntityEvent var1) {
      if (var1.getCause() == DamageCause.ENTITY_ATTACK) {
         Entity var5 = var1.getEntity();
         if (var5 instanceof Player) {
            Player var6 = (Player)var5;
            PlayerData var7 = PlayerDataManager.getPlayerData(var6);
            var7.getStorage().getPlayerHolder().j();
            double var8 = var1.getDamage(DamageModifier.BLOCKING);
            if (var8 < 0.0 && !var7.getStorage().getItemHolder().h()) {
               Unknown190.a(var1, DamageModifier.BLOCKING, Check9::b);
            }

         }
      }
   }

   public static String a(int var0) {
      StringBuilder var4 = new StringBuilder();

      for(int var5 = 0; var5 < g.length; ++var5) {
         while(var0 >= g[var5]) {
            var0 -= g[var5];
            var4.append(f[var5]);
         }
      }

      return var4.toString();
   }

   private void a(Player var1) {
      if (e) {
         PacketContainer var4 = ProtocolLibrary.getProtocolManager().createPacket(Server.UPDATE_ATTRIBUTES);
         var4.getIntegers().write(0, var1.getEntityId());
         WrappedAttribute var5 = WrappedAttribute.newBuilder()
            .packet(var4)
            .attributeKey("generic.attackDamage")
            .baseValue(0.0)
            .modifiers(Collections.emptyList())
            .build();
         var4.getAttributeCollectionModifier().write(0, Lists.newArrayList(new WrappedAttribute[]{var5}));
         ProtocolManager.sendPacket(var1, var4);
      }
   }
}
