package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.packet.wrap.AbstractPacketReader;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import java.util.List;
import java.util.function.Consumer;

public final class Unknown221 extends AbstractPacketReader {
   private final boolean a;
   private final boolean d;
   private final boolean e = MinecraftVersion.V_1_17_1.atOrAbove();

   public void a(Consumer var1) {
      if (this.e) {
         List var5 = (List)this.getPacket().getIntLists().read(0);
         var5.forEach(var1);
      } else if (this.a) {
         int[] var10 = (int[])this.getPacket().getIntegerArrays().read(0);

         for(int var9 : var10) {
            var1.accept(var9);
         }
      } else {
         var1.accept(this.getPacket().getIntegers().read(0));
      }

   }

   public Unknown221() {
      this.d = !this.e && MinecraftVersion.V_1_17.atOrAbove();
      this.a = !this.d;
   }
}
