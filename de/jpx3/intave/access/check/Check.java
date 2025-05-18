package de.jpx3.intave.access.check;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public enum Check {
   public static final Check ATTACK_RAYTRACE = new Check("AttackRaytrace");
   public static final Check BREAK_SPEED_LIMITER = new Check("BreakSpeedLimiter");
   public static final Check CLICK_PATTERNS = new Check("ClickPatterns");
   public static final Check CLICK_SPEED_LIMITER = new Check("ClickSpeedLimiter");
   public static final Check HEURISTICS = new Check("Heuristics");
   public static final Check INTERACTION_RAYTRACE = new Check("InteractionRaytrace");
   public static final Check INVENTORY_CLICK_ANALYSIS = new Check("InventoryClickAnalysis");
   public static final Check PHYSICS = new Check("Physics");
   public static final Check PLACEMENT_ANALYSIS = new Check("PlacementAnalysis");
   public static final Check PROTOCOL_SCANNER = new Check("ProtocolScanner");
   public static final Check TIMER = new Check("Timer");
   private static final Map cache = new HashMap();
   private final String c;
   private static final Check[] values = new Check[]{
      ATTACK_RAYTRACE,
      BREAK_SPEED_LIMITER,
      CLICK_PATTERNS,
      CLICK_SPEED_LIMITER,
      HEURISTICS,
      INTERACTION_RAYTRACE,
      INVENTORY_CLICK_ANALYSIS,
      PHYSICS,
      PLACEMENT_ANALYSIS,
      PROTOCOL_SCANNER,
      TIMER
   };

   private Check(String var3) {
      this.c = var3;
   }

   public static Check fromName(String var0) {
      return (Check)cache.get(var0.toLowerCase(Locale.ROOT));
   }

   public String typeName() {
      return this.c;
   }

   static {
      for(Check var15 : values()) {
         cache.put(var15.c.toLowerCase(Locale.ROOT), var15);
      }

   }
}
