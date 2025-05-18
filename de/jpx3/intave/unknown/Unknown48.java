package de.jpx3.intave.unknown;

import de.jpx3.intave.unknown.asm.Asm23;
import java.util.ArrayList;
import java.util.List;

public class Unknown48 extends Asm23 {
   public String e;
   public List a;

   Unknown48(List var1) {
      super(458752);
      this.a = var1;
   }

   public void a(Asm23 var1) {
      if (var1 != null) {
         if (this.a != null) {
            int var2 = 0;

            for(int var3 = this.a.size(); var2 < var3; var2 += 2) {
               String var4 = (String)this.a.get(var2);
               Object var5 = this.a.get(var2 + 1);
               a(var1, var4, var5);
            }
         }

         var1.c();
      }

   }

   @Override
   public Asm23 a(String var1, String var2) {
      if (this.a == null) {
         this.a = new ArrayList(this.e != null ? 2 : 1);
      }

      if (this.e != null) {
         this.a.add(var1);
      }

      Unknown48 var6 = new Unknown48(var2);
      this.a.add(var6);
      return var6;
   }

   @Override
   public Asm23 a(String var1) {
      if (this.a == null) {
         this.a = new ArrayList(this.e != null ? 2 : 1);
      }

      if (this.e != null) {
         this.a.add(var1);
      }

      ArrayList var5 = new ArrayList();
      this.a.add(var5);
      return new Unknown48(var5);
   }

   @Override
   public void c() {
   }

   @Override
   public void a(String var1, String var2, String var3) {
      if (this.a == null) {
         this.a = new ArrayList(this.e != null ? 2 : 1);
      }

      if (this.e != null) {
         this.a.add(var1);
      }

      this.a.add(new String[]{var2, var3});
   }

   @Override
   public void a(String var1, Object var2) {
      if (this.a == null) {
         this.a = new ArrayList(this.e != null ? 2 : 1);
      }

      if (this.e != null) {
         this.a.add(var1);
      }

      if (var2 instanceof byte[]) {
         this.a.add(Unknown372.a((byte[])var2));
      } else if (var2 instanceof boolean[]) {
         this.a.add(Unknown372.a((boolean[])var2));
      } else if (var2 instanceof short[]) {
         this.a.add(Unknown372.a((short[])var2));
      } else if (var2 instanceof char[]) {
         this.a.add(Unknown372.a((char[])var2));
      } else if (var2 instanceof int[]) {
         this.a.add(Unknown372.a((int[])var2));
      } else if (var2 instanceof long[]) {
         this.a.add(Unknown372.a((long[])var2));
      } else if (var2 instanceof float[]) {
         this.a.add(Unknown372.a((float[])var2));
      } else if (var2 instanceof double[]) {
         this.a.add(Unknown372.a((double[])var2));
      } else {
         this.a.add(var2);
      }

   }

   public Unknown48(String var1) {
      this(458752, var1);
      if (this.getClass() != Unknown48.class) {
         throw new IllegalStateException();
      }
   }

   public void a(int var1) {
   }

   public Unknown48(int var1, String var2) {
      super(var1);
      this.e = var2;
   }

   private static void b(Asm23 var0, Object var1) {
      a(var0, null, var1);
   }

   static void a(Asm23 var0, String var1, Object var2) {
      if (var0 != null) {
         if (var2 instanceof String[]) {
            String[] var3 = (String[])var2;
            var0.a(var1, var3[0], var3[1]);
         } else if (var2 instanceof Unknown48) {
            Unknown48 var5 = (Unknown48)var2;
            var5.a(var0.a(var1, var5.e));
         } else if (var2 instanceof List) {
            Asm23 var6 = var0.a(var1);
            if (var6 != null) {
               List var4 = (List)var2;
               var4.forEach(Unknown48::b);
               var6.c();
            }
         } else {
            var0.a(var1, var2);
         }
      }

   }
}
