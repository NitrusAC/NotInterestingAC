package de.jpx3.intave.anticheat.access.player.trust;

import de.jpx3.intave.anticheat.util.MathUtil2;
import org.bukkit.ChatColor;

public enum TrustFactor implements Comparable {
   public static final TrustFactor BYPASS = new TrustFactor(1000, ChatColor.WHITE, "intave.bypass");
   public static final TrustFactor GREEN = new TrustFactor(2, ChatColor.GREEN, "intave.trust.green");
   public static final TrustFactor YELLOW = new TrustFactor(1, ChatColor.YELLOW, "intave.trust.yellow");
   public static final TrustFactor ORANGE = new TrustFactor(0, ChatColor.GOLD, "intave.trust.orange");
   public static final TrustFactor RED = new TrustFactor(-1, ChatColor.RED, "intave.trust.red");
   public static final TrustFactor DARK_RED = new TrustFactor(-2, ChatColor.DARK_RED, "intave.trust.darkred");
   final int factor;
   final ChatColor chatColor;
   final String permission;
   private static final TrustFactor[] values = new TrustFactor[]{BYPASS, GREEN, YELLOW, ORANGE, RED, DARK_RED};

   private TrustFactor(int var3, ChatColor var4, String var5) {
      this.factor = var3;
      this.chatColor = var4;
      this.permission = var5;
   }

   public TrustFactor safer() {
      if (this == GREEN) {
         return GREEN;
      } else {
         TrustFactor[] var4 = values();
         return var4[MathUtil2.a(0, this.ordinal() - 1, var4.length)];
      }
   }

   public TrustFactor unsafer() {
      if (this == BYPASS) {
         return BYPASS;
      } else {
         TrustFactor[] var4 = values();
         return var4[MathUtil2.a(0, this.ordinal() + 1, var4.length)];
      }
   }

   public boolean atLeast(TrustFactor var1) {
      return this.factor() >= var1.factor();
   }

   public int factor() {
      return this.factor;
   }

   public String baseName() {
      return this.name().toLowerCase().replace("_", "");
   }

   public String coloredBaseName() {
      return this.chatColor() + this.baseName();
   }

   public ChatColor chatColor() {
      return this.chatColor;
   }

   public String permission() {
      return this.permission;
   }
}
