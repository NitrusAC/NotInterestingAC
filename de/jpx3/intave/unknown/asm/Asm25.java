package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown338;
import java.util.List;

public class Asm25 {
   public String e;
   public List f;
   public List a;
   public Asm19 b;
   public Asm19 c;
   public Asm19 d;

   public void a(Unknown338 var1) {
      var1.a(this.d.a(), this.b.a(), this.c == null ? null : this.c.a(), this.e);
      if (this.a != null) {
         int var2 = 0;

         for(int var3 = this.a.size(); var2 < var3; ++var2) {
            Asm22 var4 = (Asm22)this.a.get(var2);
            var4.a(var1.b(var4.g, var4.f, var4.e, true));
         }
      }

      if (this.f != null) {
         int var5 = 0;

         for(int var6 = this.f.size(); var5 < var6; ++var5) {
            Asm22 var7 = (Asm22)this.f.get(var5);
            var7.a(var1.b(var7.g, var7.f, var7.e, false));
         }
      }

   }

   public void a(int var1) {
      int var2 = 1107296256 | var1 << 8;
      if (this.a != null) {
         int var3 = 0;

         for(int var4 = this.a.size(); var3 < var4; ++var3) {
            ((Asm22)this.a.get(var3)).g = var2;
         }
      }

      if (this.f != null) {
         int var5 = 0;

         for(int var6 = this.f.size(); var5 < var6; ++var5) {
            ((Asm22)this.f.get(var5)).g = var2;
         }
      }

   }

   public Asm25(Asm19 var1, Asm19 var2, Asm19 var3, String var4) {
      this.d = var1;
      this.b = var2;
      this.c = var3;
      this.e = var4;
   }
}
