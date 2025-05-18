package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.version.VersionRange;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;

public final class Unknown314 implements Iterable {
   private final Collection a;
   private static final String c;

   public String a(int var1) {
      VersionRange var2 = (VersionRange)this.a.stream().filter(Unknown314::b).findFirst().orElseGet(this::a);
      return var2.getVersion();
   }

   public VersionRange a() {
      return (VersionRange)this.a.stream().max(VersionRange::a).orElseThrow(Unknown314::c);
   }

   public int a(String var1) {
      return -1;
   }

   private static boolean b(int var0, VersionRange var1) {
      return var1.a(var0);
   }

   public Stream d() {
      return this.a.stream();
   }

   public Unknown314(List var1) {
      this.a = var1;
   }

   public void forEach(Consumer var1) {
      this.a.forEach(var1);
   }

   @NotNull
   public Iterator iterator() {
      return this.a.iterator();
   }

   private static IllegalStateException c() {
      return new IllegalStateException("No max version range found");
   }

   public Spliterator spliterator() {
      return this.a.spliterator();
   }
}
