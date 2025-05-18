package de.jpx3.intave.unknown;

import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class Unknown216 {
   private final Map a = new HashMap();

   private void b(String var1) {
      this.a(var1, Unknown328.d());
   }

   private void a(UnknownCheck var1) {
      var1.setPlugin(IntavePlugin.getInstance());
      var1.a((Unknown328)this.a.remove(var1.getClass().getName()));
   }

   private void a(String var1, Unknown328 var2) {
      this.a.put(var1, var2);
   }

   private Object a(String var1) {
      try {
         Class var4 = Class.forName(var1);

         try {
            return var4.getConstructor(IntavePlugin.class).newInstance(IntavePlugin.getInstance());
         } catch (InvocationTargetException var6) {
            throw new IntaveInternalException(var6);
         } catch (Exception var7) {
            return var4.newInstance();
         }
      } catch (IllegalAccessException | ClassNotFoundException | InstantiationException var8) {
         throw new IllegalStateException(var8);
      }
   }

   private static UnknownCheck a(Object var0) {
      return (UnknownCheck)var0;
   }

   public native void a();

   private static boolean a(Unknown70 var0, Unknown328 var1) {
      return var1.a(var0);
   }

   private Collection a(Predicate var1) {
      return (Collection)this.a.entrySet().stream().filter(Unknown216::b).map(Entry::getKey).collect(Collectors.toList());
   }

   public Collection a(Unknown70 var1) {
      return (Collection)this.a(Unknown216::a).stream().map(this::a).map(Unknown216::a).peek(this::a).collect(Collectors.toList());
   }

   private static boolean b(Predicate var0, Entry var1) {
      return var0.test(var1.getValue());
   }
}
