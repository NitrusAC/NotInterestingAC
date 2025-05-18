package de.jpx3.intave.anticheat.logger;

import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.threading.BackgroundThreadingPool;
import de.jpx3.intave.anticheat.util.JavaUtil;
import de.jpx3.intave.anticheat.util.MinecraftVersion;
import de.jpx3.intave.anticheat.util.ServerUtil;
import de.jpx3.intave.unknown.Unknown308;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginLogger;

public final class Logger extends PluginLogger {
   private static final DateTimeFormatter m = DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm.ss.SSS");
   private String h;
   private static Logger l;
   private static final ThreadLocal k = ThreadLocal.withInitial(Logger::c);
   private final List streams = new CopyOnWriteArrayList();
   private PrintWriter j;
   private static final String d = "plugins" + File.separator + "Intave" + File.separator + "logs";
   public static final boolean a = false;
   public static boolean c = true;
   public static boolean f = JavaUtil.getJavaVersion() > 8;
   private long b;
   private final Unknown308 g;
   private final IntavePlugin i;

   public void log(LogRecord record) {
      Level var5 = record.getLevel();
      int var6 = var5.intValue();
      String var7 = record.getMessage();
      if (var6 != Integer.MAX_VALUE) {
         if (var6 >= Level.SEVERE.intValue()) {
            this.severe(var7);
         } else if (var6 >= Level.WARNING.intValue()) {
            this.warn(var7);
         } else {
            this.info(var7);
         }

      }
   }

   private boolean e(String var1) {
      if (var1.equalsIgnoreCase(this.a())) {
         return false;
      } else {
         return var1.startsWith("intave") && var1.endsWith(".log");
      }
   }

   @Deprecated
   public void err(Throwable ex) {
      this.print("[Intave] Caught an " + ex.getClass().getSimpleName() + " exception");

      for(PrintStream var6 : this.streams) {
         ex.printStackTrace(var6);
      }

   }

   public void addStream(PrintStream stream) {
      this.streams.remove(stream);
   }

   private File[] b() {
      File var1 = new File(d);
      return var1.listFiles(this::a);
   }

   public Logger(IntavePlugin var1) {
      super(var1);
      l = this;
      this.i = var1;
      this.g = new Unknown308();
      this.h();
   }

   private synchronized void b(String var1) {
      if (c && this.i.r().exists()) {
         try {
            boolean var4 = false;
            if (this.h != null && System.currentTimeMillis() - this.b > 10000L) {
               if (!this.h.equalsIgnoreCase(this.a())) {
                  this.h();
                  this.h = this.a();
                  var4 = true;
               }

               this.b = System.currentTimeMillis();
            }

            var1 = var1.replace("\n", "\\n").replace("\r", "\\r");
            String var5 = "[" + LocalDateTime.now().format(m) + "] ";
            String var6 = ChatColor.stripColor(var1);
            BackgroundThreadingPool.submit(this::a);
            if (var4) {
               BackgroundThreadingPool.submit(this::e);
            }
         } catch (Exception var7) {
            var7.printStackTrace();
         }

      }
   }

   private void h() {
      this.h = this.a();

      try {
         File var3 = this.f();
         if (!var3.exists()) {
            var3.getParentFile().mkdirs();
            var3.createNewFile();
         }

         if (this.j != null) {
            this.j.close();
         }

         this.j = new PrintWriter(new BufferedWriter(new FileWriter(var3, true)));
      } catch (IOException var4) {
         throw new IllegalStateException("Unable to create log file " + this.h, var4);
      }
   }

   private boolean a(File var1, String var2) {
      return this.e(var2);
   }

   private void a(String var1, String var2) {
      this.j.println(var1 + var2);
      this.j.flush();
   }

   public void info(String var1) {
      String var5 = IntavePlugin.getPrefix() + var1;

      for(PrintStream var7 : this.streams) {
         var7.print(ChatColor.stripColor(var5));
      }

      if (f) {
         Bukkit.getLogger().info(ChatColor.stripColor(var5));
      } else {
         Bukkit.getConsoleSender().sendMessage(var5);
      }

      this.b("(INF) " + var1);
   }

   private File f() {
      return new File(d, this.h);
   }

   public void print(String var1) {
      for(PrintStream var3 : this.streams) {
         var3.print(var1);
      }

      Bukkit.getLogger().info(var1);
   }

   private File a(File var1) {
      String var4 = var1.getName();
      String var5 = var4.substring(0, var4.lastIndexOf(46)) + ".zip";
      return new File(var1.getParent(), var5);
   }

   private boolean i() {
      return true;
   }

   public void severe(String var1) {
      String var6 = IntavePlugin.getPrefix() + ChatColor.RED + "ERROR" + IntavePlugin.l() + ": " + var1;

      for(PrintStream var8 : this.streams) {
         var8.print(ChatColor.stripColor(var6));
      }

      if (f) {
         Bukkit.getLogger().warning(ChatColor.stripColor(var6));
      } else {
         Bukkit.getConsoleSender().sendMessage(var6);
      }

      this.b("(ERR) " + var1);
   }

   public void j() {
      if (ServerUtil.isProtocolLibLoaded()) {
         if (JavaUtil.getJavaVersion() > 8 && MinecraftVersion.V_1_16_2.atOrAbove()) {
            f = false;
         }

      }
   }

   public void warn(String var1) {
      String var4 = IntavePlugin.getPrefix() + ChatColor.RED + "WARN" + IntavePlugin.l() + ": " + var1;

      for(PrintStream var6 : this.streams) {
         var6.print(ChatColor.stripColor(var4));
      }

      if (f) {
         Bukkit.getLogger().warning(ChatColor.stripColor(var4));
      } else {
         Bukkit.getConsoleSender().sendMessage(var4);
      }

      this.b("(WARN) " + var1);
   }

   public void det(String value) {
      this.b("(DET) " + value);
   }

   private static Format c() {
      return new SimpleDateFormat("yyyy_MM_dd");
   }

   public synchronized void e() {
      File[] var4 = this.b();
      if (var4 != null && var4.length != 0) {
         HashMap var5 = new HashMap();

         for(File var9 : var4) {
            File var10 = this.a(var9);
            if (var9.exists() && !var10.exists()) {
               var5.put(var9, var10);
            }
         }

         for(Entry var12 : var5.entrySet()) {
            File var13 = (File)var12.getKey();
            File var14 = (File)var12.getValue();
            if (var13.exists() && !var14.exists()) {
               this.g.a(var13, var14);
               this.info("Compressed \"" + var13 + "\"");
            }
         }

      }
   }

   public void a(Object var1) {
      this.print(var1.toString());
   }

   public static Logger getLogger() {
      return l;
   }

   public void d() {
      if (this.j != null) {
         this.j.close();
      }

   }

   private String a() {
      String var3 = ((Format)k.get()).format(System.currentTimeMillis());
      return "intave" + var3 + ".log";
   }

   public void b(PrintStream var1) {
      this.streams.add(var1);
   }

   public void c(String var1) {
      var1 = ChatColor.stripColor(var1);
      this.print("[Intave] Issued server command /" + var1);
      this.b("(EXE) " + var1);
   }
}
