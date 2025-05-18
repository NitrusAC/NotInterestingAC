package de.jpx3.intave.unknown;

import de.jpx3.intave.kt;
import de.jpx3.intave.anticheat.check.api.Certainty;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerStorage;
import de.jpx3.intave.anticheat.data.holder.VersionHolder;
import de.jpx3.intave.anticheat.engine.impl.BukkitEnginePlayer;
import de.jpx3.intave.anticheat.serializer.ByteSerializer;
import de.jpx3.intave.anticheat.storage.Storable;
import de.jpx3.intave.anticheat.util.ReachUtil;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import de.jpx3.intave.anticheat.util.reach.ReachResult;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import java.util.function.Consumer;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public final class Unknown163 implements Unknown369 {
   private final PlayerData data;
   private ByteSerializer a;

   @Override
   public boolean a(int var1, float var2) {
      Player var6 = this.data.getPlayer();
      PlayerStorage var7 = this.data.getStorage();
      TrackedEntity var8 = var7.c().a(var1);
      BukkitEnginePlayer var9 = var7.getPhysicsHolder();
      VersionHolder var10 = var7.getVersionHolder();
      double var11 = (double)this.a(this.a(GameMode.CREATIVE));
      float var13 = var9.lastYaw % 360.0F;
      float var14 = var9.yaw % 360.0F;
      boolean var15 = var10.getVersionId() == VersionHolder.V_1_8_8;
      boolean var16 = var10.getVersionId() >= 314;
      ReachResult var17 = ReachUtil.getResult(var6, var8, var15, var9.lastX, var9.lastY, var9.lastZ, var14, var9.pitch, (double)var2);
      if (var17.getDistance() > var11) {
         return false;
      } else {
         if (!var16) {
            var17 = ReachUtil.getResult(var6, var8, true, var9.lastX, var9.lastY, var9.lastZ, var13, var9.pitch, (double)var2);
         }

         return var17.getDistance() <= var11;
      }
   }

   @Override
   public float m() {
      return this.data.getStorage().getPhysicsHolder().getPitch();
   }

   @Override
   public void a(String var1, Certainty var2, String var3) {
   }

   @Override
   public double o() {
      return this.data.getStorage().getPhysicsHolder().getX();
   }

   @Override
   public int e() {
      return this.data.getStorage().getVersionHolder().getVersionId();
   }

   @Override
   public ByteSerializer l() {
      return this.a;
   }

   @Override
   public double getZ() {
      return this.data.getStorage().getPhysicsHolder().getZ();
   }

   private float a(boolean var1) {
      return (var1 ? 5.0F : 3.0F) - 0.005F;
   }

   @Override
   public double b() {
      return this.data.getStorage().getPhysicsHolder().getY();
   }

   @Override
   public float n() {
      return this.data.getStorage().getPhysicsHolder().getYaw();
   }

   @Override
   public float c() {
      return this.data.getStorage().getPhysicsHolder().getLastPitch();
   }

   @Override
   public boolean a(GameMode var1) {
      de.jpx3.intave.anticheat.engine.util.GameMode var2 = de.jpx3.intave.anticheat.engine.util.GameMode.fromBukkit(var1);
      return this.data.getStorage().getEntityHolder().isGamemode(var2);
   }

   @Override
   public void a(ByteSerializer var1) {
      this.a = var1;
   }

   @Override
   public void a(Consumer var1) {
      var1.accept(this.data);
   }

   @Override
   public boolean d() {
      return this.data.getStorage().getVersionHolder().isRewindVersion();
   }

   @Override
   public int h() {
      return this.data.getPlayer().getEntityId();
   }

   @Override
   public void a(String var1) {
   }

   @Override
   public kt g() {
      return this.data.getStorage().getPhysicsHolder().getLastRotation();
   }

   public Unknown163(PlayerData var1) {
      this.data = var1;
   }

   @Override
   public Storable a(Class var1) {
      return this.data.getStorage(var1);
   }

   @Override
   public IntaveVector f() {
      return this.data.getStorage().getPhysicsHolder().D();
   }

   @Override
   public boolean a(int var1) {
      return false;
   }

   @Override
   public float i() {
      return this.data.getStorage().getPhysicsHolder().getLastYaw();
   }

   @Override
   public boolean a(long var1) {
      return this.data.getStorage().getPlayerHolder().hasSwitchedTargets(var1);
   }

   @Override
   public void a(Unknown227 var1, String var2) {
      this.data.a(var1, var2);
   }

   @Override
   public kt j() {
      return this.data.getStorage().getPhysicsHolder().getRotation();
   }

   @Override
   public boolean b(long var1) {
      return this.data.getStorage().getPlayerHolder().hasAttacked(var1);
   }
}
