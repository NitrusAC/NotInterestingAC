package de.jpx3.intave.unknown;

import java.util.Arrays;
import org.bukkit.Bukkit;

public final class Unknown261 implements Unknown278 {
   private final String[] a;

   @Override
   public boolean a() {
      return this.a != null && this.a.length != 0 ? Arrays.stream(this.a).allMatch(Unknown261::b) : true;
   }

   private static boolean b(String var0) {
      return Bukkit.getPluginManager().isPluginEnabled(var0);
   }

   public Unknown261(String[] var1) {
      this.a = var1;
   }
}
