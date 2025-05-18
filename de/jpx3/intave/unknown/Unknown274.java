package de.jpx3.intave.unknown;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class Unknown274 implements Unknown17 {
   private final Map b = new ConcurrentHashMap();
   private final long a;

   @Override
   public boolean a(String var1) {
      Unknown151 var5 = (Unknown151)this.b.get(var1);
      return var5 != null && var5.c();
   }

   public Unknown274(long var1, TimeUnit var3) {
      this.a = var3.toMillis(var1);
   }

   @Override
   public void a(String var1, boolean var2) {
      ((Unknown151)this.b.computeIfAbsent(var1, this::b)).a(var2);
   }

   private Unknown151 b(String var1) {
      return new Unknown151(this.a);
   }

   @Override
   public boolean b(String var1) {
      Unknown151 var5 = (Unknown151)this.b.get(var1);
      return var5 != null && !var5.a();
   }
}
