package de.jpx3.intave.anticheat.util.block;

import de.jpx3.intave.anticheat.util.BlockTypeUtil;
import de.jpx3.intave.unknown.Unknown103;
import java.util.function.BiConsumer;
import org.bukkit.Material;

public final class TypeCache {
   private final Material material;
   private final boolean d;
   private final boolean b;
   private final float f;
   private final float c;
   private final float e;

   public TypeCache(Material var1, float var2, float var3, float var4, boolean var5, boolean var6) {
      this.material = var1;
      this.e = var2;
      this.f = var3;
      this.c = var4;
      this.d = var5;
      this.b = var6;
   }

   public void apply(BiConsumer var1) {
      if (this.material != null) {
         var1.accept(this, this.material);
      }

   }

   public float e() {
      return this.f;
   }

   private static void b(TypeCache var0, Material var1) {
      BlockTypeUtil.put(var0, var1);
   }

   public boolean c() {
      return this.b;
   }

   public void a() {
      this.apply(TypeCache::b);
   }

   public static Unknown103 add(String var0) {
      return new Unknown103(Material.getMaterial(var0));
   }

   public float f() {
      return this.c;
   }

   public boolean d() {
      return this.d;
   }

   public static Unknown103 add(Material var0) {
      return new Unknown103(var0);
   }

   public float getSliperiness() {
      return this.e;
   }
}
