package de.jpx3.intave.anticheat.threading;

import de.jpx3.intave.qd;
import de.jpx3.intave.access.UnsupportedFallbackOperationException;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import de.jpx3.intave.unknown.what.What1;
import java.lang.reflect.InvocationTargetException;
import java.util.Queue;
import java.util.concurrent.Executor;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;

public final class IntaveScheduler {
   private static final BukkitScheduler d = Bukkit.getScheduler();
   private static Executor c;

   public static void runTask(Runnable runnable) {
      runnable = e(runnable);
      c.execute(runnable);
   }

   private static Runnable e(Runnable var0) {
      return IntaveScheduler::b;
   }

   public static void a(Runnable var0, int var1) {
      var0 = e(var0);
      d.runTaskLater(IntavePlugin.getInstance(), var0, (long)var1);
   }

   private static void c(Runnable var0) {
      d.runTask(IntavePlugin.getInstance(), var0);
   }

   private static void b(Runnable var0) {
      try {
         What1.i.h();
         var0.run();
      } catch (IllegalArgumentException | UnsupportedFallbackOperationException var8) {
         Logger.getLogger().info("Task " + var0 + " failed because the associated player logged off already");
      } catch (Error | Exception var9) {
         Logger.getLogger().severe("Failed to execute server task " + var0);
         var9.printStackTrace();
      } finally {
         What1.i.g();
      }

   }

   public static void a() {
      try {
         Class var2 = ReflectionUtil.getClazz("MinecraftServer");
         Class[] var10004 = new Class[0];
         Object var3 = var2.getMethod(qd.b("getServer", var2, var10004), var10004).invoke(null);
         String var10003 = qd.c(var2, "processQueue");
         String var10002 = "processQueue";
         Queue var4 = (Queue)var2.getField(var10003).get(var3);
         c = var4::add;
      } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException var5) {
         throw new IllegalStateException(var5);
      } catch (NoSuchFieldException var6) {
         IntavePlugin.getInstance()
            .getLogger()
            .severe("Your version of spigot has removed support for task-queueing. We will switch to bukkit's scheduling service");
         c = IntaveScheduler::c;
      }

   }
}
