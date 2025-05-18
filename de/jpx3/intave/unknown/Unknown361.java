package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.collision.Box;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Unknown361 {
   private static final Map c = new HashMap();
   private static final Map d = new ConcurrentHashMap();

   static {
      c.put(Box.class, 48);
   }

   public static Map c() {
      HashMap var3 = new HashMap();

      for(Entry var5 : d.entrySet()) {
         Class var6 = (Class)var5.getKey();
         var3.put(var6, ((AtomicLong)var5.getValue()).get() * (long)((Integer)c.get(var6)).intValue());
      }

      return var3;
   }

   protected void finalize() {
   }

   private static AtomicLong b(Class var0) {
      return new AtomicLong();
   }

   public static Map a() {
      return d;
   }

   private static AtomicLong c(Class var0) {
      return new AtomicLong();
   }
}
