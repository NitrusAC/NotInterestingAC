package de.jpx3.intave.unknown;

import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.MultiBlockChangeInfo;
import com.comphenix.protocol.wrappers.WrappedBlockData;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import java.util.ArrayList;
import java.util.List;

public final class Unknown212 extends Unknown219 implements Unknown398 {
   private List d;
   private List a;
   private static final boolean e = MinecraftVersion.V_1_16_2.atOrAbove();

   @Override
   public List a() {
      return this.d;
   }

   @Override
   public void b() {
      if (e) {
         BlockPosition var4 = (BlockPosition)this.getPacket().getSectionPositions().readSafely(0);
         int var5 = var4.getX() << 4;
         int var6 = var4.getY() << 4;
         int var7 = var4.getZ() << 4;
         short[] var8 = (short[])this.getPacket().getShortArrays().read(0);
         WrappedBlockData[] var9 = (WrappedBlockData[])this.getPacket().getBlockDataArrays().read(0);
         int var10 = var9.length;
         this.d = new ArrayList(var10);
         this.a = new ArrayList(var10);

         for(int var11 = 0; var11 < var8.length; ++var11) {
            short var12 = var8[var11];
            int var13 = var5 + (var12 >>> 8 & 15);
            int var14 = var6 + (var12 & 15);
            int var15 = var7 + (var12 >>> 4 & 15);
            this.d.add(new BlockPosition(var13, var14, var15));
            this.a.add(var9[var11]);
         }
      } else {
         MultiBlockChangeInfo[] var16 = (MultiBlockChangeInfo[])this.getPacket().getMultiBlockChangeInfoArrays().readSafely(0);
         int var17 = var16.length;
         this.d = new ArrayList(var17);
         this.a = new ArrayList(var17);

         for(MultiBlockChangeInfo var21 : var16) {
            this.d.add(new BlockPosition(var21.getAbsoluteX(), var21.getY(), var21.getAbsoluteZ()));
            this.a.add(var21.getData());
         }
      }

   }

   @Override
   public void reset() {
      super.reset();
      this.d = null;
      this.a = null;
   }

   @Override
   public List b() {
      return this.a;
   }
}
