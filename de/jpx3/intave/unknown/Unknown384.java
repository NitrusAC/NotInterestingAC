package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class Unknown384 implements HTTPRequest {
   private final long c;
   private final HTTPRequest a;
   private final HTTPRequest b;

   @Override
   public InputStream stream() {
      return this.a() ? this.b() : this.b.stream();
   }

   @Override
   public long d() {
      return this.b.d();
   }

   private boolean a() {
      boolean var4 = this.b.c();
      boolean var5 = System.currentTimeMillis() - this.b.d() > this.c;
      return !var4 || var5;
   }

   @Override
   public void stream(InputStream var1) {
      throw new UnsupportedOperationException();
   }

   @Override
   public void b() {
      this.b.b();
   }

   public Unknown384(HTTPRequest var1, HTTPRequest var2, long var3) {
      this.b = var1;
      this.a = var2;
      this.c = var3;
   }

   private synchronized InputStream b() {
      if (!this.a()) {
         return this.b.stream();
      } else {
         InputStream var4 = this.a.stream();

         ByteArrayOutputStream var5;
         try {
            if (var4 == null || var4.available() == 0) {
               var4 = this.a.stream();
               if (var4 == null || var4.available() == 0) {
                  return this.b.stream();
               }
            }

            var5 = new ByteArrayOutputStream();
            byte[] var6 = new byte[4096];

            int var7;
            while((var7 = var4.read(var6)) != -1) {
               var5.write(var6, 0, var7);
            }
         } catch (Exception var8) {
            return this.b.stream();
         }

         byte[] var9 = var5.toByteArray();
         if (var9.length == 0) {
            return this.b.stream();
         } else {
            this.b.stream(new ByteArrayInputStream(var9));
            return new ByteArrayInputStream(var9);
         }
      }
   }

   @Override
   public boolean c() {
      return this.b.c();
   }
}
