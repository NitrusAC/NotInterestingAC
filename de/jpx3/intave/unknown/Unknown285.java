package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import java.io.IOException;
import java.io.InputStream;

public final class Unknown285 implements HTTPRequest {
   private final int a;
   private final HTTPRequest b;

   @Override
   public InputStream stream() {
      InputStream var4 = this.b.stream();
      int var5 = this.a;

      try {
         while((var4 == null || var4.available() == 0) && var5-- > 0) {
            var4 = this.b.stream();
         }
      } catch (IOException var7) {
         var7.printStackTrace();
      }

      return var4;
   }

   @Override
   public void b() {
      this.b.b();
   }

   @Override
   public boolean c() {
      return this.b.c();
   }

   @Override
   public void stream(InputStream var1) {
      this.b.stream(var1);
   }

   @Override
   public long d() {
      return this.b.d();
   }

   public Unknown285(HTTPRequest var1, int var2) {
      this.b = var1;
      this.a = var2;
   }
}
