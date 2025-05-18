package de.jpx3.intave.unknown;

import java.lang.invoke.MethodHandle;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class Unknown267 {
   private static final String c;
   private final MethodHandle[] a;

   public Stream c() {
      return Arrays.stream(this.a);
   }

   public void a(Consumer var1) {
      for(MethodHandle var8 : this.a) {
         var1.accept(var8);
      }

   }

   public static Unknown267 a(Class var0, Class[] var1, Class var2) {
      return a(var0).a(var1).a(var2).a();
   }

   public static Unknown234 a(Class var0) {
      return new Unknown234(var0);
   }

   public MethodHandle b() {
      return (MethodHandle)this.e().orElseThrow(Unknown267::d);
   }

   public Unknown267(MethodHandle[] var1) {
      this.a = var1;
   }

   public Unknown267 b(Consumer var1) {
      for(MethodHandle var8 : this.a) {
         var1.accept(var8);
      }

      return this;
   }

   public Optional e() {
      return this.a.length > 0 ? Optional.ofNullable(this.a[0]) : Optional.empty();
   }

   @Deprecated
   public static Unknown267 b(Class var0, Class[] var1, Class var2) {
      return a(var0).a(var1).a(var2).b().a();
   }

   private static IllegalStateException d() {
      return new IllegalStateException("No matching method found");
   }

   public MethodHandle[] a() {
      return this.a;
   }
}
