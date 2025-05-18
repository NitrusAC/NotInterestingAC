package de.jpx3.intave.anticheat.module.impl;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import de.jpx3.intave.nu;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.module.Module;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import io.netty.buffer.ByteBuf;
import java.util.function.BiConsumer;
import org.bukkit.entity.Player;

public final class CustomPayloadModule implements Module {
   private final String d;
   private static final JsonParser b = new JsonParser();
   private final BiConsumer a;
   private final IntavePlugin c;

   public CustomPayloadModule(IntavePlugin var1, String var2, BiConsumer var3) {
      this.c = var1;
      this.d = var2;
      this.a = var3;
      var1.b().b(this);
   }

   @PacketListener(
      packetTypes = {ClientPacket.CUSTOM_PAYLOAD}
   )
   public void a(PacketEvent var1) {
      Player var5 = var1.getPlayer();
      PacketContainer var6 = var1.getPacket();
      String var7;
      if (var6.getStrings().getValues().isEmpty()) {
         Object var8 = var6.getMinecraftKeys().getValues().get(0);

         try {
            var7 = (String)var8.getClass().getMethod("toString").invoke(var8);
         } catch (Exception var18) {
            var18.printStackTrace();
            var7 = "error";
         }
      } else {
         var7 = (String)var6.getStrings().getValues().get(0);
      }

      if (var7.startsWith("minecraft:")) {
         var7 = var7.substring(10);
      }

      if (var7.equalsIgnoreCase("LMC")) {
         ByteBuf var19 = (ByteBuf)var6.getSpecificModifier(ReflectionUtil.getClazz("PacketDataSerializer")).getValues().get(0);

         try {
            var19.markReaderIndex();
            String var9 = nu.b(var19, 32767);
            if (var9.equalsIgnoreCase(this.d)) {
               String var10 = nu.b(var19, 32767);
               JsonElement var11 = b.parse(var10);
               this.a.accept(var5, var11);
            }
         } catch (Exception var16) {
            var16.printStackTrace();
         } finally {
            var19.resetReaderIndex();
         }

      }
   }
}
