package de.jpx3.intave.unknown;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import de.jpx3.intave.anticheat.util.http.HTTPRequest;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class Unknown124 {
   private final List a;
   private static final HTTPRequest b = Unknown83.a("https:..service.intave.de.clientdata", "clientdata", TimeUnit.DAYS.toMillis(14L));

   private static List a(String var0) {
      try {
         ArrayList var4 = new ArrayList();
         JsonReader var5 = new JsonReader(new StringReader(var0));
         var5.setLenient(true);

         for(JsonElement var8 : new JsonParser().parse(var5).getAsJsonArray()) {
            var4.add(Unknown342.a(var8));
         }

         return var4;
      } catch (Exception var9) {
         return Collections.emptyList();
      }
   }

   public List b() {
      return this.a;
   }

   public Unknown124(List var1) {
      this.a = var1;
   }

   public static Unknown124 a() {
      return !b.c() ? new Unknown124(new ArrayList()) : new Unknown124(a(b.f()));
   }
}
