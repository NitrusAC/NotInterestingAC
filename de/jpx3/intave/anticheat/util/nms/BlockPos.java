package de.jpx3.intave.anticheat.util.nms;

import de.jpx3.intave.anticheat.util.MathUtil;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public final class BlockPos extends WrappedVec3d {
   private static final int k = BlockPos.i;
   private static final long m = (1L << BlockPos.j) - 1L;
   private static final long h = (1L << BlockPos.i) - 1L;
   private static final int l = BlockPos.g + BlockPos.j;
   private static final int g = k;
   public static final BlockPos NULL_BLOCKPOS = new BlockPos(0, 0, 0);
   private static final int j = 64 - BlockPos.i - k;
   private static final long n = (1L << k) - 1L;
   private static final int i = 1 + MathUtil.d(MathUtil.e(30000000));

   public BlockPos(Entity entity) {
      this(entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getZ());
   }

   public BlockPos b(int var1) {
      return this.a(de.jpx3.intave.anticheat.util.Direction.d, var1);
   }

   public BlockPos a(de.jpx3.intave.anticheat.util.Direction var1) {
      return this.b(var1, 1);
   }

   public BlockPos b(de.jpx3.intave.anticheat.util.Direction var1) {
      return this.a(var1, 1);
   }

   public BlockPos e(int var1) {
      return this.a(de.jpx3.intave.anticheat.util.Direction.b, var1);
   }

   public BlockPos d() {
      return this.d(1);
   }

   public BlockPos c(WrappedVec3d var1) {
      return this.b(var1) ? this : new BlockPos(this.x - var1.x, this.y - var1.y, this.z - var1.z);
   }

   public BlockPos a(WrappedVec3d var1) {
      return new BlockPos(this.y * var1.z - this.z * var1.y, this.z * var1.x - this.x * var1.z, this.x * var1.y - this.y * var1.x);
   }

   public BlockPos b(de.jpx3.intave.anticheat.util.Direction direction, int factor) {
      return new BlockPos(this.x + (double)(direction.e() * factor), this.y + (double)(direction.s() * factor), this.z + (double)(direction.c() * factor));
   }

   public BlockPos g() {
      return this.f(1);
   }

   public BlockPos(double var1, double var3, double var5) {
      super(var1, var3, var5);
   }

   @Override
   public WrappedVec3d c(WrappedVec3d var1) {
      return this.c(var1);
   }

   private boolean b(WrappedVec3d var1) {
      return var1.x == 0.0 && var1.y == 0.0 && var1.z == 0.0;
   }

   public BlockPos a(int var1, int var2, int var3) {
      return var1 == 0 && var2 == 0 && var3 == 0 ? this : new BlockPos(this.x + (double)var1, this.y + (double)var2, this.z + (double)var3);
   }

   public BlockPos c(int var1) {
      return this.a(de.jpx3.intave.anticheat.util.Direction.f, var1);
   }

   public BlockPos(int var1, int var2, int var3) {
      super((double)var1, (double)var2, (double)var3);
   }

   @Override
   public WrappedVec3d b(WrappedVec3d var1) {
      return this.d(var1);
   }

   @Override
   public WrappedVec3d f(WrappedVec3d var1) {
      return this.a(var1);
   }

   public BlockPos e() {
      return this.a(1);
   }

   public BlockPos b() {
      return this.c(1);
   }

   public BlockPos d(WrappedVec3d vec) {
      return this.b(vec) ? this : new BlockPos(this.x + vec.x, this.y + vec.y, this.z + vec.z);
   }

   public BlockPos a() {
      return this.e(1);
   }

   public BlockPos f(int var1) {
      return this.a(de.jpx3.intave.anticheat.util.Direction.a, var1);
   }

   public BlockPos a(int var1) {
      return this.a(de.jpx3.intave.anticheat.util.Direction.c, var1);
   }

   public BlockPos f() {
      return this.b(1);
   }

   public BlockPos a(double x, double y, double z) {
      return x == 0.0 && y == 0.0 && z == 0.0 ? this : new BlockPos(this.x + x, this.y + y, this.z + z);
   }

   public BlockPos(Location location) {
      this(location.getX(), location.getY(), location.getZ());
   }

   public BlockPos d(int var1) {
      return this.a(de.jpx3.intave.anticheat.util.Direction.e, var1);
   }

   public BlockPos a(de.jpx3.intave.anticheat.util.Direction var1, int var2) {
      return var2 == 0 ? this : new BlockPos(this.x + (double)(var1.a() * var2), this.y + (double)(var1.r() * var2), this.z + (double)(var1.q() * var2));
   }

   @Override
   public WrappedVec3d a(double var1, double var3, double var5) {
      return this.a(var1, var3, var5);
   }

   public static BlockPos fromLong(long compressed) {
      int var2 = (int)(compressed << 64 - l - i >> 64 - i);
      int var3 = (int)(compressed << 64 - g - j >> 64 - j);
      int var4 = (int)(compressed << 64 - k >> 64 - k);
      return new BlockPos(var2, var3, var4);
   }

   public BlockPos(WrappedVec3d vec) {
      this(vec.x, vec.y, vec.z);
   }

   public long c() {
      return ((long)this.x & h) << l | ((long)this.y & m) << g | (long)this.z & n;
   }
}
