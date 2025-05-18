package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.logger.Logger;
import io.netty.util.internal.ConcurrentSet;
import java.util.Collections;
import java.util.Set;
import org.bukkit.Bukkit;

public final class Unknown22 {
   private static final String c;
   private static final Set a = new ConcurrentSet();

   public static void a() {
      Unknown86.b(Unknown22::b);
   }

   public static void b(int var0) {
      a.remove(var0);
   }

   public static void b() {
      for(Integer var4 : Collections.unmodifiableSet(a)) {
         Bukkit.getScheduler().cancelTask(var4);
         b(var4);
      }

   }

   public static void a(int var0) {
      a.add(var0);
      if (a.size() > 64) {
         Logger.getLogger().severe("Intave is creating too many tasks, closing the last one to stay under 64 tasks");
         Thread.dumpStack();
         Bukkit.getScheduler().cancelTask(var0);
      }

   }
}
