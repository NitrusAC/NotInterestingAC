package de.jpx3.intave.unknown;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import de.jpx3.intave.Relocate;
import de.jpx3.intave.qd;
import de.jpx3.intave.access.IntaveInternalException;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.UnknownCheck;
import de.jpx3.intave.anticheat.listener.BukkitEventListener;
import de.jpx3.intave.anticheat.listener.PacketListener;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.AuthorNagException;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.IllegalPluginAccessException;
import org.bukkit.plugin.RegisteredListener;

@Relocate
public final class Unknown297 extends UnknownCheck {
   private final IntavePlugin a;
   private int e = 0;
   private long f = 0L;

   public void c(PacketListener var1) {
      HandlerList.unregisterAll(var1);
   }

   public long a() {
      return this.f;
   }

   private HandlerList a(Class var1) {
      try {
         String var4 = "getHandlerList";
         Class var10000 = this.b(var1);
         Class[] var10003 = new Class[0];
         Method var5 = var10000.getDeclaredMethod(qd.b(var4, var10000, var10003), var10003);
         var5.setAccessible(true);
         return (HandlerList)var5.invoke(null);
      } catch (Exception var6) {
         throw new IllegalPluginAccessException(var6.toString());
      }
   }

   private Class b(Class var1) {
      try {
         String var4 = "getHandlerList";
         Class[] var10004 = new Class[0];
         var1.getDeclaredMethod(qd.b(var4, var1, var10004), var10004);
         return var1;
      } catch (NoSuchMethodException var5) {
         if (var1.getSuperclass() != null && !var1.getSuperclass().equals(Event.class) && Event.class.isAssignableFrom(var1.getSuperclass())) {
            return this.b(var1.getSuperclass().asSubclass(Event.class));
         } else {
            throw new IllegalPluginAccessException("Unable to find handler list for event " + var1.getName() + ". Static getHandlerList method required!");
         }
      }
   }

   public void b(PacketListener var1) {
      long var2 = System.nanoTime();
      this.a(var1).forEach(this::a);
      this.f += System.nanoTime() - var2;
   }

   public int b() {
      return this.e;
   }

   @Override
   public void e() {
      HandlerList.unregisterAll(this.a);
   }

   public void a(Event var1) {
      for(RegisteredListener var5 : var1.getHandlers().getRegisteredListeners()) {
         if (var5.getPlugin().isEnabled()) {
            try {
               var5.callEvent(var1);
            } catch (EventException | AuthorNagException var7) {
               var7.printStackTrace();
            }
         }
      }

   }

   public Unknown297(IntavePlugin var1) {
      this.a = var1;
   }

   private void a(Class var1, Set var2) {
      this.a(var1).registerAll(var2);
   }

   private static Set c(Class var0) {
      return new HashSet();
   }

   private Map a(PacketListener var1) {
      Class var4 = var1.getClass();
      ImmutableList var5 = ImmutableList.copyOf(var4.getDeclaredMethods());
      ConcurrentMap var6 = Maps.newConcurrentMap();
      int var7 = 0;

      for(Method var9 : var5) {
         BukkitEventListener var10 = (BukkitEventListener)var9.getAnnotation(BukkitEventListener.class);
         Class var11;
         if (var10 != null && var9.getParameterTypes().length == 1 && Event.class.isAssignableFrom(var11 = var9.getParameterTypes()[0])) {
            if (Modifier.isPrivate(var9.getModifiers()) || Modifier.isStatic(var9.getModifiers())) {
               throw new IntaveInternalException("Invalid linking for method " + var9);
            }

            Class var12 = var11.asSubclass(Event.class);
            Set var13 = (Set)var6.computeIfAbsent(var12, Unknown297::c);
            String var14 = var4.getCanonicalName().replaceAll("\\.", "/");
            String var15 = var12.getCanonicalName().replaceAll("\\.", "/");
            Class var16 = Unknown23.a(
               Unknown297.class.getClassLoader(),
               EventExecutor.class,
               "<generated>",
               "execute",
               "(Lorg/bukkit/event/Listener;Lorg/bukkit/event/Event;)V",
               "(L" + var14 + ";L" + var15 + ";)V",
               var14,
               var9.getName(),
               Unknown357.a(var9),
               false,
               false
            );

            EventExecutor var17;
            try {
               var17 = (EventExecutor)var16.newInstance();
            } catch (IllegalAccessException | InstantiationException var19) {
               throw new IntaveInternalException(var19);
            }

            Unknown183 var18 = new Unknown183(this.a, var1, var17, var12, var10);
            var18.c();
            var13.add(var18);
            ++var7;
         }
      }

      this.e += var7;
      return var6;
   }
}
