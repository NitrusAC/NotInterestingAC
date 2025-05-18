package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

public final class Unknown107 implements HTTPRequest {
   private final HTTPRequest a;

   @Override
   public native void stream(InputStream var1);

   public Unknown107(HTTPRequest var1) {
      this.a = var1;
   }

   @Override
   public native InputStream stream();

   @Override
   public long d() {
      return this.a.d();
   }

   private static NoSuchAlgorithmException a(NoSuchAlgorithmException var0) {
      return var0;
   }

   @Override
   public void b() {
      this.a.b();
   }

   @Override
   public boolean c() {
      return this.a.c();
   }
}
