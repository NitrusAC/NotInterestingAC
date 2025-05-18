package de.jpx3.intave.anticheat.util.entity;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import de.jpx3.intave.anticheat.engine.util.AccurateMathUtil;
import de.jpx3.intave.anticheat.util.MathUtil;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.collision.Box;
import de.jpx3.intave.anticheat.util.reach.DestroyedReachEntity;
import de.jpx3.intave.anticheat.util.reach.ReachEntityType;
import de.jpx3.intave.anticheat.util.reach.ReachPosition;
import de.jpx3.intave.anticheat.util.vector.IntaveVector;
import de.jpx3.intave.unknown.Unknown340;
import de.jpx3.intave.unknown.Unknown67;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class TrackedEntity {
   private static TrackedEntity s;
   public boolean f;
   public final IntaveVector trackedEntity;
   public boolean A;
   public long motionZ;
   public ReachPosition lastPosition;
   public final boolean g;
   public long serverX;
   private final int entityId;
   private ReachEntityType B;
   public List potentials;
   private int m;
   public int w;
   public long motionX;
   private static final boolean isAbove1_14 = MinecraftVersion.V_1_14.atOrAbove();
   private static final boolean isAbove1_9 = MinecraftVersion.V_1_9.atOrAbove();
   public ReachPosition position;
   private boolean E;
   public boolean y = true;
   public ReachPosition nextPosition;
   public float D;
   public double z;
   private boolean verifying;
   public boolean h;
   public boolean o;
   private final Unknown67 x;
   private Box boundingBox;
   public long motionY;
   private TrackedEntity parent;
   public long serverY;
   public long serverZ;

   public boolean u() {
      return this.E;
   }

   private void h() {
      if ((double)this.D <= 0.0) {
         this.m();
      }

   }

   public boolean q() {
      return this.B != null;
   }

   private synchronized void clearPotentials() {
      if (!this.verifying) {
         if (this.potentials.size() > 25) {
            this.potentials.remove(0);
         }

         this.potentials.add(this.position.copy());
      }

   }

   public void clearParent() {
      this.parent = null;
   }

   public ReachEntityType r() {
      return this.B;
   }

   public static TrackedEntity l() {
      return s;
   }

   public static void f() {
      s = new DestroyedReachEntity();
   }

   public TrackedEntity copy() {
      TrackedEntity var1 = new TrackedEntity(this.entityId, this.r(), this.g);
      var1.verifying = true;
      var1.position = this.position.copy();
      var1.nextPosition = this.nextPosition.copy();
      var1.potentials = new ArrayList(this.potentials);
      return var1;
   }

   public void a(ReachEntityType var1) {
      this.B = var1;
   }

   public void setPosition(double x, double y, double z) {
      this.clearPotentials();
      this.lastPosition.posX = this.position.posX;
      this.lastPosition.posY = this.position.posY;
      this.lastPosition.posZ = this.position.posZ;
      this.position.posX = x;
      this.position.posY = y;
      this.position.posZ = z;
      this.boundingBox = null;
   }

   public void setParent(TrackedEntity parent) {
      this.parent = parent;
   }

   public void update(double var1) {
      if (!this.r().e()) {
         this.setNextY(var1);
      } else {
         this.nextPosition.otherPlayerMPY = var1;
      }
   }

   public long b() {
      return this.x.a();
   }

   public void n() {
   }

   public void d(PacketContainer var1) {
      double var6;
      double var8;
      double var10;
      if (isAbove1_14) {
         StructureModifier var12 = var1.getShorts();
         this.motionX += (long)((Short)var12.readSafely(0)).shortValue();
         this.motionY += (long)((Short)var12.readSafely(1)).shortValue();
         this.motionZ += (long)((Short)var12.readSafely(2)).shortValue();
         var6 = (double)this.motionX / 4096.0;
         var8 = (double)this.motionY / 4096.0;
         var10 = (double)this.motionZ / 4096.0;
      } else if (isAbove1_9) {
         StructureModifier var13 = var1.getIntegers();
         this.motionX += (long)((Integer)var13.readSafely(1)).intValue();
         this.motionY += (long)((Integer)var13.readSafely(2)).intValue();
         this.motionZ += (long)((Integer)var13.readSafely(3)).intValue();
         var6 = (double)this.motionX / 4096.0;
         var8 = (double)this.motionY / 4096.0;
         var10 = (double)this.motionZ / 4096.0;
      } else {
         StructureModifier var14 = var1.getBytes();
         this.motionX += (long)((Byte)var14.readSafely(0)).byteValue();
         this.motionY += (long)((Byte)var14.readSafely(1)).byteValue();
         this.motionZ += (long)((Byte)var14.readSafely(2)).byteValue();
         var6 = (double)this.motionX / 32.0;
         var8 = (double)this.motionY / 32.0;
         var10 = (double)this.motionZ / 32.0;
      }

      this.trackedEntity.setX(var6);
      this.trackedEntity.setY(var8);
      this.trackedEntity.setZ(var10);
   }

   public double a(double var1, double var3, double var5) {
      double var7 = Math.abs(var1 - this.position.posX);
      double var9 = Math.abs(var3 - this.position.posY);
      double var11 = Math.abs(var5 - this.position.posZ);
      return Math.sqrt(var7 * var7 + var9 * var9 + var11 * var11);
   }

   public boolean a() {
      return !this.o && this.D > 0.0F;
   }

   public double o() {
      return this.a(this.trackedEntity.getX(), this.trackedEntity.getY(), this.trackedEntity.getZ());
   }

   public boolean isDesyncOffsetLargerThan(double offset) {
      ReachPosition var6 = this.position;
      return AccurateMathUtil.deltaXZ(var6.otherPlayerMPX - var6.posX, var6.otherPlayerMPZ - var6.posZ) >= offset;
   }

   private void m() {
      ++this.m;
      if (this.m == 20) {
         this.o = true;
      }

   }

   public void a(double x, double y, double z, double motionY) {
      this.position.z = this.position.posX = x;
      this.position.y = this.position.posY = y;
      this.nextPosition.y = this.nextPosition.posY = motionY;
      this.position.x = this.position.posZ = z;
      this.setPosition(this.position.posX, this.position.posY, this.position.posZ);
      this.setNextY(this.nextPosition.posY);
   }

   public Unknown340 d() {
      return this.x;
   }

   public static Box getBoundingBox(ReachPosition entityPosition, TrackedEntity entity) {
      double var2 = entityPosition.posX;
      double var4 = entityPosition.posY;
      double var6 = entityPosition.posZ;
      double var8 = (double)entity.r().getHitboxSize().getWidth() / 2.0;
      double var10 = (double)entity.r().getHitboxSize().getHeight();
      return new Box(var2 - var8, var4, var6 - var8, var2 + var8, var4 + var10, var6 + var8);
   }

   public void setPositionAndTick(double x, double y, double z, int ticks) {
      if (!this.r().e()) {
         this.setPosition(x, y, z);
      } else {
         this.position.otherPlayerMPX = x;
         this.position.otherPlayerMPY = y;
         this.position.otherPlayerMPZ = z;
         this.clearPotentials();
         this.position.ticks = ticks;
      }
   }

   public void a(boolean var1) {
      this.E = var1;
   }

   public void setNextY(double y) {
      this.nextPosition.posY = y;
   }

   public void handleEntityTeleport(PacketContainer var1) {
      double var5;
      double var7;
      double var9;
      double var11;
      if (isAbove1_14) {
         StructureModifier var13 = var1.getShorts();
         this.serverX += (long)((Short)var13.readSafely(0)).shortValue();
         this.serverY += (long)((Short)var13.readSafely(1)).shortValue();
         this.serverZ += (long)((Short)var13.readSafely(2)).shortValue();
         var5 = (double)this.serverX / 4096.0;
         var7 = (double)this.serverY / 4096.0;
         var9 = var7;
         var11 = (double)this.serverZ / 4096.0;
      } else if (isAbove1_9) {
         StructureModifier var14 = var1.getIntegers();
         this.serverX += (long)((Integer)var14.readSafely(1)).intValue();
         this.serverY += (long)((Integer)var14.readSafely(2)).intValue();
         this.serverZ += (long)((Integer)var14.readSafely(3)).intValue();
         var5 = (double)this.serverX / 4096.0;
         var7 = (double)this.serverY / 4096.0;
         var9 = var7;
         var11 = (double)this.serverZ / 4096.0;
      } else {
         StructureModifier var15 = var1.getBytes();
         this.serverX += (long)((Byte)var15.readSafely(0)).byteValue();
         this.serverY += (long)((Byte)var15.readSafely(1)).byteValue();
         this.serverZ += (long)((Byte)var15.readSafely(2)).byteValue();
         var5 = (double)this.serverX / 32.0;
         var7 = (double)this.serverY / 32.0;
         var9 = (double)this.serverY / 32.0;
         var11 = (double)this.serverZ / 32.0;
      }

      this.setPositionAndTick(var5, var7, var11, 3);
      this.update(var9);
   }

   public String t() {
      return this.r().getEntityType();
   }

   public int i() {
      return this.entityId;
   }

   public void a(PacketContainer var1) {
      double var5;
      double var7;
      double var9;
      if (isAbove1_9) {
         var5 = var1.getDoubles().read(0);
         var7 = var1.getDoubles().read(1);
         var9 = var1.getDoubles().read(2);
         this.motionX = MathUtil.e(var5);
         this.motionY = MathUtil.e(var7);
         this.motionZ = MathUtil.e(var9);
      } else {
         this.motionX = (long)((Integer)var1.getIntegers().read(1)).intValue();
         this.motionY = (long)((Integer)var1.getIntegers().read(2)).intValue();
         this.motionZ = (long)((Integer)var1.getIntegers().read(3)).intValue();
         var5 = (double)this.motionX / 32.0;
         var7 = (double)this.motionY / 32.0;
         var9 = (double)this.motionZ / 32.0;
      }

      if (!(Math.abs(this.trackedEntity.getX() - var5) < 0.03125)
         || !(Math.abs(this.trackedEntity.getY() - var7) < 0.015625)
         || !(Math.abs(this.trackedEntity.getZ() - var9) < 0.03125)) {
         this.trackedEntity.setX(var5);
         this.trackedEntity.setY(var7);
         this.trackedEntity.setZ(var9);
      }
   }

   public void update() {
      ++this.w;
      this.h();
      this.v();
   }

   public void handleEntityMove(PacketContainer var1) {
      double var5;
      double var7;
      double var9;
      if (isAbove1_9) {
         var5 = var1.getDoubles().read(0);
         var7 = var1.getDoubles().read(1);
         var9 = var1.getDoubles().read(2);
         this.serverX = MathUtil.e(var5);
         this.serverY = MathUtil.e(var7);
         this.serverZ = MathUtil.e(var9);
      } else {
         this.serverX = (long)((Integer)var1.getIntegers().read(1)).intValue();
         this.serverY = (long)((Integer)var1.getIntegers().read(2)).intValue();
         this.serverZ = (long)((Integer)var1.getIntegers().read(3)).intValue();
         var5 = (double)this.serverX / 32.0;
         var7 = (double)this.serverY / 32.0;
         var9 = (double)this.serverZ / 32.0;
      }

      if (Math.abs(this.position.posX - var5) < 0.03125 && Math.abs(this.position.posY - var7) < 0.015625 && Math.abs(this.position.posZ - var9) < 0.03125) {
         this.setPositionAndTick(this.position.posX, this.position.posY, this.position.posZ, 3);
      } else {
         this.setPositionAndTick(var5, var7, var9, 3);
      }

      double var11 = (double)this.serverY / 32.0 + 0.015625;
      if (Math.abs(this.position.posX - var5) < 0.03125 && Math.abs(this.nextPosition.posY - var11) < 0.015625 && Math.abs(this.position.posZ - var9) < 0.03125
         )
       {
         this.update(this.nextPosition.posY);
      } else {
         this.update(var11);
      }

   }

   public Box getBoundingBox() {
      if (this.boundingBox != null) {
         return this.boundingBox;
      } else {
         this.boundingBox = getBoundingBox(this.position, this);
         return this.boundingBox;
      }
   }

   public TrackedEntity(int entityId, @NotNull ReachEntityType var2, boolean var3) {
      this.A = false;
      this.trackedEntity = new IntaveVector();
      this.potentials = new CopyOnWriteArrayList();
      this.g = var3;
      this.entityId = entityId;
      this.B = var2;
      this.position = new ReachPosition();
      this.lastPosition = new ReachPosition();
      this.nextPosition = new ReachPosition();
      this.x = new Unknown67();
   }

   public TrackedEntity getParent() {
      return this.parent;
   }

   void v() {
      if (this.r().e() && this.position.ticks > 0) {
         double var4 = this.position.posX + (this.position.otherPlayerMPX - this.position.posX) / (double)this.position.ticks;
         double var6 = this.position.posY + (this.position.otherPlayerMPY - this.position.posY) / (double)this.position.ticks;
         double var8 = this.nextPosition.posY + (this.nextPosition.otherPlayerMPY - this.nextPosition.posY) / (double)this.position.ticks;
         double var10 = this.position.posZ + (this.position.otherPlayerMPZ - this.position.posZ) / (double)this.position.ticks;
         --this.position.ticks;
         this.setPosition(var4, var6, var10);
         this.setNextY(var8);
      }

   }

   public double a(Vector var1) {
      return this.a(var1.getX(), var1.getY(), var1.getZ());
   }
}
