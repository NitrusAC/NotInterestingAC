package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;

public final class Unknown387 implements HTTPRequest {
   private final File a;

   @Override
   public InputStream stream() {
      try {
         if (!this.c()) {
            return new ByteArrayInputStream(new byte[0]);
         } else {
            InputStream var4 = Files.newInputStream(this.a.toPath());
            ByteArrayOutputStream var5 = new ByteArrayOutputStream();
            byte[] var6 = new byte[4096];

            int var7;
            while((var7 = var4.read(var6)) != -1) {
               var5.write(var6, 0, var7);
            }

            var4.close();
            return new ByteArrayInputStream(var5.toByteArray());
         }
      } catch (IOException var8) {
         return new ByteArrayInputStream(new byte[0]);
      }
   }

   @Override
   public boolean c() {
      return this.a.exists() && this.a.length() != 0L;
   }

   @Override
   public void b() {
      this.a.delete();
   }

   @Override
   public void stream(InputStream var1) {
      try {
         if (!this.a.exists() && !this.a.createNewFile()) {
            throw new IllegalStateException("Unable to create file " + this.a + ", exists: " + this.a.exists());
         }

         ByteArrayOutputStream var5 = new ByteArrayOutputStream();
         byte[] var6 = new byte[4096];

         int var7;
         while((var7 = var1.read(var6)) != -1) {
            var5.write(var6, 0, var7);
         }

         var1.close();
         FileChannel var8 = new FileOutputStream(this.a).getChannel();
         ReadableByteChannel var9 = Channels.newChannel(new ByteArrayInputStream(var5.toByteArray()));
         var8.transferFrom(var9, 0L, Long.MAX_VALUE);
         var8.close();
      } catch (IOException var10) {
         var10.printStackTrace();
      }

   }

   @Override
   public long d() {
      return this.a.lastModified();
   }

   public Unknown387(File var1) {
      this.a = var1;
   }
}
