package de.jpx3.intave.unknown;

import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.IntavePlugin;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public final class Unknown290 {
   public Map a = new HashMap();
   private final IntavePlugin b;

   private boolean a(String var1) {
      Plugin var4 = Bukkit.getPluginManager().getPlugin(var1);
      if (var4 != null) {
         if (!var4.isEnabled()) {
            Bukkit.getPluginManager().enablePlugin(var4);
         }

         return false;
      } else {
         File var5 = new File(this.b.r().getParentFile().getAbsolutePath() + "/" + var1 + ".jar");
         if (!var5.exists()) {
            String var6 = (String)this.a.get(var1);

            try {
               this.a(var5, var1, var6);
               return true;
            } catch (Exception var8) {
               throw new IntaveInternalException("Unable to download library " + var1, var8);
            }
         } else {
            return false;
         }
      }
   }

   private void a(InputStream var1, Path var2) {
      OutputStream var3 = this.a(var2, new OpenOption[]{StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE});
      OutputStream var4 = var3;
      Throwable var5 = null;

      try {
         this.a(var1, var4);
      } catch (Throwable var14) {
         var5 = var14;
         throw var14;
      } finally {
         if (var3 != null) {
            if (var5 != null) {
               try {
                  var4.close();
               } catch (Throwable var13) {
                  var5.addSuppressed(var13);
               }
            } else {
               var3.close();
            }
         }

      }

   }

   public void b() {
      this.a.put("ProtocolLib", "https:..service.intave.de.resource.ProtocolLib-4-8-0.jar");
   }

   private void a(File var1, String var2, String var3) {
      URL var6 = new URL(var3);
      InputStream var7 = var6.openStream();
      Throwable var8 = null;

      try {
         this.a(var7, var1.toPath());
         this.b.getLogger().info(ChatColor.GREEN + "Downloaded " + var2);
         Plugin var9 = this.b.getServer().getPluginManager().loadPlugin(var1);
         var9.onLoad();
         this.b.getServer().getPluginManager().enablePlugin(var9);
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

   public Unknown290(IntavePlugin var1) {
      this.b = var1;
   }

   private OutputStream a(Path var1, OpenOption[] var2) {
      return var1.getFileSystem().provider().newOutputStream(var1, var2);
   }

   private void a(InputStream var1, OutputStream var2) {
      byte[] var3 = new byte[4096];

      int var4;
      for(int var5 = -1; (var4 = var1.read(var3)) > 0; var2.write(var3, 0, var4)) {
         if (var5 < 0) {
            var5 = var4;
         }
      }

   }

   public void a() {
      for(String var4 : this.a.keySet()) {
         try {
            if (!this.a(var4)) {
               return;
            }
         } catch (Exception var6) {
            throw new IntaveInternalException("Unable to load library " + var4, var6);
         }
      }

   }
}
