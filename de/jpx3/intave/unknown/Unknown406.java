package de.jpx3.intave.unknown;

import com.google.gson.JsonObject;
import de.jpx3.intave.anticheat.util.Bstats;
import java.util.logging.Level;
import org.bukkit.Bukkit;

public abstract class Unknown406 {
   final String c;

   Unknown406(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         this.c = var1;
      } else {
         throw new IllegalArgumentException("ChartId cannot be null or empty!");
      }
   }

   public static JsonObject a(Unknown406 var0) {
      return var0.d();
   }

   protected abstract JsonObject c();

   private JsonObject d() {
      JsonObject var4 = new JsonObject();
      var4.addProperty("chartId", this.c);

      try {
         JsonObject var5 = this.c();
         if (var5 == null) {
            return null;
         } else {
            var4.add("data", var5);
            return var4;
         }
      } catch (Throwable var6) {
         if (Bstats.e()) {
            Bukkit.getLogger().log(Level.WARNING, "Failed to get data for custom chart with id " + this.c, var6);
         }

         return null;
      }
   }
}
