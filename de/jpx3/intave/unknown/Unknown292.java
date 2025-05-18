package de.jpx3.intave.unknown;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import de.jpx3.intave.d6;
import java.util.Set;

public final class Unknown292 extends Unknown312 {
   private long c;
   private long a = System.currentTimeMillis();
   private long d;

   public void a(long var1) {
      this.c += var1;
   }

   @Override
   public Set c() {
      return ImmutableSet.of(d6.b);
   }

   public void b(long var1) {
      this.d += var1;
   }

   @Override
   public String a() {
      return "playtime";
   }

   @Override
   public void g() {
      this.a = System.currentTimeMillis();
      this.c = 0L;
      this.d = 0L;
   }

   @Override
   public JsonObject serialize() {
      JsonObject var3 = new JsonObject();
      var3.addProperty("lifetime", (System.currentTimeMillis() - this.a) / 1000L / 60L);
      var3.addProperty("total-active-playtime", this.c);
      var3.addProperty("total-afk-playtime", this.d);
      return var3;
   }
}
