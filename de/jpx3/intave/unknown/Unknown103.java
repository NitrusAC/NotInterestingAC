package de.jpx3.intave.unknown;

import de.jpx3.intave.anticheat.util.block.TypeCache;
import org.bukkit.Material;

public final class Unknown103 {
   private final Material c;
   private boolean d;
   private boolean e;
   private float b;
   private float a = 0.6F;
   private float f;

   public Unknown103 b() {
      this.e = true;
      return this;
   }

   public Unknown103 b(float var1) {
      this.a = var1;
      return this;
   }

   public Unknown103 a(float var1) {
      this.b = var1;
      return this;
   }

   public TypeCache a() {
      return new TypeCache(this.c, this.a, this.b, this.f, this.e, this.d);
   }

   public Unknown103 c(float var1) {
      this.f = var1;
      return this;
   }

   public Unknown103 c() {
      this.d = true;
      return this;
   }

   public Unknown103(Material var1) {
      this.b = 1.0F;
      this.f = 1.0F;
      this.e = false;
      this.d = false;
      this.c = var1;
   }
}
