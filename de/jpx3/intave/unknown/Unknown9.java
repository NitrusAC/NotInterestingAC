package de.jpx3.intave.unknown;

import com.comphenix.protocol.utility.MinecraftVersion;
import java.util.Collections;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.jetbrains.annotations.NotNull;

public final class Unknown9 implements Iterable {
   private final Iterable a;

   public Unknown9 b(String var1) {
      return this.a(Unknown9::c);
   }

   private static boolean b(int var0, Unknown98 var1) {
      return var1.a().a(var0);
   }

   public static Unknown9 f() {
      return new Unknown9(Collections.emptyList());
   }

   public Unknown9(Iterable var1) {
      this.a = var1;
   }

   public Unknown9 a(String var1) {
      return this.a(Unknown9::a);
   }

   public Unknown9 b() {
      int var1 = this.a();
      return this.a(Unknown9::b);
   }

   public Optional c() {
      return this.e().findAny();
   }

   public Spliterator spliterator() {
      return this.a.spliterator();
   }

   private static boolean a(String var0, Unknown98 var1) {
      return var1.f().equals(var0);
   }

   private static boolean c(String var0, Unknown98 var1) {
      return var1.e().equals(var0);
   }

   public Unknown98 a(Supplier var1) {
      return (Unknown98)this.c().orElseGet(var1);
   }

   public void forEach(Consumer var1) {
      this.a.forEach(var1);
   }

   @NotNull
   public Iterator iterator() {
      return this.a.iterator();
   }

   public Unknown9 a(Predicate var1) {
      return new Unknown9((Iterable)this.e().filter(var1).collect(Collectors.toList()));
   }

   public Stream e() {
      return StreamSupport.stream(this.a.spliterator(), false);
   }

   private int a() {
      MinecraftVersion var1 = MinecraftVersion.getCurrentVersion();
      return var1.getMinor() * 10 + var1.getBuild();
   }

   public Unknown98 d() {
      return (Unknown98)this.c().orElse(null);
   }
}
