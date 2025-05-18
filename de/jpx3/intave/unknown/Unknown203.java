package de.jpx3.intave.unknown;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public final class Unknown203 {
   private final boolean c;
   private static final String d;

   private Unknown203(boolean var1) {
      this.c = var1;
   }

   public static Unknown203 b() {
      return new Unknown203(false);
   }

   public static Unknown203 a(JsonElement var0) {
      JsonObject var4 = var0.getAsJsonObject();
      boolean var5 = a(var4, "legacySneakHeight", false);
      return new Unknown203(var5);
   }

   private static boolean a(JsonObject var0, String var1, boolean var2) {
      JsonElement var6 = var0.get(var1);
      return var6 == null ? var2 : var6.getAsBoolean();
   }

   public boolean a() {
      return this.c;
   }
}
