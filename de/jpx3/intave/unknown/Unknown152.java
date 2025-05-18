package de.jpx3.intave.unknown;

import de.jpx3.intave.qd;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public final class Unknown152 {
   private static Class a(String var0) {
      try {
         return Class.forName(qd.a(var0));
      } catch (ClassNotFoundException var2) {
         var2.printStackTrace();
         return null;
      }
   }

   public static native Class a(ClassLoader var0, String var1);

   private static native byte[] a(File var0, String var1);

   private static native byte[] a(InputStream var0);

   private static long b(InputStream var0, OutputStream var1) {
      return a(var0, var1, new byte[4096]);
   }

   private static native byte[] b(ClassLoader var0, String var1);

   private static int a(InputStream var0, OutputStream var1) {
      long var2 = b(var0, var1);
      return var2 > 2147483647L ? -1 : (int)var2;
   }

   private static long a(InputStream var0, OutputStream var1, byte[] var2) {
      long var3;
      int var5;
      for(var3 = 0L; (var5 = var0.read(var2)) != -1; var3 += (long)var5) {
         var1.write(var2, 0, var5);
      }

      return var3;
   }

   private static native boolean c(ClassLoader var0, String var1);
}
