package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.threading.BackgroundThreadingPool;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.zip.DeflaterInputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.io.output.CountingOutputStream;
import org.bukkit.Bukkit;

public final class Unknown127 {
   private final Map e = new HashMap();
   private static UUID h = null;
   private final Map b;
   private final Map d;
   private final Map g;
   private static final long a = 67108864L;
   private long f = 0L;

   private void c(String var1, byte[] var2) {
      File var6 = new File(this.i(), var1);
      var6.createNewFile();
      var6.setWritable(true);
      var6.setReadable(true);
      FileOutputStream var7 = new FileOutputStream(var6);
      Throwable var8 = null;

      try {
         var7.write(var2);
      } catch (Throwable var17) {
         var8 = var17;
         throw var17;
      } finally {
         if (var7 != null) {
            if (var8 != null) {
               try {
                  var7.close();
               } catch (Throwable var16) {
                  var8.addSuppressed(var16);
               }
            } else {
               var7.close();
            }
         }

      }

   }

   public void b() {
      this.f();
      Unknown86.b(this::k);
   }

   public void k() {
      this.j();
      this.e();
   }

   private boolean c() {
      return h != null;
   }

   private byte[] a(byte[] var1) {
      try {
         ByteArrayOutputStream var5 = new ByteArrayOutputStream();
         DeflaterOutputStream var6 = new DeflaterOutputStream(var5);
         Throwable var7 = null;

         try {
            var6.write(var1, 0, var1.length);
            var6.flush();
         } catch (Throwable var17) {
            var7 = var17;
            throw var17;
         } finally {
            if (var6 != null) {
               if (var7 != null) {
                  try {
                     var6.close();
                  } catch (Throwable var16) {
                     var7.addSuppressed(var16);
                  }
               } else {
                  var6.close();
               }
            }

         }

         var1 = var5.toByteArray();
         String var21 = "Iloovestatistics";
         SecretKeySpec var22 = new SecretKeySpec(var21.getBytes(StandardCharsets.UTF_8), "AES");
         Cipher var8 = Cipher.getInstance("AES/ECB/PKCS5Padding");
         var8.init(1, var22);
         return var8.doFinal(var1);
      } catch (Exception var19) {
         var19.printStackTrace();
         return null;
      }
   }

   public Unknown127() {
      this.d = new HashMap();
      this.g = new HashMap();
      this.b = new HashMap();
   }

   private void f() {
      BackgroundThreadingPool.submit(this::e);
      Bukkit.getScheduler().scheduleSyncDelayedTask(IntavePlugin.getInstance(), this::f, this.l() / 50L);
   }

   private void b(String var1, byte[] var2) {
      try {
         this.c(var1, var2);
      } catch (IOException var6) {
         System.out.println("Failed to copy file to temp-directory: " + var1);
         var6.printStackTrace();
      }

   }

   public File d() {
      String var5 = System.getProperty("os.name").toLowerCase(Locale.ROOT);
      String var7;
      if (var5.contains("win")) {
         var7 = System.getenv("APPDATA") + "/Intave/Queue/";
      } else {
         var7 = System.getProperty("user.home") + "..intave.queue.";
      }

      File var6 = new File(var7);
      if (!var6.exists()) {
         var6.mkdir();
      }

      return var6;
   }

