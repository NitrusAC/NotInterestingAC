package de.jpx3.intave.unknown;

import de.jpx3.intave.access.IntaveAccess;
import de.jpx3.intave.anticheat.IntavePlugin;

public final class Unknown47 {
   private final Unknown141 f;
   private final IntavePlugin plugin;
   private final Unknown403 e;
   private final Unknown259 a;
   private final Unknown389 d;

   public Unknown47(IntavePlugin plugin) {
      this.plugin = plugin;
      this.a = new Unknown259(plugin);
      this.e = new Unknown403(plugin);
      this.d = new Unknown389(plugin);
      this.f = new Unknown141(plugin);
   }

   public void e() {
      this.plugin.a(this.a());
   }

   static Unknown141 c(Unknown47 var0) {
      return var0.f;
   }

   public Unknown141 c() {
      return this.f;
   }

   static Unknown403 b(Unknown47 var0) {
      return var0.e;
   }

   static Unknown389 d(Unknown47 var0) {
      return var0.d;
   }

   private IntaveAccess a() {
      return new Unknown130(this);
   }

   static IntavePlugin a(Unknown47 var0) {
      return var0.plugin;
   }

   public Unknown389 b() {
      return this.d;
   }
}
