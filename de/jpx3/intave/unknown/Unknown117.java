package de.jpx3.intave.unknown;

import com.comphenix.protocol.utility.MinecraftVersion;
import de.jpx3.intave.anticheat.reflection.FieldLocation;
import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.jetbrains.annotations.NotNull;

public final class Unknown117 implements Iterable {
   private final Iterable a;

   public Stream c() {
      return StreamSupport.stream(this.a.spliterator(), false);
   }

   public Unknown117 a(Predicate var1) {
      Iterable var2 = (Iterable)this.c().filter(var1).collect(Collectors.toList());
      return new Unknown117(var2);
   }

   private static boolean b(int var0, FieldLocation var1) {
      return var1.a().a(var0);
   }

   public static Unknown117 b() {
      return new Unknown117(Collections.emptyList());
   }

   public Unknown117 a(String var1) {
      return this.a(Unknown117::a);
   }

   public Spliterator spliterator() {
      return this.a.spliterator();
   }

   public Unknown117(Iterable var1) {
      this.a = var1;
   }

   public void forEach(Consumer var1) {
      this.a.forEach(var1);
   }

   public Unknown117 b(String var1) {
      return this.a(Unknown117::b);
   }

   @NotNull
   public Iterator iterator() {
      return this.a.iterator();
   }

   public Unknown117 a() {
      int var1 = this.d();
      return this.a(Unknown117::b);
   }

   private int d() {
      MinecraftVersion var1 = MinecraftVersion.getCurrentVersion();
      return var1.getMinor() * 10 + var1.getBuild();
   }

   private static boolean a(String var0, FieldLocation var1) {
      return var1.b().equals(var0);
   }

   private static boolean b(String var0, FieldLocation var1) {
      return var1.d().equals(var0);
   }
}
