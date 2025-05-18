package de.jpx3.intave.anticheat.util;

import de.jpx3.intave.d9;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FilteredMap implements Map {
   private final Map b;
   private final Function a;

   static Function a(FilteredMap var0) {
      return var0.a;
   }

   private void a() {
      this.b.entrySet().removeIf(FilteredMap::b);
   }

   public boolean containsKey(Object var1) {
      return this.get(var1) != null;
   }

   public boolean isEmpty() {
      this.a();
      return this.b.isEmpty();
   }

   public static FilteredMap b(Map var0) {
      return new FilteredMap(var0, SoftReference::new);
   }

   @NotNull
   public Set entrySet() {
      this.a();
      Set var4 = this.b.entrySet();
      HashSet var5 = new HashSet();

      for(Entry var7 : var4) {
         var5.add(new d9(this, var7));
      }

      return var5;
   }

   public void putAll(@NotNull Map var1) {
      var1.forEach(this::put);
   }

   public boolean containsValue(Object var1) {
      for(Reference var6 : this.b.values()) {
         Object var7 = var6.get();
         if (var7 != null && (var1 == var7 || var1.equals(var7))) {
            return true;
         }
      }

      return false;
   }

   private Reference a(Function var1, Object var2) {
      return (Reference)this.a.apply(var1.apply(var2));
   }

   @NotNull
   public Set keySet() {
      this.a();
      return this.b.keySet();
   }

   @Nullable
   public Object put(Object var1, Object var2) {
      Reference var6 = (Reference)this.b.put(var1, this.a.apply(var2));
      return var6 == null ? null : var6.get();
   }

   public int size() {
      this.a();
      return this.b.size();
   }

   @NotNull
   public Collection values() {
      this.a();
      Collection var5 = this.b.values();
      ArrayList var6 = new ArrayList(var5.size());

      for(Reference var8 : var5) {
         var6.add(var8.get());
      }

      return var6;
   }

   public static FilteredMap a(Map var0) {
      return new FilteredMap(var0, WeakReference::new);
   }

   private static boolean b(Entry var0) {
      return var0 != null && var0.getValue() != null && ((Reference)var0.getValue()).get() == null;
   }

   public Object computeIfPresent(Object var1, @NotNull BiFunction var2) {
      Reference var6 = (Reference)this.b.computeIfPresent(var1, this::a);
      return var6 == null ? null : var6.get();
   }

   private Reference a(BiFunction var1, Object var2, Reference var3) {
      return (Reference)this.a.apply(var1.apply(var2, var3.get()));
   }

   public Object remove(Object var1) {
      Reference var5 = (Reference)this.b.remove(var1);
      return var5 == null ? null : var5.get();
   }

   public Object get(Object var1) {
      Reference var5 = (Reference)this.b.get(var1);
      return var5 == null ? null : var5.get();
   }

   public void clear() {
      this.b.clear();
   }

   private FilteredMap(Map var1, Function var2) {
      this.b = var1;
      this.a = var2;
   }

   public Object computeIfAbsent(Object var1, @NotNull Function var2) {
      Reference var6 = (Reference)this.b.computeIfAbsent(var1, this::a);
      Object var7 = var6.get();
      if (var7 == null) {
         var7 = var2.apply(var1);
         this.b.put(var1, this.a.apply(var7));
      }

      return var7;
   }
}
