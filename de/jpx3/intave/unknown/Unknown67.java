package de.jpx3.intave.unknown;

import java.util.concurrent.atomic.AtomicLong;

public final class Unknown67 implements Unknown340 {
   private final AtomicLong a = new AtomicLong();

   @Override
   public void a(Unknown171 var1) {
      this.a.incrementAndGet();
   }

   public long a() {
      return this.a.get();
   }

   @Override
   public void b(Unknown171 var1) {
      this.a.decrementAndGet();
   }
}
