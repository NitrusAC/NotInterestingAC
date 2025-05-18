package de.jpx3.intave.unknown;

import de.jpx3.intave.f;
import de.jpx3.intave.kO;
import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.unknown.asm.Asm37;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Method;

public final class Unknown147 {
   private static Instrumentation a;
   private static Method b;

   static byte[] a(byte[] var0, String var1, String var2, Unknown62 var3) {
      return b(var0, var1, var2, var3);
   }

   public static Instrumentation b() {
      if (a == null && a()) {
         try {
            Class var3 = Class.forName("de.jpx3.intaveagent.IntaveAgent");
            Method var4 = var3.getMethod("universalInstrumentation");
            a = (Instrumentation)var4.invoke(null);
         } catch (Exception var5) {
            throw new IntaveInternalException(var5);
         }
      }

      return a;
   }

   private static byte[] b(byte[] var0, String var1, String var2, Unknown62 var3) {
      Asm37 var4 = new Asm37(var0);
      Unknown177 var5 = new Unknown177(var4, 0);
      var4.a(new Unknown178(458752, var5, var1, var2, var3), 8);
      return var5.a();
   }

   private static boolean a(Class var0) {
      return var0.getCanonicalName().startsWith("net.minecraft.server");
   }

   public static void b(Class var0) {
      if (!a()) {
         throw new UnsupportedOperationException();
      } else if (!a(var0)) {
         throw new IntaveInternalException("Can not redefine non-server class");
      } else {
         a(var0, new f(var0));
      }
   }

   static boolean b(String var0, String var1, String var2, String var3) {
      return a(var0, var1, var2, var3);
   }

   public static byte[] a(String var0) {
      try {
         if (b == null) {
            b = Class.forName("de.jpx3.intaveagent.IntaveAgent").getMethod("classBytesOfNMSClass", String.class);
         }

         var0 = var0.replace(".", "/");
         return (byte[])b.invoke(null, var0);
      } catch (Exception var5) {
         throw new IntaveInternalException(var5);
      }
   }

   public static boolean a() {
      try {
         Class.forName("de.jpx3.intaveagent.IntaveAgent");
         return true;
      } catch (ClassNotFoundException var3) {
         return false;
      }
   }

   public static void a(Class var0, String var1, String var2, Unknown62 var3) {
      if (!a()) {
         throw new UnsupportedOperationException();
      } else if (!a(var0)) {
         throw new IntaveInternalException("Can not redefine non-server class");
      } else {
         a(var0, new kO(var1, var2, var3));
      }
   }

   public static void a(Class var0, ClassFileTransformer var1) {
      if (a() && a(var0)) {
         try {
            byte[] var6 = var1.transform(ClassLoader.getSystemClassLoader(), var0.getCanonicalName(), var0, null, a(var0.getCanonicalName()));
            b().redefineClasses(new ClassDefinition[]{new ClassDefinition(var0, var6)});
         } catch (Exception var7) {
            throw new IntaveInternalException(var7);
         }
      } else {
         throw new UnsupportedOperationException();
      }
   }

   private static boolean a(String var0, String var1, String var2, String var3) {
      return var0.equalsIgnoreCase(var1) && var2.equalsIgnoreCase(var3);
   }
}
