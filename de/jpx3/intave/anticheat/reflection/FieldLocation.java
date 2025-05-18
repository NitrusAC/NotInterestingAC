package de.jpx3.intave.anticheat.reflection;

import de.jpx3.intave.qd;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import de.jpx3.intave.unknown.Unknown100;
import de.jpx3.intave.unknown.Unknown337;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public final class FieldLocation extends Unknown100 {
   private final String c;
   private Reference d;
   private static final Reference e = new WeakReference(null);
   private final String f;

   public String c() {
      return this.c;
   }

   public String d() {
      return this.f;
   }

   @Override
   public String b() {
      return super.b();
   }

   @Override
   public Unknown337 a() {
      return super.a();
   }

   public static FieldLocation a(String var0, String var1) {
      return new FieldLocation(var0, var1, Unknown337.a(), var1);
   }

   public FieldLocation(String var1, String var2, Unknown337 var3, String var4) {
      super(var2, var3);
      this.d = e;
      this.f = var1;
      this.c = var4;
   }

   public String toString() {
      return "FieldLocation{" + this.f + "/" + this.b() + " -> " + this.c + " @" + this.a() + "}";
   }

   public Field a() {
      Field var1 = (Field)this.d.get();
      if (var1 == null) {
         var1 = this.e();
         this.d = new WeakReference(var1);
      }

      return var1;
   }

   private Field e() {
      try {
         Class var10000 = ReflectionUtil.getClazz(this.f);
         String var10001 = this.c;
         Field var1 = var10000.getDeclaredField(qd.c(var10000, this.c));
         if (!var1.isAccessible()) {
            var1.setAccessible(true);
         }

         return var1;
      } catch (Exception var2) {
         throw new IllegalStateException(var2);
      }
   }
}
