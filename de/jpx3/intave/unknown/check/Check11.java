package de.jpx3.intave.unknown.check;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import de.jpx3.intave.qd;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.holder.EntityHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.engine.util.GameMode;
import de.jpx3.intave.anticheat.listener.IntaveListenerPriority;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ServerPacket;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import java.lang.reflect.Field;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public final class Check11 extends UnknownCheck {
   private final boolean e = MinecraftVersion.V_1_16.atOrAbove();
   private final Class a = !this.e ? null : ReflectionUtil.getClazz("PacketPlayOutGameStateChange$a");
   private static final boolean f = MinecraftVersion.V_1_16.atOrAbove();

   private void a(Player var1, Entity var2) {
      PlayerData var3 = PlayerDataManager.getPlayerData(var1);
      EntityHolder var4 = var3.getStorage().getEntityHolder();
      var4.l = var2 != var1;
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      packetTypes = {ClientPacket.ABILITIES}
   )
   public void a(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      PacketContainer var7 = var1.getPacket();
      EntityHolder var8 = var6.getStorage().getEntityHolder();
      BukkitEnginePlayer var9 = var6.getStorage().getPhysicsHolder();
      boolean var10 = b(var7);
      if (var8.d()) {
         if (var10) {
            var8.setFlying(true);
         } else {
            var9.bi = true;
         }
      }

   }

   @PacketListener(
      g = {ServerPacket.CAMERA}
   )
   public void c(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      PacketContainer var3 = var1.getPacket();
      Integer var4 = (Integer)var3.getIntegers().read(0);
      MoudleLoader.m().a(var2, Check15.a(var2, var4), this::a);
   }

   private static boolean b(PacketContainer var0) {
      return var0.getBooleans().read(f ? 0 : 1);
   }

   private void a(Player var1, float var2) {
      PlayerData var3 = PlayerDataManager.getPlayerData(var1);
      EntityHolder var4 = var3.getStorage().getEntityHolder();
      var4.setFlySpeed(var2);
   }

   private void b(Player var1, float var2) {
      PlayerData var3 = PlayerDataManager.getPlayerData(var1);
      EntityHolder var4 = var3.getStorage().getEntityHolder();
      var4.setMovementSpeed(var2);
   }

   @PacketListener(
      priority = IntaveListenerPriority.HIGH,
      g = {ServerPacket.ABILITIES}
   )
   public void b(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PacketContainer var6 = var1.getPacket();
      Float var7 = (Float)var6.getFloat().readSafely(1);
      if (var7 != null) {
         MoudleLoader.m().a(var5, var7, this::b);
      }

      Float var8 = (Float)var6.getFloat().readSafely(0);
      if (var8 != null) {
         MoudleLoader.m().a(var5, var8, this::a);
      }

      Boolean var9 = (Boolean)var6.getBooleans().read(2);
      if (var9 != null) {
         MoudleLoader.m().a(var5, var9, this::a);
      }

   }

   @PacketListener(
      priority = IntaveListenerPriority.NORMAL,
      g = {ServerPacket.GAME_STATE_CHANGE}
   )
   public void d(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PlayerData var6 = PlayerDataManager.getPlayerData(var5);
      PacketContainer var7 = var1.getPacket();
      EntityHolder var8 = var6.getStorage().getEntityHolder();
      if (this.a(var7)) {
         Float var9 = (Float)var7.getFloat().read(0);
         int var10 = MathUtil.e(var9 + 0.5F);
         GameMode var11 = this.a(var10);
         var8.a(var11);
         MoudleLoader.m().a(var5, var11, Check11::b);
      }
   }

   private GameMode a(int var1) {
      for(GameMode var8 : GameMode.values()) {
         if (GameMode.getId(var8) == var1) {
            return var8;
         }
      }

      throw new IllegalStateException("Unable to resolve gamemode with id " + var1);
   }

   private static void b(Player var0, GameMode var1) {
      PlayerDataManager.getPlayerData(var0).getStorage().getEntityHolder().c(var1);
   }

   private boolean a(PacketContainer var1) {
      if (this.e) {
         try {
            Object var5 = var1.getModifier().withType(this.a).read(0);
            Class var10000 = var5.getClass();
            String var10003 = qd.c(var10000, "b");
            String var10002 = "b";
            Field var6 = var10000.getDeclaredField(var10003);
            var6.setAccessible(true);
            return var6.get(var5) == 3;
         } catch (Exception var7) {
            var7.printStackTrace();
            return false;
         }
      } else {
         return var1.getIntegers().read(0) == 3;
      }
   }

   private void a(Player var1, boolean var2) {
      PlayerData var3 = PlayerDataManager.getPlayerData(var1);
      EntityHolder var4 = var3.getStorage().getEntityHolder();
      var4.setAllowFlight(var2);
   }
}
