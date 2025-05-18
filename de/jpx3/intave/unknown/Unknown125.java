package de.jpx3.intave.unknown;

import de.jpx3.intave.unknown.what.What1;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.bukkit.ChatColor;

public class Unknown125 implements Cloneable, Comparable {
   private final Unknown108 a;
   private final String f;
   private final String b;
   private final ThreadLocal e;
   private Unknown207 c = Unknown207.a;

   public boolean k() {
      return this.c == Unknown207.c;
   }

   public long getCalls() {
      return this.a.a();
   }

   public String getName() {
      return this.f;
   }

   public boolean u() {
      return this.c == Unknown207.b;
   }

   public Object clone() {
      return this.d();
   }

   public void g() {
      long var4 = m();
      this.a.a(var4 - this.e.get());
      this.a.d();
   }

   public static Unknown125 a(String var0, String var1) {
      Unknown125 var2 = new Unknown125(var0, var1);
      What1.a(var2);
      return var2;
   }

   private static String b(String var0) {
      return var0 + "/";
   }

   public String o() {
      String var5 = this.getName();
      List var6 = (List)Arrays.stream(var5.split("/")).collect(Collectors.toList());
      int var7 = 0;

      for(int var8 = var6.size(); var7 < var8; ++var7) {
         String var9 = (String)var6.get(var7);
         ChatColor var10 = (ChatColor)What1.a.get(var9);
         if (var10 != null) {
            var9 = var10 + var9 + ChatColor.WHITE;
         }

         var6.set(var7, var9);
      }

      String var11 = (String)var6.stream().map(Unknown125::b).collect(Collectors.joining());
      return var11.substring(0, var11.length() - 1);
   }

   public static Unknown125 a(String var0) {
      Unknown125 var1 = new Unknown125(var0, null);
      What1.a(var1);
      return var1;
   }

   public int a(Unknown125 var1) {
      return Long.compare(var1.getTotalNs(), this.getTotalNs());
   }

   public double t() {
      return this.b() / (double)Math.max(1L, this.getCalls());
   }

   public int compareTo(Object var1) {
      return this.a((Unknown125)var1);
   }

   public double c() {
      return (double)this.getTotalNs() / Math.max(1.0, (double)this.getCalls());
   }

   public double b() {
      return (double)this.getTotalNs() / 1000000.0;
   }

   public double n() {
      return this.t() / 50.0;
   }

   public long getTotalNs() {
      return this.a.b();
   }

   public void p() {
      this.c = Unknown207.b;
   }

   public void j() {
      this.c = Unknown207.c;
   }

   private static Long f() {
      return 0L;
   }

   public void h() {
      this.e.set(m());
   }

   private Unknown125(String var1, String var2) {
      this.a = new Unknown108();
      this.e = ThreadLocal.withInitial(Unknown125::f);
      this.f = var1;
      this.b = var2;
   }

   public String q() {
      return this.b;
   }

   public Unknown125 i() {
      return this.b == null ? null : What1.c(this.b);
   }

   public Unknown125 d() {
      try {
         return (Unknown125)super.clone();
      } catch (CloneNotSupportedException var2) {
         throw new IllegalStateException(var2);
      }
   }

   private static long m() {
      return System.nanoTime();
   }
}