   private void j() {
      File var4 = this.d();
      File var5 = new File(var4, "X3-" + System.currentTimeMillis() + "-" + UUID.randomUUID().toString().substring(0, 8));
      var5.getParentFile().mkdirs();
      boolean var6 = false;

      try {
         var5.createNewFile();
      } catch (IOException var43) {
         var43.printStackTrace();
         return;
      }

      try {
         ZipOutputStream var7 = new ZipOutputStream(Files.newOutputStream(var5.toPath()));
         Throwable var8 = null;

         try {
            if (this.c()) {
               File[] var9 = this.i().listFiles();
               if (var9 != null) {
                  for(File var13 : var9) {
                     var7.putNextEntry(new ZipEntry(var13.getName()));
                     FileInputStream var14 = new FileInputStream(var13);
                     Throwable var15 = null;

                     try {
                        byte[] var17 = new byte[2048];

                        int var16;
                        while((var16 = var14.read(var17)) != -1) {
                           var7.write(var17, 0, var16);
                        }
                     } catch (Throwable var44) {
                        var15 = var44;
                        throw var44;
                     } finally {
                        if (var14 != null) {
                           if (var15 != null) {
                              try {
                                 var14.close();
                              } catch (Throwable var42) {
                                 var15.addSuppressed(var42);
                              }
                           } else {
                              var14.close();
                           }
                        }

                     }

                     var7.closeEntry();
                     var13.delete();
                     var6 = true;
                  }
               }

               this.i().delete();
               h = null;
            }

            for(Entry var50 : this.e.entrySet()) {
               String var51 = (String)var50.getKey();
               byte[] var52 = (byte[])var50.getValue();
               var7.putNextEntry(new ZipEntry(var51));
               var7.write(var52);
               var7.closeEntry();
               var6 = true;
            }

            this.e.clear();
         } catch (Throwable var46) {
            var8 = var46;
            throw var46;
         } finally {
            if (var7 != null) {
               if (var8 != null) {
                  try {
                     var7.close();
                  } catch (Throwable var41) {
                     var8.addSuppressed(var41);
                  }
               } else {
                  var7.close();
               }
            }

         }
      } catch (IOException var48) {
         throw new RuntimeException(var48);
      }

      if (!var6) {
         var5.delete();
      }

   }

   private OutputStream d(String var1) {
      File var2 = new File(this.i(), var1);
      var2.createNewFile();
      var2.setWritable(true);
      var2.setReadable(true);
      return Files.newOutputStream(var2.toPath());
   }

   private long l() {
      return 86400000L - System.currentTimeMillis() % 86400000L;
   }

   private void e() {
      this.a("X3-2-S");
      File var4 = this.d();
      File var5 = new File(var4, "X4-" + (this.a() - 4L));
      if (var5.exists()) {
         var5.delete();
      }

      File var6 = new File(var4, "X4-" + (this.a() - 1L));
      if (var6.exists()) {
         this.b("X3-2-S");
      } else {
         try {
            var6.createNewFile();
         } catch (IOException var47) {
            throw new RuntimeException(var47);
         }

         try {
            URL var7 = new URL("https:..service.intave.de.analytics.upload");
            HttpURLConnection var8 = (HttpURLConnection)var7.openConnection();
            var8.setDoOutput(true);
            var8.setRequestMethod("POST");
            var8.setRequestProperty("Content-Type", "application/zip");
            var8.setRequestProperty("Identifier", Unknown60.b());
            var8.setRequestProperty("Hardware", Unknown138.a());
            OutputStream var9 = var8.getOutputStream();
            CountingOutputStream var10 = new CountingOutputStream(var9);
            ZipOutputStream var11 = new ZipOutputStream(var10);
            Throwable var12 = null;

            try {
               File[] var13 = var4.listFiles();
               if (var13 != null) {
                  for(File var17 : var13) {
                     if (var17.getName().startsWith("X3-")) {
                        var11.putNextEntry(new ZipEntry(var17.getName()));
                        FileInputStream var18 = new FileInputStream(var17);
                        Throwable var19 = null;

                        try {
                           byte[] var21 = new byte[2048];

                           int var20;
                           while((var20 = var18.read(var21)) != -1) {
                              var11.write(var21, 0, var20);
                           }
                        } catch (Throwable var48) {
                           var19 = var48;
                           throw var48;
                        } finally {
                           if (var18 != null) {
                              if (var19 != null) {
                                 try {
                                    var18.close();
                                 } catch (Throwable var46) {
                                    var19.addSuppressed(var46);
                                 }
                              } else {
                                 var18.close();
                              }
                           }

                        }

                        var11.closeEntry();
                     }
                  }
               }
            } catch (Throwable var50) {
               var12 = var50;
               throw var50;
            } finally {
               if (var11 != null) {
                  if (var12 != null) {
                     try {
                        var11.close();
                     } catch (Throwable var45) {
                        var12.addSuppressed(var45);
                     }
                  } else {
                     var11.close();
                  }
               }

            }

            long var57 = var10.getByteCount();
            InputStream var59 = var8.getInputStream();
            StringBuilder var60 = new StringBuilder();
            Scanner var61 = new Scanner(var59);

            while(var61.hasNextLine()) {
               var60.append(var61.nextLine());
            }

            var61.close();
            if (!var60.toString().equals("SUCCESS")) {
               throw new RuntimeException("Server error: " + var60);
            }
         } catch (Exception var52) {
            var6.delete();
            this.b("X3-2-S");
            throw new RuntimeException("Upload failed: " + var52.getMessage());
         }

         File[] var53 = var4.listFiles();
         if (var53 != null) {
            for(File var58 : var53) {
               if (var58.getName().startsWith("X3-")) {
                  var58.delete();
               }
            }
         }

         this.b("X3-2-S");
      }
   }

