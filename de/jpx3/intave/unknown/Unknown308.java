package de.jpx3.intave.unknown;

import com.google.common.base.Preconditions;
import de.jpx3.intave.access.IntaveBootFailureException;
import de.jpx3.intave.access.IntaveInternalException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class Unknown308 {
   public void b(File var1, File var2) {
      this.c(var1, var2);
      this.d(var2);
      this.d(var1, var2);
   }

   public void a(File var1, File var2) {
      this.c(var1, var2);
      this.b(var1, var2);
      this.a(var1);
   }

   private void c(File var1) {
      if (var1.isDirectory()) {
         throw new IllegalArgumentException("Can't have folder as archive");
      } else if (!var1.getName().endsWith(".zip")) {
         throw new IllegalArgumentException("Archive needs a .zip suffix");
      } else if (var1.exists()) {
         throw new IllegalArgumentException("Archive already exists?");
      }
   }

   private void b(File var1) {
      if (var1.isDirectory()) {
         throw new IllegalArgumentException("Can't pack directory");
      } else if (!var1.exists()) {
         throw new IllegalArgumentException("Input file does not exist");
      } else if (!var1.canRead()) {
         throw new IllegalArgumentException("Can't read input file");
      }
   }

   private void d(File var1, File var2) {
      try {
         FileInputStream var6 = new FileInputStream(var1);
         Throwable var7 = null;

         try {
            ZipOutputStream var8 = new ZipOutputStream(new FileOutputStream(var2));
            Throwable var9 = null;

            try {
               var8.putNextEntry(new ZipEntry(var1.getName()));
               var8.setLevel(9);
               byte[] var11 = new byte[1024];

               int var10;
               while((var10 = var6.read(var11)) != -1) {
                  var8.write(var11, 0, var10);
               }
            } catch (Throwable var35) {
               var9 = var35;
               throw var35;
            } finally {
               if (var8 != null) {
                  if (var9 != null) {
                     try {
                        var8.close();
                     } catch (Throwable var34) {
                        var9.addSuppressed(var34);
                     }
                  } else {
                     var8.close();
                  }
               }

            }
         } catch (Throwable var37) {
            var7 = var37;
            throw var37;
         } finally {
            if (var6 != null) {
               if (var7 != null) {
                  try {
                     var6.close();
                  } catch (Throwable var33) {
                     var7.addSuppressed(var33);
                  }
               } else {
                  var6.close();
               }
            }

         }

      } catch (IOException var39) {
         throw new IntaveBootFailureException(var39);
      }
   }

   private void c(File var1, File var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      this.b(var1);
      this.c(var2);
   }

   private void d(File var1) {
      try {
         var1.createNewFile();
      } catch (IOException var3) {
         throw new IntaveInternalException(var3);
      }
   }

   private void a(File var1) {
      var1.delete();
   }
}
