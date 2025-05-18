package de.jpx3.intave.unknown;

import de.jpx3.intave.qd;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Unknown234 {
   private boolean d;
   private Unknown357[] b;
   private Unknown357 a;
   private final Class c;
   private boolean e;

   private MethodHandle a(Method var1) {
      try {
         Lookup var2 = this.d ? MethodHandles.publicLookup() : MethodHandles.lookup();
         MethodType var3 = MethodType.methodType(var1.getReturnType(), var1.getParameterTypes());
         Class var10001 = this.c;
         return var2.findVirtual(this.c, qd.b(var1.getName(), var10001, var3.parameterArray()), var3);
      } catch (IllegalAccessException | NoSuchMethodException var4) {
         throw new IllegalStateException(var4);
      }
   }

   public Unknown234 a(Class[] var1) {
      Unknown357[] var2 = new Unknown357[var1.length];

      for(int var3 = 0; var3 < var1.length; ++var3) {
         Class var4 = var1[var3];
         var2[var3] = Unknown357.c(var4);
      }

      this.b = var2;
      return this;
   }

   public Unknown267 a() {
      if (this.c == null) {
         throw new IllegalStateException();
      } else {
         if (this.b == null) {
            this.b = new Unknown357[0];
         }

         if (this.a == null) {
            this.a = Unknown357.b;
         }

         ArrayList var3 = new ArrayList();
         Unknown357 var4 = Unknown357.b(this.a, this.b);

         for(Method var8 : this.c.getDeclaredMethods()) {
            if (Unknown357.b(var8).equals(var4)) {
               var3.add(this.a(var8));
            }
         }

         if (var3.isEmpty() && this.e) {
            throw new IllegalStateException("Method pattern " + var4 + " does not apply to any methods in " + this.c);
         } else {
            return new Unknown267((MethodHandle[])var3.toArray(new MethodHandle[0]));
         }
      }
   }

   public Unknown234(Class var1) {
      this.c = var1;
   }

   @Deprecated
   public Unknown234 b() {
      this.d = true;
      return this;
   }

   public Unknown234 c() {
      this.e = true;
      return this;
   }

   public Unknown234 a(Class var1) {
      this.a = Unknown357.c(var1);
      return this;
   }
}
