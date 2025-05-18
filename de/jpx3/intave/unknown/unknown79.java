package de.jpx3.intave.unknown;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.anticheat.util.entity.TrackedEntity;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.DelayQueue;
import org.bukkit.entity.Player;

@Relocate
public final class unknown79 {
   public long p;
   private final Player I;
   public long u;
   public long t;
   public int c;
   private final DelayQueue g;
   public long G;
   public long f;
   public short w;
   public long A;
   public long y;
   private long C;
   public long i;
   public boolean l;
   private final Set B;
   public long m;
   public long k;
   private final Map q;
   private final List o;
   private final List F;
   private long H;
   public int a;
   public boolean J;
   private final List K;
   public long D;
   private final List E;
   private final Map v;
   public long e;
   public boolean n;
   public long d;
   private final Map j = Maps.newConcurrentMap();
   private final Deque b;
   private long z;
   private final Map r = Maps.newConcurrentMap();
   private final Map x = Maps.newConcurrentMap();
   public int h;
   public long s;

   public List e() {
      return this.F;
   }

   @Deprecated
   public Map d() {
      return this.v;
   }

   public TrackedEntity a(int var1) {
      return (TrackedEntity)this.v.get(var1);
   }

   public Map a() {
      return this.q;
   }

   public void b(int var1) {
      this.v.put(var1, TrackedEntity.l());
      this.B.remove(var1);
      this.E.removeIf(unknown79::b);
   }

   public void a(long var1) {
      this.C += Math.min(var1, 1000L);
      ++this.z;
      if (this.z > 16383L) {
         this.C /= 2L;
         this.z /= 2L;
      }

   }

   private static boolean b(int var0, TrackedEntity var1) {
      return var1.i() == var0;
   }

   public DelayQueue k() {
      return this.g;
   }

   public unknown79(Player var1) {
      this.v = Maps.newConcurrentMap();
      this.B = new HashSet();
      this.E = Lists.newCopyOnWriteArrayList();
      this.F = Lists.newCopyOnWriteArrayList();
      this.q = Maps.newConcurrentMap();
      this.K = Lists.newCopyOnWriteArrayList();
      this.A = 0L;
      this.J = false;
      this.n = false;
      this.a = 0;
      this.b = new ArrayDeque(8500);
      this.g = new DelayQueue();
      this.d = 0L;
      this.G = 0L;
      this.t = 0L;
      this.k = 0L;
      this.i = 0L;
      this.s = 0L;
      this.w = -32768;
      this.D = 0L;
      this.y = -1L;
      this.e = System.currentTimeMillis();
      this.m = 0L;
      this.o = new ArrayList();
      this.C = 0L;
      this.z = 0L;
      this.I = var1;
   }

   public Map g() {
      return this.x;
   }

   public Collection i() {
      return this.E;
   }

   public void a(TrackedEntity var1) {
      this.v.put(var1.i(), var1);
      this.B.add(var1.i());
      this.E.add(var1);
   }

   public Deque f() {
      return this.b;
   }

   public Map m() {
      return this.j;
   }

   public void c() {
      long var1 = System.currentTimeMillis();
      if (this.H != 0L) {
         long var3 = var1 - this.H;
         this.o.add(var3);
         if (this.o.size() > 3) {
            this.o.remove(0);
         }
      }

      this.H = var1;
   }

   public List o() {
      return this.K;
   }

   public long b() {
      return this.z == 0L ? 0L : this.C / this.z;
   }

   public long j() {
      return this.H;
   }

   public double n() {
      return this.a(this.o);
   }

   private double a(List var1) {
      double var2 = 0.0;

      for(Number var5 : var1) {
         var2 += var5.doubleValue();
      }

      return var2 == 0.0 ? 0.0 : var2 / (double)var1.size();
   }

   public Map h() {
      return this.r;
   }

   public Set l() {
      return this.B;
   }
}
