package de.jpx3.intave.unknown;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import de.jpx3.intave.fd;
import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.event.Event;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;

public final class Unknown294 extends UnknownCheck {
   private final Map g;
   private final IntavePlugin f;
   private int e = 0;
   private long h = 0L;

   public int b() {
      return this.e;
   }

   public long a() {
      return this.h;
   }

   public Unknown294(IntavePlugin var1) {
      this.g = Maps.newHashMap();
      this.f = var1;
   }

   private String a(String var1) {
      return var1.replaceAll("\\.", "/");
   }

   public void a(Unknown369 var1, Event var2) {
      List var6 = (List)this.g.get(var2.getClass());
      if (var6 != null && !var6.isEmpty()) {
         var6.forEach(Unknown294::a);
      }
   }

   private static List b(Class var0) {
      return new ArrayList();
   }

   private static void a(Unknown369 var0, Event var1, Unknown327 var2) {
      var2.a(var0, var1);
   }

   public void a(Unknown315 var1) {
      for(Entry var6 : this.g.entrySet()) {
         List var7 = (List)var6.getValue();
         var7.removeIf(Unknown294::a);
      }

   }

   @Override
   public void e() {
      this.g.clear();
   }

   private static boolean a(Unknown315 var0, Unknown327 var1) {
      return var1.b() == var0;
   }

   private String c(Class var1) {
      return var1.getCanonicalName();
   }

   private Map c(Unknown315 var1) {
      Class var5 = var1.getClass();
      ImmutableList var6 = ImmutableList.copyOf(var5.getDeclaredMethods());
      ConcurrentMap var7 = Maps.newConcurrentMap();
      int var8 = 0;

      for(Method var10 : var6) {
         Unknown358 var11 = (Unknown358)var10.getAnnotation(Unknown358.class);
         Class var12;
         if (var11 != null
            && var10.getParameterTypes().length == 2
            && var10.getParameterTypes()[0].equals(Unknown369.class)
            && Event.class.isAssignableFrom(var12 = var10.getParameterTypes()[1])) {
            if (Modifier.isPrivate(var10.getModifiers()) || Modifier.isStatic(var10.getModifiers())) {
               throw new IntaveInternalException("Invalid linking for method " + var10);
            }

            Class var13 = var12.asSubclass(Event.class);
            List var14 = (List)var7.computeIfAbsent(var13, Unknown294::b);
            String var15 = this.a(this.c(Unknown315.class));
            String var16 = this.a(this.c(Unknown369.class));
            String var17 = this.a(this.c(Event.class));
            String var18 = this.a(this.c(var5));
            String var19 = this.a(this.c(var10.getParameterTypes()[0]));
            String var20 = this.a(this.c(var13));
            Class var21 = Unknown23.a(
               Unknown297.class.getClassLoader(),
               fd.class,
               "<generated>",
               "execute",
               "(L" + var15 + ";L" + var16 + ";L" + var17 + ";)V",
               "(L" + var18 + ";L" + var19 + ";L" + var20 + ";)V",
               var18,
               var10.getName(),
               Unknown357.a(var10),
               false,
               false
            );

            fd var22;
            try {
               var22 = (fd)var21.newInstance();
            } catch (IllegalAccessException | InstantiationException var24) {
               throw new IntaveInternalException(var24);
            }

            Unknown327 var23 = new Unknown327(var1, var22);
            var23.a();
            var14.add(var23);
            ++var8;
         }
      }

      this.e += var8;
      return var7;
   }

   public void b(Unknown315 var1) {
      long var6 = System.nanoTime();
      this.g.putAll(this.c(var1));
      this.h += System.nanoTime() - var6;
   }
}
