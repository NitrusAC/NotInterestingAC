package de.jpx3.intave.unknown.check;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.MinecraftKey;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import de.jpx3.intave.nu;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.Check;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.packet.ClientPacket;
import de.jpx3.intave.anticheat.packet.PacketListener;
import de.jpx3.intave.anticheat.packet.ProtocolManager;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import de.jpx3.intave.unknown.Unknown203;
import de.jpx3.intave.unknown.unknown79;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class Check7 implements Check {
   private final IntavePlugin b;
   private static final JsonParser a = new JsonParser();

   private static void b(Player var0, PacketContainer var1) {
      ProtocolManager.sendPacket(var0, var1);
   }

   private static void a(Player var0) {
      var0.kickPlayer("Invalid Intave client support payload packet");
   }

   private void a(Player var1, String var2, String var3, String var4, String var5) {
      PacketContainer var9 = ProtocolLibrary.getProtocolManager().createPacket(Server.CUSTOM_PAYLOAD);
      if (MinecraftVersion.V_1_13.atOrAbove()) {
         var9.getMinecraftKeys().write(0, new MinecraftKey(var4, var5));
      } else {
         var9.getStrings().write(0, var4 + ":" + var5);
      }

      try {
         Class var10 = ReflectionUtil.getClazz("PacketDataSerializer");
         Object var11 = var10.getConstructor(ByteBuf.class).newInstance(Unpooled.wrappedBuffer(nu.a(var2, var3)));
         var9.getSpecificModifier(var10).write(0, var11);
         IntaveScheduler.runTask(Check7::b);
      } catch (Exception var12) {
         var12.printStackTrace();
      }

   }

   @PacketListener(
      packetTypes = {ClientPacket.CUSTOM_PAYLOAD}
   )
   public void a(PacketEvent var1) {
      Player var6 = var1.getPlayer();
      PacketContainer var7 = var1.getPacket();
      String var8;
      if (var7.getStrings().getValues().isEmpty()) {
         Object var9 = var7.getMinecraftKeys().getValues().get(0);

         try {
            var8 = (String)var9.getClass().getMethod("toString").invoke(var9);
         } catch (Exception var22) {
            var22.printStackTrace();
            var8 = "error";
         }
      } else {
         var8 = (String)var7.getStrings().getValues().get(0);
      }

      if (var8.startsWith("minecraft:")) {
         var8 = var8.substring(10);
      }

      if (var8.equalsIgnoreCase("intave")) {
         ByteBuf var23 = (ByteBuf)var7.getSpecificModifier(ReflectionUtil.getClazz("PacketDataSerializer")).getValues().get(0);

         try {
            var23.markReaderIndex();
            String var10 = nu.b(var23, 100);
            if (var10.equalsIgnoreCase("clientconfig")) {
               PlayerData var11 = PlayerDataManager.getPlayerData(var6);
               unknown79 var12 = var11.getStorage().c();
               if (System.currentTimeMillis() - var12.A > 4000L) {
                  Logger.getLogger().info(var6.getName() + " has sent a custom client configuration (client has special Intave support)");
                  var12.A = System.currentTimeMillis();
               }

               String var13 = nu.b(var23, 32767);
               JsonElement var14 = a.parse(var13);
               Unknown203 var15 = Unknown203.a(var14);
               var11.a(var15);
               this.a(var6, "clientconfig", "received", "minecraft", "intave");
               this.a(var6, "clientconfig", "received", "intave", "customclient");
            }
         } catch (RuntimeException var20) {
            var20.printStackTrace();
            IntaveScheduler.runTask(Check7::a);
         } finally {
            var23.resetReaderIndex();
         }

      }
   }

   public Check7(IntavePlugin var1) {
      this.b = var1;
   }

   public void a() {
      try {
         Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this.b, "intave:customclient");
         Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this.b, "minecraft:intave");
      } catch (Exception var4) {
      }

      this.b.b().b(this);
   }
}
