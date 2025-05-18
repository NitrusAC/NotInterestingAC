package de.jpx3.intave.anticheat.check.api;

import java.util.ArrayList;
import java.util.List;

public enum Certainty implements Comparable {
   public static final Certainty LIKELY = new Certainty("likely", "?", 80);
   public static final Certainty CERTAIN = new Certainty("certain", "!!", 960);
   final int level;
   public static final Certainty MAYBE = new Certainty("maybe", "-", 10);
   private static final Certainty[] values = new Certainty[]{
      CERTAIN, Certainty.ALMOST_CERTAIN, Certainty.VERY_LIKELY, LIKELY, Certainty.PROBABLE, MAYBE, Certainty.NONE
   };
   public static final Certainty ALMOST_CERTAIN = new Certainty("almost certain", "!", 320);
   public static final Certainty NONE = new Certainty("none", "-", 0);
   public static final Certainty PROBABLE = new Certainty("probable", "??", 40);
   public static final Certainty VERY_LIKELY = new Certainty("very likely", "?!", 160);
   final String name;
   final String shortcut;

   public static Certainty a(int var0) {
      Certainty var4 = NONE;

      for(Certainty var8 : values()) {
         if (var8.level > var4.level && var8.level <= var0) {
            var4 = var8;
         }
      }

      return var4;
   }

   public int getLevel() {
      return this.level;
   }

   public static int sum(Certainty[] certainties) {
      int var4 = 0;

      for(Certainty var8 : certainties) {
         var4 += var8.getLevel();
      }

      return var4;
   }

   private Certainty(String name, String shortcut, int level) {
      this.name = name;
      this.shortcut = shortcut;
      this.level = level;
   }

   public static List b(int var0) {
      ArrayList var4;
      Certainty var5;
      for(var4 = new ArrayList(); var0 > MAYBE.getLevel(); var0 -= var5.getLevel()) {
         var5 = a(var0);
         var4.add(var5);
      }

      return var4;
   }

   public String getName() {
      return this.name;
   }

   public String getShortcut() {
      return this.shortcut;
   }

   public boolean isOrAbove(Certainty certainty) {
      return this.getLevel() >= certainty.getLevel();
   }
}
