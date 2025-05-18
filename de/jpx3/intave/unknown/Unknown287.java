package de.jpx3.intave.unknown;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers.Direction;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerDigType;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.DamageHolder;
import de.jpx3.intave.anticheat.data.holder.ItemHolder;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ProtocolManager;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import de.jpx3.intave.anticheat.util.ServerUtil;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.inventory.ItemStack;

public class Unknown287 extends UnknownCheck {
   private final boolean a = ServerUtil.getServerVersion().isAtLeast(MinecraftVersion.V_1_9);

   @BukkitEventListener
   public void handleFoodLevel(FoodLevelChangeEvent event) {
      if (event.getEntity() instanceof Player) {
         Player var5 = (Player)event.getEntity();
         PlayerData var6 = PlayerDataManager.getPlayerData(var5);
         ItemHolder var7 = var6.getStorage().getItemHolder();
         if (event.getFoodLevel() >= 20 && var7.b() && var7.h()) {
            var7.resetItem();
         }

      }
   }

   @PacketListener(
      g = {ServerPacket.HELD_ITEM_SLOT}
   )
   public void a(PacketEvent event) {
      Player var2 = event.getPlayer();
      PlayerData var3 = PlayerDataManager.getPlayerData(var2);
      int var4 = event.getPacket().getIntegers().read(0);
      MoudleLoader.m().a(var2, var4, Unknown287::b);
   }

   @PacketListener(
      priority = IntaveListenerPriority.LOWEST,
      packetTypes = {ClientPacket.HELD_ITEM_SLOT}
   )
   public void c(PacketEvent event) {
      Player var2 = event.getPlayer();
      PacketContainer var3 = event.getPacket();
      PlayerData var4 = PlayerDataManager.getPlayerData(var2);
      ItemHolder var5 = var4.getStorage().getItemHolder();
      Integer var6 = (Integer)var3.getIntegers().read(0);
      ItemStack var7 = var2.getInventory().getItem(var6);
      var5.f = new Unknown279(var6, var7);
   }

   private static void b(PlayerData var0, int var1, Player var2, Integer var3) {
      var0.getStorage().getItemHolder().setHeldItemSlot(var1);
   }

   private boolean a(PacketContainer var1) {
      if (this.a) {
         return true;
      } else {
         StructureModifier var5 = var1.getIntegers();
         return var5.read(0) == 255;
      }
   }

   @PacketListener(
      priority = IntaveListenerPriority.LOWEST,
      packetTypes = {ClientPacket.BLOCK_PLACE}
   )
   public void d(PacketEvent event) {
      Player var5 = event.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      PlayerStorage var7 = var6.getStorage();
      ItemHolder var8 = var7.getItemHolder();
      DamageHolder var9 = var7.getDamageHolder();
      PacketContainer var10 = event.getPacket();
      ItemStack var11 = var8.getItemInHand();
      ItemStack var12 = var8.getItemInOffHand();
      boolean var13 = this.a(var10);
      boolean var14 = var11 != null && var11.getType().name().endsWith("_SWORD");
      if (var13 && var14 && System.currentTimeMillis() - var9.f < 5000L) {
         event.setCancelled(true);
      } else {
         boolean var15 = Unknown159.a(var5, var11) || Unknown159.a(var5, var12);
         if (var13 && var15) {
            var8.e();
         }

      }
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.BLOCK_DIG}
   )
   public void b(PacketEvent event) {
      Player var6 = event.getPlayer();
      PlayerData var7 = PlayerDataManager.getPlayerData(var6);
      ItemHolder var8 = var7.getStorage().getItemHolder();
      PacketContainer var9 = event.getPacket();
      PlayerDigType var10 = (PlayerDigType)var9.getPlayerDigTypes().read(0);
      BlockPosition var11 = (BlockPosition)event.getPacket().getModifier().withType(ReflectionUtil.getClazz("BlockPosition"), Unknown283.c()).read(0);
      if (var10 != PlayerDigType.RELEASE_USE_ITEM
         || var8.h()
         || !((Direction)var9.getDirections().read(0)).equals(Direction.DOWN)
         || var11.toVector().length() != 0.0) {
         boolean var12 = var8.b() && var8.h();
         switch(Unknown347.a[var10.ordinal()]) {
            case 1:
            case 2:
            case 3:
               var8.resetItem();
            default:
               if (var10 == PlayerDigType.DROP_ITEM && var12) {
                  PacketContainer var13 = var9.deepClone();
                  var13.getPlayerDigTypes().write(0, PlayerDigType.RELEASE_USE_ITEM);
                  var7.c();
                  ProtocolManager.receivePacket(var6, var9);
               }

         }
      }
   }

   @BukkitEventListener
   public void a(FoodLevelChangeEvent var1) {
      HumanEntity var5 = var1.getEntity();
      if (var5 instanceof Player) {
         Player var6 = (Player)var5;
         PlayerData var7 = PlayerDataManager.getPlayerData(var6);
         ItemHolder var8 = var7.getStorage().getItemHolder();
         int var9 = var1.getFoodLevel();
         if (var9 >= 20 && var8.h() && var8.b() && !Unknown159.b(var6, var8.getMaterialInHand())) {
            var8.resetItem();
         }

      }
   }
}
