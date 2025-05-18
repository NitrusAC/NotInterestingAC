package de.jpx3.intave.unknown;

public enum Unknown227 {
   public static final Unknown227 BLOCKING = new Unknown227("blocking");
   public static final Unknown227 CANCEL_FIRST = new Unknown227("cancel/first");
   private static final Unknown227[] values = new Unknown227[]{
      Unknown227.CANCEL, CANCEL_FIRST, Unknown227.DMG_MEDIUM, Unknown227.DM_LIGHT, Unknown227.HT_MEDIUM, Unknown227.HT_LIGHT, Unknown227.GARBAGE_HIT, BLOCKING
   };
   private final String j;
   public static final Unknown227 DM_LIGHT = new Unknown227("dmg/light");
   public static final Unknown227 HT_MEDIUM = new Unknown227("ht/medium");
   public static final Unknown227 CANCEL = new Unknown227("cancel");
   public static final Unknown227 DMG_MEDIUM = new Unknown227("dmg/medium");
   public static final Unknown227 GARBAGE_HIT = new Unknown227("garbage-hits");
   public static final Unknown227 HT_LIGHT = new Unknown227("ht/light");

   private Unknown227(String var3) {
      this.j = var3;
   }

   public String a() {
      return this.j;
   }
}
