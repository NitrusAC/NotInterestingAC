package de.jpx3.intave.anticheat.world;

import de.jpx3.intave.anticheat.util.collision.Boxable;
import de.jpx3.intave.unknown.Unknown121;
import de.jpx3.intave.unknown.Unknown361;
import java.util.Objects;
import org.bukkit.Material;

public final class IntaveWorldBlock extends Unknown361 {
   private final Material material;
   private static final IntaveWorldBlock h = new IntaveWorldBlock(Unknown121.a(), Material.AIR, 0);
   private final int data;
   private final long timestamp = System.currentTimeMillis();
   private final Boxable box;

   public long a() {
      return System.currentTimeMillis() - this.timestamp;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         IntaveWorldBlock var5 = (IntaveWorldBlock)var1;
         if (this.data != var5.data) {
            return false;
         } else if (this.timestamp != var5.timestamp) {
            return false;
         } else if (!Objects.equals(this.box, var5.box)) {
            return false;
         } else {
            return this.material == var5.material;
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      int var5 = this.box != null ? this.box.hashCode() : 0;
      var5 = 31 * var5 + (this.material != null ? this.material.hashCode() : 0);
      var5 = 31 * var5 + this.data;
      return 31 * var5 + (int)(this.timestamp ^ this.timestamp >>> 32);
   }

   public Boxable getBox() {
      return this.box;
   }

   public Material getMaterial() {
      return this.material;
   }

   public static IntaveWorldBlock d() {
      return h;
   }

   public boolean f() {
      return this.a() > 10000L;
   }

   public IntaveWorldBlock(Boxable box, Material material, int data) {
      this.box = box;
      this.material = material;
      this.data = data;
   }

   public int getData() {
      return this.data;
   }
}
