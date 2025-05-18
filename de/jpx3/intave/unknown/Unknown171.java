package de.jpx3.intave.unknown;

import org.bukkit.entity.Player;

public final class Unknown171 {
   private final Object f;
   private final long d;
   private final long b;
   private final Unknown340 e;
   private final short c;
   private final Unknown176 a;

   public short g() {
      return this.c;
   }

   void e() {
      if (this.e != null) {
         this.e.a(this);
      }

   }

   public void a(Player var1) {
      this.a.a(var1, this.f);
      if (this.e != null) {
         this.e.b(this);
      }

   }

   public long a() {
      return this.d;
   }

   public long b() {
      return this.b;
   }

   Object c() {
      return this.f;
   }

   public long d() {
      return System.currentTimeMillis() - this.d;
   }

   Unknown176 f() {
      return this.a;
   }

   Unknown171(Unknown176 var1, Unknown340 var2, Object var3, short var4, long var5) {
      this.a = var1;
      this.e = var2;
      this.f = var3;
      this.c = var4;
      this.b = var5;
      this.d = System.currentTimeMillis();
   }
}
