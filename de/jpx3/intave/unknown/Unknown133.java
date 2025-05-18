package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.util.http.IHTTPRequest;
import java.io.File;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Locale;

@Deprecated
public final class Unknown133 implements IHTTPRequest {
   private final String a;
   private FileLock e;
   private static final int f = 4;
   private final boolean d;
   private FileChannel c;

   @Override
   public native InputStream stream();

   private String a() {
      return IntavePlugin.m();
   }

   public native boolean a(InputStream var1);

   private native void a(FileChannel var1);

   private native void g();

   public File e() {
      String var4 = System.getProperty("os.name").toLowerCase(Locale.ROOT);
      String var6;
      if (var4.contains("win")) {
         var6 = System.getenv("APPDATA") + "/Intave/";
      } else {
         var6 = System.getProperty("user.home") + "..intave.";
      }

      File var5 = new File(var6);
      if (!var5.exists()) {
         var5.mkdir();
      }

      return new File(var5, this.f());
   }

   private native FileChannel b();

   public Unknown133(String var1, boolean var2) {
      this.a = var1;
      this.d = var2;
   }

   public boolean h() {
      File var1 = this.e();
      return var1.exists();
   }

   private native String f();

   private native FileChannel d();
}
