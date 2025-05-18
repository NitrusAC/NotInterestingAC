package de.jpx3.intave.anticheat.threading;

import de.jpx3.intave.anticheat.logger.Logger;
import java.util.concurrent.atomic.AtomicInteger;

public final class ThreadFactory implements java.util.concurrent.ThreadFactory {
   private final int c;
   private static final AtomicInteger b = new AtomicInteger(1);
   private static final ThreadGroup d = new ThreadGroup("intave");
   private final AtomicInteger e = new AtomicInteger(1);
   private final int a;

   public static ThreadFactory b() {
      return a(1);
   }

   private ThreadFactory(int var1) {
      this.c = b.getAndIncrement();
      this.a = var1;
   }

   private Runnable a(Runnable var1) {
      return var1;
   }

   public static ThreadFactory a() {
      return a(10);
   }

   private String c() {
      return "Intave";
   }

   private static void b(Thread var0, Throwable var1) {
      Logger.getLogger().print("Thread " + var0.getName() + " has encountered an " + var1);
      var1.printStackTrace();
   }

   public static ThreadFactory a(int var0) {
      return new ThreadFactory(var0);
   }

   public Thread newThread(Runnable var1) {
      Thread var6 = new Thread(d, this.a(var1), this.c(), 0L);
      var6.setDaemon(false);
      var6.setPriority(this.a);
      var6.setUncaughtExceptionHandler(ThreadFactory::b);
      return var6;
   }
}
