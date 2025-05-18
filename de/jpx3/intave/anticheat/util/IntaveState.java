package de.jpx3.intave.anticheat.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public enum IntaveState {
   public static final IntaveState STABLE = new IntaveState("STABLE");
   public static final IntaveState e = new IntaveState("");
   public static final IntaveState OUTDATED = new IntaveState("OUTDATED");
   public static final IntaveState LATEST = new IntaveState("LATEST");
   public static final IntaveState DISABLED = new IntaveState("DISABLED");
   private static final Map g = new HashMap();
   private static final IntaveState[] h = new IntaveState[]{OUTDATED, LATEST, STABLE, DISABLED, e};
   private final String i;

   public String a() {
      return this.i;
   }

   public static IntaveState getFromString(String var0) {
      IntaveState var4 = (IntaveState)g.get(var0.toUpperCase(Locale.ROOT));
      return var4 == null ? e : var4;
   }

   private IntaveState(String var3) {
      this.i = var3;
   }

   static {
      for(IntaveState var15 : values()) {
         g.put(var15.a(), var15);
      }

   }
}
