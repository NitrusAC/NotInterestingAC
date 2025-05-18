package de.jpx3.intave.unknown;

import com.comphenix.protocol.reflect.EquivalentConverter;
import com.comphenix.protocol.reflect.StructureModifier;
import java.lang.reflect.Constructor;

public final class Unknown283 {
   private static Constructor c;
   private static StructureModifier a;
   private static final ThreadLocal b = ThreadLocal.withInitial(Unknown283::d);

   static Constructor b() {
      return c;
   }

   static StructureModifier a() {
      return a;
   }

   static Constructor a(Constructor var0) {
      c = var0;
      return var0;
   }

   public static EquivalentConverter c() {
      return (EquivalentConverter)b.get();
   }

   private static EquivalentConverter d() {
      return new Unknown247();
   }

   static StructureModifier a(StructureModifier var0) {
      a = var0;
      return var0;
   }
}
