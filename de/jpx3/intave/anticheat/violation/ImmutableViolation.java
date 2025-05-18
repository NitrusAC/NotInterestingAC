package de.jpx3.intave.anticheat.violation;

import com.google.common.collect.ImmutableList;
import de.jpx3.intave.unknown.Unknown37;
import de.jpx3.intave.unknown.Unknown99;
import java.util.ArrayList;
import java.util.List;

public final class ImmutableViolation {
   private boolean e;
   private boolean a;
   private List c = new ArrayList();
   private double b;
   private boolean i;
   private double h;
   private final Violation d;
   private String g;
   private double f;

   public void c(double var1) {
      if (this.i) {
         throw new UnsupportedOperationException();
      } else {
         this.b = var1;
      }
   }

   public void a(double var1) {
      if (this.i) {
         throw new UnsupportedOperationException();
      } else {
         this.f = var1;
      }
   }

   public boolean f() {
      return this.a;
   }

   public Unknown37 a(Unknown99 var1) {
      boolean var2 = var1 == Unknown99.a;
      return new Unknown37(this.d.getCheck().k(), this.d.l(), var2 ? this.d.h() : "", this.h, this.f);
   }

   public void b(String var1) {
      if (this.i) {
         throw new UnsupportedOperationException();
      } else {
         this.c.add(var1);
      }
   }

   public double j() {
      return this.f;
   }

   public void a(boolean var1) {
      if (this.i) {
         throw new UnsupportedOperationException();
      } else {
         this.a = var1;
      }
   }

   public Violation l() {
      return this.d;
   }

   public void b(double var1) {
      if (this.i) {
         throw new UnsupportedOperationException();
      } else {
         this.h = var1;
      }
   }

   public ImmutableViolation h() {
      this.i = true;
      this.c = ImmutableList.copyOf(this.c);
      return this;
   }

   public List g() {
      return this.c;
   }

   public ImmutableViolation k() {
      if (this.i) {
         throw new UnsupportedOperationException();
      } else {
         this.e = true;
         return this;
      }
   }

   public ImmutableViolation a(String var1) {
      if (this.i) {
         throw new UnsupportedOperationException();
      } else {
         this.g = var1;
         return this.i();
      }
   }

   public void a(List var1) {
      if (this.i) {
         throw new UnsupportedOperationException();
      } else {
         this.c = var1;
      }
   }

   public boolean e() {
      return this.f > this.b;
   }

   public boolean a() {
      return this.i;
   }

   public String d() {
      return this.g;
   }

   private ImmutableViolation(Violation var1) {
      this.d = var1;
   }

   public double c() {
      return this.b;
   }

   public double b() {
      return this.h;
   }

   public ImmutableViolation c(String var1) {
      if (this.i) {
         throw new UnsupportedOperationException();
      } else {
         this.g = var1;
         return this.k();
      }
   }

   public ImmutableViolation i() {
      if (this.i) {
         throw new UnsupportedOperationException();
      } else {
         this.e = false;
         return this;
      }
   }

   public boolean m() {
      return this.e;
   }

   public static ImmutableViolation a(Violation var0) {
      return new ImmutableViolation(var0);
   }
}
