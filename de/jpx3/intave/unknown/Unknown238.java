package de.jpx3.intave.unknown;

import com.comphenix.protocol.utility.MinecraftVersion;
import de.jpx3.intave.anticheat.reflection.ClassLocation;
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

public final class Unknown238 implements Iterable {
   private final Iterable a;

   private int b() {
      MinecraftVersion var1 = MinecraftVersion.getCurrentVersion();
      return var1.getMinor() * 10 + var1.getBuild();
   }

   public void forEach(Consumer var1) {
      this.a.forEach(var1);
   }

   private static boolean a(String var0, ClassLocation var1) {
      return var1.b().equals(var0);
   }

   public ClassLocation a(Supplier var1) {
      return (ClassLocation)this.c().orElseGet(var1);
   }

   @NotNull
   public Iterator iterator() {
      return this.a.iterator();
   }

   public Optional c() {
      return this.e().findAny();
   }

   public Unknown238 a(String var1) {
      return this.a(Unknown238::a);
   }

   public Unknown238(Iterable var1) {
      this.a = var1;
   }

   private static boolean b(int var0, ClassLocation var1) {
      return var1.a().a(var0);
   }

   public ClassLocation d() {
      return (ClassLocation)this.c().orElse(null);
   }

   public Spliterator spliterator() {
      return this.a.spliterator();
   }

   public Unknown238 a() {
      int var1 = this.b();
      return this.a(Unknown238::b);
   }

   public Stream e() {
      return StreamSupport.stream(this.a.spliterator(), false);
   }

   public Unknown238 a(Predicate var1) {
      return new Unknown238((Iterable)this.e().filter(var1).collect(Collectors.toList()));
   }
}
