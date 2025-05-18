package de.jpx3.intave.anticheat.packet;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.injector.PacketFilterManager;
import de.jpx3.intave.qd;
import de.jpx3.intave.anticheat.logger.Logger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.bukkit.entity.Player;

public final class ProtocolManager {
   private static final Method receiveMethod;
   private static final PacketFilterManager packetFilterManager = (PacketFilterManager)ProtocolLibrary.getProtocolManager();
   private static final boolean e = Arrays.stream(com.comphenix.protocol.ProtocolManager.class.getDeclaredMethods()).anyMatch(ProtocolManager::checkMethodName);

   public static void sendPacket(Player var0, PacketContainer var1) {
      if (!packetFilterManager.isClosed()) {
         try {
            packetFilterManager.sendServerPacket(var0, var1);
         } catch (InvocationTargetException var6) {
            var6.printStackTrace();
         }
      }

   }

   static {
      Method var11 = null;

      try {
         Method var10000;
         if (e) {
            Class[] var10004 = new Class[]{Player.class, PacketContainer.class};
            var10000 = com.comphenix.protocol.ProtocolManager.class
               .getMethod(qd.b("receiveClientPacket", com.comphenix.protocol.ProtocolManager.class, var10004), var10004);
         } else {
            Class[] var14 = new Class[]{Player.class, PacketContainer.class};
            var10000 = com.comphenix.protocol.ProtocolManager.class
               .getMethod(qd.b("recieveClientPacket", com.comphenix.protocol.ProtocolManager.class, var14), var14);
         }

         var11 = var10000;
      } catch (NoSuchMethodException var13) {
         var13.printStackTrace();
      }

      receiveMethod = var11;
   }

   public static void send(Player var0, PacketContainer var1) {
      if (!packetFilterManager.isClosed()) {
         try {
            packetFilterManager.sendServerPacket(var0, var1, false);
         } catch (InvocationTargetException var6) {
            var6.printStackTrace();
         }
      }

   }

   private static boolean checkMethodName(Method var0) {
      return var0.getName().equalsIgnoreCase("receiveClientPacket");
   }

   public static void receivePacket(Player var0, PacketContainer var1) {
      try {
         receiveMethod.invoke(packetFilterManager, var0, var1);
      } catch (UnsupportedOperationException var5) {
         Logger.getLogger().severe("Your version of ProtocolLib is broken, see https:..github.com.dmulloy2.ProtocolLib.issues.1552 for details on the issue");
         Logger.getLogger().severe("We recommend you upgrade your version");
         var5.printStackTrace();
      } catch (InvocationTargetException | IllegalAccessException var6) {
         var6.printStackTrace();
      }

   }
}
