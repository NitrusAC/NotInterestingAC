package de.jpx3.intave.unknown;

import com.comphenix.protocol.reflect.EquivalentConverter;
import de.jpx3.intave.anticheat.packet.wrap.converter.PlayerInfoDataConverter;
import java.lang.reflect.Constructor;

public final class Unknown225 {
   private static Class c;
   private static Constructor b;
   private static Class a;
   private static Class d;
   private static final ThreadLocal e = ThreadLocal.withInitial(Unknown225::c);

   public static Class e() {
      return d;
   }

   public static EquivalentConverter f() {
      return (EquivalentConverter)e.get();
   }

   public static Class b(Class var0) {
      d = var0;
      return var0;
   }

   public static Class c(Class var0) {
      a = var0;
      return var0;
   }

   public static EquivalentConverter c() {
      return new PlayerInfoDataConverter();
   }

   public static Constructor d() {
      return b;
   }

   public static Class a() {
      return a;
   }

   public static Class a(Class var0) {
      c = var0;
      return var0;
   }

   public static Constructor a(Constructor var0) {
      b = var0;
      return var0;
   }

   public static Class b() {
      return c;
   }
}
