package de.jpx3.intave.unknown;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public final class Unknown342 {
   private final String d;
   private final String g;
   private final String c;
   private final String f;
   private final String e;

   public String d() {
      return this.d;
   }

   public String f() {
      return this.f;
   }

   public Unknown342(String var1, String var2, String var3, String var4, String var5) {
      this.d = var1;
      this.c = var2;
      this.g = var3;
      this.e = var4;
      this.f = var5;
   }

   public static Unknown342 a(JsonElement var0) {
      JsonObject var5 = var0.getAsJsonObject();
      String var6 = var5.get("name").getAsString();
      String var7 = var5.get("payload").getAsString();
      String var8 = var5.get("brandcont").getAsString();
      String var9 = var5.get("action").getAsString();
      String var10 = var5.get("content").getAsString();
      return new Unknown342(var6, var7, var8, var9, var10);
   }

   public String g() {
      return this.e;
   }

   public String c() {
      return this.c;
   }

   public String e() {
      return this.g;
   }
}
