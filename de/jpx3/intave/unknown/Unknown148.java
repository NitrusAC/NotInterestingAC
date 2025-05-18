package de.jpx3.intave.unknown;

import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.comphenix.protocol.wrappers.EnumWrappers.NativeGameMode;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import de.jpx3.intave.F;
import de.jpx3.intave.b;
import de.jpx3.intave.c7;
import de.jpx3.intave.cX;
import de.jpx3.intave.cZ;
import de.jpx3.intave.ct;
import de.jpx3.intave.cu;
import de.jpx3.intave.kG;
import de.jpx3.intave.nE;
import de.jpx3.intave.nK;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.data.PlayerData;
import de.jpx3.intave.anticheat.data.PlayerDataManager;
import de.jpx3.intave.anticheat.data.holder.PlayerHolder;
import de.jpx3.intave.anticheat.threading.IntaveScheduler;
import de.jpx3.intave.anticheat.unknown.MoudleLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public final class Unknown148 extends Unknown118 {
   private final int p;
   private final WrappedGameProfile z;
   private final Player E;
   private static final int r = 25;
   public static final float v = 20.0F;
   private int y;
   private static final IntavePlugin q = IntavePlugin.getInstance();
   private final PlayerData s;
   private final F F;
   private final Consumer A;
   public double D = 0.0;
   public long u;
   private final Map C;
   private int t;
   private int B;
   private long w;
   private final NativeGameMode x;
   private static final double o = 3.5;

   public NativeGameMode o() {
      return this.x;
   }

   @Override
   public void a(Location var1, boolean var2) {
      super.a(var1, var2);
      this.F.a(var1);
      MoudleLoader.m().a(this.E, var1, Unknown148::c, Unknown228.c);
   }

   public void f(Location var1) {
      if (!this.b(this::e)) {
         Preconditions.checkNotNull(var1);
         this.F.s = var1;
         this.F.l = (this.F.b() + this.F.i()) / 2.0;
         this.c(var1);
         this.g();
         kG.a(this.e(), this, 20.0F);
         this.c();
         this.b();
         this.j();
      }
   }

   public void r() {
      this.a(nE.a(this.E.getLocation(), ThreadLocalRandom.current().nextDouble(10.0)));
   }

   public void i() {
      Bukkit.getScheduler().cancelTask(this.t);
      Unknown22.b(this.t);
   }

   private static void b(Player var0, Location var1) {
      PlayerData var2 = PlayerDataManager.getPlayerData(var0);
      PlayerHolder var3 = var2.getStorage().getPlayerHolder();
      var3.e = var1.getX();
      var3.h = var1.getY();
      var3.f = var1.getZ();
   }

   private Map f() {
      ArrayList var4 = Lists.newArrayList(new ct[]{new c7(this.E, this), new cX(this.E, this)});
      if (nK.a(this.p, nK.c)) {
         var4.add(new cZ(this.E, this));
      }

      if (nK.a(this.p, nK.d)) {
         var4.add(new cu(this.E, this));
      }

      HashMap var5 = new HashMap();

      for(ct var7 : var4) {
         var5.put(var7.getClass(), var7);
      }

      return var5;
   }

   public void p() {
      this.F.z = System.currentTimeMillis();
   }

   private void g() {
      int var4 = this.f();
      if (nK.a(var4, nK.d)) {
         this.a(cu.class);
      }

      if (nK.a(var4, nK.c)) {
         this.a(cZ.class);
      }

   }

   @Override
   public void d(boolean var1) {
      super.d(var1);
      this.F.m = var1;
   }

   @Override
   public void a(Location var1, Location var2, boolean var3) {
      super.a(var1, var2, var3);
      MoudleLoader.m().a(this.E, var1, Unknown148::b, Unknown228.c);
   }

   @Override
   public WrappedGameProfile c() {
      return this.z;
   }

   Unknown148(F var1, Player var2, WrappedGameProfile var3, String var4, String var5, int var6, int var7, Consumer var8) {
      super(var2, var6, var7, var3, var4, var5);
      this.y = 0;
      this.B = 0;
      this.s = PlayerDataManager.getPlayerData(var2);
      this.F = var1;
      this.z = var3;
      this.E = var2;
      this.p = var7;
      this.C = this.f();
      this.A = var8;
      this.x = NativeGameMode.SURVIVAL;
      this.s.getStorage().getPlayerHolder().a(this);
   }

   @Override
   public void a(boolean var1) {
      super.a(var1);
      this.F.k = var1;
   }

   private void k() {
      if (this.D > 0.0) {
         this.D -= 0.1;
      }

   }

   public boolean b(Location var1, Location var2) {
      if (var1.getWorld() != var2.getWorld()) {
         return true;
      } else {
         return this.b(var1, var2) > 3.5;
      }
   }

   public static b a(Player var0) {
      return new b(var0);
   }

   public Consumer h() {
      return this.A;
   }

   public void a(Class var1) {
      ct var5 = (ct)this.C.get(var1);
      if (var5 != null) {
         IntaveScheduler.runTask(var5::b);
      }

   }

   private void m() {
      this.F.b(this.E.getLocation());
      Location var4 = this.F.s;
      Location var5 = this.F.A;
      if (var5 != null) {
         boolean var6 = this.b(var4, var5);
         boolean var7 = this.F.u;
         if (var6) {
            this.a(var4, var7);
         } else {
            this.a(var4, var5, var7);
         }
      }

   }

   private void a() {
      for(ct var5 : this.C.values()) {
         var5.c();
      }

   }

   public int l() {
      if (this.y == 0) {
         int var6 = ThreadLocalRandom.current().nextInt(20, 250);
         this.y = var6;
         return var6;
      } else {
         int var4 = ThreadLocalRandom.current().nextInt(this.y - 25, this.y + 25);
         int var5 = Math.max(25, var4);
         this.y = var5;
         return var5;
      }
   }

   private void e(Location var1) {
      this.f(var1);
   }

   public void e() {
      ++this.B;

      try {
         this.a();
         this.m();
         this.k();
         double var4 = this.F.h();
         double var6 = this.F.a(this.E);
         this.d(var4 > 0.0 && !this.F.k);
         if (var4 < 0.5 && var6 < 9.0 && this.B != 0) {
            if (ThreadLocalRandom.current().nextInt(1, 10) % 5 == 0 && this.B % 250 == 0) {
               this.a(true);
            }
         } else if (var4 > 1.0) {
            this.a(false);
         }

         if (this.B % 5 == 0 && var4 > 0.0 && this.F.u) {
            this.b(this.F.s);
         }
      } catch (Exception var8) {
         System.out.println(var8.getClass().getSimpleName() + " occurred in tick #" + this.B + " of # " + this.a());
         var8.printStackTrace();
      }

   }

   public void a(double var1, double var3, double var5) {
      this.F.y = true;
      this.F.n = var1 * 4.0;
      this.F.w = var3;
      this.F.i = var5 * 4.0;
   }

   public void n() {
      this.F.f();
      if (System.currentTimeMillis() - this.w > 500L) {
         this.a(cX.class);
         this.w = System.currentTimeMillis();
      }

   }

   public F b() {
      return this.F;
   }

   public void q() {
      if (!this.b(this::q)) {
         this.i();
         this.d();
         this.s.getStorage().getPlayerHolder().a(null);
      }
   }

   public void j() {
      this.t = Bukkit.getScheduler().scheduleAsyncRepeatingTask(q, this::e, 0L, 1L);
      Unknown22.a(this.t);
   }

   private boolean b(Runnable var1) {
      if (Bukkit.isPrimaryThread()) {
         return false;
      } else {
         IntaveScheduler.runTask(var1);
         return true;
      }
   }

   private static void c(Player var0, Location var1) {
      PlayerData var2 = PlayerDataManager.getPlayerData(var0);
      PlayerHolder var3 = var2.getStorage().getPlayerHolder();
      var3.e = var1.getX();
      var3.h = var1.getY();
      var3.f = var1.getZ();
   }
}
