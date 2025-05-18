package de.jpx3.intave.anticheat.reflection;

import de.jpx3.intave.qd;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import de.jpx3.intave.unknown.Unknown100;
import de.jpx3.intave.unknown.Unknown337;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class ClassLocation extends Unknown100 {
   private static final Reference d = new WeakReference(null);
   private final String c;
   private Reference e = d;

   private Class b() {
      try {
         return Class.forName(qd.a(this.a()));
      } catch (ClassNotFoundException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public ClassLocation(String var1, Unknown337 var2, String var3) {
      super(var1, var2);
      this.c = var3;
   }

   @Override
   public Unknown337 a() {
      return super.a();
   }

   public String a() {
      return this.c.replace("{version}", ReflectionUtil.getCBVersion());
   }

   public String toString() {
      return "ClassLocation{" + this.b() + " -> " + this.a() + '}';
   }

   public Class c() {
      Class var1 = (Class)this.e.get();
      if (var1 == null) {
         var1 = this.b();
         this.e = new WeakReference(var1);
      }

      return var1;
   }

   @Override
   public String b() {
      return super.b();
   }

   public static ClassLocation a(String var0) {
      return new ClassLocation(var0, Unknown337.a(80, 169), "net.minecraft.server.{version}." + var0);
   }
}
