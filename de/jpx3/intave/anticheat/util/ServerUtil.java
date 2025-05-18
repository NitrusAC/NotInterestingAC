package de.jpx3.intave.anticheat.util;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import de.jpx3.intave.qd;
import de.jpx3.intave.access.InvalidDependencyException;
import de.jpx3.intave.anticheat.logger.Logger;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.bukkit.Bukkit;

public final class ServerUtil {
   public static void initProtocolLib() {
      boolean var4 = Arrays.stream(PacketEvent.class.getMethods()).anyMatch(ServerUtil::isMethodPlayerTemporary);
      boolean var5 = Arrays.stream(EnumWrappers.class.getMethods()).anyMatch(ServerUtil::isMethodGenericConverter);
      if (!var5) {
         throw new InvalidDependencyException("Your version of ProtocolLib is outdated (missing generic enum conversion)");
      } else if (!methodExists(com.comphenix.protocol.utility.MinecraftVersion.class.getName(), "atOrAbove")) {
         throw new InvalidDependencyException("Your version of ProtocolLib is outdated (atOrAbove check missing)");
      } else if (!methodExistsHierarchy(PacketContainer.class.getName(), "getMinecraftKeys")) {
         throw new InvalidDependencyException("Your version of ProtocolLib is outdated (missing minecraft key access)");
      } else if (MinecraftVersion.V_1_14.atOrAbove() && !methodExistsHierarchy("com.comphenix.protocol.events.PacketContainer", "getMovingBlockPositions")) {
         throw new InvalidDependencyException("Your version of ProtocolLib is outdated (missing moving-object-position packet access)");
      } else {
         if (MinecraftVersion.V_1_17.atOrAbove()) {
            if (!methodExistsHierarchy(PacketContainer.class.getName(), "getEnumEntityUseActions")) {
               throw new InvalidDependencyException("Your version of ProtocolLib is outdated (missing enum entity use action access)");
            }

            if (MinecraftVersion.V_1_17_1.atOrAbove() && !methodExistsHierarchy(PacketContainer.class.getName(), "getIntLists")) {
               throw new InvalidDependencyException("Your version of ProtocolLib is outdated (missing int list access)");
            }
         }

         if (!var4) {
            Logger.getLogger().info("Consider updating ProtocolLib");
         }

      }
   }

   private static boolean isMethodPlayerTemporary(Method var0) {
      return var0.getName().equalsIgnoreCase("isPlayerTemporary");
   }

   @Deprecated
   public static com.comphenix.protocol.utility.MinecraftVersion getServerVersion() {
      return com.comphenix.protocol.utility.MinecraftVersion.getCurrentVersion();
   }

   private static boolean methodExists(String className, String methodName) {
      try {
         Class var10000 = Class.forName(qd.a(className));
         Class[] var10003 = new Class[0];
         var10000.getDeclaredMethod(qd.b(methodName, var10000, var10003), var10003);
         return true;
      } catch (Exception var3) {
         return false;
      }
   }

   private static boolean methodExistsHierarchy(String className, String methodName) {
      try {
         Class var5 = Class.forName(qd.a(className));

         while(!methodExists(var5.getName(), methodName)) {
            if ((var5 = var5.getSuperclass()) == Object.class) {
               return false;
            }
         }

         return true;
      } catch (ClassNotFoundException var6) {
         return false;
      }
   }

   private static boolean isMethodGenericConverter(Method var0) {
      return var0.getName().equalsIgnoreCase("getGenericConverter") && var0.getParameterCount() == 2;
   }

   public static boolean isProtocolLibLoaded() {
      return Bukkit.getPluginManager().getPlugin("ProtocolLib") != null;
   }
}
