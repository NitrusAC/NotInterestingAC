package de.jpx3.intave.unknown;

import com.google.gson.JsonObject;
import de.jpx3.intave.d6;
import java.util.Set;

public abstract class Unknown312 {
   public abstract JsonObject serialize();

   public boolean e() {
      return this.c().contains(d6.b);
   }

   public abstract String a();

   public abstract void g();

   public boolean h() {
      return this.c().contains(d6.a);
   }

   public abstract Set c();

   private static Unknown4 b(Unknown4 var0) {
      return var0;
   }
}
