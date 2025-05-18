package de.jpx3.intave.clean;

import de.jpx3.intave.unknown.Unknown44;
import de.jpx3.intave.unknown.Unknown58;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class Clean1 {
   public static final Unknown58 c = new Unknown58();
   public static final Unknown58 e = new Unknown58();
   public static final Map a = new Unknown44();
   public static final Unknown58 d = new Unknown58();
   private static final Map b = new ConcurrentHashMap();

   public static double b() {
      AtomicLong var0 = new AtomicLong();
      AtomicLong var1 = new AtomicLong();
      b.forEach(Clean1::b);
      return (double)var0.get() / Math.max((double)var1.get(), 1.0);
   }

   private static void b(AtomicLong var0, AtomicLong var1, Integer var2, AtomicLong var3) {
      var0.addAndGet((long)var2.intValue() * var3.get());
      var1.addAndGet(var3.get());
   }

   public static void a(int var0) {
      ((AtomicLong)b.computeIfAbsent(var0, Clean1::a)).incrementAndGet();
   }

   private static AtomicLong a(Integer var0) {
      return new AtomicLong(0L);
   }
}
