package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown338;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Asm1 {
   public int t;
   public static final int d = 14;
   public static final int x = 11;
   public static final int p = 8;
   public Asm1 e;
   public static final int f = 3;
   public static final int j = 5;
   public int w;
   public List n;
   public static final int m = 13;
   public List c;
   public static final int i = 2;
   public List b;
   public static final int g = 15;
   public static final int a = 10;
   public static final int l = 7;
   public Asm1 k;
   public static final int r = 1;
   public static final int o = 12;
   public static final int s = 4;
   public static final int u = 0;
   public static final int h = 9;
   public static final int q = 6;

   public abstract Asm1 a(Map var1);

   protected final void visit(Unknown338 var1) {
      if (this.b != null) {
         for(Asm22 var6 : this.b) {
            var6.a(var1.a(var6.g, var6.f, var6.e, true));
         }
      }

      if (this.c != null) {
         for(Asm22 var8 : this.c) {
            var8.a(var1.a(var8.g, var8.f, var8.e, false));
         }
      }

   }

   public abstract int d();

   protected final Asm1 a(Asm1 var1) {
      if (var1.b != null) {
         this.b = new ArrayList();
         int var5 = 0;

         for(int var6 = var1.b.size(); var5 < var6; ++var5) {
            Asm22 var7 = (Asm22)var1.b.get(var5);
            Asm22 var8 = new Asm22(var7.g, var7.f, var7.e);
            var7.a(var8);
            this.b.add(var8);
         }
      }

      if (var1.c != null) {
         this.c = new ArrayList();
         int var9 = 0;

         for(int var10 = var1.c.size(); var9 < var10; ++var9) {
            Asm22 var11 = (Asm22)var1.c.get(var9);
            Asm22 var12 = new Asm22(var11.g, var11.f, var11.e);
            var11.a(var12);
            this.c.add(var12);
         }
      }

      return this;
   }

   static Asm19[] a(List var0, Map var1) {
      Asm19[] var5 = new Asm19[var0.size()];
      int var6 = 0;

      for(int var7 = var5.length; var6 < var7; ++var6) {
         var5[var6] = (Asm19)var1.get(var0.get(var6));
      }

      return var5;
   }

   public int g() {
      return this.w;
   }

   public void a(String var1) {
      if (this.n == null) {
         this.n = new ArrayList();
      }

      this.n.add(var1);
   }

   public abstract void accept(Unknown338 var1);

   public Asm1 c() {
      return this.k;
   }

   protected Asm1(int var1) {
      this.w = var1;
      this.t = -1;
   }

   public Asm1 f() {
      return this.e;
   }

   public static Asm19 a(Asm19 var0, Map var1) {
      return (Asm19)var1.get(var0);
   }
}
