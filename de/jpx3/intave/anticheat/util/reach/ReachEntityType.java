package de.jpx3.intave.anticheat.util.reach;

import de.jpx3.intave.anticheat.unknown.HitboxSize;
import java.util.Locale;

public final class ReachEntityType {
   private final int a;
   private final boolean boat;
   private static final String i;
   private final String entityType;
   public final int c;
   private final HitboxSize hitboxSize;
   private final boolean b;

   public ReachEntityType(String entityType, HitboxSize hitboxSize, int var3, boolean var4, int var5) {
      this.entityType = entityType;
      this.hitboxSize = hitboxSize;
      this.a = var3;
      this.b = var4;
      this.boat = entityType.toLowerCase(Locale.ROOT).contains("boat");
      this.c = var5;
   }

   public boolean e() {
      return this.b;
   }

   public int g() {
      return this.a;
   }

   public boolean isBoat() {
      return this.boat;
   }

   public String getEntityType() {
      return this.entityType;
   }

   public HitboxSize getHitboxSize() {
      return this.hitboxSize;
   }
}
