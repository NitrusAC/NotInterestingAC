package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class Unknown41 implements HTTPRequest {
   private FileChannel d;
   private final File b;
   private final HTTPRequest e;
   private FileLock a;
   private final Lock c = new ReentrantLock();

   @Override
   public boolean c() {
      return this.e.c() && !this.b.exists() && !this.a();
   }

   private void d() {
      try {
         this.c.unlock();
         this.a.close();
         this.d.close();
         this.b.delete();
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }

   public Unknown41(File var1, HTTPRequest var2) {
      this.b = new File(var1 + ".lock");
      this.e = var2;
   }

   @Override
   public void stream(InputStream var1) {
      try {
         this.c();
         this.e.stream(var1);
      } finally {
         this.d();
      }

   }

   private void c() {
      try {
         this.c.lock();
         if (this.b.exists() && System.currentTimeMillis() - this.b.lastModified() > 60000L) {
            try {
               this.b.delete();
            } catch (Exception var8) {
            }
         }

         int var4 = 600;

         while(this.b.exists() && var4-- > 0) {
            try {
               Thread.sleep(50L);
            } catch (InterruptedException var7) {
               var7.printStackTrace();
            }
         }

         this.b.delete();
         this.b.createNewFile();
         this.b.deleteOnExit();
         RandomAccessFile var5 = new RandomAccessFile(this.b, "rw");
         this.d = var5.getChannel();
         this.a = this.d.lock();
         String var6 = String.valueOf(ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE));
         this.d.write(ByteBuffer.wrap(var6.getBytes(StandardCharsets.UTF_8)));
      } catch (IOException var9) {
         throw new IllegalStateException(var9);
      }
   }

   @Override
   public void b() {
      try {
         this.c();
         this.e.b();
      } finally {
         this.d();
      }

   }

   private boolean a() {
      return this.b.exists() && this.d != null && this.d.isOpen();
   }

   @Override
   public long d() {
      return this.e.d();
   }

   @Override
   public InputStream stream() {
      InputStream var1;
      try {
         this.c();
         var1 = this.e.stream();
      } finally {
         this.d();
      }

      return var1;
   }
}
