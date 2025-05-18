package de.jpx3.intave.unknown.handler;

import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.engine.world.IntaveWorld;
import de.jpx3.intave.anticheat.util.HitResult;
import de.jpx3.intave.anticheat.util.nms.WrappedVec3d;
import de.jpx3.intave.anticheat.world.IntaveWorldBlock;
import de.jpx3.intave.unknown.Unknown140;
import de.jpx3.intave.unknown.Unknown213;
import de.jpx3.intave.unknown.Unknown61;
import net.minecraft.server.v1_8_R3.Block;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.Blocks;
import net.minecraft.server.v1_8_R3.EnumDirection;
import net.minecraft.server.v1_8_R3.IBlockData;
import net.minecraft.server.v1_8_R3.MathHelper;
import net.minecraft.server.v1_8_R3.MovingObjectPosition;
import net.minecraft.server.v1_8_R3.Vec3D;
import net.minecraft.server.v1_8_R3.WorldServer;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.Player;

@Unknown61
public final class Handler1 implements Unknown140 {
   @Unknown61
   @Unknown213
   private IBlockData a(Player var1, WorldServer var2, BlockPosition var3) {
      IntaveWorld var4 = PlayerDataManager.getPlayerData(var1).getWorld();
      IntaveWorldBlock var5 = var4.d(var3.getX(), var3.getY(), var3.getZ());
      return var5 != null ? Block.getById(var5.getMaterial().getId()).fromLegacyData(var5.getData()) : var2.getType(var3);
   }

   @Unknown61
   @Override
   public HitResult a(World var1, Player var2, WrappedVec3d var3, WrappedVec3d var4) {
      WorldServer var5 = ((CraftWorld)var1).getHandle();
      Vec3D var6 = (Vec3D)var3.g();
      Vec3D var7 = (Vec3D)var4.g();
      MovingObjectPosition var8 = this.a(var2, var5, var6, var7);
      return HitResult.a(var8);
   }

   @Unknown61
   @Unknown213
   private MovingObjectPosition a(Player var1, WorldServer var2, Vec3D var3, Vec3D var4) {
      WrappedVec3d var5 = WrappedVec3d.a(var3);
      WrappedVec3d var6 = WrappedVec3d.a(var4);
      if (!this.a(var5) && !this.a(var6)) {
         int var8 = MathHelper.floor(var6.x);
         int var9 = MathHelper.floor(var6.y);
         int var10 = MathHelper.floor(var6.z);
         int var11 = MathHelper.floor(var5.x);
         int var12 = MathHelper.floor(var5.y);
         int var13 = MathHelper.floor(var5.z);
         BlockPosition var14 = new BlockPosition(var11, var12, var13);
         IBlockData var15 = this.a(var1, var2, var14);
         Block var16 = var15.getBlock();
         if (var16.a(var15, false)) {
            MovingObjectPosition var7 = (MovingObjectPosition)this.a(var2, var16, var14, (Vec3D)var5.g(), (Vec3D)var6.g());
            if (var7 != null) {
               return var7;
            }
         }

         int var17 = 50;

         while(var17-- >= 0) {
            if (this.a(var5)) {
               return null;
            }

            if (var11 == var8 && var12 == var9 && var13 == var10) {
               return null;
            }

            boolean var19 = true;
            boolean var20 = true;
            boolean var21 = true;
            double var22 = 999.0;
            double var24 = 999.0;
            double var26 = 999.0;
            if (var8 > var11) {
               var22 = (double)var11 + 1.0;
            } else if (var8 < var11) {
               var22 = (double)var11 + 0.0;
            } else {
               var19 = false;
            }

            if (var9 > var12) {
               var24 = (double)var12 + 1.0;
            } else if (var9 < var12) {
               var24 = (double)var12 + 0.0;
            } else {
               var20 = false;
            }

            if (var10 > var13) {
               var26 = (double)var13 + 1.0;
            } else if (var10 < var13) {
               var26 = (double)var13 + 0.0;
            } else {
               var21 = false;
            }

            double var28 = 999.0;
            double var30 = 999.0;
            double var32 = 999.0;
            double var34 = var6.x - var5.x;
            double var36 = var6.y - var5.y;
            double var38 = var6.z - var5.z;
            if (var19) {
               var28 = (var22 - var5.x) / var34;
            }

            if (var20) {
               var30 = (var24 - var5.y) / var36;
            }

            if (var21) {
               var32 = (var26 - var5.z) / var38;
            }

            if (var28 == -0.0) {
               var28 = -1.0E-4;
            }

            if (var30 == -0.0) {
               var30 = -1.0E-4;
            }

            if (var32 == -0.0) {
               var32 = -1.0E-4;
            }

            EnumDirection var18;
            if (var28 < var30 && var28 < var32) {
               var18 = var8 > var11 ? EnumDirection.WEST : EnumDirection.EAST;
               var5 = new WrappedVec3d(var22, var5.y + var36 * var28, var5.z + var38 * var28);
            } else if (var30 < var32) {
               var18 = var9 > var12 ? EnumDirection.DOWN : EnumDirection.UP;
               var5 = new WrappedVec3d(var5.x + var34 * var30, var24, var5.z + var38 * var30);
            } else {
               var18 = var10 > var13 ? EnumDirection.NORTH : EnumDirection.SOUTH;
               var5 = new WrappedVec3d(var5.x + var34 * var32, var5.y + var36 * var32, var26);
            }

            var11 = MathHelper.floor(var5.x) - (var18 == EnumDirection.EAST ? 1 : 0);
            var12 = MathHelper.floor(var5.y) - (var18 == EnumDirection.UP ? 1 : 0);
            var13 = MathHelper.floor(var5.z) - (var18 == EnumDirection.SOUTH ? 1 : 0);
            var14 = new BlockPosition(var11, var12, var13);
            IBlockData var40 = this.a(var1, var2, var14);
            Block var41 = var40.getBlock();
            boolean var42 = var41.a(var40, false);
            if (var42) {
               MovingObjectPosition var43 = (MovingObjectPosition)this.a(var2, var41, var14, (Vec3D)var5.g(), (Vec3D)var6.g());
               if (var43 != null) {
                  return var43;
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private boolean a(WrappedVec3d var1) {
      return Double.isNaN(var1.x) || Double.isNaN(var1.y) || Double.isNaN(var1.z);
   }

   @Unknown61
   @Unknown213
   private Object a(WorldServer var1, Block var2, BlockPosition var3, Vec3D var4, Vec3D var5) {
      try {
         return var2.a(var1, var3, var4, var5);
      } catch (Error | Exception var7) {
         return Blocks.STONE.a(var1, var3, var4, var5);
      }
   }
}
