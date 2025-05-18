package de.jpx3.intave.unknown;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import de.jpx3.intave.d6;
import de.jpx3.intave.anticheat.IntavePlugin;
import de.jpx3.intave.anticheat.check.api.AbstractCheck;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public final class Unknown300 extends Unknown312 {
   private long movements;
   private final Map f = new HashMap();
   private double blocksMoved;
   private long blocksDestroyed;
   private long blocksPlaced;

   public Unknown300() {
      this.c();
   }

   @Override
   public String a() {
      return "global-statistics";
   }

   private void c() {
      for(AbstractCheck var6 : IntavePlugin.getInstance().g().getChecks()) {
         this.f.put(var6.k(), 0L);
      }

   }

   @Override
   public void g() {
      this.blocksPlaced = 0L;
      this.blocksDestroyed = 0L;
      this.movements = 0L;
      this.blocksMoved = 0.0;
      this.f.clear();
      this.c();
   }

   @Override
   public Set c() {
      return ImmutableSet.of(d6.b);
   }

   public synchronized void a(double var1) {
      this.blocksMoved += var1;
      ++this.movements;
   }

   @Override
   public JsonObject serialize() {
      JsonObject var5 = new JsonObject();
      var5.addProperty("blocksPlaced", this.blocksPlaced);
      var5.addProperty("blocksDestroyed", this.blocksDestroyed);
      var5.addProperty("movements", this.movements);
      var5.addProperty("blocksMoved", (long)this.blocksMoved);
      JsonObject var6 = new JsonObject();

      for(Entry var8 : this.f.entrySet()) {
         var6.addProperty((String)var8.getKey(), (Number)var8.getValue());
      }

      var5.add("detections", var6);
      return var5;
   }

   public synchronized void b() {
      ++this.blocksPlaced;
   }

   public synchronized void a() {
      ++this.blocksDestroyed;
   }

   public synchronized void a(String var1) {
      this.f.put(var1, this.f.get(var1) + 1L);
   }
}
