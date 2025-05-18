package de.jpx3.intave.unknown;

import com.comphenix.protocol.utility.MinecraftVersion;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.bukkit.Material;

public final class Unknown402 {
   private static final Collector c = Collectors.toMap(Unknown39::d, Unknown39::c, Unknown402::b);
   private final Collection a;

   private boolean a(MinecraftVersion var1, MinecraftVersion var2, Unknown39 var3) {
      return this.a(var3, var1, var2);
   }

   public Stream a() {
      return this.a.stream();
   }

   private Unknown402(Collection var1) {
      this.a = var1;
   }

   private static Material b(Material var0, Material var1) {
      return var1;
   }

   public Unknown402 a(Predicate var1) {
      return a((Collection)this.a().filter(var1).collect(Collectors.toList()));
   }

   public Map b() {
      return (Map)this.a.stream().collect(c);
   }

   public Unknown402 a(MinecraftVersion var1, MinecraftVersion var2) {
      Predicate var3 = this::a;
      return var2.isAtLeast(var1) ? c() : this.a(var3);
   }

   private boolean a(Unknown39 var1, MinecraftVersion var2, MinecraftVersion var3) {
      return var2.isAtLeast(var1.a()) && !var3.isAtLeast(var1.getVersion()) && var3.isAtLeast(var1.a());
   }

   public static Unknown402 a(Collection var0) {
      return new Unknown402(ImmutableList.copyOf(var0));
   }

   public static Unknown402 c() {
      return new Unknown402(Collections.emptyList());
   }
}
