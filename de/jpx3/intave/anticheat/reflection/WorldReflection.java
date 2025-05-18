package de.jpx3.intave.anticheat.reflection;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import de.jpx3.intave.anticheat.util.ReflectionUtil;
import de.jpx3.intave.unknown.Unknown134;
import de.jpx3.intave.unknown.Unknown267;
import java.lang.invoke.MethodHandle;
import java.util.concurrent.TimeUnit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.Nullable;

public final class WorldReflection {
   private static final Cache entityCache = CacheBuilder.newBuilder().expireAfterAccess(16L, TimeUnit.SECONDS).weakValues().concurrencyLevel(16).build();
   private static final MethodHandle worldHandle = Unknown267.a(ReflectionUtil.getClazz("World"), new Class[]{Integer.TYPE}, ReflectionUtil.getClazz("Entity"))
      .b();
   private static final MethodHandle entityHandle = Unknown267.a(ReflectionUtil.getClazz("Entity"), new Class[0], ReflectionUtil.b("entity.CraftEntity")).b();

   @Nullable
   private static Entity _getEntityFromWorld(World world, int entityId) {
      try {
         Object var2 = (Object)worldHandle.invoke(Unknown134.a(world), entityId);
         return var2 == null ? null : (Entity)entityHandle.invoke(var2);
      } catch (Throwable var3) {
         var3.printStackTrace();
         return null;
      }
   }

   @Nullable
   public static Entity getEntityFromWorld(World world, int entityId) {
      Entity var6 = (Entity)entityCache.getIfPresent(entityId);
      if (var6 != null) {
         return var6;
      } else {
         var6 = _getEntityFromWorld(world, entityId);
         if (var6 != null) {
            entityCache.put(entityId, var6);
         }

         return var6;
      }
   }
}
