package de.jpx3.intave.unknown;

import com.google.common.collect.Maps;
import de.jpx3.intave.anticheat.util.PluginInvocationInfo;
import java.util.Map;
import org.bukkit.plugin.java.JavaPlugin;

@Deprecated
public final class Unknown356 {
   private static final String b;
   private static final Map a = Maps.newHashMap();

   private static String a(String var0) {
      return (String)a.computeIfAbsent(var0, Unknown356::b);
   }

   @Deprecated
   public static PluginInvocationInfo a() {
      StackTraceElement[] var3 = Thread.currentThread().getStackTrace();
      int var4 = 0;

      for(StackTraceElement var8 : var3) {
         String var9 = var8.getClassName();
         String var10 = var8.getMethodName();
         String var11 = a(var9);
         if (!var11.equalsIgnoreCase("null") && var4++ > 1) {
            return new PluginInvocationInfo(var11, var9, var10);
         }
      }

      return null;
   }

   private static String b(String var0) {
      try {
         Class var3 = Class.forName(var0);
         JavaPlugin var4 = JavaPlugin.getProvidingPlugin(var3);
         return var4.getName();
      } catch (IllegalArgumentException | IllegalStateException | ClassNotFoundException var5) {
         return "null";
      }
   }

   private Unknown356() {
      throw new SecurityException("Can not instantiate utility class");
   }
}
