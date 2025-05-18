package de.jpx3.intave.anticheat.util;

import de.jpx3.intave.anticheat.util.block.TypeCache;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Material;

public final class BlockTypeUtil {
   private static final TypeCache typeCache = TypeCache.add(Material.AIR).a();
   private static final Map cache = new HashMap();

   public static void put(TypeCache typeCache, Material var1) {
      cache(typeCache, var1);
   }

   private static void cache(TypeCache typeCache, Material var1) {
      cache.put(var1, typeCache);
   }

   public static void create() {
      TypeCache.add(Material.ICE).b(0.98F).a().a();
      TypeCache.add(Material.SLIME_BLOCK).b(0.8F).a().a();
      TypeCache.add(Material.PACKED_ICE).b(0.98F).a().a();
      TypeCache.add("FROSTED_ICE").b(0.98F).a().a();
      TypeCache.add("BLUE_ICE").b(0.989F).a().a();
      TypeCache.add(Material.LADDER).b().a().a();
      TypeCache.add(Material.VINE).b().a().a();
      TypeCache.add("SCAFFOLDING").b().a().a();
      TypeCache.add("WEEPING_VINES").b().a().a();
      TypeCache.add("WEEPING_VINES_PLANT").b().a().a();
      TypeCache.add("TWISTING_VINES").b().a().a();
      TypeCache.add("TWISTING_VINES_PLANT").b().a().a();
      TypeCache.add("CAVE_VINES_PLANT").b().a().a();
      TypeCache.add(Material.SOUL_SAND).c(0.4F).c().a().a();
      TypeCache.add("SOUL_SOIL").c().a().a();
      TypeCache.add("HONEY_BLOCK").a(0.5F).c(0.4F).a().a();
   }

   public static TypeCache getOrDefault(Material var0) {
      return (TypeCache)cache.getOrDefault(var0, typeCache);
   }
}
