package de.jpx3.intave.anticheat.util;

import de.jpx3.intave.qd;
import de.jpx3.intave.anticheat.util.nms.BlockPos;
import de.jpx3.intave.anticheat.util.nms.HitResult$HitType;
import de.jpx3.intave.anticheat.util.nms.WrappedVec3d;
import de.jpx3.intave.unknown.Unknown182;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;

public class HitResult {
   public Direction direction;
   public Entity entity;
   private static final boolean isV_14 = MinecraftVersion.V_1_14.atOrAbove();
   public HitResult$HitType type;
   public WrappedVec3d pos;
   private BlockPos blockpos;

   public static HitResult a(Object var0) {
      if (var0 == null) {
         return null;
      } else {
         return isV_14 ? b(var0) : c(var0);
      }
   }

   private static HitResult c(Object var0) {
      try {
         Class var4 = ReflectionUtil.getClazz("MovingObjectPosition");
         String var10003 = qd.c(var4, "e");
         String var10002 = "e";
         Field var5 = var4.getDeclaredField(var10003);
         checkField(var5);
         Object var6 = var5.get(var0);
         var10003 = qd.c(var4, "type");
         var10002 = "type";
         Object var7 = var4.getField(var10003).get(var0);
         var10003 = qd.c(var4, "direction");
         var10002 = "direction";
         Object var8 = var4.getField(var10003).get(var0);
         var10003 = qd.c(var4, "pos");
         var10002 = "pos";
         Object var9 = var4.getField(var10003).get(var0);
         var10003 = qd.c(var4, "entity");
         var10002 = "entity";
         Object var10 = var4.getField(var10003).get(var0);
         WrappedVec3d var11 = Unknown182.b(var9);
         if (var10 == null) {
            BlockPos var18 = Unknown182.a(var6);
            String var13 = (String)Enum.class.getMethod("name").invoke(var7);
            HitResult$HitType var14 = HitResult$HitType.valueOf(var13);
            String var15 = (String)Enum.class.getMethod("name").invoke(var8);
            Direction var16 = Direction.valueOf(var15);
            return new HitResult(var14, var11, var16, var18);
         } else {
            Class var10000 = var10.getClass();
            Class[] var27 = new Class[0];
            Entity var12 = getEntityFromId(var10000.getMethod(qd.b("getId", var10000, var27), var27).invoke(var10));
            return new HitResult(var12, var11);
         }
      } catch (Exception var17) {
         throw new IllegalStateException(var17);
      }
   }

   public String toString() {
      return "HitResult{type=" + this.type + ", blockpos=" + this.blockpos + ", f=" + this.direction + ", pos=" + this.pos + ", entity=" + this.entity + '}';
   }

   public HitResult(WrappedVec3d vec, Direction direction) {
      this(HitResult$HitType.MISS, vec, direction, BlockPos.NULL_BLOCKPOS);
   }

   private static Entity getEntityFromId(int id) {
      for(World var5 : Bukkit.getWorlds()) {
         for(Entity var7 : var5.getEntities()) {
            if (var7.getEntityId() == id) {
               return var7;
            }
         }
      }

      return null;
   }

   public HitResult(Entity entity) {
      this(entity, new WrappedVec3d(entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getZ()));
   }

   public static HitResult ofNull() {
      return null;
   }

   public HitResult(HitResult$HitType type, WrappedVec3d vec, Direction direction, BlockPos blockpos) {
      this.type = type;
      this.blockpos = blockpos;
      this.direction = direction;
      this.pos = new WrappedVec3d(vec.x, vec.y, vec.z);
   }

   public HitResult(Entity entity, WrappedVec3d pos) {
      this.type = HitResult$HitType.ENTITY;
      this.entity = entity;
      this.pos = pos;
   }

   public BlockPos getBlockPos() {
      return this.blockpos;
   }

   private static HitResult b(Object var0) {
      try {
         Class var4 = ReflectionUtil.getClazz("MovingObjectPositionEntity");
         Class var5 = ReflectionUtil.getClazz("MovingObjectPositionBlock");
         Class var6 = ReflectionUtil.getClazz("MovingObjectPosition$EnumMovingObjectType");
         Method var7 = ReflectionUtil.getMethod("MovingObjectPosition", "getType", var6);
         String var8 = (String)Enum.class.getMethod("name").invoke(var7.invoke(var0));
         HitResult$HitType var9 = HitResult$HitType.valueOf(var8);
         if (var9 == HitResult$HitType.ENTITY) {
            String var27 = qd.c(var4, "entity");
            String var24 = "entity";
            Field var21 = var4.getDeclaredField(var27);
            if (!var21.isAccessible()) {
               var21.setAccessible(true);
            }

            Object var22 = var21.get(var0);
            Class var25 = var22.getClass();
            Class[] var10005 = new Class[0];
            return new HitResult(getEntityFromId(var25.getMethod(qd.b("getId", var25, var10005), var10005).invoke(var22)));
         } else {
            Field var10 = ReflectionUtil.getField("MovingObjectPosition", "pos");
            if (!var10.isAccessible()) {
               var10.setAccessible(true);
            }

            Object var11 = var10.get(var0);
            WrappedVec3d var12 = Unknown182.b(var11);
            String var10003 = qd.c(var5, "b");
            String var10002 = "b";
            Field var13 = var5.getDeclaredField(var10003);
            if (!var13.isAccessible()) {
               var13.setAccessible(true);
            }

            Object var14 = var13.get(var0);
            String var15 = (String)Enum.class.getMethod("name").invoke(var14);
            Direction var16 = Direction.valueOf(var15);
            var10003 = qd.c(var5, "c");
            var10002 = "c";
            Field var17 = var5.getDeclaredField(var10003);
            if (!var17.isAccessible()) {
               var17.setAccessible(true);
            }

            Object var18 = var17.get(var0);
            BlockPos var19 = Unknown182.a(var18);
            return new HitResult(var9, var12, var16, var19);
         }
      } catch (Exception var20) {
         throw new IllegalStateException(var20);
      }
   }

   private static void checkField(Field field) {
      if (!field.isAccessible()) {
         field.setAccessible(true);
      }

   }

   public HitResult(WrappedVec3d vec, Direction direction, BlockPos blockPos) {
      this(HitResult$HitType.MISS, vec, direction, blockPos);
   }
}
