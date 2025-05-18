package de.jpx3.intave.unknown;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.jpx3.intave.d6;
import de.jpx3.intave.unknown.what.What1;
import java.util.List;
import java.util.Set;

public final class Unknown295 extends Unknown312 {
   @Override
   public Set c() {
      return ImmutableSet.of(d6.b);
   }

   @Override
   public String a() {
      return "timings";
   }

   @Override
   public void g() {
   }

   @Override
   public JsonObject serialize() {
      JsonObject var4 = new JsonObject();
      List var5 = What1.a();
      JsonArray var6 = new JsonArray();
      JsonArray var7 = new JsonArray();
      JsonArray var8 = new JsonArray();

      for(Unknown125 var10 : var5) {
         JsonObject var11 = new JsonObject();
         var11.addProperty("name", var10.getName());
         var11.addProperty("calls", var10.getCalls());
         var11.addProperty("total-ns", var10.getTotalNs());
         if (var10.k()) {
            var6.add(var11);
         } else if (var10.u()) {
            var7.add(var11);
         } else {
            var8.add(var11);
         }
      }

      var4.add("packet", var6);
      var4.add("event", var7);
      var4.add("intave", var8);
      return var4;
   }
}
