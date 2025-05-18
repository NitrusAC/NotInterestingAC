package de.jpx3.intave.unknown;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.util.IntaveState;
import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class Unknown392 {
   private final List a = new ArrayList();
   private final Map b = new HashMap();

   public Unknown260 a(String var1) {
      return (Unknown260)this.b.get(var1.toLowerCase(Locale.ROOT));
   }

   public void c() {
      HTTPRequest var5 = Unknown83.a("https:..service.intave.de.versions", "versions", TimeUnit.DAYS.toMillis(2L));
      JsonReader var6 = new JsonReader(new StringReader(var5.f()));
      var6.setLenient(true);

      for(JsonElement var9 : new JsonParser().parse(var6).getAsJsonArray()) {
         JsonObject var10 = var9.getAsJsonObject();
         String var11 = var10.get("name").getAsString();
         String var12 = var10.get("release").getAsString();
         String var13 = var10.get("status").getAsString();
         Unknown260 var14 = new Unknown260(var11, Long.parseLong(var12), IntaveState.getFromString(var13));
         this.a.add(var14);
         this.b.put(var14.c().toLowerCase(Locale.ROOT), var14);
      }

   }

   private int a(Unknown260 var1) {
      return this.a.indexOf(var1);
   }

   public List b() {
      return this.a;
   }

   public Unknown260 a(int var1) {
      return (Unknown260)this.a.get(this.a(this.a()) - var1);
   }

   public Unknown260 a() {
      return this.a(IntavePlugin.m());
   }
}
