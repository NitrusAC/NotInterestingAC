package de.jpx3.intave.unknown;

import com.google.common.collect.Maps;
import de.jpx3.intave.pB;
import de.jpx3.intave.access.server.ServerHealthStatisticAccess;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.util.TPSUtil;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleConsumer;

public final class Unknown87 {
   private final Map c = Maps.newConcurrentMap();
   private ServerHealthStatisticAccess e;
   private int a;
   private final IntavePlugin plugin;

   static Map a(Unknown87 var0) {
      return var0.c;
   }

   private void e() {
      this.a = this.plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(this.plugin, this::b, 20L, 100L);
      Unknown86.b(this::g);
   }

   private double b(ServerHealthStatisticAccess.TimeSpan var1) {
      return TPSUtil.c()[this.a(var1)];
   }

   static double a(Unknown87 var0, ServerHealthStatisticAccess.TimeSpan var1) {
      return var0.b(var1);
   }

   private void b() {
      this.c.forEach(this::a);
   }

   public synchronized ServerHealthStatisticAccess c() {
      if (this.e == null) {
         this.e = this.d();
         this.e();
      }

      return this.e;
   }

   public void g() {
      if (this.a > 0 && this.e != null) {
         this.plugin.getServer().getScheduler().cancelTask(this.a);
      }

   }

   private ServerHealthStatisticAccess d() {
      return new pB(this);
   }

   public Unknown87(IntavePlugin var1) {
      this.plugin = var1;
   }

   private void a(ServerHealthStatisticAccess.TimeSpan var1, List var2) {
      double var6 = this.b(var1);

      for(DoubleConsumer var9 : var2) {
         var9.accept(var6);
      }

   }

   private int a(ServerHealthStatisticAccess.TimeSpan var1) {
      return var1.ordinal();
   }
}
