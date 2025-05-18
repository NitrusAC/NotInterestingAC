package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.unknown.check.Check8;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class Unknown149 {
   private final Map a = new ConcurrentHashMap();

   private static boolean b(Unknown70 var0, UnknownCheck var1) {
      return var1.b().b(var0);
   }

   public void b() {
      this.a(this::d);
   }

   private void a(Consumer var1) {
      this.a.values().forEach(var1);
   }

   public void d(UnknownCheck var1) {
      var1.e();
   }

   public void b(UnknownCheck var1) {
      if (var1.b().a()) {
         Unknown297 var5 = (Unknown297)this.get(Unknown297.class);
         if (var5 != null) {
            var5.b(var1);
         }

         Check8 var6 = (Check8)this.get(Check8.class);
         if (var6 != null) {
            var6.b(var1);
         }
      }

      var1.refreshConfig();
   }

   private Collection a(Predicate var1) {
      return (Collection)this.a.values().stream().filter(var1).collect(Collectors.toList());
   }

   public UnknownCheck get(Class var1) {
      return (UnknownCheck)this.a.get(var1);
   }

   public Collection a(Unknown70 var1) {
      return new ArrayList(this.a(Unknown149::b));
   }

   public void c(UnknownCheck var1) {
      this.a.put(var1.getClass(), var1);
   }

   public void a() {
      this.a.clear();
   }

   public void a(UnknownCheck var1) {
      this.a.remove(var1.getClass());
   }
}
