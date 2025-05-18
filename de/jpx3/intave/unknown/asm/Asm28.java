package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown338;
import de.jpx3.intave.unknown.Unknown371;
import java.util.Iterator;
import java.util.ListIterator;

public class Asm28 implements Iterable {
   public Asm1[] a;
   private int d;
   private Asm1 c;
   private Asm1 b;

   public void b(Asm28 var1) {
      if (var1.d != 0) {
         this.d += var1.d;
         if (this.b == null) {
            this.c = var1.c;
            this.b = var1.b;
         } else {
            Asm1 var5 = var1.c;
            this.b.e = var5;
            var5.k = this.b;
            this.b = var1.b;
         }

         this.a = null;
         var1.a(false);
      }
   }

   public Asm1[] f() {
      int var1 = 0;
      Asm1 var2 = this.c;

      Asm1[] var3;
      for(var3 = new Asm1[this.d]; var2 != null; var2 = var2.e) {
         var3[var1] = var2;
         var2.t = var1++;
      }

      return var3;
   }

   public void b(Asm1 var1, Asm1 var2) {
      Asm1 var6 = var1.e;
      var2.e = var6;
      if (var6 != null) {
         var6.k = var2;
      } else {
         this.b = var2;
      }

      Asm1 var7 = var1.k;
      var2.k = var7;
      if (var7 != null) {
         var7.e = var2;
      } else {
         this.c = var2;
      }

      if (this.a != null) {
         int var8 = var1.t;
         this.a[var8] = var2;
         var2.t = var8;
      } else {
         var2.t = 0;
      }

      var1.t = -1;
      var1.k = null;
      var1.e = null;
   }

   public void a() {
      this.a(false);
   }

   public void a(Asm1 var1, Asm28 var2) {
      if (var2.d != 0) {
         this.d += var2.d;
         Asm1 var6 = var2.c;
         Asm1 var7 = var2.b;
         Asm1 var8 = var1.e;
         if (var8 == null) {
            this.b = var7;
         } else {
            var8.k = var7;
         }

         var1.e = var6;
         var7.e = var8;
         var6.k = var1;
         this.a = null;
         var2.a(false);
      }
   }

   public void b(Asm1 var1) {
      ++this.d;
      if (this.c == null) {
         this.c = var1;
         this.b = var1;
      } else {
         this.c.k = var1;
         var1.e = this.c;
      }

      this.c = var1;
      this.a = null;
      var1.t = 0;
   }

   void a(boolean var1) {
      Asm1 var6;
      if (var1) {
         for(Asm1 var5 = this.c; var5 != null; var5 = var6) {
            var6 = var5.e;
            var5.t = -1;
            var5.k = null;
            var5.e = null;
         }
      }

      this.d = 0;
      this.c = null;
      this.b = null;
      this.a = null;
   }

   public Asm1 d() {
      return this.b;
   }

   public void a(Asm28 var1) {
      if (var1.d != 0) {
         this.d += var1.d;
         if (this.c == null) {
            this.c = var1.c;
            this.b = var1.b;
         } else {
            Asm1 var5 = var1.b;
            this.c.k = var5;
            var5.e = this.c;
            this.c = var1.c;
         }

         this.a = null;
         var1.a(false);
      }
   }

   public void a(Asm1 var1, Asm1 var2) {
      ++this.d;
      Asm1 var6 = var1.e;
      if (var6 == null) {
         this.b = var2;
      } else {
         var6.k = var2;
      }

      var1.e = var2;
      var2.e = var6;
      var2.k = var1;
      this.a = null;
      var2.t = 0;
   }

   public void b() {
      for(Asm1 var1 = this.c; var1 != null; var1 = var1.e) {
         if (var1 instanceof Asm19) {
            ((Asm19)var1).b();
         }
      }

   }

   public int g() {
      return this.d;
   }

   public int e(Asm1 var1) {
      if (this.a == null) {
         this.a = this.f();
      }

      return var1.t;
   }

   public void d(Asm1 var1) {
      --this.d;
      Asm1 var5 = var1.e;
      Asm1 var6 = var1.k;
      if (var5 == null) {
         if (var6 == null) {
            this.c = null;
            this.b = null;
         } else {
            var6.e = null;
            this.b = var6;
         }
      } else if (var6 == null) {
         this.c = var5;
         var5.k = null;
      } else {
         var6.e = var5;
         var5.k = var6;
      }

      this.a = null;
      var1.t = -1;
      var1.k = null;
      var1.e = null;
   }

   public Asm1 a(int var1) {
      if (var1 >= 0 && var1 < this.d) {
         if (this.a == null) {
            this.a = this.f();
         }

         return this.a[var1];
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public Asm1 c() {
      return this.c;
   }

   public Iterator iterator() {
      return this.e();
   }

   public boolean c(Asm1 var1) {
      Asm1 var5 = this.c;

      while(var5 != null && var5 != var1) {
         var5 = var5.e;
      }

      return var5 != null;
   }

   public void c(Asm1 var1, Asm1 var2) {
      ++this.d;
      Asm1 var6 = var1.k;
      if (var6 == null) {
         this.c = var2;
      } else {
         var6.e = var2;
      }

      var1.k = var2;
      var2.e = var1;
      var2.k = var6;
      this.a = null;
      var2.t = 0;
   }

   public void a(Asm1 var1) {
      ++this.d;
      if (this.b == null) {
         this.c = var1;
         this.b = var1;
      } else {
         this.b.e = var1;
         var1.k = this.b;
      }

      this.b = var1;
      this.a = null;
      var1.t = 0;
   }

   public void a(Unknown338 var1) {
      for(Asm1 var2 = this.c; var2 != null; var2 = var2.e) {
         var2.accept(var1);
      }

   }

   public ListIterator b(int var1) {
      return new Unknown371(this, var1);
   }

   public ListIterator e() {
      return this.b(0);
   }

   public void b(Asm1 var1, Asm28 var2) {
      if (var2.d != 0) {
         this.d += var2.d;
         Asm1 var6 = var2.c;
         Asm1 var7 = var2.b;
         Asm1 var8 = var1.k;
         if (var8 == null) {
            this.c = var6;
         } else {
            var8.e = var6;
         }

         var1.k = var7;
         var7.e = var1;
         var6.k = var8;
         this.a = null;
         var2.a(false);
      }
   }
}
