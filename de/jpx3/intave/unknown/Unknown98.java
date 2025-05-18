package de.jpx3.intave.unknown;

import de.jpx3.intave.qd;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Unknown98 extends Unknown100 {
   private static final Pattern c = Pattern.compile("R([a-z]|[A-Z]|[0-9]|\\$)+;");
   private final String g;
   private static final Reference d = new WeakReference(null);
   private final String e;
   private Reference f = d;

   public Method g() {
      Method var4 = (Method)this.f.get();
      if (var4 == null) {
         var4 = this.d();
         this.f = new WeakReference(var4);
      }

      return var4;
   }

   @Override
   public Unknown337 a() {
      return super.a();
   }

   private Method d() {
      String var4 = this.b();
      String var5 = this.e;
      String var6 = this.a(var4);
      String var7 = this.a(var5);
      if (!var6.equals(var7)) {
         throw new IllegalStateException("Signatures differ: " + var6 + " != " + var7);
      } else {
         Class var8 = ReflectionUtil.getClazz(this.f());
         Unknown357[] var9 = Unknown357.e(var7);
         Class[] var10 = (Class[])Arrays.stream(var9).map(this::a).toArray(Unknown98::b);

         try {
            return var8.getMethod(qd.b(this.b(var5), var8, var10), var10);
         } catch (NoSuchMethodException var12) {
            throw new IllegalStateException(var12);
         }
      }
   }

   public String toString() {
      return "MethodLocation{" + this.g + "." + this.b() + "/" + this.e() + " -> " + this.e + " @" + this.a() + "}";
   }

   public String c() {
      return this.a(this.e);
   }

   public String a() {
      return this.b(this.e);
   }

   public String f() {
      return this.g;
   }

   private Class c(String var1) {
      try {
         return Class.forName(qd.a(var1));
      } catch (ClassNotFoundException var3) {
         throw new IllegalStateException(var3);
      }
   }

   public static Unknown98 a(String var0, String var1) {
      return new Unknown98(var0, var1, Unknown337.a(80, 170), var1);
   }

   @Override
   public String b() {
      return super.b();
   }

   private Class a(Unknown357 var1) {
      return this.c(var1.d());
   }

   private static Class[] b(int var0) {
      return new Class[var0];
   }

   public Unknown98(String var1, String var2, Unknown337 var3, String var4) {
      super(var2, var3);
      this.g = var1;
      this.e = var4;
   }

   private String a(String var1) {
      String var5 = var1.substring(var1.indexOf("("));
      Matcher var6 = c.matcher(var5);

      for(int var7 = 0; var6.find(var7); var6 = c.matcher(var5)) {
         int var8 = var6.start();
         int var9 = var6.end();
         String var10 = var5.substring(var8 + 1, var9 - 1);
         Class var11 = ReflectionUtil.getClazz(var10);
         String var12 = "L" + var11.getName().replace(".", "/") + ";";
         var5 = var5.substring(0, var8) + var12 + var5.substring(var9);
         var7 = var8 + var12.length();
      }

      return var5;
   }

   private String b(String var1) {
      return var1.substring(0, var1.indexOf("("));
   }

   public String e() {
      return this.b(this.b()) + this.a(this.b());
   }
}
