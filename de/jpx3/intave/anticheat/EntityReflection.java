package de.jpx3.intave.anticheat;

import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import org.bukkit.Bukkit;

public final class EntityReflection {
   private static final Field d = ReflectionUtil.getField("Entity", "entityCount");
   private static final int a = 25;
   private static final Queue c = new ConcurrentLinkedDeque();
   private static final boolean b = d.getType() == AtomicInteger.class;

   private static void c() {
      if (c.size() < 25) {
         if (Bukkit.isPrimaryThread()) {
            d();
         } else {
            IntaveScheduler.runTask(EntityReflection::d);
         }
      }

   }

   private static void d() {
      int var3 = 25 - c.size();
      if (var3 > 0) {
         Arrays.stream(c(var3)).forEach(c::add);
      }

   }

   public static void b() {
      c();
   }

   private static int e() {
      int var3 = 0;

      try {
         if (b) {
            AtomicInteger var4 = (AtomicInteger)d.get(null);
            var3 = var4.getAndIncrement();
         } else {
            var3 = d.getInt(null);
            d.setInt(null, var3 + 1);
         }
      } catch (IllegalAccessException var5) {
         var5.printStackTrace();
      }

      return var3;
   }

   private static int[] c(int var0) {
      return IntStream.range(0, var0).map(EntityReflection::b).toArray();
   }

   private static int b(int var0) {
      return e();
   }

   public static int a() {
      c();
      Integer var3 = (Integer)c.poll();
      return var3 != null ? var3 : e();
   }
}
