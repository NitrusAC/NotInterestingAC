package de.jpx3.intave.unknown;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.holder.PotionHolder;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.packet.wrap.PacketInterpreters;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public final class Unknown304 extends UnknownCheck {
   private final boolean g = MinecraftVersion.V_1_9.atOrAbove();
   public static final int f = 2;
   public static final int e = 8;
   public static final int a = 1;

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      g = {ServerPacket.ENTITY_EFFECT}
   )
   public void a(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PacketContainer var6 = var1.getPacket();
      Unknown198 var7 = (Unknown198)PacketInterpreters.getInterpreter(var6);
      int var8 = var7.getEntityId();
      if (var8 != var5.getEntityId()) {
         var7.reset();
      } else {
         Unknown367 var9 = new Unknown367(var7.b(), var7.d(), var7.c());
         var7.reset();
         MoudleLoader.m().a(var5, var9, this::a);
      }
   }

   private void a(Player var1, Unknown367 var2) {
      PlayerData var6 = PlayerDataManager.getPlayerData(var1);
      PotionHolder var7 = var6.getStorage().getPotionHolder();
      int var8 = Unknown367.c(var2);
      int var9 = Unknown367.a(var2);
      switch(Unknown367.b(var2)) {
         case 1:
            var7.setSpeedAmplifier(var8 + 1);
            var7.speedEffectDuration = var9 - 1;
            break;
         case 2:
            var7.setSlownessAmplifier(var8 + 1);
            var7.slownessEffectDuration = var9 - 1;
            break;
         case 8:
            var7.setJumpBoostAmplifier(var8);
            var7.jumpBoostEffectDuration = var9 - 1;
      }

   }

   private void a(Player var1, PotionEffectType var2) {
      PlayerData var6 = PlayerDataManager.getPlayerData(var1);
      PotionHolder var7 = var6.getStorage().getPotionHolder();
      if (var2.equals(PotionEffectType.SPEED)) {
         var7.setSpeedAmplifier(0);
         var7.speedEffectDuration = 0;
      } else if (var2.equals(PotionEffectType.SLOW)) {
         var7.setSlownessAmplifier(0);
         var7.slownessEffectDuration = 0;
      } else if (var2.equals(PotionEffectType.JUMP)) {
         var7.setJumpBoostAmplifier(0);
         var7.jumpBoostEffectDuration = 0;
      }

   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      g = {ServerPacket.REMOVE_ENTITY_EFFECT}
   )
   public void b(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      PacketContainer var3 = var1.getPacket();
      int var4 = var3.getIntegers().read(0);
      if (var4 == var2.getEntityId()) {
         PotionEffectType var5 = this.a(var3);
         MoudleLoader.m().a(var2, var5, this::a);
      }
   }

   private PotionEffectType a(PacketContainer var1) {
      return this.g ? (PotionEffectType)var1.getEffectTypes().read(0) : PotionEffectType.getById(var1.getIntegers().read(1));
   }
}
