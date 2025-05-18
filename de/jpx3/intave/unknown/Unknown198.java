package de.jpx3.intave.unknown;

import com.comphenix.protocol.events.PacketContainer;
import de.jpx3.intave.anticheat.packet.wrap.EntityPacketReader;
import de.jpx3.intave.anticheat.util.MinecraftVersion;

public final class Unknown198 extends EntityPacketReader {
   private static final boolean a = MinecraftVersion.V_1_18_2.atOrAbove();

   public int b() {
      PacketContainer var4 = this.getPacket();
      if (a) {
         Integer var6 = (Integer)var4.getIntegers().readSafely(1);
         if (var6 == null) {
            var6 = 0;
         }

         return var6;
      } else {
         Byte var5 = (Byte)var4.getBytes().readSafely(0);
         if (var5 == null) {
            var5 = (byte)0;
         }

         return var5;
      }
   }

   public int d() {
      PacketContainer var4 = this.getPacket();
      Byte var5 = (Byte)var4.getBytes().readSafely(a ? 0 : 1);
      if (var5 == null) {
         var5 = (byte)0;
      }

      return var5;
   }

   public int c() {
      Integer var4 = (Integer)this.getPacket().getIntegers().readSafely(a ? 2 : 1);
      if (var4 == null) {
         var4 = 0;
      }

      return var4;
   }
}
