package de.jpx3.intave.unknown;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.comphenix.protocol.wrappers.EnumWrappers.NativeGameMode;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerInfoAction;
import com.comphenix.protocol.wrappers.EnumWrappers.SoundCategory;
import com.google.common.base.Preconditions;
import de.jpx3.intave.ff;
import de.jpx3.intave.gG;
import de.jpx3.intave.jI;
import de.jpx3.intave.js;
import de.jpx3.intave.kG;
import de.jpx3.intave.nK;
import de.jpx3.intave.anticheat.block.IntaveMaterial;
import de.jpx3.intave.anticheat.packet.ProtocolManager;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.WorldUtil;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public abstract class Unknown118 extends Unknown119 {
   private static final int m = 8;
   private final String e;
   private final Player j;
   private final String n;
   private static final float g = 0.7111111F;
   private static final Map k = new gG();
   private static final boolean l = MinecraftVersion.V_1_9.atOrAbove();
   private final int f;
   private static final boolean i = MinecraftVersion.V_1_14.atOrAbove();
   private static final double h = 32.0;

   static boolean a() {
      return l;
   }

   protected void c(Location var1) {
      boolean var6 = !MinecraftVersion.V_1_5_0.atOrAbove();
      PacketContainer var7 = this.a(Server.NAMED_ENTITY_SPAWN);
      WrappedGameProfile var8 = this.c();
      WrappedDataWatcher var9 = this.b();
      var7.getModifier().write(0, this.a()).write(1, var8.getUUID()).write(5, this.b(var1.getYaw())).write(6, this.b(var1.getPitch()));
      this.a(var7, var1, 0);
      if (!l) {
         var7.getModifier().write(7, 0);
      }

      k.forEach(Unknown118::a);
      if (var6) {
         var7.getDataWatcherModifier().write(0, var9);
      }

      String var10 = this.n + var8.getName();
      jI.a(this.j, var8, var10);
      this.c(var7);
      if (!var6) {
         PacketContainer var11 = this.a(Server.ENTITY_METADATA);
         var11.getIntegers().write(0, this.a());
         var11.getWatchableCollectionModifier().write(0, var9.getWatchableObjects());
         this.c(var11);
      }

      if (!nK.a(this.f, nK.a)) {
         jI.a(this.j, this.c());
      }

      if (nK.a(this.f, nK.b)) {
         kG.c(this.j, this, true);
      }

   }

   public void b() {
      PacketContainer var1 = this.a(Server.PLAYER_INFO);
      WrappedChatComponent var2 = WrappedChatComponent.fromText(this.e);
      PlayerInfoData var3 = new PlayerInfoData(this.c(), 0, NativeGameMode.SURVIVAL, var2);
      List var4 = (List)var1.getPlayerInfoDataLists().readSafely(0);
      var4.add(var3);
      var1.getPlayerInfoAction().writeSafely(0, PlayerInfoAction.UPDATE_LATENCY);
      var1.getPlayerInfoDataLists().writeSafely(0, var4);
      var1.getBooleans().writeSafely(0, true);
      this.c(var1);
   }

   private byte a(double var1, double var3) {
      double var5 = (double)MathUtil.floor(var1 * 32.0);
      double var7 = (double)MathUtil.floor(var3 * 32.0);
      return (byte)((int)(var5 - var7));
   }

   private static Object b(boolean var0) {
      return var0 ? 300 : (short)300;
   }

   public void a(Location var1, boolean var2) {
      Preconditions.checkNotNull(var1);
      float var3 = var1.getYaw();
      float var4 = var1.getPitch();
      PacketContainer var5 = this.a(Server.ENTITY_TELEPORT);
      var5.getIntegers().write(0, this.a());
      this.a(var5, var1, 0);
      var5.getBytes().write(0, this.b(var3)).write(1, this.b(var4));
      var5.getBooleans().write(0, var2);
      this.c(var5);
   }

   private void b(PacketContainer var1) {
      this.c(var1);
   }

   protected Unknown118(Player var1, int var2, int var3, WrappedGameProfile var4, String var5, String var6) {
      super(var2, var4);
      this.j = var1;
      this.f = var3;
      this.n = var5;
      this.e = var6;
   }

   // $FF: Unable to simplify switch on enum
   // Please report this to the Quiltflower issue tracker, at https://github.com/QuiltMC/quiltflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private String e(Location var1) {
      Block var4 = WorldUtil.getBlockAt(var1.clone().add(0.0, -1.0, 0.0));
      switch(ff.a[IntaveMaterial.from(var4).ordinal()]) {
         case 1:
            return "step.grass";
         case 2:
            return "step.gravel";
         case 3:
            return "step.wood";
         default:
            return "step.stone";
      }
   }

   public void c() {
      PacketContainer var1 = this.a(Server.SCOREBOARD_TEAM);
      String var2 = js.b();
      var1.getStrings().write(0, var2).write(2, this.e);
      this.c(var1);
      Unknown325.a(this.j, var2, this.c(), nK.a(this.f, nK.b));
   }

   private static boolean a(Location var0, Location var1) {
      boolean var5 = var0.getYaw() == var1.getYaw();
      boolean var6 = var0.getPitch() == var1.getPitch();
      return !var5 || !var6;
   }

   private void c(PacketContainer var1) {
      if (!this.a(this::b)) {
         ProtocolManager.sendPacket(this.j, var1);
      }
   }

   private void d(Location var1) {
      this.a(var1);
   }

   public void a(Location var1) {
      if (!this.a(this::d)) {
         this.d();
         this.c(var1);
      }
   }

   private PacketContainer a(PacketType var1) {
      return ProtocolLibrary.getProtocolManager().createPacket(var1);
   }

   private void a(PacketContainer var1, Location var2, int var3) {
      if (l) {
         var1.getDoubles().write(var3 + 0, var2.getX()).write(var3 + 1, var2.getY()).write(var3 + 2, var2.getZ());
      } else {
         var1.getIntegers().write(var3 + 1, this.a(var2.getX())).write(var3 + 2, this.a(var2.getY())).write(var3 + 3, this.a(var2.getZ()));
      }

   }

   static Object c(boolean var0) {
      return b(var0);
   }

   public void a(boolean var1) {
      kG.b(this.j, this, var1);
   }

   public void d(boolean var1) {
      kG.a(this.j, this, var1);
   }

   public int f() {
      return this.f;
   }

   public Player e() {
      return this.j;
   }

   private static void a(WrappedDataWatcher var0, Integer var1, Object var2) {
      kG.a(var0, var1, var2.getClass(), var2);
   }

   public void b(Location var1) {
      PacketContainer var5 = this.a(Server.NAMED_SOUND_EFFECT);
      if (MinecraftVersion.V_1_9.atOrAbove()) {
         var5.getSoundEffects().write(0, Sound.BLOCK_STONE_STEP);
         var5.getSoundCategories().write(0, SoundCategory.PLAYERS);
      } else {
         var5.getStrings().write(0, this.e(var1));
      }

      var5.getIntegers().write(0, (int)(var1.getX() * 8.0)).write(1, (int)(var1.getY() * 8.0)).write(2, (int)(var1.getZ() * 8.0));
      if (MinecraftVersion.V_1_10.atOrAbove()) {
         var5.getFloat().write(0, 1.0F).write(1, 0.15F);
      } else {
         var5.getIntegers().write(3, 63);
         var5.getFloat().write(0, 0.15F);
      }

      this.c(var5);
   }

   public void a(Location var1, Location var2, boolean var3) {
      boolean var7 = this.b(var1, var2) != 0.0;
      boolean var8 = a(var1, var2);
      PacketContainer var9 = null;
      if (var7 && var8) {
         var9 = this.a(Server.REL_ENTITY_MOVE_LOOK);
         var9.getIntegers().write(0, this.a());
         if (i) {
            var9.getShorts()
               .write(0, (short)((int)((var1.getX() - var2.getX()) * 4096.0)))
               .write(1, (short)((int)((var1.getY() - var2.getY()) * 4096.0)))
               .write(2, (short)((int)((var1.getZ() - var2.getZ()) * 4096.0)));
            var9.getBytes().write(0, this.b(var1.getYaw())).write(1, this.b(var1.getPitch()));
         } else if (l) {
            var9.getIntegers()
               .write(1, (int)((var1.getX() - var2.getX()) * 4096.0))
               .write(2, (int)((var1.getY() - var2.getY()) * 4096.0))
               .write(3, (int)((var1.getZ() - var2.getZ()) * 4096.0));
            var9.getBytes().write(0, this.b(var1.getYaw())).write(1, this.b(var1.getPitch()));
         } else {
            var9.getBytes()
               .write(0, this.a(var1.getX(), var2.getX()))
               .write(1, this.a(var1.getY(), var2.getY()))
               .write(2, this.a(var1.getZ(), var2.getZ()))
               .write(3, this.b(var1.getYaw()))
               .write(4, this.b(var1.getPitch()));
         }
      } else if (var7) {
         var9 = this.a(Server.REL_ENTITY_MOVE);
         var9.getIntegers().write(0, this.a());
         if (i) {
            var9.getShorts()
               .write(0, (short)((int)((var1.getX() - var2.getX()) * 4096.0)))
               .write(1, (short)((int)((var1.getY() - var2.getY()) * 4096.0)))
               .write(2, (short)((int)((var1.getZ() - var2.getZ()) * 4096.0)));
         } else if (l) {
            var9.getIntegers()
               .write(1, (int)((var1.getX() - var2.getX()) * 4096.0))
               .write(2, (int)((var1.getY() - var2.getY()) * 4096.0))
               .write(3, (int)((var1.getZ() - var2.getZ()) * 4096.0));
         } else {
            var9.getBytes().write(0, this.a(var1.getX(), var2.getX())).write(1, this.a(var1.getY(), var2.getY())).write(2, this.a(var1.getZ(), var2.getZ()));
         }
      } else if (var8) {
         var9 = this.a(Server.ENTITY_LOOK);
         var9.getIntegers().write(0, this.a());
         var9.getBytes().write(0, this.b(var1.getYaw())).write(1, this.b(var1.getPitch()));
      }

      if (var9 != null) {
         var9.getBooleans().write(0, var3);
         this.c(var9);
      }

      if (var8) {
         this.a(var1.getYaw());
      }

   }

   private boolean a(Runnable var1) {
      if (Bukkit.isPrimaryThread()) {
         return false;
      } else {
         IntaveScheduler.runTask(var1);
         return true;
      }
   }

   private int a(double var1) {
      return (int)Math.floor(var1 * 32.0);
   }

   private void a(float var1) {
      PacketContainer var2 = this.a(Server.ENTITY_HEAD_ROTATION);
      var2.getIntegers().write(0, this.a());
      var2.getBytes().write(0, this.b(var1));
      this.c(var2);
   }

   private byte b(float var1) {
      return (byte)((int)(var1 * 0.7111111F));
   }

   public void d() {
      if (nK.a(this.f, nK.a)) {
         jI.a(this.e(), this.c());
      }

      PacketContainer var4 = this.a(Server.ENTITY_DESTROY);
      var4.getIntegerArrays().write(0, new int[]{this.a()});
      this.c(var4);
   }

   public double b(Location var1, Location var2) {
      return var1.getWorld() != var2.getWorld() ? 0.0 : var1.distance(var2);
   }
}