   private File i() {
      return new File(System.getProperty("java.io.tmpdir"), "intave-" + h);
   }

   public native void a(String var1, InputStream var2);

   public void b(String var1) {
      File var5 = (File)this.d.remove(var1);
      FileLock var6 = (FileLock)this.g.remove(var1);
      if (var6 != null) {
         try {
            var6.release();
         } catch (IOException var10) {
            var10.printStackTrace();
         }
      }

      FileChannel var7 = (FileChannel)this.b.remove(var1);
      if (var7 != null) {
         try {
            var7.close();
         } catch (IOException var9) {
            var9.printStackTrace();
         }
      }

      var5.delete();
   }

   public void a(String var1, String var2) {
      this.a(var1, new ByteArrayInputStream(var2.getBytes(StandardCharsets.UTF_8)));
   }

   private InputStream a(InputStream var1) {
      try {
         DeflaterInputStream var8 = new DeflaterInputStream(var1);
         String var4 = "Iloovestatistics";
         SecretKeySpec var5 = new SecretKeySpec(var4.getBytes(StandardCharsets.UTF_8), "AES");
         Cipher var6 = Cipher.getInstance("AES/ECB/PKCS5Padding");
         var6.init(1, var5);
         return new CipherInputStream(var8, var6);
      } catch (Exception var7) {
         var7.printStackTrace();
         return null;
      }
   }

   private long a() {
      return System.currentTimeMillis() / 86400000L;
   }

   private void h() {
      File var4;
      do {
         h = UUID.randomUUID();
         var4 = this.i();
      } while(var4.exists());

      var4.mkdir();
   }

   public void a(String var1) {
      FileLock var5 = null;
      FileChannel var6 = null;

      try {
         File var7 = new File(this.d(), "X0-" + var1 + ".lock");
         if (var7.exists() && System.currentTimeMillis() - var7.lastModified() > 300000L) {
            try {
               var7.delete();
            } catch (Exception var11) {
            }
         }

         int var8 = 600;

         while(var7.exists() && var8-- > 0) {
            try {
               Thread.sleep(50L);
            } catch (InterruptedException var10) {
               var10.printStackTrace();
            }
         }

         var7.delete();
         var7.createNewFile();
         this.d.put(var1, var7);
         var6 = new FileOutputStream(var7).getChannel();
         var5 = var6.lock();
      } catch (IOException var12) {
         var12.printStackTrace();
      }

      this.g.put(var1, var5);
      this.b.put(var1, var6);
   }

   public void d(String var1, byte[] var2) {
      this.a(var1, new ByteArrayInputStream(var2));
   }
}
