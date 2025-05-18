package de.jpx3.intave.anticheat.threading;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.unknown.what.What1;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class BackgroundThreadingPool {
   private static ExecutorService service;

   public static void submit(Runnable runnable) {
      if (service != null && !service.isShutdown() && !service.isTerminated()) {
         runnable = queue(runnable);
         service.execute(runnable);
      }
   }

   private static void execute(Runnable var0) {
      try {
         What1.g.h();
         var0.run();
         return;
      } catch (Error | Exception var8) {
         if (!service.isShutdown() && !service.isTerminated()) {
            Logger.getLogger().severe("Failed to execute background task " + var0);
            var8.printStackTrace();
            return;
         }
      } finally {
         What1.g.g();
      }

   }

   public static void start() {
      service = Executors.newSingleThreadExecutor(ThreadFactory.b());
   }

   private static Runnable queue(Runnable var0) {
      return BackgroundThreadingPool::execute;
   }

   public static void stop() {
      if (service != null) {
         List var3 = service.shutdownNow();
         if (!var3.isEmpty()) {
            IntavePlugin.getInstance().getLogger().info("Waiting for background tasks to complete");
         }

         for(Runnable var5 : var3) {
            var5.run();
         }

         try {
            if (!service.awaitTermination(16L, TimeUnit.SECONDS)) {
               IntavePlugin.getInstance().getLogger().info("Unable to complete background tasks after 16s");
            }
         } catch (InterruptedException var6) {
            var6.printStackTrace();
         }

      }
   }
}
