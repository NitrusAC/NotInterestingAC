package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

public final class Unknown333 implements HTTPRequest {
   private final URL a;

   @Override
   public InputStream stream() {
      try {
         URLConnection var4 = this.a.openConnection();
         var4.addRequestProperty("User-Agent", "Intave/" + IntavePlugin.m());
         var4.addRequestProperty("Cache-Control", "no-cache, no-store, must-revalidate");
         var4.addRequestProperty("Pragma", "no-cache");
         var4.addRequestProperty("Identifier", Unknown60.b());
         var4.setConnectTimeout(4000);
         var4.setReadTimeout(4000);
         InputStream var5 = var4.getInputStream();
         if (var5.available() != 0) {
            return var5;
         } else {
            byte[] var6 = new byte[4096];
            ByteArrayOutputStream var7 = new ByteArrayOutputStream();

            int var8;
            while((var8 = var5.read(var6)) != -1) {
               var7.write(var6, 0, var8);
            }

            byte[] var9 = var7.toByteArray();
            return new ByteArrayInputStream(var9);
         }
      } catch (SocketTimeoutException var10) {
         return new ByteArrayInputStream(new byte[0]);
      } catch (Exception var11) {
         var11.printStackTrace();
         return new ByteArrayInputStream(new byte[0]);
      }
   }

   @Override
   public boolean c() {
      return true;
   }

   public Unknown333(String var1) {
      this(new URL(var1));
   }

   @Override
   public long d() {
      return System.currentTimeMillis();
   }

   public Unknown333(URL var1) {
      this.a = var1;
   }

   @Override
   public void b() {
      throw new UnsupportedOperationException();
   }

   @Override
   public void stream(InputStream var1) {
      throw new UnsupportedOperationException();
   }
}
