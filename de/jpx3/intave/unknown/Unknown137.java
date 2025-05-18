package de.jpx3.intave.unknown;

public final class Unknown137 {
   private boolean e;
   private int b;
   private String c;
   private String a;
   private String d;

   @Deprecated
   public Unknown137(int var1, String var2, String var3, String var4) {
      this(var1, var2, var3, var4, var1 == 9);
   }

   public String b() {
      return this.c;
   }

   public void a(int var1) {
      this.b = var1;
   }

   public void c(String var1) {
      this.d = var1;
   }

   public String a() {
      return this.a;
   }

   public String toString() {
      return this.c + '.' + this.a + this.d + " (" + this.b + (this.e ? " itf" : "") + ')';
   }

   public String d() {
      return this.d;
   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof Unknown137)) {
         return false;
      } else {
         Unknown137 var5 = (Unknown137)var1;
         return this.b == var5.b && this.e == var5.e && this.c.equals(var5.c) && this.a.equals(var5.a) && this.d.equals(var5.d);
      }
   }

   public void a(String var1) {
      this.c = var1;
   }

   public void a(boolean var1) {
      this.e = var1;
   }

   public Unknown137(int var1, String var2, String var3, String var4, boolean var5) {
      this.b = var1;
      this.c = var2;
      this.a = var3;
      this.d = var4;
      this.e = var5;
   }

   public boolean e() {
      return this.e;
   }

   public void b(String var1) {
      this.a = var1;
   }

   public int hashCode() {
      return this.b + (this.e ? 64 : 0) + this.c.hashCode() * this.a.hashCode() * this.d.hashCode();
   }

   public int c() {
      return this.b;
   }
}
