package de.jpx3.intave.unknown;

import com.google.common.base.Charsets;
import de.jpx3.intave.anticheat.packet.wrap.AbstractPacketReader;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import io.netty.buffer.ByteBuf;

public final class Unknown209 extends AbstractPacketReader {
   public String a() {
      ByteBuf var3 = (ByteBuf)this.getPacket().getSpecificModifier(ReflectionUtil.getClazz("PacketDataSerializer")).getValues().get(0);

      try {
         var3.markReaderIndex();
         byte var4 = var3.readByte();
         return var3.toString(Charsets.UTF_8);
      } catch (Exception var5) {
         var5.printStackTrace();
         return "";
      }
   }

   public String b() {
      String var4;
      if (this.getPacket().getStrings().getValues().isEmpty()) {
         Object var5 = this.getPacket().getMinecraftKeys().getValues().get(0);

         try {
            var4 = (String)var5.getClass().getMethod("toString").invoke(var5);
         } catch (Exception var7) {
            var7.printStackTrace();
            var4 = "error";
         }
      } else {
         var4 = (String)this.getPacket().getStrings().getValues().get(0);
      }

      if (var4.startsWith("minecraft:")) {
         var4 = var4.substring(10);
      }

      return var4;
   }
}
