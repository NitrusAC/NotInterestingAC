package de.jpx3.intave.anticheat.violation;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.entity.Player;

public class ViolationBuilder {
   private final Class clazz;
   private int c = 0;
   private UUID uuid;
   private String description;
   private boolean i;
   private String a;
   private double vl;
   private Map h;
   private String e;

   public ViolationBuilder description(String description) {
      this.description = description;
      return this;
   }

   public ViolationBuilder subcheck(String var1) {
      this.a = var1;
      return this;
   }

   public ViolationBuilder vl(double violation) {
      this.vl = violation;
      return this;
   }

   public ViolationBuilder player(Player player) {
      this.uuid = player.getUniqueId();
      return this;
   }

   public ViolationBuilder a(int var1) {
      this.c = var1;
      return this;
   }

   public synchronized Violation build() {
      if (this.i) {
         throw new IllegalStateException();
      } else {
         this.i = true;
         Preconditions.checkNotNull(this.clazz);
         Preconditions.checkNotNull(this.uuid);
         Preconditions.checkNotNull(this.e);
         if (this.description == null) {
            this.description = "";
         }

         this.e = this.e.trim();
         this.description = this.description.trim();
         if (this.vl < 0.0) {
            throw new IllegalStateException("Can not have negative VL");
         } else {
            if (this.a == null) {
               this.thresholds();
            }

            return new Violation(this.clazz, this.uuid, this.e, this.description, this.a, this.vl, this.h, this.c, null);
         }
      }
   }

   public ViolationBuilder c() {
      this.c = 0;
      return this;
   }

   public ViolationBuilder(Class var1) {
      this.clazz = var1;
   }

   public ViolationBuilder name(String var1) {
      this.e = var1;
      return this;
   }

   public ViolationBuilder a(String var1, String var2) {
      if (this.h == null) {
         this.h = new HashMap();
      }

      this.h.put(var1, var2);
      return this;
   }

   public ViolationBuilder thresholds() {
      this.a = "thresholds";
      return this;
   }

   public ViolationBuilder b(int var1) {
      this.c |= var1;
      return this;
   }
}
