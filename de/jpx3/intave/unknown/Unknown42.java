package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

public final class Unknown42 implements HTTPRequest {
   private final Function e;
   private final HTTPRequest d;
   private final HTTPRequest[] c;
   private final File a;
   private boolean b = false;

   public Unknown42(File var1, Function var2, int var3) {
      this.a = var1;
      this.d = (HTTPRequest)var2.apply(var1);
      this.e = var2;
      this.c = new HTTPRequest[var3];
      if (this.d.c()) {
         this.c();
      }

   }

   private String a(int var1) {
      return String.valueOf((char)(var1 + 97));
   }

   private void d() {
      for(HTTPRequest var7 : this.c) {
         if (var7 != null) {
            var7.b();
         }
      }

   }

   @Override
   public void stream(InputStream var1) {
      this.d.stream(var1);
      this.c();
      this.a();
   }

   @Override
   public InputStream stream() {
      this.c();
      int var4 = 1000;

      while(this.c() && var4-- > 0) {
         int var5 = ThreadLocalRandom.current().nextInt(0, this.c.length);
         HTTPRequest var6 = this.c[var5];
         if (var6.c()) {
            return var6.stream();
         }
      }

      return this.d.stream();
   }

   @Override
   public boolean c() {
      return this.d.c() && Arrays.stream(this.c).anyMatch(HTTPRequest::c);
   }

   private void a() {
      for(HTTPRequest var7 : this.c) {
         var7.stream(this.d.stream());
      }

   }

   @Override
   public long d() {
      return this.d.d();
   }

   public synchronized void c() {
      if (!this.b) {
         this.b = true;

         for(int var1 = 0; var1 < this.c.length; ++var1) {
            File var2 = new File(this.a + this.a(var1));
            this.c[var1] = (HTTPRequest)this.e.apply(var2);
            boolean var3 = var2.exists();
            boolean var4 = var2.length() == 0L;
            if (!var3 || var4) {
               this.c[var1].stream(this.d.stream());
            }
         }

      }
   }

   @Override
   public void b() {
      this.d.b();
      this.d();
   }
}
