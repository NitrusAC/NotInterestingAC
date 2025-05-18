package de.jpx3.intave.unknown;

import java.io.OutputStream;
import org.jetbrains.annotations.NotNull;

final class Unknown191 extends OutputStream {
   private final OutputStream[] a;

   public Unknown191(OutputStream[] var1) {
      this.a = var1;
   }

   public void flush() {
      for(OutputStream var7 : this.a) {
         var7.flush();
      }

   }

   public void write(@NotNull byte[] var1) {
      for(OutputStream var8 : this.a) {
         var8.write(var1);
      }

   }

   public void write(@NotNull byte[] var1, int var2, int var3) {
      for(OutputStream var10 : this.a) {
         var10.write(var1, var2, var3);
      }

   }

   public void write(int var1) {
      for(OutputStream var8 : this.a) {
         var8.write(var1);
      }

   }

   public void close() {
      for(OutputStream var7 : this.a) {
         var7.close();
      }

   }
}
