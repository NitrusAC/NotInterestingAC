package de.jpx3.intave.anticheat.check.inventory.itemslot;

import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.dn;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.PartialConfigurableCheck;
import de.jpx3.intave.anticheat.check.inventory.InventoryAnalysisCheckGroup;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.MathUtil2;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import de.jpx3.intave.anticheat.util.ServerUtil;
import de.jpx3.intave.anticheat.violation.ImmutableViolation;
import de.jpx3.intave.anticheat.violation.Violation;
import de.jpx3.intave.unknown.Unknown227;
import java.util.List;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class ItemSlotInventoryCheck extends PartialConfigurableCheck {
   private static final boolean isNewVersion = ServerUtil.getServerVersion().isAtLeast(MinecraftVersion.V_1_9);
   private final boolean highTolerance;
   private final Class clickTypeClazz;
   private final IntavePlugin intavePlugin;

   private void validate(Player player, ItemSlotInventoryStorage storage) {
      PlayerData var6 = this.getPlayerData(player);
      double var7 = this.getStandardDeviation(storage.getSlotChangeTimes) * 100.0;
      double var9 = var6.getStorage().c().n();
      if (var7 < 2.0 && Math.abs(var9 - 50.0) < 40.0) {
         Violation var11 = Violation.builder(InventoryAnalysisCheckGroup.class)
            .player(player)
            .thresholds()
            .name("is clicking with regular deviation on items")
            .description(MathUtil2.getStringRounded(var7, 2) + " deviation")
            .vl(5.0)
            .build();
         MoudleLoader.violations().dispatchViolation(var11);
      }

   }

   private void a(Player player, ItemSlotInventoryStorage storage, int targetSlot) {
      double var7 = (double)(System.nanoTime() - ItemSlotInventoryStorage.getLastSlotChange(storage)) / 1.0E9;
      if (var7 < 2.0) {
         storage.getSlotChangeTimes.add(var7);
      }

      if (storage.getSlotChangeTimes.size() > 10) {
         if (this.a()) {
            this.validate(player, storage);
         }

         storage.getSlotChangeTimes.clear();
      }

      this.handleTime(player, storage, targetSlot, var7);
   }

   public ItemSlotInventoryCheck(InventoryAnalysisCheckGroup group, boolean highTolerance) {
      super(group, ItemSlotInventoryStorage.class);
      this.highTolerance = highTolerance;
      this.intavePlugin = IntavePlugin.getInstance();
      this.clickTypeClazz = isNewVersion ? ReflectionUtil.getClazz("InventoryClickType") : null;
   }

   private int[] a(int var1) {
      int var2 = var1 / 9 + 1;
      int var3 = var1 - (var2 - 1) * 9;
      return new int[]{var2, var3};
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.WINDOW_CLICK}
   )
   public void handlePacket(PacketEvent event) {
      Player var5 = event.getPlayer();
      if (!var5.getGameMode().equals(GameMode.CREATIVE)) {
         if (!ServerUtil.getServerVersion().isAtLeast(MinecraftVersion.V_1_13)) {
            PlayerData var6 = this.getPlayerData(var5);
            ItemSlotInventoryStorage var7 = (ItemSlotInventoryStorage)this.getStorage(var6);
            if (var6.getStorage().getVersionHolder().getVersionId() < VersionHolder.V_1_12) {
               int var8 = event.getPacket().getIntegers().read(1);
               ItemStack var9 = (ItemStack)event.getPacket().getItemModifier().read(0);
               int var10 = var9.getData().getItemTypeId() * 16 + var9.getData().getData();
               boolean var11;
               if (isNewVersion) {
                  dn var12 = (dn)event.getPacket().getEnumModifier(dn.class, this.clickTypeClazz).read(0);
                  var11 = var12 == dn.e && var8 != -999;
               } else {
                  var11 = event.getPacket().getIntegers().read(3) == 4 && var8 != -999;
               }

               if (var8 != -999
                  && ItemSlotInventoryStorage.b(var7) != -999
                  && (var10 != ItemSlotInventoryStorage.a(var7) || var11)
                  && ItemSlotInventoryStorage.getLastSlotChange(var7) != 0L) {
                  this.a(var5, var7, var8);
               }

               this.a(var6, var8, var10);
            }
         }
      }
   }

   private void a(PlayerData data, int var2, int var3) {
      ItemSlotInventoryStorage var4 = (ItemSlotInventoryStorage)this.getStorage(data);
      ItemSlotInventoryStorage.b(var4, var2);
      ItemSlotInventoryStorage.a(var4, System.nanoTime());
      ItemSlotInventoryStorage.a(var4, var3);
   }

   private double a(int var1, int var2) {
      int[] var3 = this.a(var1);
      int[] var4 = this.a(var2);
      return Math.sqrt((double)((var3[0] - var4[0]) * (var3[0] - var4[0]) + (var3[1] - var4[1]) * (var3[1] - var4[1])));
   }

   private void handleTime(Player player, ItemSlotInventoryStorage storage, int targetSlot, double time) {
      double var9 = this.a(targetSlot, ItemSlotInventoryStorage.b(storage));
      double var11 = var9 / time;
      boolean var13 = var11 > (double)(this.highTolerance ? 60 : 30);
      boolean var14 = var11 > (double)(this.highTolerance ? 150 : 100);
      if (var9 > 2.0 && var13 && (var14 || System.currentTimeMillis() - ItemSlotInventoryStorage.c(storage) < 5000L)) {
         Violation var15 = Violation.builder(InventoryAnalysisCheckGroup.class)
            .player(player)
            .thresholds()
            .name("is switching too quickly between item slots")
            .description(
               "moved from slot " + ItemSlotInventoryStorage.b(storage) + " to slot " + targetSlot + " in " + MathUtil2.getStringRounded(time, 3) + " seconds"
            )
            .vl(5.0)
            .build();
         ImmutableViolation var16 = MoudleLoader.violations().dispatchViolation(var15);
         if (var16.j() >= 50.0) {
            this.getPlayerData(player).a(Unknown227.GARBAGE_HIT, "29");
         }

         if (var16.j() >= 200.0) {
            this.getPlayerData(player).a(Unknown227.CANCEL_FIRST, "29");
            this.getPlayerData(player).a(Unknown227.DMG_MEDIUM, "29");
            this.getPlayerData(player).a(Unknown227.BLOCKING, "29");
         }
      }

      if (var13) {
         ItemSlotInventoryStorage.b(storage, System.currentTimeMillis());
      }

   }

   private double getStandardDeviation(List values) {
      double var5 = 0.0;
      double var7 = 0.0;

      for(Number var10 : values) {
         var5 += var10.doubleValue();
      }

      double var13 = var5 / (double)values.size();

      for(Number var12 : values) {
         var7 += (var12.doubleValue() - var13) * (var12.doubleValue() - var13);
      }

      return Math.sqrt(var7 / (double)values.size());
   }

   private native boolean a();
}
