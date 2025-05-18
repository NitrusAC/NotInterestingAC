package de.jpx3.intave.unknown.asm;

import de.jpx3.intave.unknown.Unknown186;
import de.jpx3.intave.unknown.Unknown246;
import de.jpx3.intave.unknown.Unknown338;
import de.jpx3.intave.unknown.Unknown372;
import java.util.List;

public class Asm21 extends Asm22 {
   public List h;
   public List j;
   public List i;

   public void a(Unknown338 var1, boolean var2) {
      Unknown246[] var3 = new Unknown246[this.i.size()];
      Unknown246[] var4 = new Unknown246[this.h.size()];
      int[] var5 = new int[this.j.size()];
      int var6 = 0;

      for(int var7 = var3.length; var6 < var7; ++var6) {
         var3[var6] = ((Asm19)this.i.get(var6)).a();
         var4[var6] = ((Asm19)this.h.get(var6)).a();
         var5[var6] = this.j.get(var6);
      }

      this.a(var1.a(this.g, this.f, var3, var4, var5, this.e, var2));
   }

   public Asm21(int var1, int var2, Unknown186 var3, Asm19[] var4, Asm19[] var5, int[] var6, String var7) {
      super(var1, var2, var3, var7);
      this.i = Unknown372.a((Object[])var4);
      this.h = Unknown372.a((Object[])var5);
      this.j = Unknown372.a(var6);
   }

   public Asm21(int var1, Unknown186 var2, Asm19[] var3, Asm19[] var4, int[] var5, String var6) {
      this(458752, var1, var2, var3, var4, var5, var6);
   }
}
