package de.jpx3.intave.unknown;

import com.google.gson.JsonElement;

public abstract class Unknown95 {
   private final String c;

   public abstract JsonElement serialize();

   protected Unknown95(String var1) {
      this.c = var1;
   }

   public abstract void deserialize(JsonElement var1);

   public String c() {
      return this.c;
   }
}
