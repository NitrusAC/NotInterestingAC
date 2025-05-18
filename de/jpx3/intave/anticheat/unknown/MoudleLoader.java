package de.jpx3.intave.anticheat.unknown;

import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.unknown.Unknown149;
import de.jpx3.intave.unknown.Unknown164;
import de.jpx3.intave.unknown.Unknown216;
import de.jpx3.intave.unknown.Unknown286;
import de.jpx3.intave.unknown.Unknown293;
import de.jpx3.intave.unknown.Unknown296;
import de.jpx3.intave.unknown.Unknown309;
import de.jpx3.intave.unknown.Unknown324;
import de.jpx3.intave.unknown.Unknown49;
import de.jpx3.intave.unknown.Unknown70;
import de.jpx3.intave.unknown.Unknown75;
import de.jpx3.intave.unknown.Unknown93;
import de.jpx3.intave.unknown.check.Check10;

public final class MoudleLoader {
   private static final Unknown149 cache = new Unknown149();
   private static final Unknown164 e = new Unknown164();
   private static final Unknown49 a = new Unknown49();
   private static final Unknown93 c = new Unknown93();
   private static final Unknown216 f = new Unknown216();
   private static final Unknown75 g = new Unknown75();

   public static UnknownCheck of(Class clazz) {
      UnknownCheck var4 = cache.get(clazz);
      if (var4 == null) {
         throw new IllegalStateException("Unable to find module " + clazz + ", is it loaded?");
      } else {
         return var4;
      }
   }

   public static Unknown293 n() {
      return (Unknown293)of(Unknown293.class);
   }

   public static Unknown49 o() {
      return a;
   }

   public static Unknown296 e() {
      return (Unknown296)of(Unknown296.class);
   }

   public static native void i();

   @Deprecated
   public static Check10 g() {
      return (Check10)of(Check10.class);
   }

   public static Unknown286 violations() {
      return (Unknown286)of(Unknown286.class);
   }

   public static native void a(Unknown70 var0);

   public static Unknown309 m() {
      return (Unknown309)of(Unknown309.class);
   }

   public static Unknown324 f() {
      return (Unknown324)of(Unknown324.class);
   }

   public static Unknown164 c() {
      return e;
   }

   public static void d() {
      cache.b();
      cache.a();
   }

   public static Unknown75 k() {
      return g;
   }

   public static Unknown93 j() {
      return c;
   }
}
