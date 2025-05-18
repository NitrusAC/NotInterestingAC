package de.jpx3.intave.anticheat.check;

public enum CombatCheckType {
   public static final CombatCheckType KILLAURA = new CombatCheckType("killaura");
   public static final CombatCheckType AUTOCLICKER = new CombatCheckType("autoclicker");
   private static final CombatCheckType[] values = new CombatCheckType[]{KILLAURA, AUTOCLICKER};
   private final String name;

   private CombatCheckType(String var3) {
      this.name = var3;
   }

   public String getName() {
      return this.name;
   }
}
