package de.jpx3.intave.anticheat;

import de.jpx3.intave.access.IntaveAccess;
import de.jpx3.intave.anticheat.bungee.BungeecordHandler;
import de.jpx3.intave.anticheat.check.api.CheckLoader;
import de.jpx3.intave.anticheat.config.ConfigLoader;
import de.jpx3.intave.anticheat.listener.TrustFactorListener;
import de.jpx3.intave.anticheat.logger.Logger;
import de.jpx3.intave.anticheat.module.impl.BlacklistModule;
import de.jpx3.intave.anticheat.threading.BackgroundThreadingPool;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import de.jpx3.intave.anticheat.util.Bstats;
import de.jpx3.intave.unknown.Unknown127;
import de.jpx3.intave.unknown.Unknown175;
import de.jpx3.intave.unknown.Unknown262;
import de.jpx3.intave.unknown.Unknown290;
import de.jpx3.intave.unknown.Unknown297;
import de.jpx3.intave.unknown.Unknown365;
import de.jpx3.intave.unknown.Unknown392;
import de.jpx3.intave.unknown.Unknown407;
import de.jpx3.intave.unknown.Unknown47;
import de.jpx3.intave.unknown.Unknown70;
import de.jpx3.intave.unknown.Unknown92;
import de.jpx3.intave.unknown.check.Check7;
import de.jpx3.intave.unknown.check.Check8;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class IntavePlugin extends JavaPlugin {
   private Unknown127 server;
   private Logger logger;
   private BungeecordHandler bungeecordHandler;
   private Unknown47 r;
   private CheckLoader j;
   private ConfigLoader configLoader;
   private static String c = ChatColor.translateAlternateColorCodes('&', "&8[&c&lIntave&8]&7 ");
   private Unknown392 m;
   private TrustFactorListener trustFactorListener;
   private static String z = ChatColor.getLastColors(c);
   private BlacklistModule p;
   private Check7 i;
   private IntaveAccess u;
   private static final long h = TimeUnit.DAYS.toMillis(90L);
   public static final long q = TimeUnit.MINUTES.toMillis(1L);
   private static boolean e = false;
   private Unknown92 d;
   private static IntavePlugin instance;
   private static String f = "UNKNOWN";
   private Unknown407 l;
   private List g = new ArrayList();
   private Unknown365 k;
   private static boolean t = false;
   private Unknown175 b;
   private Bstats n;
   private Unknown290 o;

   public static boolean q() {
      return t;
   }

   public native void y();

   private String I() {
      return (String)this.g.get(ThreadLocalRandom.current().nextInt(this.g.size()));
   }

   private static void g(File var0) {
      try {
         var0.delete();
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public void a(IntaveAccess var1) {
      this.u = var1;
   }

   private static boolean h(File var0) {
      return System.currentTimeMillis() - var0.lastModified() > h;
   }

   private void recursiveNuke(File var1) {
      if (var1.exists() && var1.isDirectory()) {
         File[] var5 = var1.listFiles();
         if (var5 == null) {
            throw new IOException("Failed to list contents of " + var1);
         } else {
            for(File var9 : var5) {
               try {
                  this.deleteFile(var9);
               } catch (IOException var11) {
               }
            }

            var1.delete();
         }
      }
   }

   private void b(File var1) {
      try {
         this.recursiveNuke(var1);
      } catch (IOException var5) {
      }

   }

   private static boolean isTempIntaveFile(File var0) {
      return "deleteme".equalsIgnoreCase(var0.getName()) && var0.getParentFile().getName().toLowerCase(Locale.ROOT).contains("intave");
   }

   private static boolean launchError(String var0, CommandSender var1, Command var2, String var3, String[] var4) {
      var1.sendMessage(getPrefix() + ChatColor.RED + "Intave couldn't boot properly: " + var0);
      return false;
   }

   private static void B() {
      MoudleLoader.a(Unknown70.k);
      BackgroundThreadingPool.submit(Unknown262::d);
   }

   public CheckLoader g() {
      return this.j;
   }

   public native void s();

   public void A() {
   }

   private void deleteFile(File var1) {
      if (var1.isDirectory()) {
         this.recursiveNuke(var1);
      } else {
         boolean var5 = var1.exists();
         if (!var1.delete()) {
            if (!var5) {
               throw new FileNotFoundException("File does not exist: " + var1);
            }

            throw new IOException("Unable to delete file: " + var1);
         }
      }

   }

   public TrustFactorListener c() {
      return this.trustFactorListener;
   }

   public Unknown407 E() {
      return this.l;
   }

   public Unknown392 k() {
      return this.m;
   }

   private void x() {
      this.a(null);
   }

   public IntaveAccess F() {
      return this.u;
   }

   public static IntavePlugin getInstance() {
      return instance;
   }

   public Unknown365 p() {
      return this.k;
   }

   public Unknown47 o() {
      return this.r;
   }

   private void C() {
      try {
         Class var3 = Class.forName("de.jpx3.intave.unknown.Unknown12");
         var3.getMethod("i").invoke(null);
      } catch (Exception var4) {
      }

   }

   public native void onDisable();

   @Deprecated
   public Unknown297 d() {
      return MoudleLoader.j().c();
   }

   public static String m() {
      return f;
   }

   @Deprecated
   public Check8 b() {
      return MoudleLoader.j().a();
   }

   public IntavePlugin() {
      this.create();
   }

   public static String l() {
      return z;
   }

   public Unknown175 z() {
      return this.b;
   }

   private static boolean d(File var0) {
      return System.currentTimeMillis() - var0.lastModified() > h;
   }

   public native void n();

   public Unknown127 D() {
      return this.server;
   }

   public BungeecordHandler i() {
      return this.bungeecordHandler;
   }

   private static boolean i(File var0) {
      return System.currentTimeMillis() - var0.lastModified() > q;
   }

   public File r() {
      return new File(this.getServer().getUpdateFolderFile().getParentFile(), "Intave");
   }

   private static boolean a(Path var0) {
      return Files.isRegularFile(var0, new LinkOption[0]);
   }

   public native void w();

   public Logger getLogger() {
      return this.logger;
   }

   public static String getPrefix() {
      return c;
   }

   public void h() {
      try {
         Field var3 = JavaPlugin.class.getDeclaredField("logger");
         var3.setAccessible(true);
         var3.set(this, this.getLogger());
      } catch (Exception var4) {
         this.logger.severe("[Intave] Failed to inject logger to bukkit");
      }

   }

   public native void create();

   public void t() {
      File var4 = this.r();
      if (!var4.exists() && !var4.mkdirs()) {
         this.logger.severe("Failed to create Intave folder " + var4.getAbsolutePath());
      }

   }

   private static boolean b(Path var0) {
      return Files.isDirectory(var0, new LinkOption[0]);
   }

   public native void f();

   private static boolean c(File var0) {
      return var0.listFiles() == null;
   }

   public native void onEnable();

   public native void a(String var1);

   private void v() {
      Unknown262.a(this::s);
      Unknown262.a(this::x);
   }

   private static void j(File var0) {
      try {
         var0.delete();
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public native void onLoad();

   public YamlConfiguration getConfig() {
      return this.configLoader.e();
   }
}
